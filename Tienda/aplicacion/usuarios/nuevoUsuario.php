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

//Control del formulario de modificacion
if ($_POST){

        //Comprobación de Nick
        if (empty($_POST["nick"])) 
            $errores[] = "El nick no puede estar vacío.";

        if ($acl->existeUsuario($_POST["nick"]))
            $errores[] = "El nick ya pertenece a otro usuario.";

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

        //Comprobación de Contraseña
        if (empty($_POST["contra"]))
            $errores[] = "La contraseña no puede estar vacía.";

        if (!(validaCadena($_POST["contra"],30,$_POST["contra"])))
             $errores[] = "La contraseña no puede tener mas de 30 caracteres.";

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
        
        //Se establece la sentencia y ejecuta, si ocurre algun error este se almacena en el array de errores
        $sentencia = "INSERT INTO `usuarios` (`nick`,`nif`,`direccion`,`poblacion`,`provincia`,`cp`,`fecha_nacimiento`,`borrado`)".
                                  " values ('$nick','$nif','$direccion','$poblacion','$provincia',$cp,'$nacimiento',0);";
        
        if(!$sqli->query($sentencia))
            paginaError("Error : ".$sqli->errno." ->".$sqli->error);

        else{
            $acl->anadirUsuario($nick,$nombre,$_POST["contra"],$rol);
            header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/usuarios/index.php");
            exit();
        }
    }
}

//Vista
inicioCabecera("Nuevo usuario");
cabecera();
finCabecera();
inicioCuerpo("Nuevo usuario",$acceso,$sqli);
cuerpo($errores, $roles);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($e, $r){
    ?>
    <div class="bloque" style="width: 50%;">
        <form method="post">
            <table>
            <tr>
                <th>Nick:</th>
                <td><input type="text" name="nick"></td>
            </tr>
            <tr>
                <th>NIF:</th>
                <td><input type="text" name="nif" maxlength="9"></td>
            </tr>
            <tr>
                <th>Nombre:</th>
                <td><input type="text" name="nombre"></td>
            </tr>
            <tr>
                <th>Contraseña:</th>
                <td><input type="password" name="contra"></td>
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
                <td><input type="text" name="direccion"></td>
            </tr>
            <tr>
                <th>Población:</th>
                <td><input type="text" name="poblacion"></td>
            </tr>
            <tr>
                <th>Provincia:</th>
                <td><input type="text" name="provincia"></td>
            </tr>
            <tr>
                <th>Código postal:</th>
                <td><input type="text" name="cp"></td>
            </tr>
            <tr>
                <th>Fecha de nacimiento:</th>
                <td><input type="text" name="fecha_nacimiento"></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Crear</button></td>
            </tr>
            </table>
        </form>
    </div>

    <div style="color: red; float:right; margin-right:10%; margin-top: 5%; border: 1px solid orange; padding: 1%">
        <?php
            foreach ($e as $error => $texto) {
                echo "<p>Error : ".$texto.PHP_EOL."</p>";
            }
        ?>
    </div>
    <?php 

}

?>