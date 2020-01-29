import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MiServlet extends HttpServlet
{
public void doGet(HttpServletRequest peticion,
HttpServletResponse respuesta)
throws ServletException, IOException
{
Cookie migalleta,migalleta2,migalleta3;
Cookie[] misgalletas;
misgalletas=peticion.getCookies();

if ((misgalletas == null)){
    migalleta=new Cookie("contador","0");
    migalleta.setMaxAge (60); //1 minuto
    migalleta2=new Cookie("contador","1");
    migalleta2.setMaxAge(60); //1 minuto
    migalleta3=new Cookie("contador","2");
    migalleta3.setMaxAge (60); //1 minuto
}else{
    migalleta=misgalletas[0];
    migalleta2=misgalletas[1];
    migalleta3=misgalletas[2];
}
int contador,contador2,contador3;
contador=Integer.parseInt(migalleta.getValue());
contador2=Integer.parseInt(migalleta2.getValue());
contador3=Integer.parseInt(migalleta3.getValue());
migalleta.setValue(""+(contador+1)); // setValue acepta un string, no un entero.
migalleta2.setValue(""+(contador2+1)); // setValue acepta un string, no un entero.
migalleta3.setValue(""+(contador3+1)); // setValue acepta un string, no un entero.
respuesta.addCookie(migalleta);
respuesta.addCookie(migalleta2);
respuesta.addCookie(migalleta3);
respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String titulo = "Contador";
salida.println ("<TITLE>"+titulo+"</TITLE>\n<BODY>");
salida.println ("<H1 ALIGN=CENTER>" + titulo +"</H1>\n\n");
salida.println("El contador vale: "+contador+"<br>");
salida.println("El contador2 vale: "+contador2+"<br>");
salida.println("El contador3 vale: "+contador3+"<br>");
salida.println("</BODY></HTML>");
}
}