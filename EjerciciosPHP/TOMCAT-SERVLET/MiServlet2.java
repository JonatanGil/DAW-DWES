
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings ("unchecked")

public class MiServlet2 extends HttpServlet
{
public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
throws ServletException, IOException
{
respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String formulario = peticion.getParameter("form");
if(peticion.getParameter("id")!=null){

    int a = Integer.parseInt(peticion.getParameter("id"));
}

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


    salida.println("Valor de los productos");
    salida.println(IdProductosArray+"<br>   ");
        




    if(formulario.equals("enviar")){



    salida.println(
        "<TABLE BORDER=1 ALIGN=CENTER>\n"+
        "<TR BGCOLOR=\"#FFAD00\">\n"+
        "<TH>Producto</TH><TH>Precio</TH><TH>Comprar</TH>");
    

for (int i = 0; i < IdProductosArray.size(); i++) {
    
            int ide = IdProductosArray.get(i);
            misentencia=miconexion.createStatement();
            misresultados =misentencia.executeQuery("select * from productos where id="+ide);

            while (misresultados.next()) {
                salida.println(
                "<TR>"+
                "<TD>"+misresultados.getString("nombre")+"\n</TD>"+
                "<TD>"+misresultados.getDouble("precio")+"\n</TD>"+
                "<TD>"+misresultados.getInt("id")+"</TD>"+
                "</TR>");
                suma = suma + misresultados.getDouble("precio");
            }



           
    }
    salida.println("</TABLE>");

    salida.println(
        "<form ACTION='http://localhost:8080/Proyecto1/servlet2' method='GET'>"+
        "<input type='text' name='form' value='precio' hidden>"+
        "<input type='text' name='total' value='"+suma+"' hidden>"+
        "<input TYPE='SUBMIT' value='Confirmar'>"+
        "</form>"
        );


        salida.println("<h1>"+suma+": valor de todos los productos</h1>");
       
    }else{

        salida.println("PRECIO transporte="+(IdProductosArray.size())+"<br>");

        salida.println("mas gasto de enviaos +2 euros"+(IdProductosArray.size()+2)+"<br>");

        salida.println(peticion.getParameter("total")+"<br>");

        salida.println(Double.parseDouble(peticion.getParameter("total"))+"<br>");
        
        salida.println(peticion.getParameter("total")+(IdProductosArray.size()+2)+"<br>");

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
