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
String titulo = "Parámetros leídos";

boolean divisionPor0=false;
int resultado =0;
String palabra1 =  peticion.getParameter("param1");
String palabra2 =  peticion.getParameter("param2");
String palabra3 =  peticion.getParameter("param3");


salida.println(
"<BODY BGCOLOR=\"#FDF5E6\">\n" +
"<H1 ALIGN=CENTER>" + palabra1 + "</H1>\n" +
"<H2><B>"+ palabra2 + "</B>\n "+
"<H3><B>"+palabra3+"</B>\n" +
"</BODY></HTML>");
}



}