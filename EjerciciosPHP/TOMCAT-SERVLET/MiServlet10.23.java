
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MiServlet extends HttpServlet
{
public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
throws ServletException, IOException
{
respuesta.setContentType("text/html");
PrintWriter salida = respuesta.getWriter();
String formulario = peticion.getParameter("form");
String nombre = peticion.getParameter("usuario");
String dni = peticion.getParameter("dni");
String password = peticion.getParameter("password");
boolean bienIntroducido = false;
salida.println ("<H1 ALIGN=CENTER></H1>\n\n");


try
{
DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
String SourceURL = "jdbc:mysql://127.0.0.1:3306/pagweb";
String user = "miusuario";
String pass = "mipassword";
Connection miconexion;
miconexion = DriverManager.getConnection(SourceURL, user, pass);
Statement misentencia;
ResultSet misresultados;

if(formulario.equals("iniciarSesion")){

misentencia=miconexion.createStatement();
salida.println("SELECT * FROM usuarios WHERE dni='"+dni+"';");
misresultados =misentencia.executeQuery ("SELECT * FROM usuarios WHERE dni='"+dni+"';");

while(misresultados.next()){


    salida.println(
        "<TABLE BORDER=1 ALIGN=CENTER>\n"+
        "<TR BGCOLOR=\"#FFAD00\">\n"+
        "<TH>nombre<TH>contraseña<TH>dni");
    while (misresultados.next())
    {
        salida.println(
            "<TR><TD>"+
            misresultados.getString("nombre")+"\n<TD>"+
            misresultados.getString("contraseña")+"\n<TD>"+
            misresultados.getFloat("dni"));
    }
    salida.println("</TABLE>");

    salida.println("<button onclick='location.href='MiServletHTML10.23usuario.html'''>Crear Usuario</button>");
    salida.println("</BODY></HTML>");

bienIntroducido = true;
}

if(bienIntroducido == false){
salida.println("No coincide el dni en la base de datos");     
}
}

if(formulario.equals("crearUsuario")){

misentencia=miconexion.createStatement();
misentencia.executeUpdate("INSERT INTO usuarios VALUES('"+nombre+"','"+password+"','"+dni+"');");
}

miconexion.close();
}
catch (SQLException sqle)
{ 
    
salida.println(sqle);
salida.println("</BODY></HTML>");
}
}
}