package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MatrizCaracol", urlPatterns = {"/MatrizCaracol"})
public class MatrizCaracol extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Matriz Caracol</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Matriz Caracol</h1>");
        out.println("<form action='' method='post'>");
        out.println("Valor: ");
        out.println("<input type='number' name='valor'>");
        out.println("<input type='submit' value='Procesar'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int valor = Integer.parseInt(request.getParameter("valor"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Matriz Caracol</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Matriz Caracol N = "+valor+"</h1><br>");
            int x=1;
            int[][] M = new int[valor + 1][valor + 1];
            for (int a = 1; a <= valor / 2; a++) {
                for (int i = a; i <= valor - a; i++) {
                    M[a][i] = x;
                    x++;
                }
                for (int i = a; i <= valor - a; i++) {
                    M[i][valor - a + 1] = x;
                    x++;
                }
                for (int i = valor - a + 1; i >= a + 1; i--) {
                    M[valor - a + 1][i] = x;
                    x++;
                }
                for (int i = valor - a + 1; i >= a + 1; i--) {
                    M[i][a] = x;
                    x++;
                }
            }
            if (valor % 2 == 1) {
                M[valor / 2 + 1][valor / 2 + 1] = x;
            }
        out.println("<table border='1' cellspacing='0' width='200'>");
            for(int i = 1; i <= valor; i++){
                out.println("<tr>");
                for (int j = 1; j <= valor; j++) {
                    out.println("<td align='center'>"+M[i][j]+"</td>");
                }
                out.println("</tr>");
            }
        out.println("<table>");        
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
