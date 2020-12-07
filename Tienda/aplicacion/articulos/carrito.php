<?php 
require_once ('../../cabecera.php');
//Controlador

//Función para calcular el total de las lineas de compra y reflejarlo en la BD
function calculaTotal($codUsu,$sqli){

    $total = 0;
    $precios = $sqli->query("select `importe` from `dfs_cesta_usuario` where `cod_usuario` = '$codUsu'")->fetch_all();

    for ($cont = 0 ; $cont < sizeof($precios) ; $cont++)
        $total += (float) $precios[$cont][0];
    
    $sqli->query("update `dfs_cestas_compra` set `importe_total` = '$total' where `cod_usuario` = '$codUsu'");

}

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
$codUsu = $sqli->query("select `cod_usuario` from `usuarios` where `nick` = '$nick'")->fetch_array()[0];
calculaTotal($codUsu,$sqli);


$sentencia = "select * from `dfs_cesta_usuario` where `nick` = '$nick'";
$consulta = $sqli->query($sentencia);
$codUsu = $sqli->query("select `importe_total`, `fecha` from `dfs_cestas_compra` where `cod_usuario` = '$codUsu'")->fetch_assoc();

//Vista
inicioCabecera("Usuarios");
cabecera();
finCabecera();
inicioCuerpo("Cesta de compra",$acceso,$sqli);
cuerpo($consulta, $codUsu);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos, $totales){
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
                <th>Precio(productos)</th>
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
            <tfoot>
                <tr>
                <?php
                    echo "<th colspan='6'></th>".PHP_EOL;
                    echo "<th>Total: {$totales["importe_total"]}€</th>".PHP_EOL;
                    echo "<th>Fecha: {$totales["fecha"]}</th>".PHP_EOL;
                ?>
                </tr>
            </tfoot>
        </table>
    </div>
    <?php 
}

?>