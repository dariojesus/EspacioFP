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

//Control de inicio de sesion
if (!$acceso->hayUsuario()){
    header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/acceso/login.php");
    exit();
}

//Control de permisos
if(!$acceso->puedePermisos(1)){
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

        //No han ocurrido errores, pasamos a la BD
            if (!$errores){

                //Aseguramos frente a inyeccion de código
                $nick = $sqli-> real_escape_string($_POST["nick"]);
                $nombre = $sqli-> real_escape_string($_POST["nombre"]);
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

                //Se llama a la ACL que modifique sus tablas
                else{
                    $codUS = $acl->getCodUsuario($nick);
                    $acl->setNombre($codUS,$nombre);
                    header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/usuarios/misDatos.php?nick=$nick");
                    exit();
                }
            }
    }
}


$sentencia = "select * from `usuarios` where `nick` = '".$acceso->getNick()."';";

$consulta = $sqli->query($sentencia);
$consulta = $consulta->fetch_assoc();
$consulta["nombre"] = $acl->getNombre($acl->getCodUsuario($consulta["nick"]));

//Vista
inicioCabecera("Mi cuenta");
cabecera();
finCabecera();
inicioCuerpo("Datos de ".$consulta['nombre'],$acceso,$sqli);
cuerpo($consulta,$errores);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos,$e){
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
            </table>

            <div style="margin-top: 2%;">
                <button type="submit" name="modifica">Modificar</button>
            </div>
        </form>
    </div>

        <?php
            if ($e){
                echo '<div style="color: red; float:right; margin-right:10%; margin-top: 5%; border: 1px solid orange; padding: 1%">'.PHP_EOL;
                foreach ($e as $error => $texto) {
                    echo "<p>Error : ".$texto.PHP_EOL."</p>";
                }
                echo '</div>'.PHP_EOL;
            }
        ?>
    <?php 

}

?>