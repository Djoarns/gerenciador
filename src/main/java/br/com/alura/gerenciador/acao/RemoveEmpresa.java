package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveEmpresa implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Banco banco = new Banco();
        banco.removeEmpresa(id);
        return "redirect:ListaEmpresas";
    }

}
