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
for (contador=0;contador<10;contador++) {
    if(contador%2==0){
        salida.println(contador+"<BR>");
    }
}

salida.println("</BODY></HTML>");
}
}