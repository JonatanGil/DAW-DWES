
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings ("unchecked")

public class MiServlet extends HttpServlet
{
public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
throws ServletException, IOException
{
respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String formulario = peticion.getParameter("form");

if(peticion.getParameter("form")==null){
    formulario="vacio";
}else{
}

salida.println ("<H1 ALIGN=CENTER>TIENDA VIRTUAL</H1>\n\n");
ArrayList<Integer> IdProductosArray= new ArrayList<Integer>();

HttpSession misesion;
misesion=peticion.getSession(true);

if (misesion.isNew()==true){
    IdProductosArray= new ArrayList<Integer>();
    misesion.setAttribute("idSesion", IdProductosArray);
}else{
    //si existe no se hace nada
}
//cuando meta uno de los productos form valdra 1 inserto
if(formulario.equals("1")){

    var misesionIdes = (ArrayList<Integer>) misesion.getAttribute("idSesion");
    int idProducto = Integer.parseInt(peticion.getParameter("id"));
    misesionIdes.add(idProducto);
    misesion.setAttribute("idSesion", misesionIdes);
}


if(misesion.getAttribute("idSesion")!=null){

    Object arraylistIDs =  misesion.getAttribute("idSesion");
    IdProductosArray = (ArrayList<Integer>) arraylistIDs;


try
{
DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
String SourceURL = "jdbc:mysql://127.0.0.1:3306/tiendavirtual";
String user = "miusuario";
String pass = "mipassword";
Connection miconexion;
miconexion = DriverManager.getConnection(SourceURL, user, pass);
Statement misentencia;
ResultSet misresultados;


if(!formulario.equals("enviar")){

misentencia=miconexion.createStatement();
misresultados =misentencia.executeQuery ("SELECT * from productos");
salida.println(
    "<TABLE BORDER=1 ALIGN=CENTER>\n"+
    "<TR BGCOLOR=\"#FFAD00\">\n"+
    "<TH>Producto<TH>Precio<TH>Comprar");

while (misresultados.next()) {
        salida.println(
            "<TR><TD>"+
            misresultados.getString("nombre")+"\n</TD>"+
            "<TD>"+misresultados.getDouble("precio")+"\n</TD>"+
            "<TD>"+"<form ACTION='http://localhost:8080/Proyecto1/servlet' method='GET'>"+
            "<input type='text' name='id' value='" +misresultados.getInt("id")+"' hidden>"+
            "<input type='text' name='form' value='1' hidden>"+
            "<input TYPE='SUBMIT' value='1'>"+
            "</form>"+
            "</TD>"+
            "</TR>");
}

salida.println("</TABLE>");

salida.println(
    "<form ACTION='http://localhost:8080/Proyecto1/servlet2' method='GET'>"+
    "<input type='text' name='form' value='enviar' hidden>"+
    "<input TYPE='SUBMIT' value='Ver Carrito'>"+
    "</form>"
    );
   
}


salida.println("</BODY></HTML>");


miconexion.close();

}catch (SQLException sqle)
{ 
    
salida.println(sqle);
salida.println("</BODY></HTML>");
}

}
}
}
