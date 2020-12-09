<?php 
require_once ('../../cabecera.php');
require_once('libreriaBD.php');
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

//Obtengo el codigo de usuario a partir del nick
$nick = $acceso->getNick();
$codUsu = dameDatosTabla($sqli,"usuarios",["cod_usuario"],"nick",$nick);
$codUsu = $codUsu->fetch_assoc()["cod_usuario"];

if ($_POST){

    if (isset($_POST["elimina"])){
        $codPro = $sqli->real_escape_string($_POST["elimina"]);

        $codCesta = dameDatosTabla($sqli,"dfs_cestas_compra",["cod_cesta_compra"],"cod_usuario",$codUsu);
        $codCesta = $codCesta->fetch_assoc()["cod_cesta_compra"];
        $sqli->query("delete from `dfs_cesta_lineas` where `cod_cesta_compra` = '$codCesta'".
                                                     " and `cod_producto` = '$codPro'");
    }

    if (isset($_POST["pago"])){
        //Recojo el modo de pago y el importe
        $modo = $_POST["modo_pago"];
        $modo = $sqli->real_escape_string($modo);
        $importe = dameDatosTabla($sqli,"dfs_cestas_compra",["importe_total"],"cod_usuario",$codUsu)->fetch_assoc()["importe_total"];

        //Creo la compra
        $sqli->query("insert into `dfs_compras` (`cod_usuario`,`importe_total`,`modo_pago`) ".
                                    "values ('$codUsu','$importe','$modo')");

        $codCompra = $sqli->insert_id;

        //Recojo las lineas de la cesta para pasarlas a las lineas de compra
        $modo = dameDatosTabla($sqli,"dfs_cesta_usuario","*","cod_usuario",$codUsu);

        $orden = 0;
        while($fila = $modo->fetch_assoc()){
            $cod_pro = $fila["cod_producto"];
            $orden++;
            $unidades = $fila["unidades"];
            $precio_uni = $fila["precio_unidad"];
            $importe = $fila["importe"];

            $sqli->query("insert into `dfs_compra_lineas` (`cod_compra`,`cod_producto`,`orden`,`unidades`,`precio_unidad`,`importe`)".
                                        "values ('$codCompra','$cod_pro','$orden','$unidades','$precio_uni','$importe')");

            $uds = dameDatosTabla($sqli,"dfs_productos",["unidades"],"cod_producto",$cod_pro)->fetch_assoc()["unidades"];
            $unidades = intval($uds) - intval($unidades);

            $sqli->query("update `dfs_productos` set `unidades` = '$unidades' where `cod_producto` = '$cod_pro'");
        }

        //Elimino las lineas del carrito y el carrito de la compra
        $codCompra = dameDatosTabla($sqli,"dfs_cestas_compra",["cod_cesta_compra"],"cod_usuario",$codUsu)->fetch_assoc()["cod_cesta_compra"];
        $sqli->query("delete from `dfs_cesta_lineas` where `cod_cesta_compra` = '$codCompra'");
        $sqli->query("delete from `dfs_cestas_compra` where `cod_cesta_compra` = '$codCompra'");

        header("Location: http://".$_SERVER['HTTP_HOST']."/aplicacion/articulos/misCompras.php");
        exit();
    }
}

calculaTotal($codUsu,$sqli);

//Saco los datos de la cesta de mis productos
$consulta = dameDatosTabla($sqli,"dfs_cesta_usuario","*","nick",$nick);

//Saco el total y fecha de mi cesta
$consulta2 = dameDatosTabla($sqli,"dfs_cestas_compra",["importe_total","fecha"],"cod_usuario",$codUsu);
$consulta2 = $consulta2->fetch_assoc();

//Saco mis datos de facturación
$miFactura = dameDatosTabla($sqli,"usuarios","*","cod_usuario",$codUsu);
$miFactura = $miFactura->fetch_assoc();
$miFactura["nombre_factura"] = $acceso->getNombre();

//Vista
inicioCabecera("Cesta de compra");
cabecera();
finCabecera();
inicioCuerpo("Cesta de compra",$acceso,$sqli);
cuerpo($consulta, $consulta2, $miFactura);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($datos, $totales, $factura){
    ?>
    <div style="display:inline-block; max-width:70%; max-height:80%; overflow:auto; margin: 0% 3% 0% 5%">
        <table style="border-collapse: collapse;">
            <tr>
                <th>Foto</th>
                <th>Nombre</th>
                <th>Fabricante</th>
                <th>Orden</th>
                <th>Unidades</th>
                <th>Precio(unidad)</th>
                <th>Precio(productos)</th>
                <th>Descartar</th>
            </tr>
            <?php
                while ($fila=$datos->fetch_assoc()){
                    echo '<form method="post">';
                    echo '<tr><td><img style="width:100px;" src="data:image/jpeg;base64,'.base64_encode($fila['foto']).'"/></td>'.PHP_EOL;
                    echo "<td>{$fila["nombre"]}</td>".PHP_EOL;
                    echo "<td>{$fila["fabricante"]}</td>".PHP_EOL;
                    echo "<td>{$fila["orden"]}</td>".PHP_EOL;
                    echo "<td>{$fila["unidades"]}</td>".PHP_EOL;
                    echo "<td>{$fila["precio_unidad"]}€</td>".PHP_EOL;
                    echo "<td>{$fila["importe"]}€</td>".PHP_EOL;
                    echo "<td><button name='elimina' value='".$fila["cod_producto"]."'>Eliminar</button></td></tr>".PHP_EOL;
                    echo '</form>';
                }
            ?>
        </table>
    </div>

    <div style="display:inline-block; vertical-align:top;">
        <table style="border-collapse: collapse;">
            <thead>
                <tr>
                    <th colspan="2">Datos de facturación</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Nombre:</td>
                    <td><?php echo $factura["nombre_factura"].PHP_EOL; ?></td>
                </tr>
                <tr>
                    <td>NIF</td>
                    <td><?php echo $factura["nif"].PHP_EOL; ?></td>
                </tr>
                <tr>
                    <td>Dirección:</td>
                    <td><?php echo $factura["direccion"].PHP_EOL; ?></td>
                </tr>
                <tr>
                    <td>Localidad:</td>
                    <td><?php echo $factura["cp"].", ".$factura["poblacion"].", ".$factura["provincia"].PHP_EOL; ?></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <th colspan="2"><u>Total:<?php echo "   ".$totales["importe_total"].PHP_EOL;?>€</u></th>
                </tr>
                <tr>
                    <th colspan="2"><u>Fecha:<?php echo "   ".$totales["fecha"].PHP_EOL;?></u></th>
                </tr>
                <tr>
                    <form method="post">
                        <td>
                            <select name="modo_pago">
                                <option value="efectivo">Efectivo</option>
                                <option value="tarjeta">Tarjeta</option>
                            </select>
                        </td>
                        <td><button name="pago">Proceder al pago</button></td>
                    </form>
                </tr>
            </tfoot>
        </table>
    </div>

    <?php 
}

?>