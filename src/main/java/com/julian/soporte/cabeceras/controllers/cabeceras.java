package com.julian.soporte.cabeceras.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class cabeceras extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String metodoHttp = request.getMethod();
        String requestUri = request.getRequestURI();
        String requesrUrl = request.getRequestURL().toString();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String ipServidor = request.getLocalAddr();
        String ipCliente = request.getRemoteAddr();
        int port = request.getLocalPort();
        String schema = request.getScheme();
        String host = request.getHeader("host");
        String url = schema + "://" + host + contextPath + servletPath;
        String url2 = schema + "://" + ipServidor + ":" + port + contextPath + servletPath;



        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("	<head>");
        out.println("		<meta charset=\"UTF-8\">");
        out.println("		<title>cabeceras de request</title>");
        out.println("	</head>");
        out.println("	<body>");
        out.println("		<h1>cabeceras de request!!</h1>");
        out.println("   <ul>");
        out.println("       <li>metodo http: " + metodoHttp + "</li>");
        out.println("       <li>Request URI: " + requestUri + "</li>");
        out.println("       <li>Request url: " + requesrUrl + "</li>");
        out.println("       <li>Context Path: " + contextPath + "</li>");
        out.println("       <li>Servlet Path: " + servletPath + "</li>");
        out.println("       <li>ip Servidor: " + ipServidor + "</li>");
        out.println("       <li>ip Cliente: " + ipCliente + "</li>");


        out.println("       <li>puerto: " + port + "</li>");

        out.println("       <li>Schema: " + schema + "</li>");
        out.println("       <li>Host: " + host + "</li>");

        out.println("       <li>Url Formada: " + url + "</li>");
        out.println("       <li>Url Formada 2: " + url2 + "</li>");


        Enumeration<String> headerNames = request.getHeaderNames();

        while(headerNames.hasMoreElements()){
            String cabecera = headerNames.nextElement();
            out.println("<li>" + cabecera + ": " + request.getHeader(cabecera) + "</li>");
        }

        out.println("   </ul>");

        out.println("	</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
