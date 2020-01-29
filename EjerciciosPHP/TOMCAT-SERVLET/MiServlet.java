import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;

public class MiServlet extends HttpServlet

{

   public void doGet (HttpServletRequest peticion,

   HttpServletResponse respuesta)

   throws ServletException, IOException

   {

       PrintWriter impresor;

       impresor=respuesta.getWriter();

       impresor.println("Hola, mundo");

   }

}