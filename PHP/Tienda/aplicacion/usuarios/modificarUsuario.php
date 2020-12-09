<?php

use function libreriaPropia\validaExpresion;
use function libreriaPropia\validaCadena;
use function libreriaPropia\validaEntero;
use function libreriaPropia\validaFecha;

require_once ('../../cabecera.php');
require_once('libreriaPropia.php');
//Controlador

$sentencia;
$errores = [];
$roles = $acl->dameRoles();

//Control de inicio de sesion
if (!$acceso->hayUsuario()){
    header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/acceso/login.php");
    exit();
}

//Control de permisos
if(!$acceso->puedePermisos(1) || !$acceso->puedePermisos(10)){
    paginaError("No dispone de permisos para realizar esta accion");
    exit();
}

//Control del formulario
if ($_POST){


    //Si se quiere modificar
    if (isset($_POST["modifica"])){

        //Comprobación de NIF
            if (empty($_POST["nif"])) 
                $errores[] = "El NIF no puede estar vacío.";
            if (!(validaExpresion($_POST["nif"],"/[0-9]{8}[A-Z]{1}/",$_POST["nif"])))
                $errores[] = "NIF no válido, compruebelo de nuevo";
                
        //Comprobación de Nombre  
            if (empty($_POST["nombre"])) 
                $errores[] = "El nombre no puede estar vacío";

            if (!(validaCadena($_POST["nombre"],50,$_POST["nombre"])))
                $errores[] = "El nombre no puede tener mas de 50 caracteres.";

        //Comprobación de rol
            if (!$acl->existeRole($_POST["rol"]))
                $errores[] = "El rol especificado no existe.";

        //Comprobación de Dirección
            if (empty($_POST["direccion"]))
                $errores[] = "La dirección no puede estar vacía.";

            if (!(validaCadena($_POST["direccion"],50,$_POST["direccion"])))
                $errores[] = "La dirección no puede tener mas de 50 caracteres.";

        //Comprobación de Población
            if (empty($_POST["poblacion"]))
                $errores[] = "La población no puede estar vacía.";

            if (!(validaCadena($_POST["poblacion"],30,$_POST["poblacion"])))
                $errores[] = "La población no puede tener mas de 30 caracteres.";

        //Comprobación de la Provincia
            if (empty($_POST["provincia"]))
                $errores[] = "La provincia no puede estar vacía.";

            if (!(validaCadena($_POST["provincia"],30,$_POST["provincia"])))
                $errores[] = "La provincia no puede tener mas de 30 caracteres.";

        //Comprobación del código postal       
            if (empty($_POST["cp"]))
                $errores[] = "El código postal no puede estar vacío.";

            if (!(validaEntero($_POST["cp"],10000,99999,$_POST["cp"])))
                $errores[] = "El código postal debe ser un dígito de 5 cifras.";

        //Comprobación de la fecha de nacimiento
            if (empty($_POST["fecha_nacimiento"]))
                $errores[] = "La fecha de nacimiento no puede estar vacía.";

            if(!(validaFecha($_POST["fecha_nacimiento"],$_POST["fecha_nacimiento"])))
                $errores[] = "Compruebe el formato de fecha yyyy-mm-dd.";

            if (!$errores){

                //Aseguramos frente a inyeccion de código
                $nick = $sqli-> real_escape_string($_POST["nick"]);
                $nombre = $sqli-> real_escape_string($_POST["nombre"]);
                $rol = $sqli-> real_escape_string($_POST["rol"]);
                $nif = $sqli-> real_escape_string($_POST["nif"]);
                $direccion = $sqli-> real_escape_string($_POST["direccion"]);
                $poblacion = $sqli-> real_escape_string($_POST["poblacion"]);
                $provincia = $sqli-> real_escape_string($_POST["provincia"]);
                $postal = $sqli-> real_escape_string($_POST["cp"]);
                $nacimiento = $sqli-> real_escape_string($_POST["fecha_nacimiento"]);
                
                //Se establece la sentencia y ejecuta
                $sentencia = "UPDATE usuarios set nif = '$nif',".
                                                 " direccion = '$direccion',".
                                                 " poblacion = '$poblacion',".
                                                 " provincia = '$provincia',".
                                                 " cp = '$postal',".
                                                 " fecha_nacimiento = '$nacimiento'".
                                                 " WHERE nick = '$nick'";
                
                if(!$sqli->query($sentencia))
                    paginaError("Error : ".$sqli->errno." ->".$sqli->error);
                
                else{
                    $codUS = $acl->getCodUsuario($nick);
                    $acl->setNombre($codUS,$nombre);
                    $acl->setUsuarioRole($codUS,$rol);

                    header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/usuarios/index.php");
                    exit();
                }
            }
    }

    //Si se quiere eliminar
    if (isset($_POST["elimina"])){

        $nick = $sqli-> real_escape_string($_POST["nick"]);
        $sentencia= "UPDATE `usuarios` SET `borrado` = 1 where `nick` = '$nick';";

        if(!$sqli->query($sentencia))
            paginaError("Error : ".$sqli->errno." ->".$sqli->error);

        else{
            $acl->setBorrado($acl->getCodUsuario($nick),1);
            header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/usuarios/index.php");
            exit();
        }
    }


}

