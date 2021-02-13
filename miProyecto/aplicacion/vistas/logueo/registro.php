<?php

$this->textoHead =<<<EOL
    <style>
    main{
        display: grid;
        grid-template-columns: 80%;
        justify-content: center;
        row-gap: 5%;
        margin-top: 15vh;
    }

    .logo > *{
        display: inline-block;
    }

    html,body{
        background-color: white;
    }

    @media (min-width: 600px) {

        fieldset{
            display: grid;
            grid-template-columns: auto auto;
        }

        legend{
            grid-column-start: 1;
            grid-column-end: 3;
        }   
        
    }
    </style>
EOL;
echo CHTML::iniciarForm().PHP_EOL;
?>
<main>
    <div class="logo">
        <img src="../../../imagenes/logo/64.png" alt="" srcset="">
        <h1>Horizonts</h1>
    </div>

    <fieldset>
        <legend>Datos personales</legend>
        <div class="form-floating m-2">
            <input type="text" class="form-control" id="nif" placeholder="nif">
            <label for="nif">NIF</label>
        </div>
        <div class="form-floating m-2">
            <input type="text" class="form-control" id="nombre" placeholder="nombre">
            <label for="nombre">Nombre</label>
        </div>
        <div class="form-floating m-2">
            <input type="text" class="form-control" id="apellidos" placeholder="apellidos">
            <label for="apellidos">Apellidos</label>
        </div>
        <div class="form-floating m-2">
            <input type="date" class="form-control" id="nacimiento" placeholder="nacimiento">
            <label for="nacimiento">Fecha de nacimiento</label>
        </div>
    </fieldset>


    <fieldset>
        <legend>Datos de contacto</legend>
        <div class="form-floating m-2">
            <input type="email" class="form-control" id="email" placeholder="email">
            <label for="email">Email</label>
        </div>

        <div class="form-floating m-2">
            <input type="email" class="form-control" id="emailRepetido" placeholder="email">
            <label for="emailRepetido">Confirmar Email</label>
        </div>

        <div class="form-floating m-2">
            <input class="form-control" list="Opciones" id="poblacion" placeholder="poblacion">
            <datalist id="Opciones">
                <option value="San Francisco">
                <option value="New York">
                <option value="Seattle">
                <option value="Los Angeles">
                <option value="Chicago">
            </datalist>
            <label for="poblacion">Poblacion</label>
        </div>

        <div class="form-floating m-2">
            <input type="text" class="form-control" id="direccion" placeholder="direccion">
            <label for="direccion">Direccion</label>
        </div>
    </fieldset>


    <fieldset>
        <legend>Seguridad</legend>
        <div class="form-floating m-2">
            <input type="password" class="form-control" id="contra" placeholder="contraseña">
            <label for="contra">Contraseña</label>
        </div>
        <div class="form-floating m-2">
            <input type="password" class="form-control" id="contraRepetida" placeholder="contraseña">
            <label for="contra">Confirmar contraseña</label>
        </div>
    </fieldset>


    <button type="button" class="btn btn-outline-success">Registrarse</button>

</main>

<?php
echo CHTML::finalizarForm().PHP_EOL;
?>