<html>
    <head>
        <title>Prueba</title>
    </head>

    <body>

        <?php
            # Para conocer en qué consiste RSS (“really simple syndication”),
            # pruebe a leer noticias desde un móvil con un programa como por
            # ejemplo feedly.

            # Conéctese con un navegador a:
            # http://estaticos.elmundo.es/elmundo/rss/valencia.xml
           
            # A continuación vamos a ver un cliente RSS con PHP:
           
            # Se crea un objeto SimpleXML
            $xml=simplexml_load_file("http://estaticos.elmundo.es/elmundo/rss/valencia.xml");
            # Se muestra el título del feed RSS
            echo "<h2>".$xml->channel->title."</h2><br/><br/>";
            # Se muestra la primera noticia:
           
            foreach ($xml->channel->item as $elemento) 
            {
            echo "<br>".$elemento->title."<br>";
            echo "<a href='$elemento->link'>'LINK'</a><br>";
        }

            /*

            //$href = $elemento->channel->getElementsByTagName('link')->item(0)->getAttribute('href');



            
            $namespaces = $elemento->getNameSpaces(true);
            $media = $elemento->children($namespaces['href']);
            echo "El link es:" .$media->thumbnail."<br>";


                for ($i = 1; $i <= strlen ( $xml ); $i++) {
                    echo "<br>".$xml->channel->item[$i]->title;
                }
            */
            

                
        ?>
    </body>
</html>