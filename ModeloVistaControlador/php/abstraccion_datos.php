<?php
function abrir_conexion($host, $usuario, $password)
{
return mysql_connect($host, $usuario, $password);
}
function cerrar_conexion($link)
{
mysql_close($link);
}
function consultar_base_de_datos($consulta, $database, $link)
{
mysql_select_db($database, $link);
return mysql_query($consulta, $link);
}
function extraer_resultados($result)
{
return mysql_fetch_array($result, MYSQL_ASSOC);
}
?>
