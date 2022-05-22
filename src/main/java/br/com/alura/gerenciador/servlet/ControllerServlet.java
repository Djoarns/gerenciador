package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.*;
import br.com.alura.gerenciador.util.StringUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "entrada", value = "/entrada")
public class ControllerServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");
        String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
        String nome = "";

        HttpSession session = request.getSession();
        boolean userIsNotLogged = !StringUtil.isValid(session.getAttribute("usuarioLogado"));

        if (userIsNotLogged && isProtectedAction(paramAcao)) {
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] tipoEndereco = nome.split(":");

        if (tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
            rd.forward(request, response);
        } else if (tipoEndereco[0].equals("redirect")) {
            response.sendRedirect("entrada?acao=" + tipoEndereco[1]);
        }

    }

    private boolean isProtectedAction(String paramAcao) {
        List<String> unprotectedActions = Arrays.asList("Login", "LoginForm");
        return !unprotectedActions.contains(paramAcao);
    }

}
