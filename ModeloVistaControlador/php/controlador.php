<?php
// Requerir el modelo
require_once('modelo.php');
// Extraer la lista de mensajes
$mensajes = ListarMensajes();
// Requerir la vista
require('vista.php');
?>
