
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings ("unchecked")

public class MiServlet3 extends HttpServlet
{
public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
throws ServletException, IOException
{
respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String formulario = peticion.getParameter("form");
if(peticion.getParameter("IdProducto")!=null){

    int a = Integer.parseInt(peticion.getParameter("IdProducto"));
}


salida.println ("<H1 ALIGN=CENTER>TIENDA VIRTUAL</H1>\n\n");


try
{
DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
String SourceURL = "jdbc:mysql://127.0.0.1:3306/tiendavirtual";
String user = "miusuario";
String pass = "mipassword";
Connection miconexion;
miconexion = DriverManager.getConnection(SourceURL, user, pass);
Statement misentencia;
misentencia=miconexion.createStatement();
Statement misentencia2;
misentencia2=miconexion.createStatement();
ResultSet misresultados;
ResultSet misresultados2;
ResultSet misresultados3;

        salida.println("<h2>TODOS LOS PEDIDOS CON SUS COSAS</H2>");

  
        
  misresultados =misentencia.executeQuery("SELECT * FROM Pedidos");
  salida.println(
    "<TABLE BORDER=1 ALIGN=CENTER>\n"+
    "<TR BGCOLOR=\"#FFAD00\">\n"+
    "<TH>DetallePedido<TH>ClienteID<TH>IdPEDIDO<TH>IdProducto<TH>Cantidad<TH>TOTAL de la factura");

    while (misresultados.next()) {
        int IdPedido = misresultados.getInt("IdPedidos");
        int idCliente = misresultados.getInt("IdUsuario");
        int totalg = misresultados.getInt("PrecioTotal");
    
        misresultados2 = misentencia2.executeQuery("SELECT * from DetallePedido where IdPedido="+IdPedido);
    
    
      while (misresultados2.next()) {
        salida.println(
        "<TR>"+
        "<TD>"+misresultados2.getInt("IdDetalleDePedidos")+"\n</TD>"+
        "<TD>"+idCliente+"\n</TD>"+
        "<TD>"+misresultados2.getInt("IdPedido")+"\n</TD>"+
        "<TD>"+misresultados2.getDouble("IdProducto")+"\n</TD>"+
        "<TD>"+misresultados2.getInt("Cantidad")+"</TD>"+
        "<TD>"+totalg+"</TD>"+
        "</TR>");
      }
    }

salida.println("</TABLE>");











salida.println("</BODY></HTML>");


miconexion.close();

}catch (SQLException sqle)
{ 
    
salida.println(sqle);
salida.println("</BODY></HTML>");
}


}
}
