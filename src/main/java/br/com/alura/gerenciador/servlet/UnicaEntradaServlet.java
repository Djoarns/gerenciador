package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "entrada", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");

        if (paramAcao.equalsIgnoreCase("ListaEmpresas")) {
            ListaEmpresas acao = new ListaEmpresas();
            acao.executa(request, response);
        } else if (paramAcao.equalsIgnoreCase("RemoveEmpresa")) {
            RemoveEmpresa acao = new RemoveEmpresa();
            acao.executa(request, response);
        } else if (paramAcao.equalsIgnoreCase("AlteraEmpresa")) {
            AlteraEmpresa acao = new AlteraEmpresa();
            acao.executa(request, response);
        }
    }

}
