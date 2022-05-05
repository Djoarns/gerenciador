package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "alteraEmpresa", value = "/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
        String nomeEmpresa = request.getParameter("nome");
        Date dataAbertura;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(request.getParameter("data"));
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Banco banco = new Banco();
        banco.altera(idEmpresa, nomeEmpresa, dataAbertura);

        response.sendRedirect("listaEmpresas");
    }
}
