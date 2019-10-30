<html>
<head></head>
<body>

  <p>Before the script...</p>

  <?php

    $cadenaC = "jonatan aeiou individuo";
    $aux = "";

    echo $cadenaC."<br>";

    for ($i=0; $i <= strlen($cadenaC); $i=$i+2) {

        switch ($cadenaC[$i+1]) {


            case "a":{
                $aux = "e".$aux;
             } break;
            case "e":{
                $aux = "i".$aux;
            } break;
            case "i":{
                $aux = "o".$aux;
            } break;
            case "o":{
                $aux = "u".$aux;
            } break;
            case "u":{
                $aux = "a".$aux;
            } break;

            default:{
                $aux = $cadenaC[$i+1].$aux;
            }break;
        }


        switch ($cadenaC[$i]) {


            case "a":{
                $aux = "e".$aux;
             } break;
            case "e":{
                $aux = "i".$aux;
            } break;
            case "i":{
                $aux = "o".$aux;
            } break;
            case "o":{
                $aux = "u".$aux;
            } break;
            case "u":{
                $aux = "a".$aux;
            } break;

            default:{
                $aux = $cadenaC[$i].$aux;
            }break;
        }


          
    }

    echo $aux."  codificado<br>";

    $aux2="";
    $iPara=0;

    if(strlen($aux)%2!=0){

       //para el impar, que compare la primera posicion compare vocales inserta la primera y despues pares hasta el final con el for
      $iPara=1;

      switch ($aux[0]) {


        case "a":{
            $aux2 = "u".$aux2;
         } break;
        case "e":{
            $aux2 = "a".$aux2;
        } break;
        case "i":{
            $aux2 = "e".$aux2;
        } break;
        case "o":{
            $aux2 = "i".$aux2;
        } break;
        case "u":{
            $aux2 = "o".$aux2;
        } break;

        default:{
            $aux2 = $aux[0].$aux2;
        }break;
    }
    }


    for ($i=$iPara; $i <= strlen($aux); $i=$i+2) {
        
        switch ($aux[$i+1]) {
            case "a":{
                $aux2 = "u".$aux2;
             } break;
            case "e":{
                $aux2 = "a".$aux2;
            } break;
            case "i":{
                $aux2 = "e".$aux2;
            } break;
            case "o":{
                $aux2 = "i".$aux2;
            } break;
            case "u":{
                $aux2 = "o".$aux2;
            } break;

            default:{
                $aux2 = $aux[$i+1].$aux2;
            }break;
        }


        switch ($aux[$i]) {
            case "a":{
                $aux2 = "u".$aux2;
             } break;
            case "e":{
                $aux2 = "a".$aux2;
            } break;
            case "i":{
                $aux2 = "e".$aux2;
            } break;
            case "o":{
                $aux2 = "i".$aux2;
            } break;
            case "u":{
                $aux2 = "o".$aux2;
            } break;

            default:{
                $aux2 = $aux[$i].$aux2;
            }break;
        }


    
    
    }

    echo $aux2."  resuelto<br>";
    
  ?>

<br><br>
  <p>...After the script.</p>

</body>

</html>
