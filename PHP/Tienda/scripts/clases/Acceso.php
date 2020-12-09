<?php

class Acceso{

    private $_validado;
    private $_nick;
    private $_nombre;
    private $_permisos;

    public function __construct(){
        $this->_validado = false;
        $this->_nick = "";
        $this->_nombre = "";
        $this->_permisos = [];
    }

    public function registrarUsuario($nick, $nombre, $permisos){
        $this->_nick = $nick;
        $this->_nombre = $nombre;
        $this->_permisos = $permisos;
        $this->_validado = true;
    }

    public function quitarRegistroUsuario(){
        $this->_validado = false;
    }
    
    public function hayUsuario(){
        return $this->_validado;
    }
    
    public function puedePermisos($numero){
        return $this->_permisos[$numero-1];
    }

    public function getNick(){
        return $this->_nick;
    }

    public function getNombre(){
        return $this->_nombre;
    }
    }


?>