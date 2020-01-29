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
        String titulo = "Conexión JDBC a MySQL";
        salida.println ("<TITLE>"+titulo+"</TITLE>\n");
        salida.println ("<BODY BGCOLOR=\"#FDF5E6\">\n");
        salida.println ("<H1 ALIGN=CENTER>"+titulo+"</H1>\n\n");
       
        try
        {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            String SourceURL = "jdbc:mysql://127.0.0.1:3306/bdprueba";
            String user = "miusuario";
            String password = "mipassword";
           
            Connection miconexion;
            miconexion = DriverManager.getConnection(SourceURL, user, password);
           

            Statement misentencia;
            ResultSet misresultados;
            misentencia=miconexion.createStatement();


            int DNI = Integer.parseInt(peticion.getParameter("param1"));
            salida.println(DNI+"EL dni pasado como parametro");
            misresultados=misentencia.executeQuery ("SELECT * FROM empleados WHERE DNI = "+DNI);
           
            salida.println(
                "<TABLE BORDER=1 ALIGN=CENTER>\n"+
                "<TR BGCOLOR=\"#FFAD00\">\n"+
                "<TH>DNI<TH>Nombre<TH>Sueldo");
           
            while (misresultados.next())
            {
                salida.println(
                    "<TR><TD>"+
                    misresultados.getInt("DNI")+"\n<TD>"+
                    misresultados.getString("nombre")+"\n<TD>"+
                    misresultados.getFloat("sueldo"));
            }
            salida.println("</TABLE></BODY></HTML>");
            miconexion.close();
        }
        catch (SQLException sqle)
        {
            salida.println(sqle);
            salida.println("</BODY></HTML>");
        }
    }
}