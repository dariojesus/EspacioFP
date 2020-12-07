<?php

function paginaError($mensaje){
    header("HTTP/1.0 404 $mensaje");
    inicioCabecera("PRACTICA");
    finCabecera();
    echo "<br />\n";
    echo $mensaje;
    finCuerpo();
}

function inicioCabecera($titulo){
    ?>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><?php echo $titulo ?></title>
        <meta name="description" content="">
        <meta name="author" content="Administrador">
        <meta name="viewport" content="width=device-width; initialscale=1.0">
        <!-- Replace favicon.ico & apple-touch-icon.png in the root
        of your domain and delete these references -->
        <link rel="shortcut icon" href="/favicon.ico">
        <link rel="apple-touch-icon" href="/apple-touch-icon.png">
        <link rel="stylesheet" type="text/css" href="/estilos/base.css">
    <?php
}

function finCabecera(){
    ?>
    </head>
    <?php
}

function inicioCuerpo($cabecera,$acceso,$conexion){

    $valido = $acceso->hayUsuario();
    
    ?>
    <body>
        
        <header>
            <h1 id="titulo"><?php echo $cabecera;?></h1>
            
            <nav>
                <a href="/index.php">Inicio</a>

                <?php
                        if (!$valido)
                            echo "<a href='/aplicacion/acceso/login.php'>Login</a>".PHP_EOL;
                
                       else{
                            $nombre = $acceso->getNombre();
                            $nick = $acceso->getNick();
                            $consulta = $conexion->query("select * from `dfs_cesta_usuario` where `nick` = '$nick'");

                            echo "<a>Bienvenido: $nombre</a>".PHP_EOL;
                            echo "<a href='/aplicacion/usuarios/misDatos.php'>Cuenta</a>".PHP_EOL;
                            
                            
                            if ($consulta->num_rows > 0){
                                echo "<a href='/aplicacion/articulos/carrito.php'>Carrito de compra</a>".PHP_EOL;
                            }

                            if ($acceso->puedePermisos(9)){
                                echo "<a href='/aplicacion/articulos/index.php'>Articulos</a>".PHP_EOL; 
                            }

                            if ($acceso->puedePermisos(10)){
                                echo "<a href='/aplicacion/usuarios/index.php'>Usuarios</a>".PHP_EOL; 
                            }

                            echo "<a href='/aplicacion/acceso/login.php?logout=1'>Logout</a>".PHP_EOL; 
                        }
                ?>
            </nav>

            <hr>
        </header>	
    <?php
}

function finCuerpo(){
    ?>

            </body>
        </html>
    <?php
}