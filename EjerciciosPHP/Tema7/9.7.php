<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
       



    <form action="9.6.php" method = "post">
      
        Introduzca su nombre:
        <br>
        <input type="text" name="nombre">
        <br>
        Sueldo
        <input type="number" name="sueldo">
        <br>
        Plus:
        <input type="number" name="plus" value="0">
        <br>
        <input type="submit" value="enviar">
    </form>



    <?php


        if ( !isset ( $_POST["nombre"] ) )  {
           # En caso contrario (es decir, si se ha pulsado antes el botón)...
           }else{


        # Crear conexión
        $conn = conexionBDD();
        InsertarEmpleado($conn);
        mysqli_close($conn);
    }

    # Crear conexión y ver todos los dni
    $conn = conexionBDD();
    $empleados = mysqli_query($conn, " SELECT * from ejercicio92;");
        
        if(!$empleados){
            echo "selector fallido<br>";
        }  else{
            echo "selector con exito<br>";
        }
    ?>

    <form action="9.7.php" method="POST">

        <select name="eliminar">
        <?php foreach ($empleados as $r): ?>

            <option value="<?php echo $r['DNI']; ?>"> <?php echo $r['DNI']; ?> : <?php echo $r['nombre']; ?> </option>

        <?php endforeach; ?>
        </select>
        <br>
        <input type="submit" value="DELETE">

    </form>


    <?php
    if(!isset($_POST["eliminar"])){
           # En caso contrario (es decir, si se ha pulsado antes el botón)...
    }else{

    # Crear conexión
    $conn = conexionBDD();
    //eliminar dni funcion
    eliminarDNI($conn);
    mysqli_close($conn);

    }



function InsertarEmpleado($conecxion){

    $dni = mysqli_query($conecxion, "SELECT MAX(dni) FROM ejercicio92;");
        
    if(!$dni){
        echo "selector fallido<br>";
    }  else{
        echo "selector con exito<br>";
    }


    while ($fila = mysqli_fetch_array($dni)){ 
        echo $fila[0];
        $dniNumero=$fila[0];
    }

    //sumamos una al id dni
    $dniNumero++;

    $dniSumado= $dniNumero;
    $nombreE = $_POST['nombre'];
    $sueldo = $_POST["sueldo"];
    $plus = $_POST["plus"];

    $consulta = "INSERT INTO ejercicio92(dni,nombre,sueldo,plus) VALUES ($dniSumado,'$nombreE',$sueldo,$plus);";
    echo $consulta."<br>";
    $result2 = mysqli_query($conecxion,$consulta);

    if ($result2==TRUE){
        echo "Se ha insertado la fila: ".$dniSumado."/ ".$nombreE."/ ".$sueldo."/ ".$plus ."<br>";
    }else{
        # La siguiente función muestra el último error, en caso
        # de haberlo.
        echo mysqli_error($conecxion);
        die ("Hubo un error");
    }   # Como no se trata de un SELECT, mysqli_query devuelve TRUE
        


}

function eliminarDNI($conecxion){
    $dniEliminar = $_POST["eliminar"];
    echo "<br> DNI a eliminar".$dniEliminar.":".$_POST["eliminar"]."<br>";
    $consulta = "DELETE FROM ejercicio92 WHERE DNI LIKE $dniEliminar;";
    $resultado = mysqli_query($conecxion,$consulta);
    if ($resultado==TRUE){
        echo "Se ha eliminado el dni".$dniEliminar."<br>";
    }else{
        # La siguiente función muestra el último error, en caso
        # de haberlo.
        echo mysqli_error($conecxion);
        die ("Hubo un error");
    }   # Com
    
   
}

function conexionBDD(){


    $servidor = "localhost";
    $username = "miusuario";
    $password = "mipassword";
    $basedatos = "bdprueba";

    # Crear conexión
    $conecxion = mysqli_connect($servidor, $username, $password, $basedatos);

    if (!$conecxion) {
        die("<br><br>Conexi&ocacuten fallida: " . mysqli_connect_error());
    }
    echo "<br><br>Conexi&oacuten con &eacutexito <br>";

    if (!$conecxion) {
        die("<br><br>Conexi&ocacuten fallida: " . mysqli_connect_error());
    }
    echo "<br><br>Conexi&oacuten con &eacutexito <br><br>";
    

        return $conecxion;
    }



    ?>


</body>
</html>