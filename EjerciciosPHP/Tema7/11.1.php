<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>


       <?php

    session_start();
        if (!isset($_SESSION["nombre"])){
        ?>

        <form action='11.1.php' method='POST'>
        <input type='text' name='nombre'>
        <input type='submit' value='enviar post' name='boton'>
        </form>

        <?php
        $_SESSION["nombre"]=$_POST["nombre"];
        
    }else{

        echo $_POST["nombre"]." WELCOME";

    }

    
    ?>


     
  </body>

    </body>
</html>