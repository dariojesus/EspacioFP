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
</style>
EOL;

echo CHTML::iniciarForm().PHP_EOL;
?>
<main>
    <div class="logo">
        <?php
            echo CHTML::link("<img src='../../../imagenes/logo/64.png'>",["inicial"]);
            echo CHTML::dibujaEtiqueta("h1",[],"Horizonts");
        ?>
    </div>
    <div class="form-floating">
        <input type="text" class="form-control" id="identificacion" placeholder="identifiacion">
        <label for="Identifiacion">Identifiación (DNI/NIF)</label>
    </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="contra" placeholder="contra">
        <label for="contra">Contraseña</label>
    </div>
    <div>
        <?php
            echo CHTML::boton("Acceder",["class"=>"btn btn-dark"]);
            echo CHTML::link("Registrarse",["logueo","Registro"],["class"=>"btn btn-dark"]);
        ?>
    </div>
    <hr>
        <?php
            echo CHTML::botonHtml("Login mediante Google",["class"=>"btn btn-outline-warning"]);
            echo CHTML::botonHtml("Login mediante Facebook",["class"=>"btn btn-outline-primary"]);
        ?>
</main>

<?php
echo CHTML::finalizarForm().PHP_EOL;
?>