<?php
	 
	class logueoControlador extends CControlador{

        public function __construct(){
            $this->accionDefecto ="formulario";
        }

		public function accionFormulario(){
            $this->dibujaVista("index",array(),"Acceso a la aplicacion");
		}

        public function accionRegistro(){
            $this->dibujaVista("registro",array(),"Registro de la aplicación");
        }
		
	}