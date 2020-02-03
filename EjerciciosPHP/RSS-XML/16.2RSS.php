<html>

<head>
    <title>Prueba</title>
    <style>
        h3 {
            color: red
        }

        h2 {
            color: red;
        }
    </style>
</head>

<body>

    <?php
    $xml = simplexml_load_file("http://estaticos.elmundo.es/elmundo/rss/valencia.xml");
    # Se muestra el título del feed RSS
    echo "<div style='color:white;background-color:blue;width:250px;float:left;padding:10px'><h2>" . $xml->channel->title . "</h2><br/><br/>";
    # Se muestra la primera noticia:

    foreach ($xml->channel->item as $elemento) {
        echo "<br>" . $elemento->title . "<br>";
        echo "<a href='$elemento->link'>'LINK'</a><br>";
    }
    echo "</div>";




    
    # Se muestra el título del feed RSS
    echo "<div style='color:white;background-color:black;width:250px;float:left;margin-left:10px;padding:10px'><h2>" . $xml->origen->nombre . "</h2>";

    $xml = simplexml_load_file("http://www.aemet.es/xml/municipios/localidad_46250.xml");

    echo "<h2> Temperatura maxima 7dias siguientes </h2><br><br>";
    foreach ($xml->prediccion->dia as $elemento) {
        $atributos = $elemento->attributes();
        echo "<h3>Fecha--> " . $atributos['fecha'] . "</h3>";

        echo "Temperatura maxima" . $elemento->temperatura->maxima . "<br>";
        echo "<br> Temperatura minima" . $elemento->temperatura->minima . "<br><br>";
    }
    echo "</div>";




    # Se crea un objeto SimpleXML
    $xml = simplexml_load_file("http://feeds.bbci.co.uk/mundo/rss.xml");
    # Se muestra el título del feed RSS
    echo "<div style='color:white;background-color:blue;width:250px;float:left;padding:10px'><h2>" . $xml->channel->title . "</h2><br/><br/>";
    # Se muestra la primera noticia:

    foreach ($xml->channel->item as $elemento) {
        echo "<br>" . $elemento->title . "<br>";
        echo "<a style='color:purple' href='$elemento->link'>'<strong>LINK</strong>'</a><br>";
    }
    echo "</div>";






    ?>
</body>

</html>