import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MiServlet41 extends HttpServlet {public void doGet (HttpServletRequest peticion,HttpServletResponse respuesta)throws ServletException, IOException{PrintWriter impresor;
impresor=respuesta.getWriter();
respuesta.setContentType("text/html");
impresor.println("<HTML>\n" +
"<HEAD><TITLE>Hola WWW</TITLE></HEAD>\n" +
"<BODY>\n" +
"<table border='1'>\n" +
"<tr>\n" +
"<td>hola</td><td>hola2</td><td>hola3</td>\n" +
"</tr>" +
"<tr>\n" +
"<td>adiosin</td><td>adiosin2</td><td>adiosin3</td>\n" +
"</tr>\n" +
"</table>\n"+
"</BODY></HTML>");
}
}
