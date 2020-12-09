<?php 
require_once ('../../cabecera.php');
//Controlador


//Control de inicio de sesion
if (!$acceso->hayUsuario()){
    header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/acceso/login.php");
    exit();
}

//Control de permisos
if(!$acceso->puedePermisos(1) || !$acceso->puedePermisos(9)){
    paginaError("No dispone de permisos para realizar esta acción");
    exit();
}

$sentencia = "select * from dfs_productos_categorias";
$consulta = $sqli->query($sentencia);

//Vista
inicioCabecera("Usuarios");
cabecera();
finCabecera();
inicioCuerpo("CRUD",$acceso,$sqli);
cuerpo($consulta);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos){
    ?>
    <div class="bloque" style="width: 95%;">
        <table class="crud">
            <tr>
                <th>Nombre</th>
                <th>Fabricante</th>
                <th>Fecha de alta</th>
                <th>Unidades</th>
                <th>Precio de venta</th>
                <th>Categoria</th>
                <th>Borrado</th>
                <th>Acciones</th>
            </tr>
            <?php
                while ($fila=$datos->fetch_assoc()){
                    echo "<tr><td>{$fila["nombre"]}</td>".PHP_EOL;
                    echo "<td>{$fila["fabricante"]}</td>".PHP_EOL;
                    echo "<td>{$fila["fecha_alta"]}</td>".PHP_EOL;
                    echo "<td>{$fila["unidades"]}</td>".PHP_EOL;
                    echo "<td>{$fila["precio_venta"]} €</td>".PHP_EOL;
                    echo "<td>{$fila["nombre_categoria"]}</td>".PHP_EOL;
                    echo "<td>{$fila["borrado"]}</td>".PHP_EOL;
                    echo "<td><a href='/aplicacion/articulos/verArticulo.php?cod={$fila["cod_producto"]}'><img src='/imagenes/sitio/ver.png' alt='ver'>
                            <a href='/aplicacion/articulos/modificarArticulo.php?cod={$fila["cod_producto"]}'><img src='/imagenes/sitio/editar.png' alt='editar'>
                            <a href='/aplicacion/articulos/borrarArticulo.php?cod={$fila["cod_producto"]}'><img src='/imagenes/sitio/borrar.png' alt='borrar'></td>
                            </tr>".PHP_EOL;
                }
            ?>
        </table>
    </div>
    <?php 
}

?>