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
        ?>

        <form action='11.2.php' method='POST'>
        <input type='number' name='numero'>
        <input type='submit' value='enviar post' name='boton'>
        </form>

        <?php
        if(!$_POST["numero"]==""){
            $_SESSION["numero"]=$_SESSION["numero"].$_POST["numero"]."#";
        }
        echo $_SESSION["numero"];
        
    

    
    ?>


     
  </body>

    </body>
</html>