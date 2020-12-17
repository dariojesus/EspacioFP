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

//Control del formulario (Creación de sentencia)
if ($_POST){

    $sentencia = "select * from dfs_productos_categorias where ";
    $union = " and ";
    $senFinal = "true";

    if(!empty($_POST["nombre"])){
        $nombre = $sqli-> real_escape_string($_POST["nombre"]);
        $sentencia .= "`nombre` like '%$nombre%' ".$union;
    }
        
    if (!empty($_POST["categoria"])){
        $categoria = $sqli-> real_escape_string($_POST["categoria"]);
        $sentencia .= "`cod_categoria` = '$categoria' ".$union;
    }
        
    if (!empty($_POST["borrado"])){
        $borrado = $sqli-> real_escape_string($_POST["borrado"]);
        $sentencia .= "`borrado` = '$borrado' ".$union;
    }
        
    $sentencia .= $senFinal;
        
}

$consulta = $sqli->query($sentencia);
$categoria = $sqli->query("Select `cod_categoria`, `nombre` from `dfs_categorias`");

//Vista
inicioCabecera("Articulos");
cabecera();
finCabecera();
inicioCuerpo("CRUD de articulos",$acceso,$sqli);
cuerpo($consulta,$categoria);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos,$cat){
    ?>
    <div class="bloque">
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
                    echo "<td><a href='/aplicacion/articulos/modificarArticulo.php?cod={$fila["cod_producto"]}'><img src='/imagenes/sitio/editar.png' alt='editar'></td></tr>".PHP_EOL;
                }
            ?>
        </table>
    </div>
    <div style="float:left; margin-top: 2%; margin-left:4%">
        <form method="post">
            <table class="formulario">
                <tr>
                    <td><label for="nombre">Filtrado por nombre:</label></td>
                    <td><input type="text" name="nombre" size="10"></td>
                </tr>
                <tr>
                    <td><label for="categoria">Filtrado por categoria:</label></td>
                    <td>
                        <select name="categoria">
                            <?php 
                                while($dt = $cat->fetch_assoc())
                                    echo "<option value='".$dt["cod_categoria"]."'>".$dt["nombre"]."</option>".PHP_EOL;
                            ?>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Filtrado por borrado:</label></td>
                    <td><label for="borrado">Si</label><input type="radio" name="borrado" value="1">
                    <label for="borrado">No</label><input type="radio" name="borrado" value="0" checked></td>
                </tr>
                <tr>
                    <td><button type="submit">Filtrar</button></td>
                    <td>
                        <?php
                            echo "<a href='/aplicacion/articulos/nuevoArticulo.php'>Agregar articulo</a></td>".PHP_EOL;
                        ?>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <?php 
}

?>