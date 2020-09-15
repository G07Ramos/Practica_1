package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Edad", urlPatterns = {"/Edad"})
public class Edad extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edad</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edad</h1>");
            
            String nombre = request.getParameter("nombre");
            String fecha = request.getParameter("fecha"); 
            Calendar fecha_actual = new GregorianCalendar();
            
            if (nombre != null || fecha !=null ){
                int año_actual = fecha_actual.get(Calendar.YEAR);
                int edad=año_actual-Integer.parseInt(fecha.substring(4,8));
                out.println("<p>Tu nombre es: "+nombre+" </p>");
                out.println("<p>Tu edad es: "+edad+" años </p>");
            
            }else{
                out.println("Ponga los parametros en la URL nombre y fecha de nacimiento");
                out.println("<br>Ejemplo<br>");
                out.println("<p>?nombre=Gabriela&fecha=20051998</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
