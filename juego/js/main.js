var juego;
var nodoPuntos;
var intervalos = [];

/** Clases del juego */

class Juego {
    constructor(){
        this._mensajes;
        this._sonidos;
        this._niveles;

        this._nivel = 1;
        this._personajes = [];
        this._puntuacion = 0;
        this._finaliza = false;
    }

    /*Método que muestra los mensajes del juego*/
    muestraMensaje(msg1, msg2){
        let mensaje = document.createElement("div");
        mensaje.className = "mensaje";
        mensaje.appendChild(document.createTextNode(msg1));
        document.body.appendChild(mensaje);

        setTimeout(() => {mensaje.textContent = ""}, 1000);
        setTimeout(() => {mensaje.textContent= msg2}, 2000);
        setTimeout(() => {document.body.removeChild(mensaje);}, 3000);
    }

    /*Método que muestra la interfaz del juego */
    muestraNiveles(){
        let nodo;
        let txt;

        //Se ajusta todo a la pantalla disponible
        document.getElementById("li").style.height = window.innerHeight+"px";
        document.getElementById("main").style.height = window.innerHeight+"px";
        document.getElementById("ld").style.height = window.innerHeight+"px";


        //Se crean los botones de los niveles
        for (let cont = 1 ; cont < this._niveles ; cont++){
            nodo = document.createElement("button");
            nodo.className = "boton";
            nodo.addEventListener("click", ()=>{juego.nivel=cont;});

            txt = document.createTextNode("Nivel: "+cont);
            nodo.appendChild(txt);

            document.getElementById("li").appendChild(nodo);
        }

        //Se crea el botón de START
        nodo = document.createElement("button");
        nodo.className = "boton";
        nodo.style.backgroundColor = "darkgreen";
        nodo.addEventListener("click", ()=>{juego.empiezaJuego();});

        txt = document.createTextNode("Start");
        nodo.appendChild(txt);
        document.getElementById("li").appendChild(nodo);

        
        //Se crea el nodo con la puntuacion del juego
        nodo = document.createElement("div");
        nodo.id = "pto";
        
        nodoPuntos = document.createTextNode("Puntos: 0");
        nodo.appendChild(nodoPuntos);
        
        document.getElementById("ld").appendChild(nodo);
    }

    /*Método para resetear el contador y borrar personajes*/
    resetea(){
        this._puntuacion=0;
        this.actualizaPuntos(0);

        for (let cont = 0; cont < intervalos.length; cont++){
            clearInterval(intervalos[cont][0]);
            clearInterval(intervalos[cont][1]);
            clearInterval(intervalos[cont][2]);
        }

        let pjs = document.getElementsByClassName("personaje");
            
        while (pjs.length > 0)
            document.body.removeChild(pjs[0]);

        this._personajes=[];
        intervalos = [];
    }

    /*Método que actualiza los puntos mostrados por pantalla */
    actualizaPuntos(puntos){
        this._puntuacion += puntos;
        nodoPuntos.nodeValue="Puntos: "+this._puntuacion; 
    }

    /*Método que se llama al hacer click en cualquier animal */
    mataAnimal(numero = -1){

        this._sonidos[1].play();

          //Se llama al acabar el juego habiendo perdido
        if (numero == -1){
            this._sonidos[2].play();
            this.muestraMensaje(this.mensajes[5],this.mensajes[4]+this.puntuacion);
            this.resetea();
        }

        else {

            //Actualizo puntos del animal
            this.actualizaPuntos(this.personajes[numero].puntos);

            //Limpio intervalos del animal
            clearInterval(intervalos[numero][0]);
            clearInterval(intervalos[numero][1]);  
            clearInterval(intervalos[numero][2]);

            //Mato al animal y remuevo hijo             
            this.personajes[numero].estado = false;
            document.body.removeChild(document.getElementById(numero));
        
               //Si todos los enemigos han muerto
            if (this.enemigosMuertos()){
                this._sonidos[3].play();
                this.muestraMensaje(this.mensajes[3],this.mensajes[4]+this.puntuacion);
                this.resetea();
            }
        
               //Si has matado a un amigo
            else if (this.personajes[numero].tipo === 1){
                this._sonidos[2].play();
                this.muestraMensaje(this.mensajes[2],this.mensajes[5]);
                this.resetea();
            }
        }
    }

    /*Método que comprueba si todos los enemigos han muerto o no */
    enemigosMuertos(){

        let muertos = true;
        let cont = 0;

        do {
            if (this.personajes[cont].estado === true && this.personajes[cont].tipo === 0)
                muertos = false;

            cont++;

        }while(muertos && cont < this.personajes.length);

        return muertos;
    }

