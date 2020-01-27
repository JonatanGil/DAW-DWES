<?php
$data = file_get_contents("../got.json");
$result = json_decode($data, true);
 

        // Rellenar el array
        $personajes = array();
        while ($fila = mysqli_fetch_array($result))
        {   
        $personajes[] = $fila;
        }


    return $personajes;

?>