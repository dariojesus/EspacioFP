<?php

?>
<div id="fondo"></div>

<div id="menu">
  <ul class="list-group list-group-flush">
    <?php
         echo CHTML::link("Menu de opciones","#",["class"=>"list-group-item list-group-item-action list-group-item-dark"]);
         echo CHTML::link("Iniciar sesion",["logueo","formulario"],["class"=>"list-group-item list-group-item-action list-group-item-dark"]);
         echo CHTML::link("Opción 1","#",["class"=>"list-group-item list-group-item-action list-group-item-dark"]);
         echo CHTML::link("Opción 2","#",["class"=>"list-group-item list-group-item-action list-group-item-dark"]);
         echo CHTML::link("Opción 3","#",["class"=>"list-group-item list-group-item-action list-group-item-dark"]);
    ?>
  </ul>
</div>

<nav class="navbar sticky-top navbar-light bg-transparent">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"></a>
    <div class="nav-item">
      <a class="nav-link" aria-current="page" id="btnMenu"><img src="/imagenes/logo/menu.png"></a>
    </div>
  </div>
</nav>

<main>
  <header>
    <div class="principal">
      <input type="text" id="busqueda" class="buscar" placeholder="Encuentra tu próximo destino">
      <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Numquam ut non officiis </p>
    </div>
  </header>

    <section class="card-group s1">
      <div class="card planeta">
        <img src="/imagenes/luna.jpg" class="card-img-top">
        <div class="card-body">
          <h5 class="card-title">Estación espacial luna</h5>
          <p class="card-text">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Cum consequatur dolore libero voluptas</p>
          <a href="#" class="btn btn-dark">Más información</a>
        </div>
      </div>
      <div class="card planeta">
        <img src="/imagenes/marte.jpg" class="card-img-top">
        <div class="card-body">
          <h5 class="card-title">Campamento biologico marte</h5>
          <p class="card-text">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quas alias dolorem fugiat omnis vero eaque saepe voluptas.</p>
          <a href="#" class="btn btn-dark">Más información</a>
        </div>
      </div>
      <div class="card planeta">
        <img src="/imagenes/urano.jpg" class="card-img-top">
        <div class="card-body">
          <h5 class="card-title">Base acuática urano</h5>
          <p class="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Porro corporis mollitia reprehenderit, soluta, vitae</p>
          <a href="#" class="btn btn-dark">Más información</a>
        </div>
      </div>
    </section>

    <section class="s2"></section>

    <footer>
      <div class="accordion accordion-flush">
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed blanco" type="button" data-bs-toggle="collapse"
              data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
              Sobre nosotros
            </button>
          </h2>
          <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
            data-bs-parent="#accordionFlushExample">
            <div class="accordion-body">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Debitis blanditiis
              nostrum natus quod ipsa cumque nemo accusamus saepe itaque optio quia reiciendis dignissimos ratione,
              perspiciatis vitae dicta laborum pariatur vero.</div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed blanco" type="button" data-bs-toggle="collapse"
              data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
              Protección de datos y cookies
            </button>
          </h2>
          <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo"
            data-bs-parent="#accordionFlushExample">
            <div class="accordion-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Necessitatibus, nemo
              inventore? Pariatur, a odio minima facilis dolor, deserunt saepe dolores itaque accusamus minus
              reiciendis
              cumque qui, alias asperiores fuga nemo.</div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed blanco" type="button" data-bs-toggle="collapse"
              data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
              Condiciones de uso
            </button>
          </h2>
          <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree"
            data-bs-parent="#accordionFlushExample">
            <div class="accordion-body">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Iure soluta fugit
              unde
              qui dolor ullam eveniet esse. Assumenda nostrum quibusdam molestias aperiam. Dolores perspiciatis
              molestiae
              voluptas aut similique cupiditate a?</div>
          </div>
        </div>
      </div>
      <div class="empresa">
        <div id="copyright">
          <img src="/imagenes/logo/64.png">
          <p>
            <b>The horizont company</b><br>
            <i>Todos los derechos reservados</i>
          </p>
        </div>
        <div>
          <a href="#"><img src="/imagenes/social/twitter.png" alt="" srcset=""></a>
          <a href="#"><img src="/imagenes/social/insta.png" alt="" srcset=""></a>
          <a href="#"><img src="/imagenes/social/facebook.png" alt="" srcset=""></a>
        </div>
      </div>
    </footer>
</main>