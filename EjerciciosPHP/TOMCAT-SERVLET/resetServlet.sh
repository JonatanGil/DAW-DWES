#!/bin/bash
echo "eliminar classes"
sudo rm /opt/tomcat/latest/webapps/Proyecto1/WEB-INF/classes/MiServlet.class
read archivo
echo "copiar archivo a miservlet.java"
cp $archivo MiServlet.java 
echo "javac muevo class"
javac MiServlet.java
echo "muevo el class"
sudo mv MiServlet.class /opt/tomcat/latest/webapps/Proyecto1/WEB-INF/classes/


