<html>
<head></head>
<body>

  <p>Before the script...</p>

  <?php

    $_1=1;
    $_2="1";

    echo is_int($_1);
    echo("<br>numero lo detecta como int<br>");
    echo is_int($_2);
    echo("<br>string no lo detecta como numero<br>");
    echo is_int($_1+$_2);
    echo("<br>sumar si, detecta numeros en string y calcula, si el string tiene una letra lo ignora<br>");
  


  ?>

<br><br>
  <p>...After the script.</p>

</body>

</html>
