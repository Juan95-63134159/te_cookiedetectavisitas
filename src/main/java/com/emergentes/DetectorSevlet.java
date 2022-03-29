
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetectorSevlet", urlPatterns = {"/DetectorSevlet"})
public class DetectorSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;

        Cookie[] cukis = request.getCookies();

        if (cukis != null) {
            for (Cookie c : cukis) {
                if (c.getName().equals("visitas")) {
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        if(contador ==0){
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Bienvenido a nuestro sitio Web "); 
        }
        else{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Gracias por visitarnos nuevamente "); 
        }
        contador++;
        Cookie c = new Cookie("visitas", Integer.toString(contador));
        //Establece el tiempo de la cookie en segundos
        c.setMaxAge(3600);
        response.addCookie(c);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
