<?php 
require_once ('../../cabecera.php');
//Controlador

if ($_GET){
   unset($_SESSION["usuario"]);
}

$error = "";

if ($_POST){

    if ($acl->esValido($_POST["usuario"],$_POST["contrasena"])){

        $nick = $_POST["usuario"];
        $cod = $acl->getCodUsuario($nick);
        $nombre = $acl->getNombre($cod);
        $permisos = $acl->getPermisos($cod);

        $acceso->registrarUsuario($nick,$nombre,$permisos);
        $_SESSION["usuario"] = $acceso;

        header("Location: http://".$_SERVER["HTTP_HOST"]."/index.php");
        exit();
    }

    else{
        $error = "Usuario no encontrado, compruebe nick y contraseña.";
    }
}

//Vista
inicioCabecera("Pagina login");
cabecera();
finCabecera();
inicioCuerpo("Inicio de sesion",$acceso,$sqli);
cuerpo($error);
finCuerpo();

///*************************************

function cabecera(){
    
    ?>
    <?php 
    
}

function cuerpo($e){
    ?>

    <div style="margin: 2%;">
        <form method="post">
            <table>
                <tr>
                    <td><label for="usuario">Usuario:</label></td>
                    <td><input type="text" name="usuario"></td>
                </tr>
                <tr>
                    <td><label for="contrasena">Contraseña:</label></td>
                    <td><input type="password" name="contrasena"></td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Entrar</button>
                        <?php echo "<label style='color:red;'> $e </label>"?>
                    </td>
                </tr>
           </table>
        </form>
    </div>
    <?php 

}

?>