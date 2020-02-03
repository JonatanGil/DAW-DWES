<?php
    $APIKEY="f3d5281b792c932eb2d15d8b5bb85135"; //¡¡Ojo!! Su "Key" será otra.
    $url="http://api.openweathermap.org/data/2.5/weather?q=Valencia&mode=xml&APPID=".$APIKEY;
   
    $respuesta= file_get_contents($url);
   
   
    //  Sin embargo, este documento se podría tratar sin necesidad de mostrarlo.
   
    $xml=simplexml_load_string($respuesta) or die("Error: no se puede crear");
 
    $pais=$xml->city->country;
    $temperatura=$xml->temperature["hola"];
    echo "<br><br>";

    echo "Pais: ".$pais."<br>";
    echo "Temperatura: ".$temperatura."<br>";
   
   
    echo "<PRE>";
    print_r($xml);
    echo "</PRE>";
