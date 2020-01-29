import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MiServlet extends HttpServlet
{
int contador=1;
int contador2=2;
int contador3=3;
public void init() throws ServletException
{
}
public void doGet(HttpServletRequest peticion,
HttpServletResponse respuesta)
throws ServletException, IOException
{
respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String titulo = "Contador";
salida.println ("<TITLE>"+titulo+"</TITLE>\n<BODY>");
salida.println ("<H1 ALIGN=CENTER>" +
titulo + "</H1>\n\n");
salida.println("El contador vale: "+contador+"<br>");
salida.println("El contador vale: "+contador2+"<br>");
salida.println("El contador vale: "+contador3+"<br>");
salida.println("</BODY></HTML>");
contador++;
contador2+=2;
contador3+=4;

}
}


