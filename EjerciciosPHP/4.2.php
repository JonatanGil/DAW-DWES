<html>
<head></head>
<body>

  <p>Before the script...</p>

  <?php

  $num1=1;

   
  $num2=1;

   if($num1++===++$num2){
     
    echo "num1"+($num1++)+" es igual a "+(++$num2);
   }else{
    echo "num1".($num1++)." es igual a ".(++$num2);
   }


  ?>

<br><br>
  <p>...After the script.</p>

</body>

</html>
