import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MiServlet extends HttpServlet
{
Integer a;
int numero=1;
String[] numeros=new String[500];

public void doGet(HttpServletRequest peticion,
HttpServletResponse respuesta)
throws ServletException, IOException
{
HttpSession misesion;
misesion=peticion.getSession(true);
if (misesion.isNew()==true)
{
a=new Integer(1);
misesion.setAttribute("Contador", a);
}
else
{
a=(Integer)misesion.getAttribute("Contador");
a=new Integer(a.intValue()+1);
misesion.setAttribute("Contador", a);
}
respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String titulo = "Contador";
salida.println ("<TITLE>"+titulo+"</TITLE>\n<BODY>");
salida.println ("<H1 ALIGN=CENTER>" + titulo +
"</H1>\n\n");
salida.println("El contador vale: "+a.intValue()+"<br>");

for (int i = 0; i < a.intValue(); ++i) {

    numeros[i]="otra vez";
    salida.println(numeros[i]+"<br>");
}
salida.println("</BODY></HTML>");
}
}