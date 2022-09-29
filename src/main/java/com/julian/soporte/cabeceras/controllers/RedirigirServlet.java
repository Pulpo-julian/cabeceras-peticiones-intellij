package com.julian.soporte.cabeceras.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/redirigir")
public class RedirigirServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirigit mediante una bacera de la peticion pero crea una nueva peticion
        // no mantiene la peticion enviada por el cliente
        //response.setHeader("Location", request.getContextPath() + "/productos.html");
        //response.setStatus(HttpServletResponse.SC_FOUND);

        // lo anterior es lo mismo que escribir
        response.sendRedirect(request.getContextPath() + "/productos.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
