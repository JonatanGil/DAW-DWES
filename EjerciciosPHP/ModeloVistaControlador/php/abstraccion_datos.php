<?php

function abrir_conexion($host, $usuario, $password, $bd){
    return mysqli_connect($host, $usuario, $password, $bd);
}


$conn = abrir_conexion('localhost', 'wpadmin', 'wp4dm1n', 'Carrito');

$result = mysqli_query($conn, 'SELECT * FROM Producto');

$productos = mysqli_fetch_all($result);
 
$resutladoFinal =  json_encode($productos);

echo $resutladoFinal;

?>