<?php





function ListarProductos(){
    // Conexión
    $link = mysqli_connect('localhost', 'usuario', 'password', 'Carrito');
    // Consulta
    $result = mysqli_query($link, 'SELECT * FROM producto');
    // Rellenar el array
    $productos = array();
    while ($fila = mysqli_fetch_array($result)){
        $productos[] = $fila;
    }
    // Cierre de la conexión
    mysqli_close($link);
    return $productos;
}




?>
