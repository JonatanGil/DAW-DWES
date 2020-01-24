<?php
function ListarMensajes()
{
// Conexión
$link = mysql_connect('localhost', 'usuario', 'password');
mysql_select_db('blog_db', $link);
// Consulta
$result = mysql_query('SELECT fecha, titulo FROM mensaje', $link);
// Rellenar el array
$mensajes = array();
while ($fila = mysql_fetch_array($result, MYSQL_ASSOC))
{
$mensajes[] = $fila;
}
// Cierre de la conexión
mysql_close($link);
return $mensajes;
}
?>
