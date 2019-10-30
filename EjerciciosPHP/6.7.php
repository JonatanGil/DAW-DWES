<html>
<head></head>
<body>

  <p>Before the script...</p>

  <?php

    $cadenaC = "jonatan";
    $letrasDown=["a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","u","v","w","x","y","z"];
    /*$letrasUper=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","U","V","W","X","Y","Z"];*/
    $numerosDown = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
    $aux = "";
    $cadenaC = strtolower($cadenaC);
    $bucleCadena = strlen($cadenaC);
    $bucleAbecedario = count($letrasDown);

    echo $cadenaC."<br>";

    for ($i=0; $i < $bucleCadena; $i++) {
      for ($b=0; $b < $bucleAbecedario; $b++) { 

        //si posicion 1 hasta la 26 es la primera de la cadena sumar uno a esa letras, hasta la cadena.lengt del string
        if($letrasDown[$b]==$cadenaC[$i]){
            $numero = $numerosDown[$b];
            $numerosDown[$b]=$numero+1;
        }

      } 
    }

    for ($b=0; $b < count($letrasDown); $b++) { 
      echo $letrasDown[$b]."  esta: ".$numerosDown[$b]."<br>";
    }

  ?>

<br><br>
  <p>...After the script.</p>

</body>

</html>
