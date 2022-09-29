package com.julian.soporte.cabeceras.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.julian.soporte.cabeceras.models.Producto;
import com.julian.soporte.cabeceras.service.ProductoService;
import com.julian.soporte.cabeceras.service.ProductoServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductoService productoService = new ProductoServiceImpl();
        List<Producto> listaProductos = productoService.listar();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(listaProductos);


        response.setContentType("application/json");
        response.getWriter().write(json);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //para recibir un objeto se recibe del tipo getInputStream
        ServletInputStream jsonStream = request.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(jsonStream,  Producto.class);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("	<head>");
        out.println("		<meta charset=\"UTF-8\">");
        out.println("		<title>Producto recibido en Json</title>");
        out.println("	</head>");
        out.println("	<body>");
        out.println("		<h1>Producto recibido en Json!!</h1>");
        out.println("       <h3>id del producto: " + producto.getId() + "</h3>");
        out.println("       <h3>Nombre del producto: " + producto.getNombre() + "</h3>");
        out.println("       <h3>Tipo del producto: " + producto.getTipo() + "</h3>");
        out.println("       <h3>Precio del producto: " + producto.getPrecio() + "</h3>");
        out.println("	</body>");
        out.println("</html>");

    }
}
