<html>
<head></head>
<body>

  <p>Before the script...</p>

  <?php

    $num1=3;
    $num2=3;

    if($num1===$num2){
        
        echo ("a) igual a la segunda "."<br>");
    }

    if($num1>$num2){
        echo ("b) mayor que la segunda <br>");
    }

    if($num1<=$num2){
        echo ($num1." c) es menor o igual que la segunda:".$num2);
    }

    if($num!=$num2){
        echo ($num1+" d) no es igual a la segunda:"+$num2);
    }




  ?>

<br><br>
  <p>...After the script.</p>

</body>

</html>