    /*Método para generar los enemigos y amigos del juego */
    empiezaJuego(){
        
        this._sonidos[0].play();
        let amigos = this._nivel *1;
        let enemigos = this._nivel * 2;
        let velocidad, tamano, puntos;

        /* Se muestran los mensajes de inicio */
        this.muestraMensaje(this._mensajes[0]+this._nivel,this._mensajes[1]);

        setTimeout(() => {
            
            //Se generan los personajes de manera aleatoria y con el calculo de sus puntos
            for (let cont = 0 ; cont < amigos; cont++){

                velocidad = Math.floor(Math.random() * (35 * this._nivel)) + 50;
                tamano = Math.floor(Math.random() * 15) + 5;
                puntos = Math.floor(0.40 * velocidad + ((11*this._nivel)/tamano));

                let a = new Amigo (cont,puntos,tamano,velocidad, "amigo");

                a.mostrarPantalla();
                this._personajes.push(a);
            }

            for (let cont = amigos ; cont < (amigos+enemigos); cont++){

                velocidad = Math.floor(Math.random() * (35 * this._nivel)) + 50;
                tamano = Math.floor(Math.random() * 10) + 5;
                puntos = Math.floor(0.40 * velocidad + ((11*this._nivel)/tamano));

                let e = new Enemigo (cont,puntos,tamano,velocidad, "enemigo");

                e.mostrarPantalla();
                this._personajes.push(e);
            }

        }, 4000);


    }

    get nivel () {return this._nivel;}

    set nivel (lvl) {this._nivel = lvl;}

    get niveles () {return this._niveles;}

    set niveles (lvl) {this._niveles = lvl;}

    get finaliza () {return this._finaliza;}

    set finaliza (x) {this._finaliza=true;}

    get mensajes () {return this._mensajes;}

    set mensajes (msg) {this._mensajes = msg;}

    get sonidos () {return this._sonidos;}

    set sonidos (snd) {this._sonidos = snd;}

    get puntuacion () {return this._puntuacion;}

    get personajes(){return this._personajes;}

}

class Animal{

    constructor (id, tipo, puntos, tamano, velocidad, imagen){
        
        this._id = id;
        this._tamano = tamano;
        this._imagen = imagen;
        
        /**Accesibles via get y set*/
        this._estado = true;
        this._velocidad = velocidad;
        this._tipo = tipo;
        this._puntos = puntos;
        this._nodo;

        this._posInicial = window.innerWidth * 0.1;
        this._anchoLimite = window.innerHeight - 250;
        this._limite = window.innerWidth * 0.9;
    }

    mostrarPantalla(){
        this._nodo = document.createElement("img");
        
        this._nodo.src = "./images/"+this._imagen+".png";
        this._nodo.id = this._id;
        this._nodo.className = "personaje";
        this._nodo.style.position = "absolute";
        this._nodo.style.bottom = Math.floor(Math.random() * this._anchoLimite)+"px";
        this._nodo.style.left = this._posInicial+"px";
        this._nodo.style.height = this._tamano+"%";

        this._nodo.addEventListener("click", ()=>{juego.mataAnimal(this._id);});
        document.body.appendChild(this._nodo);

        //Se inician los intervalos y se guardan para su eliminación posterior

        intervalos.push([      
            
            setInterval(() => {
            this._posInicial += this._velocidad;
            this._nodo.style.left = this._posInicial +"px";
        
                if (this._posInicial > this._limite){

                    if (this._tipo != 1)
                        juego.mataAnimal();

                    else{
                        this.posInicial = window.innerWidth * 0.1;
                        this._nodo.style.left = this.posInicial+"px";
                    }
                }
                    
        
            } , 1000),

        
            setInterval(() => {this._nodo.src = "./images/"+this._imagen+"2.png"}, 1000),

            setInterval(() => {this._nodo.src = "./images/"+this._imagen+".png"}, 2000)
        ]);
    }

    set estado (e){
        this._estado = e;
    }

    get estado (){
        return this._estado;
    }

    set velocidad (v){
        this._velocidad = v;
    }

    get velocidad (){
        return this._velocida;
    }

    set tipo (t){
        this._tipo = t;
    }

    get tipo (){
        return this._tipo;
    }

    set puntos (p){
        this._puntos= p;
    }

    get puntos (){
        return this._puntos;
    }

    set imagen (im){
        this._imagen = im;
    }

    get imagen (){
        return this._imagen;
    }

    set nodo (n){
        this._nodo = n;
    }

    get nodo(){
        return this._nodo;
    }

    set posInicial(pos){
        this._posInicial = pos;
    }

    get posInicial(){
        return this._posInicial;
    }
}

class Amigo extends Animal{

    constructor(id, puntos, tamano, velocidad, imagen){
        super(id, 1, -puntos, tamano, velocidad, imagen);
    }
}

class Enemigo extends Animal{
    constructor(id, puntos, tamano, velocidad, imagen){
        super(id, 0, puntos, tamano, velocidad, imagen);
    }
}

/*------------------------------------------------Esto es el main------------------------------------------- */
juego = new Juego();
juego.niveles = 8;

juego.sonidos = [document.getElementById("intro"), 
                document.getElementById("kill"),
                document.getElementById("over"),
                document.getElementById("win")];

juego.mensajes = ["Nivel ","!Adelante!","!Has matado un amigo!","!Has Ganado!","Puntuacion :","GAME OVER"];

juego.muestraNiveles();