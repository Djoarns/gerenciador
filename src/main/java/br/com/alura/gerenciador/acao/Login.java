package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;
import br.com.alura.gerenciador.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Banco banco = new Banco();
        Usuario user = banco.getUserIfExists(login, senha);

        if (StringUtil.isValid(user)) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", user);
            return "redirect:ListaEmpresas";
        } else {
            return "redirect:LoginForm";
        }
    }
}
