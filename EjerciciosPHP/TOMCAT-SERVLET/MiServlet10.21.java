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
           
           
           
            salida.println(
            "<FORM ACTION='http://localhost:8080/Proyecto1/servlet'>"+
            "DNI: <INPUT TYPE='NUMBER' NAME='param1'><BR>"+
            
            "nombre: <INPUT TYPE='text' NAME='param2'><BR>"+
            
            "sueldo: <INPUT TYPE='NUMBER' NAME='param3'><BR>"+
            "<CENTER>"+
            "<INPUT TYPE='SUBMIT'>"+
            "</CENTER>"+
            "</FORM>"
            );
           
           
           
           
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            String SourceURL = "jdbc:mysql://127.0.0.1:3306/bdprueba";
            String user = "miusuario";
            String password = "mipassword";
           
            Connection miconexion;
            miconexion = DriverManager.getConnection(SourceURL, user, password);
           
            int DNI = Integer.parseInt(peticion.getParameter("param1"));
            String nombre  = peticion.getParameter("param2");
            Double sueldo  = Double.parseDouble(peticion.getParameter("param3"));
            salida.println("datos insertados: EL dni:"+DNI+" / el nombre:"+nombre+"/ el sueldo:"+sueldo+"\n\n");
            Statement misentencia;
            ResultSet misresultados;
            misentencia=miconexion.createStatement();
           

            misentencia.executeUpdate("INSERT INTO empleados(DNI,nombre,sueldo) VALUES ("+DNI+",'"+nombre+"',"+sueldo+")");
            
             
            misresultados = misentencia.executeQuery("SELECT last_insert_id()");
            
            int IDConsulta =0;
            while(misresultados.next()){
                salida.println("\n"+misresultados.getInt("last_insert_id()")+"\n");
                IDConsulta = misresultados.getInt("last_insert_id()");

            };
            
            misresultados=misentencia.executeQuery ("SELECT DNI,nombre,sueldo FROM empleados WHERE id="+IDConsulta);
           

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