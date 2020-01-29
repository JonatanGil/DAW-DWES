import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MiServlet extends HttpServlet
{
public void doGet(HttpServletRequest peticion,
HttpServletResponse respuesta)
throws ServletException, IOException
{
respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String titulo = "Contador";
salida.println ("<TITLE>"+titulo+"</TITLE>\n<BODY>");
salida.println ("<H1 ALIGN=CENTER>"+titulo+"</H1>\n\n");
int contador;
int contador2;
int contador3;
salida.println("<table border='1' align='center'>" );
for (contador=1;contador<=5;contador++) {
    salida.println("<tr>");
    for (contador2=1;contador2<=5;contador2++){
        for (contador3=1;contador3<=5;contador3++){
            salida.println("<td>"+contador+""+contador2+""+contador3+"</td>");
        }
    }
    salida.println("</td>");
}
salida.println("</table>");
salida.println("</BODY></HTML>");
}
}