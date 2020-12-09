<?php 
require_once ('cabecera.php');

//Controlador
$puede = false;
$sentencia = "select * from `dfs_productos`";
$sentencia2 = "select `cod_categoria`, `nombre` from `dfs_categorias`";

//Control de inicio de sesion
if ($acceso->hayUsuario() && $acceso->puedePermisos(1))
    $puede = true;


//Se pulsó algun formulario
if ($_POST){

    //Formulario de filtrado
    if (isset($_POST["filtro"])){
        
        $sentencia .= " where ";
        $union = " and ";
        $senFinal = "true";
    
        if (!empty($_POST["nombre"])){
            $nombre = $sqli->real_escape_string($_POST["nombre"]);
            $nombre = mb_strtolower($nombre);
            $sentencia .= "`nombre` like '%$nombre%'".$union;
        }
    
        if (!empty($_POST["categoria"])){
            $categoria = $sqli->real_escape_string($_POST["categoria"]);
            $sentencia .= "`cod_categoria` = $categoria ".$union;
        }
    
        $sentencia.= $senFinal;
    }

    //Se quiere agregar un producto a la cesta de la compra
    if (isset($_POST["producto"])){

        //Compruebo las unidades contra inyecciones
        if (!empty($_POST["uds"]))
            $unidades = $sqli->escape_string($_POST["uds"]);
        else
            $unidades = 1;

        //Compruebo el precio contra inyecciones
        $precio = $sqli->escape_string($_POST["precio"]);

        $total = (float)$precio * (float)$unidades;

        //Compruebo el codigo de producto contra inyecciones
        $codPro = $_POST["producto"];
        $codPro = $sqli->escape_string($codPro);
        $nick = $acceso->getNick();

        //Recojo el codigo del usuario
        $codUsr = $sqli->query("select `cod_usuario` from `usuarios` where `nick` = '$nick'")->fetch_array()[0];
        //Recojo si tiene alguna linea en su cesta
        $linea = $sqli->query("select * from `dfs_cesta_usuario` where `nick` = '$nick'")->num_rows;



        //Ya existe una cesta de la compra a la que agregar productos
        if ($linea > 0){

            $unidad = $sqli->query("select `unidades` from `dfs_cesta_usuario` where `nick` = '$nick' and `cod_producto` = '$codPro'")->fetch_array()[0];

            //Si ya habia un producto similar en el carrito
            if ($unidad){
                $unidades += $unidad;
                $total = (float)$precio * (float)$unidades;

                $sqli->query("update `dfs_cesta_usuario` set `unidades` = '$unidades',".
                                                        "`importe` = '$total'".
                                                        "where `nick` = '$nick'".
                                                        "and `cod_producto` = '$codPro'");
                
                header("Location: http://".$_SERVER["SERVER_NAME"]);
                exit();

            }

            //Si es el primer producto con este código
            else{
                //Obtengo el código de la cesta
                $codCom = $sqli->query("select `cod_cesta_compra` from `dfs_cestas_compra` where `cod_usuario` = '$codUsr'")->fetch_array()[0];
            }

        }

        //No existe una cesta de la compra
        else{
            //Creo su cesta de la compra a partir del codigo
            $sqli->query("insert into `dfs_cestas_compra` (`cod_usuario`) values ('$codUsr')");
            $codCom = $sqli->insert_id;
        }


        //En cualquier caso creo la linea de compra asociada a esa cesta
        $sqli->query("insert into `dfs_cesta_lineas` (`cod_cesta_compra`,`cod_producto`,`orden`,`unidades`,`precio_unidad`,`importe`)".
                                            " values ($codCom,".
                                                     "$codPro,".
                                                     "'".($linea+1)."',".
                                                     "'$unidades',".
                                                     "'$precio',".
                                                     "'$total')");

    }

}

//Consultas a la BD
$consulta = $sqli->query($sentencia);
$catego = $sqli->query($sentencia2);

//Vista
inicioCabecera("Pagina inicial");
cabecera();
finCabecera();
inicioCuerpo("Página principal de la tienda",$acceso,$sqli);
cuerpo($consulta,$catego,$puede);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($consulta,$catego,$puede){
    ?>

    <div class="filtro">
        <form method="post">
            <label for="nombre">Nombre del producto: </label>
            <input type="text" name="nombre">
            <label for="categoria">Categoria: </label>
            <select name="categoria">

            <?php 
                while ($cat = $catego->fetch_assoc())
                echo "<option value='".$cat["cod_categoria"]."'>".$cat["nombre"]."</option>";
            ?>
                
            </select>
            <button type="submit" name="filtro">Filtrar</button>
        </form>
    </div>

    <?php 

    while ($fila = $consulta->fetch_assoc()){
        echo "<form method='post' class='producto'>".PHP_EOL;
        echo "<div>".PHP_EOL;
        echo "<h3>".$fila["nombre"]."</h3>".PHP_EOL;
        echo '<img class="producto" src="data:image/jpeg;base64,'.base64_encode($fila['foto']).'"/>';
        echo "<div class='producto'>".PHP_EOL;
        echo "<p>Fabricante: ".$fila["fabricante"]."</p>".PHP_EOL;
        echo "<p>Lanzamiento: ".$fila["fecha_alta"]."</p>".PHP_EOL;
        echo "<p>Stock: ".$fila["unidades"]." uds</p>".PHP_EOL;
        echo "<p>Precio: ".$fila["precio_venta"]." €</p>".PHP_EOL;

        if ($puede){
            //Unidades que se quieren comprar
            echo"<label for='uds'>Cantidad: </label>".PHP_EOL;
            echo "<input type='number' name='uds' min='1' max='".$fila["unidades"]."'>".PHP_EOL;
            //Envio el precio escondido
            echo "<input type='number' name='precio' value='".$fila["precio_venta"]."' hidden>".PHP_EOL;
            //Codigo del producto
            $codPro = $fila["cod_producto"];
            echo "<button type='submit' name='producto' value='$codPro'>Comprar</button>".PHP_EOL;
        }
        
        echo "</div>".PHP_EOL;
        echo "</div>".PHP_EOL;
        echo "</form>".PHP_EOL;
}
}

?>