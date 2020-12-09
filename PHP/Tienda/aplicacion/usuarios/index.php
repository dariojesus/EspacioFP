<?php 
require_once ('../../cabecera.php');
//Controlador

//Control de inicio de sesion
if (!$acceso->hayUsuario()){
    header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/acceso/login.php");
    exit();
}

//Control de permisos
if(!$acceso->puedePermisos(1) || !$acceso->puedePermisos(10)){
    paginaError("No dispone de permisos para realizar esta accion",$colores);
    exit();
}

$sentencia = "select * from usuarios";

//Control del formulario (Creación de sentencia)
if ($_POST){

    $sentencia = "select * from usuarios where ";
    $union = " and ";
    $senFinal = "true";

    if(!empty($_POST["nick"])){
        $nick = $sqli-> real_escape_string($_POST["nick"]);
        $sentencia .= "`nick` like '%$nick%' ".$union;
    }
        
    if (!empty($_POST["provincia"])){
        $provincia = $sqli-> real_escape_string($_POST["provincia"]);
        $sentencia .= "`provincia` like '%$provincia%' ".$union;
    }
        
    if (!empty($_POST["borrado"])){
        $borrado = $sqli-> real_escape_string($_POST["borrado"]);
        $sentencia .= "`borrado` = '$borrado' ".$union;
    }
        
    $sentencia .= $senFinal;
        
}

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
    <div class="bloque">
    <table class="crud">
            <tr>
                <th>Nick</th>
                <th>NIF</th>
                <th>Dirección</th>
                <th>Población</th>
                <th>Provincia</th>
                <th>Código Postal</th>
                <th>Fecha nacimiento</th>
                <th>Borrado</th>
                <th>Acciones</th>
            </tr>
            <?php
                while ($fila=$datos->fetch_assoc()){
                    echo "<tr><td>{$fila["nick"]}</td>".PHP_EOL;
                    echo "<td>{$fila["nif"]}</td>".PHP_EOL;
                    echo "<td>{$fila["direccion"]}</td>".PHP_EOL;
                    echo "<td>{$fila["poblacion"]}</td>".PHP_EOL;
                    echo "<td>{$fila["provincia"]}</td>".PHP_EOL;
                    echo "<td>{$fila["cp"]}</td>".PHP_EOL;
                    echo "<td>{$fila["fecha_nacimiento"]}</td>".PHP_EOL;
                    echo "<td>{$fila["borrado"]}</td>".PHP_EOL;
                    echo "<td><a href='/aplicacion/usuarios/modificarUsuario.php?cod={$fila["cod_usuario"]}'><img src='/imagenes/sitio/editar.png' alt='editar'></tr>".PHP_EOL;
                }
            ?>
        </table>
    </div>

    <div style="float:left; margin-top: 2%; margin-left:4%">
        <form method="post">
            <table class="formulario">
                <tr>
                    <td><label for="nick">Filtrado por nick:</label></td>
                    <td><input type="text" name="nick" size="10"></td>
                </tr>
                <tr>
                    <td><label for="provincia">Filtrado por provincia:</label></td>
                    <td><input type="text" name="provincia" size="10"></td>
                </tr>
                <tr>
                    <td><label>Filtrado por borrado:</label></td>
                    <td><label for="borrado">Si</label><input type="radio" name="borrado" value="1">
                    <label for="borrado">No</label><input type="radio" name="borrado" value="0"></td>
                </tr>
                <tr>
                    <td><button type="submit">Filtrar</button></td>
                    <td>
                        <?php
                            echo "<a href='/aplicacion/usuarios/nuevoUsuario.php'>Crear usuario</a></td>".PHP_EOL;
                        ?>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <?php 

}

?>