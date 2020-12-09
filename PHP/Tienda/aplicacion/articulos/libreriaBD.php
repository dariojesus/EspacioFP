<?php

function dameDatosTabla ($conexion,$tabla,$datos,$condicion=true,$cumple=true){

    $sentencia = "Select ";
    $tabla = $conexion->real_escape_string($tabla);
    $condicion = $conexion->real_escape_string($condicion);
    $cumple = $conexion->real_escape_string($cumple);


    //Si solo se quieren algunos campos
    if ($datos != '*'){
        for ($cont=0; $cont<count($datos)-1; $cont++){
            $sentencia .= "`".$conexion->real_escape_string($datos[$cont])."`";
            $sentencia .= ", ";
        }

        $sentencia .= "`".$conexion->real_escape_string(end($datos))."`";
    }else{

        $sentencia .= $datos;
    }

    $sentencia .= " from `$tabla` where `$condicion` = '$cumple'";

    $consulta = $conexion->query($sentencia);


    //Devolución del array asociativo o false si algo va mal
    if ($consulta)
        return $consulta;
    else
        return false;

}

?>