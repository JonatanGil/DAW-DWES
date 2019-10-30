<html>
<head></head>
<body>

  <p>Before the script...</p>

  <?php

    $cadenaC = "aeiou";
    echo $cadenaC." <br>cambiar las (a)   por (e)<br>";
    $aux = "";
    echo strlen($cadenaC)."tamaño de la cadena para el for(las A mayus no las cambio)<br>";

    for ($i=0; $i <= strlen($cadenaC); $i++) {

        switch ($cadenaC[$i]) {


            case "e":{
                $aux = $aux."a";
             } break;
            case "i":{
               $aux = $aux."e";
            } break;
            case "o":{
              $aux = $aux."i";
            } break;
            case "u":{
             $aux = $aux."o";
            } break;
            case "a":{
              $aux = $aux."u";
            } break;

            
            default:{
            $aux = $aux.$cadenaC[$i];
            }break;
        }
        
        if($i==strlen($cadenaC)){
            $ultimo = substr($aux, strlen($aux)-1, strlen($aux));            
            $aux = substr($aux, 0, -1);
            $aux = $ultimo.$aux;
        }
        
    }

    echo $aux;
  ?>

<br><br>
  <p>...After the script.</p>

</body>

</html>
