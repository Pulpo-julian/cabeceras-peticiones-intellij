package com.julian.soporte.cabeceras.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/hora-actualizada")
public class HoraActualizadaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setHeader("refresh", "1");

        LocalTime hora = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");


        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("	<head>");
        out.println("		<meta charset=\"UTF-8\">");
        out.println("		<title>La hora actualizada</title>");
        out.println("	</head>");
        out.println("	<body>");
        out.println("		<h1>Hora actualizada!!</h1>");
        out.println("       <h3>" + hora.format(df) +"</h3>");
        out.println("	</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
