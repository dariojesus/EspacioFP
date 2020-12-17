<?php 
require_once ('../../cabecera.php');
require_once('libreriaBD.php');
require_once('../usuarios/libreriaPropia.php');

use function libreriaPropia\validaCadena;
use function libreriaPropia\validaEntero;
use function libreriaPropia\validaFecha;

//Controlador
$errores = [];

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

//Control de formularios
if ($_POST){

    $codPro= $sqli->real_escape_string($_POST["id"]);

    //Si se quiere modificar el articulo
    if (isset($_POST["modifica"])){

            //Comprobación de Nombre  
            if (empty($_POST["nombre"])) 
                $errores[] = "El nombre no puede estar vacío";

            if (!(validaCadena($_POST["nombre"],50,$_POST["nombre"])))
                $errores[] = "El nombre no puede tener mas de 50 caracteres.";

            //Comprobación de Fabricante 
            if (empty($_POST["fabricante"])) 
                $errores[] = "El nombre del fabricante no puede estar vacío";

            if (!(validaCadena($_POST["fabricante"],50,$_POST["fabricante"])))
                $errores[] = "El nombre del fabricante no puede tener mas de 50 caracteres.";

            //Comprobación de la fecha de alta
            if (empty($_POST["fecha"]))
                $errores[] = "La fecha de alta no puede estar vacía.";

            if(!(validaFecha($_POST["fecha"],$_POST["fecha"])))
                $errores[] = "Compruebe el formato de fecha yyyy-mm-dd.";

            //Comprobación del stock    
            if (empty($_POST["unidades"]))
                $errores[] = "Las unidades no pueden estar vacías.";

            if (!(validaEntero($_POST["unidades"],0,99999,$_POST["unidades"])))
                $errores[] = "Las unidades no pueden ser menor de 0 o mayor de 99999.";

            //Comprobación del precio    
            if (empty($_POST["precio"]))
                $errores[] = "El precio no puede ser vacío.";

            if (!(validaEntero($_POST["precio"],0,99999,$_POST["precio"])))
                $errores[] = "El precio no pueden ser menor de 0 o mayor de 99999.";

            //Comprobación de la foto
            if (!empty($_FILES["foto"]["name"])){
                
                if ($_FILES["foto"]["type"] != "image/jpeg" && $_FILES["foto"]["type"] != "image/png")
                    $errores[] = "El archivo debe ser una imagen jpg o png";

                if ($_FILES["foto"]["size"] > 1000000)
                    $errores[] = "El archivo no puede pesar mas de 1MB";
            }

            //Si no han habido fallos se modifica el archivo
            if (!$errores){

                $nombre = $sqli->real_escape_string($_POST["nombre"]);
                $fabricante = $sqli->real_escape_string($_POST["fabricante"]);
                $fecha = $sqli->real_escape_string($_POST["fecha"]);
                $unidades = $sqli->real_escape_string($_POST["unidades"]);
                $precio = $sqli->real_escape_string($_POST["precio"]);

                if (!empty($_FILES["foto"]["name"]))
                    $foto = addslashes(file_get_contents($_FILES["foto"]["tmp_name"]));
                else 
                    $foto ="";

                $categoria= $sqli->real_escape_string($_POST["categoria"]);

                $sentencia = "UPDATE `dfs_productos` SET `nombre` = '$nombre',".
                                                    (empty($foto)? "":"`foto` = '$foto',").
                                                    "`fabricante` = '$fabricante',".
                                                    "`fecha_alta` = '$fecha',".
                                                    "`unidades` = '$unidades',".
                                                    "`precio_venta` = '$precio',".
                                                    "`cod_categoria` = '$categoria'".
                                                    " WHERE `cod_producto` = '$codPro'";

                if(!$sqli->query($sentencia))
                    paginaError("Error : ".$sqli->errno." ->".$sqli->error);

            }

    }

    //Si se quiere borrar el articulo
    if (isset($_POST["elimina"])){

        $sentencia = "UPDATE `dfs_productos` SET `borrado` = '1' WHERE `cod_producto` = '$codPro'";

        if(!$sqli->query($sentencia))
            paginaError("Error : ".$sqli->errno." ->".$sqli->error);

    }

}

if ($_GET)
    $codPro = $_GET["cod"];


$consulta = dameDatosTabla($sqli,"dfs_productos_categorias","*","cod_producto",$codPro)->fetch_assoc();
$categorias = $sqli->query("select * from `dfs_categorias`");

//Vista
inicioCabecera("Articulo");
cabecera();
finCabecera();
inicioCuerpo("CRUD de articulos",$acceso,$sqli);
cuerpo($consulta,$categorias,$errores);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos,$catego,$err){
    ?>
    
    <table>
        <form method="post" enctype="multipart/form-data">
            <thead>
                <tr>
                    <th colspan="3">Datos del producto</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td rowspan="9">
                        <?php echo '<img style="width:300px;" src="data:image/jpeg;base64,'.base64_encode($datos['foto']).'"/>'; ?>
                    </td>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="nombre" value="<?php echo $datos['nombre'] ?>">
                        <input type="text" name="id" value="<?php echo $datos['cod_producto'] ?>" hidden>
                    </td>
                </tr>
                <tr>
                    <td>Fabricante:</td>
                    <td><input type="text" name="fabricante" value="<?php echo $datos['fabricante'] ?>"></td>
                </tr>
                <tr>
                    <td>Fecha de alta:</td>
                    <td><input type="text" name="fecha" value="<?php echo $datos['fecha_alta'] ?>"></td>
                </tr>
                <tr>
                    <td>Stock actual:</td>
                    <td><input type="text" name="unidades" value="<?php echo $datos['unidades'] ?>"></td>
                </tr>
                <tr>
                    <td>Precio venta:</td>
                    <td><input type="text" name="precio" value="<?php echo $datos['precio_venta'] ?>"></td>
                </tr>
                <tr>
                    <td>Foto:</td>
                    <td><input type="file" name="foto"></td>
                </tr>
                <tr>
                    <td>Borrado:</td>
                    <td><?php echo $datos['borrado'] ?></td>
                </tr>
                <tr>
                    <td>Categoria:</td>
                    <td>
                        <select name="categoria">
                            <?php
                                while ($fila = $catego->fetch_assoc())
                                    echo "<option value='".$fila["cod_categoria"]."'>".$fila["nombre"]."</option>".PHP_EOL;
                            ?>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button name="modifica">Modificar articulo</button>
                        &nbsp;
                        &nbsp;
                        <button name="elimina">Eliminar articulo</button>
                    </td>
                </tr>
            </tbody>
        </form>
    </table>
    
    <?php
            if ($err){
                echo '<div style="color: red; float:right; margin-right:10%; margin-top: 5%; border: 1px solid cadetblue; padding: 1%">'.PHP_EOL;
                foreach ($err as $error => $texto) {
                    echo "<p>Error : ".$texto.PHP_EOL."</p>";
                }
                echo '</div>'.PHP_EOL;
            }
        ?>
    <?php 
}

?>