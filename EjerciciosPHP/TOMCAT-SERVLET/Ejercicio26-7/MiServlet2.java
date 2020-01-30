
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings ("unchecked")

public class MiServlet2 extends HttpServlet
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

Cookie migalleta;
Cookie[] misgalletas;
misgalletas=peticion.getCookies();

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
double suma= 0;





    if(formulario.equals("enviar")){


        salida.println("Valor de los productos");
        salida.println(IdProductosArray+"<br>   ");

    salida.println(
        "<TABLE BORDER=1 ALIGN=CENTER>\n"+
        "<TR BGCOLOR=\"#FFAD00\">\n"+
        "<TH>Producto</TH><TH>Precio</TH><TH>Comprar</TH>");
    

for (int i = 0; i < IdProductosArray.size(); i++) {
    
            int ide = IdProductosArray.get(i);
            misentencia=miconexion.createStatement();
            misresultados =misentencia.executeQuery("select * from Productos where IdProducto="+ide);

            while (misresultados.next()) {
                salida.println(
                "<TR>"+
                "<TD>"+misresultados.getString("Nombre")+"\n</TD>"+
                "<TD>"+misresultados.getDouble("Precio")+"\n</TD>"+
                "<TD>"+misresultados.getInt("IdProducto")+"</TD>"+
                "</TR>");
                suma = suma + misresultados.getDouble("precio");
            }



           
    }
    salida.println("</TABLE>");

    salida.println(
        "<form ACTION='http://localhost:8080/Proyecto1/servlet2' method='GET'>"+
        "<input type='text' name='form' value='Confirmar' hidden>"+
        "<input type='text' name='total' value='"+suma+"' hidden>"+
        "<input TYPE='SUBMIT' value='Confirmar'>"+
        "</form>"
        );


        salida.println("<h1>"+suma+": valor de todos los productos</h1>");
        salida.println("<h1>"+(suma+(IdProductosArray.size()+2))+": valor total /gastos de envios etc..</h1>");
       
    }else{

        if(formulario.equals("Confirmar")){
            
            salida.println(
                
                "<form ACTION='http://localhost:8080/Proyecto1/servlet2' method='GET'>"+
                "<input type='text' name='NombreCliente' value='IntroduceNombre' >"+
                "<input type='text' name='apellidoCliente' value='IntroduceApellidos' >"+
                "<input type='text' name='total' value='"+peticion.getParameter("total")+"' hidden>"+
                "<input type='text' name='form' value='GraciasCompra' hidden>"+
                "<input TYPE='SUBMIT' value='REALIZAR PEDIDO'>"
            );
             

    }else{

        salida.println("<h2>GRACIAS POR SU COMPRA</H2>");


        salida.println(
            "<form ACTION='http://localhost:8080/Proyecto1/servlet' method='GET'>"+
            "<input type='text' name='form' value='volver' hidden>"+
            "<input TYPE='SUBMIT' value='Volver Al inicio'>"+
            "</form>"
            );

        String nombreCliente = peticion.getParameter("NombreCliente")+" "+peticion.getParameter("apellidoCliente");

        misentencia=miconexion.createStatement();
        misentencia.executeUpdate("INSERT INTO  Usuario  VALUES(null,'"+nombreCliente+"','')");
        
        misentencia=miconexion.createStatement();
        misresultados = misentencia.executeQuery ("SELECT IdUsuario from Usuario where Nombre LIKE '"+nombreCliente+"'");

        //int idCliente = (int) misresultados.getInt("IdUsuario");
        int idCliente= 404;
        while (misresultados.next()) {
            idCliente =  misresultados.getInt("IdUsuario");
            break;
        }



    
    if ((misgalletas == null)){
        migalleta=new Cookie("Nombre","idCliente");
        migalleta.setMaxAge (555); //1 minuto
    }else{
        migalleta=misgalletas[0];
    }


        //                                  pedido autoincre como el cliente primer campo pedido
        misentencia.executeUpdate("INSERT INTO  Pedidos  VALUES("+idCliente+","+idCliente+","+peticion.getParameter("total")+")");

        for (int i = 0; i < IdProductosArray.size(); i++) {
    
            int ide = IdProductosArray.get(i);
            
            misentencia=miconexion.createStatement();
            //misresultados =misentencia.executeQuery("SELECT * FROM Productos where IdProducto="+ide);
            //                                  pedido autoincre como el cliente primer campo pedido
            misentencia.executeUpdate("INSERT INTO  DetallePedido  VALUES(null,"+ide+","+idCliente+","+1+")");
            
        }

        


        
    }

        

    /*



        misentencia=miconexion.createStatement();

        
       
        misentencia.executeUpdate("INSERT INTO facturas VALUES('"+IdProductosArray.get(0)+"','"+
        Double.parseDouble(peticion.getParameter("total")+IdProductosArray.size()+2)+"','"+
        null+"');");*/



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
