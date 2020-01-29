import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MiServlet3.5 extends HttpServlet{
String[] arrayNumeros = new String[500];
int contador = 0;
public void doGet(HttpServletRequest peticion,
HttpServletResponse respuesta)
throws ServletException, IOException{
//no sumara porque esta iniciado despues, se iniciara cada vez a 1.


respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String titulo = "Contador";
salida.println ("<TITLE>"+titulo+"</TITLE>\n<BODY>");
salida.println ("<H1 ALIGN=CENTER>" +
titulo + "</H1>\n\n");
for(int a=0;a<contador;a++){
salida.println(arrayNumeros[a]+a)+"<br>";
}
salida.println("</BODY></HTML>");
arrayNumeros[contador]="Numero:";
contador++;
}
}
