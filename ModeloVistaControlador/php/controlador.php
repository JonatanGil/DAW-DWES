<?php

// Requerir el modelo
require_once('modelo.php');
// Extraer la lista de mensajes
$productos = ListarProductos();
// Requerir la vista
require('vista.php');

?>
