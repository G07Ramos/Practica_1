package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CambioMoneda", urlPatterns = {"/CambioMoneda"})
public class CambioMoneda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cambio de Moneda</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Cambio de Moneda</h1>");
        out.println("<form action='' method='post'>");
        out.println("Monto: ");
        out.println("<input type='float' name='monto'>");
        out.println("<br><br>DE:");
        out.println("<select name='opcion1'>");
        out.println("<option value='1'>Bolivianos</option>");
        out.println("<option value='2'>Dolar</option>");
        out.println("</select>");
        out.println("A:");
        out.println("<select name='opcion2'>");
        out.println("<option value='1'>Bolivianos</option>");
        out.println("<option value='2'>Dolar</option>");
        out.println("</select>");
        out.println("<br><br><input type='submit' value='Procesar'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        double monto = Double.parseDouble(request.getParameter("monto"));
        int valor1=Integer.parseInt(request.getParameter("opcion1"));
        int valor2=Integer.parseInt(request.getParameter("opcion2"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cambio de Moneda</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Cambio de Moneda</h1><br>");
            double r;
            double cambio=6.96;
            if(valor1==1){
                if(valor2==1){
                    r=monto;
                    out.print("El monto Bs "+monto+" es Bs "+r);
                }else{
                    r=monto/cambio;
                    out.print("El monto Bs "+monto+" es $ "+r);
                }
            }else if(valor1==2){
                if(valor2==1){
                    r=monto*cambio;
                    out.print("El monto $ "+monto+" es Bs  "+r);
                }else{
                    r=monto;
                    out.print("El monto $ "+monto+" es $  "+r);
                }
            }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
