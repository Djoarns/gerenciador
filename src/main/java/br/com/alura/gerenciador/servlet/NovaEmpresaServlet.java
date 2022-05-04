package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "NovaEmpresa", value = "/NovaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nomeEmpresa = request.getParameter("nome");
        Date dataAbertura;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(request.getParameter("data"));
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        response.sendRedirect("listaEmpresas");

//        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//        request.setAttribute("empresa", empresa.getNome());
//        rd.forward(request, response);
    }
}
