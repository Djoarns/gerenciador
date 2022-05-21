package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NovaEmpresaForm implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return "forward:formNovaEmpresa.jsp";
    }
}
