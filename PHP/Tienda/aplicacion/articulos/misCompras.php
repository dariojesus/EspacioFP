<?php 
require_once ('../../cabecera.php');
require_once('libreriaBD.php');
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

//Obtengo el codigo de usuario a partir del nick
$nick = $acceso->getNick();
$codUsu = dameDatosTabla($sqli,"usuarios",["cod_usuario"],"nick",$nick);
$codUsu = $codUsu->fetch_assoc()["cod_usuario"];

$consulta = dameDatosTabla($sqli,"dfs_compras","*","cod_usuario",$codUsu);

//Vista
inicioCabecera("Mis pedidos");
cabecera();
finCabecera();
inicioCuerpo("Pedidos realizados",$acceso,$sqli);
cuerpo($consulta);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos){
    ?>
    <div style="display:inline-block; max-width:70%; max-height:80%; overflow:auto; margin: 3% 3% 0% 5%">
        <table style="border-collapse: collapse;">
            <tr>
                <th>Fecha del pedido</th>
                <th>Importe</th>
                <th>Modo de pago</th>
                <th>Seguimiento</th>
                <th>Fecha de entrega</th>
            </tr>
                <?php
                    while ($fila=$datos->fetch_assoc()){
                        echo "<tr>".PHP_EOL;
                        echo "<td>".$fila["fecha"]."</td>".PHP_EOL;
                        echo "<td>".$fila["importe_total"]."€</td>".PHP_EOL;
                        echo "<td>".$fila["modo_pago"]."</td>".PHP_EOL;
                        echo "<td>Numero de seguimiento inventado</td>".PHP_EOL;
                        echo "<td>Fecha de entrega inventada</td>".PHP_EOL;
                        echo "</tr>".PHP_EOL;
                    }
                ?>            
        </table>
    </div>
    <?php 
}

?>