package com.julian.soporte.cabeceras.controllers;

import com.julian.soporte.cabeceras.models.Producto;
import com.julian.soporte.cabeceras.service.ProductoService;
import com.julian.soporte.cabeceras.service.ProductoServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.html"})
public class controllers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoService productoService = new ProductoServiceImpl();
        List<Producto> productos = productoService.listar();

        response.setContentType("text/html; charset=UTF-8");

        String extencion = request.getServletPath();

        boolean esXls = extencion.endsWith(".xls");

        if(esXls){
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=productosTabla.xls");
        }

        PrintWriter out = response.getWriter();
        if(!esXls) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("	<head>");
            out.println("		<meta charset=\"UTF-8\">");
            out.println("		<title>Listado de Productos</title>");
            out.println("	</head>");
            out.println("	<body>");
            out.println("		<h1>Listado de Productos!!</h1>");
            out.println("       <a href=\"" + request.getContextPath() + "/productos.xls\">Descargar Excel</a>");
            out.println("       </br>");
            out.println("       <a href=\"" + request.getContextPath() + "/productos.json\">Ver productos en Json</a>");

        }

        out.println("       <table>");
        out.println("           <tr>");
        out.println("               <th>id</th>");
        out.println("               <th>Nombre</th>");
        out.println("               <th>Tipo</th>");
        out.println("               <th>Precio</th>");
        out.println("           </tr>");

        productos.forEach(p -> {
            out.println("       <tr>");

            out.println("           <td>" + p.getId() + "</td>");
            out.println("           <td>" + p.getNombre() + "</td>");
            out.println("           <td>" + p.getTipo() + "</td>");
            out.println("           <td>" + p.getPrecio() + "</td>");

            out.println("       </tr>");
        });

        out.println("       </table>");

        if(!esXls) {
            out.println("	</body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
