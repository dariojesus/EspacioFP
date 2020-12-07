<?php 
require_once ('../../cabecera.php');
//Controlador


//Control de inicio de sesion
if (!$acceso->hayUsuario()){
    header("Location: http://".$_SERVER["HTTP_HOST"]."/aplicacion/acceso/login.php");
    exit();
}

//Control de permisos
if(!$acceso->puedePermisos(1)){
    paginaError("No dispone de permisos para realizar esta acción");
    exit();
}

$nick = $acceso->getNick();
$sentencia = "select * from `dfs_cesta_usuario` where `nick` = '$nick'";
$consulta = $sqli->query($sentencia);

//Vista
inicioCabecera("Usuarios");
cabecera();
finCabecera();
inicioCuerpo("Cesta de compra",$acceso,$sqli);
cuerpo($consulta);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos){
    ?>
    <div>
        <table>
            <tr>
                <th>Foto</th>
                <th>Nombre</th>
                <th>Fabricante</th>
                <th>Orden</th>
                <th>Unidades</th>
                <th>Precio(unidad)</th>
                <th>Total</th>
                <th>Fecha</th>
            </tr>
            <?php
                while ($fila=$datos->fetch_assoc()){
                    echo '<tr><td><img style="width:100px;" src="data:image/jpeg;base64,'.base64_encode($fila['foto']).'"/></td>'.PHP_EOL;
                    echo "<td>{$fila["nombre"]}</td>".PHP_EOL;
                    echo "<td>{$fila["fabricante"]}</td>".PHP_EOL;
                    echo "<td>{$fila["orden"]}</td>".PHP_EOL;
                    echo "<td>{$fila["unidades"]}</td>".PHP_EOL;
                    echo "<td>{$fila["precio_unidad"]}€</td>".PHP_EOL;
                    echo "<td>{$fila["importe"]}€</td>".PHP_EOL;
                    echo "<td>{$fila["fecha"]}</td></tr>".PHP_EOL;
                }
            ?>
        </table>
    </div>
    <?php 
}

?>