package com.example.simulacionexamen_kotlin

import kotlin.random.Random


fun String.transformar(descolocada: Boolean, func_cambiar:(c:Char, a: Int)-> Char): String{

    var palabraModificada = ""
    var palabraFinal=""

    //Conjunto que guarda las posiciones a cambiar

    if (descolocada){
        // Descolocamos la palabra original de forma aleatoria
        var conjunto=mutableSetOf<Int>()
        var num_Aleatorio:Int

          while (conjunto.size < this.length){

              num_Aleatorio = Random.nextInt(1,this.length-1)
              conjunto.add(num_Aleatorio)

          }
        // Descolocamos la palabra
        //Recorro las posiciones de la palabras
        var pos: Int
        for (pos in 0 .. this.length-1){
            palabraModificada = palabraModificada+this.get(conjunto.elementAt(pos)).toString()
        }
    }
    else{
        palabraModificada= this
    }
    //Transformar la palabra, se recorre la palabra y se invoca por
    //cada caracter a la func_cambiar
    for (i in 0 .. this.length-1)
    {
        palabraFinal = palabraFinal+func_cambiar(this.get(i),i).toString()
    }

    // retornar palabrar
    return palabraFinal
}

