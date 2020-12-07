<?php 
namespace libreriaPropia;

function validaEntero (&$var, $min, $max, $defecto){

    if (is_integer(intval($var)) && ($var >= $min && $var <=$max))
        return true;

    else{
        $var=$defecto;
        return false;
    }
}

function validaReal (&$var, $min, $max, $defecto){

    if (is_float($var) && ($var >= $min && $var <=$max))
        return true;

    else{
        $var=$defecto;
        return false;
    }
}

function validaFecha(&$var, $defecto){
    $correcta = preg_match("/[0-9]{4}\-{1}[0-9]{2}\-{1}[0-9]{2}/",$var);
    $prt = explode("-",$var);

    if ($correcta && checkdate(intval($prt[1]),intval($prt[2]),intval($prt[0]))){
        return true;
    }
    else{
        $var = $defecto;
        return false;
    }
}

function validaHora(&$var, $defecto){
    $correcta = preg_match("/[0-9]{2}:{1}[0-9]{2}:{1}[0-9]{2}/",$var);

    if ($correcta){

        $prt = explode(":",$var);
        $hora = (intval($prt[0]) >= 0 && intval($prt[0]) <= 23);
        $min = (intval($prt[1]) >= 0 && intval($prt[1]) <= 59);
        $seg = (intval($prt[2]) >= 0 && intval($prt[2]) <= 59);

        if($hora && $min && $seg)
            return true;
    
        else{
            $var=$defecto;
            return false;
        }
            
    }
        
    else{
        $var=$defecto;
        return $correcta;
    }
}

function validaEmail(&$var, $defecto){
    $correcta = preg_match("/[A-Za-z0-9._-]+@{1}[A-Za-z0-9]+.{1}[A-Za-z]{2,}/", $var);

    if($correcta)
        return true;
    else{
        $var = $defecto;
        return false;
    }
}

function validaCadena(&$var, $longitud, $defecto){

    if (strlen($var) > $longitud){
        $var=$defecto;
        return false;
    }

    else
        return true;
}

function validaExpresion(&$var, $expresion, $defecto){
    
    if (preg_match($expresion,$var))
        return true;
    else {
        $var=$defecto;
        return false;
    }
}

function validaRango (&$var, $posibles){
    $coincidencia = false;
    $cont = 0;

    while ($cont < (count($posibles)) && !$coincidencia){
        if ($var==$posibles[$cont])
            $coincidencia = true;
        
        $cont++;
    }

    return $coincidencia;
}

?>