package com.julian.soporte.cabeceras.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //aqui se redirecciona solo a url internas de la aplicacion y se mantiene la peticion
        //mantiene todos los datos de formulario (Parameters) y los atributos asignados en
        //otros sevlets (Attribute)
        getServletContext().getRequestDispatcher("/productos.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
