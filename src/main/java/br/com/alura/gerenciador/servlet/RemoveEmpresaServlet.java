package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.modelo.Banco;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);
        
        response.sendRedirect("listaEmpresas");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