//Se coge el cod si se viene de un boton externo..
if($_GET){
    $sentencia = "select * from `usuarios` where `cod_usuario` = ".$_GET["cod"].";";
}
    
$consulta = $sqli->query($sentencia);
$consulta = $consulta->fetch_assoc();
$consulta["nombre"] = $acl->getNombre($acl->getCodUsuario($consulta["nick"]));

//Vista
inicioCabecera("Modificar usuario");
cabecera();
finCabecera();
inicioCuerpo("Modificar usuario",$acceso,$sqli);
cuerpo($consulta,$errores,$roles);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos,$e,$r){
    ?>
    <div class="bloque" style="width: 50%;">
        <form method="post">
            <table>
                <tr>
                    <th>Nick:</th>
                    <td><input type="text" name="nick" value="<?php echo $datos["nick"] ?>" hidden>
                        <?php echo $datos["nick"] ?></td>
                </tr>
                <tr>
                    <th>NIF:</th>
                    <td><input type="text" name="nif" value="<?php echo $datos["nif"] ?>" maxlength="9"></td>
                </tr>
                <tr>
                    <th>Nombre:</th>
                    <td><input type="text" name="nombre" value="<?php echo $datos["nombre"] ?>"></td>
                </tr>
                <tr>
                    <th>Rol:</th>
                    <td><select name="rol">
                            <?php
                                foreach ($r as $key => $value) 
                                    echo "<option value='$key'>$value</option>".PHP_EOL;
                            ?>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Dirección:</th>
                    <td><input type="text" name="direccion" value="<?php echo $datos["direccion"] ?>"></td>
                </tr>
                <tr>
                    <th>Población:</th>
                    <td><input type="text" name="poblacion" value="<?php echo $datos["poblacion"] ?>"></td>
                </tr>
                <tr>
                    <th>Provincia:</th>
                    <td><input type="text" name="provincia" value="<?php echo $datos["provincia"] ?>"></td>
                </tr>
                <tr>
                    <th>Código postal:</th>
                    <td><input type="text" name="cp" value="<?php echo $datos["cp"] ?>"></td>
                </tr>
                <tr>
                    <th>Fecha de nacimiento:</th>
                    <td><input type="text" name="fecha_nacimiento" value="<?php echo $datos["fecha_nacimiento"] ?>"></td>
                </tr>
                <tr>
                    <th>Borrado:</th>
                    <td><?php echo $datos["borrado"] ?></td>
                </tr>
            </table>

            <div style="margin-top: 2%; text-align: center; width: 50%;">
                <button type="submit" name="modifica">Modificar datos</button>
                <button type="submit" name="elimina">Eliminar usuario</button>
            </div>
        </form>
    </div>

        <?php
            if ($e){
                echo '<div style="color: red; float:right; margin-right:10%; margin-top: 5%; border: 1px solid cadetblue; padding: 1%">'.PHP_EOL;
                foreach ($e as $error => $texto) {
                    echo "<p>Error : ".$texto.PHP_EOL."</p>";
                }
                echo '</div>'.PHP_EOL;
            }
        ?>
    <?php 

}

?>