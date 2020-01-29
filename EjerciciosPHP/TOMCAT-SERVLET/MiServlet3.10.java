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
int numero1 = Integer.parseInt(peticion.getParameter("param1"));
int numero2 =  Integer.parseInt(peticion.getParameter("param2"));


switch (peticion.getParameter("param3")) {
    case "+":
        resultado = numero1+numero2;
        break;
    case "-":
        resultado = numero1-numero2;
        break;
    case "/":{
        if(numero2==0){
            divisionPor0=true;
        }else{
            resultado = numero1/numero2;
        }
    }break;
    case "*":
        resultado = numero1*numero2;
        break;
}


salida.println(
"<BODY BGCOLOR=\"#FDF5E6\">\n" +
"<H1 ALIGN=CENTER>" + titulo + "</H1>\n" +
"\n"+" <LI><B>Numero1:</B> "
+ peticion.getParameter("param1") + "\n" +
" <LI><B>Numero2:</B> "
+ peticion.getParameter("param2") + "\n" +
" <LI><B>OPerador:</B> ");
if(!divisionPor0){
salida.println(
peticion.getParameter("param1")
+peticion.getParameter("param3") + peticion.getParameter("param2")+" = "+
resultado+
"</BODY></HTML>");
}else{
salida.println(
peticion.getParameter("param1")
+peticion.getParameter("param3") + peticion.getParameter("param2")+" = "+
"error"+"</BODY></HTML>");
}


}
}