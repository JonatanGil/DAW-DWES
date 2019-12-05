<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

    <form action="10.1.php" method="POST">

       <?php
        
        if (isset($_COOKIE["micookie"]))
        {
            echo "La cookie se ha devuelto al servidor y su valor es el nombre introducido: ";
            echo $_COOKIE["micookie"];
            echo "</form>";
        }  
        else{
            

            echo "<input type='text' name='nombre'>";
            echo "<input type='submit'>";
            echo "</form>";

            if($_POST["nombre"]!=""){
  
                $name="micookie";
                $value=$_POST["nombre"]; # Podría ser una cadena de texto
                $expires=time()+60; # 60 segundos después del momento actual
                $path="/";
                $domain="";
                $secure=false;
                $HttpOnly=true;
               
                # Es preciso asegurarse de llamar a setcookie() antes de enviar
                # ninguna otra salida al navegador
                setcookie ($name,$value,$expires,$path,$domain,$secure,$HttpeOnly);
               
                $servidor = "localhost";
                $username = "miusuario";
                $password = "mipassword";
                $basedatos = "bdprueba";
                
                # Crear conexión
                $conn = mysqli_connect($servidor, $username, $password, $basedatos);
                
                if (!$conn) {
                    die("Conexi&ocacuten fallida: " . mysqli_connect_error());
                }else{echo "Conexi&oacuten con &eacutexito <br><br>";}
    
                $idSumado=0;
                $id = mysqli_query($conn, "SELECT MAX(id) FROM ejercicio102;");

                if(!$id){
                    echo "selector fallido<br>";
                }  else{
                    echo "selector con exito<br>";
                }

                //obtenemos array i isnertamos el mayor id que ahi +1
                while ($fila = mysqli_fetch_array($dni)){ 
                    echo $fila[0];
                    $idSumado=$fila[0];
                }
                //insert into ejercicio102(id,nombre) values (1,"jon");
                $nombreInput = $_POST['nombre'];
                $consulta = mysqli_query($conn, "INSERT INTO ejercicio102(id,nombre) VALUES ($idSumado,'$nombreInput')");
        
                if(!$consulta){
                    echo "id nombre insertado  error<br>";
                }  else{
                    echo "id nombre insertado corectamente<br>";
                }
        
                
                
                
                header("Location: 10.1.php");






        }
    }
    
    ?>


     
  </body>

    </body>
</html>