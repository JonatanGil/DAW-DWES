
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
String password = peticion.getParameter("password");
boolean bienIntroducido = false;
salida.println ("<H1 ALIGN=CENTER></H1>\n\n");


try
{
DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
String SourceURL = "jdbc:mysql://127.0.0.1:3306/amazon22";
String user = "miusuario";
String pass = "mipassword";
Connection miconexion;
miconexion = DriverManager.getConnection(SourceURL, user, pass);
Statement misentencia;
ResultSet misresultados;

if(formulario.equals("iniciarSesion")){

misentencia=miconexion.createStatement();
misresultados =misentencia.executeQuery ("SELECT * FROM usuario WHERE nombre='"+nombre+"' and contraseña='"+password+"' ;");

while(misresultados.next()){

salida.println("Hola que tal "+nombre);
bienIntroducido = true;
}

if(bienIntroducido == false){
salida.println("Ha introducido mal la contraseña");     
}
}

if(formulario.equals("crearUsuario")){

misentencia=miconexion.createStatement();
misentencia.executeUpdate("INSERT INTO usuario VALUES('"+nombre+"','"+password+"');");
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