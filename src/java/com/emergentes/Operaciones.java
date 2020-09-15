package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Operaciones", urlPatterns = {"/Operaciones"})
public class Operaciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Operaciones</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Operaciones</h1>");
        out.println("<form action='' method='post'>");
        out.println("Numero 1:");
        out.println("<input type='number' name='numero1'>");
        out.println("<br><br>Numero 2:");
        out.println("<input type='number' name='numero2'>");
        out.println("<br><br>Operador:");
        out.println("<select name='operaciones'>");
        out.println("<option value='1'>SUMA</option>");
        out.println("<option value='2'>RESTA</option>");
        out.println("<option value='3'>MULTIPLICACION</option>");
        out.println("<option value='4'>DIVISION</option>");
        out.println("</select>");
        out.println("<br><br><input type='submit' value='Procesar'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        double numero1 = Double.parseDouble(request.getParameter("numero1"));
        double numero2 = Double.parseDouble(request.getParameter("numero2"));
        int valor=Integer.parseInt(request.getParameter("operaciones"));
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Operacion</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>OPERACION:</h1><br>");
            double r;
            if(valor==1){
                r=numero1+numero2;
                out.print("La suma es :" +r);
            }else if(valor==2){
                r=numero1-numero2;
                out.print("La resta es :" +r);
            }else if(valor==3){
                r=numero1*numero2;
                out.print("El producto es:" +r);
            }else if(valor==4){
                if(numero2==0){
                    out.print("No hay divison con cero es infinito");
                }else{
                    r=numero1/numero2;
                    out.print("La división es :" +r);
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
