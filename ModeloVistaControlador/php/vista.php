<html>
<head>
<title>List of productos</title>
</head>
<body>
<h1>List of productos</h1>
<table>
<tr><th>Date</th><th>Title</th></tr>
<?php foreach ($productos as $post): ?>

<form action="controlador.php" method="POST">
<tr>
<td><input type="text" value='<?php echo $post['IdProducto'] ?>' hidden><?php echo $post['IdProducto'] ?></td>
<td><?php echo $post['Precio'] ?></td>
<td><?php echo $post['Nombre'] ?></td>
<td><input type="submit" value="comprarProducto"></td>
</tr>
</form>

<?php endforeach; ?>
</table>
<form action="controlador.php">
<input type="submit" value="Comprar">
</form>
</body>
</html>
