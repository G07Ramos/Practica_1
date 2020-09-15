package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "JuegoDados", urlPatterns = {"/JuegoDados"})
public class JuegoDados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Juego de Dados</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Juego de Dados</h1>");
        out.println("<form action='' method='post'>");
        out.println("<input type='submit' value='Lanzar Dados'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Juego de Dados</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Lanzamiento de Dados:</h1><br>");
            int dado1 = (int)(Math.random() * 6) + 1;
            int dado2 = (int)(Math.random() * 6) + 1;
            out.println("Dado 1 = "+dado1);
            out.println("<br>Dado 2 = "+dado2);
            int suma = dado1 + dado2;
            if (suma == 7 || suma == 11){
                out.println("<br><br>Felicidades has ganado");
            }else{ 
                out.println("<br><br>Lo siento has perdido");
            }   
        out.println("</body>");
        out.println("</html>");

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
