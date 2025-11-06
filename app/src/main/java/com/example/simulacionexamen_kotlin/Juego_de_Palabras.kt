package com.example.simulacionexamen_kotlin

class Juego_de_Palabras() {

    private var palabras = mutableListOf<String>("Arrancar","Patata","Juego","Pizarra")

    private  val pista = listOf<String>("Faltan caracteres", "Cambio de vocal", "Posicion del caracter", "Cambia consonante")

    var puntos = 2
        get()=field
        set(value){
            field=value
        }

    constructor(palabras: ArrayList<String>):this() {
        this.palabras = palabras
    }

    fun obtener_Palabra():String {
       return palabras.random()
    }


    fun obtener_Pista(n: Int): String{
        return pista.get(n)
    }




}