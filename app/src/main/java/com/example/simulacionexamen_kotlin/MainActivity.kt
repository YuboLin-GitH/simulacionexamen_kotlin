package com.example.simulacionexamen_kotlin

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simulacionexamen_kotlin.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var mibinding: ActivityMainBinding
    lateinit var mireloj: CountDownTimer

    var  minutos =3
    var segundos =59
    var objpalabras= Juego_de_Palabras()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mibinding= ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarComponentes()
        inicializarReloj()

    }

    private fun inicializarReloj() {
        //Instancio el objeto
        mireloj = object : CountDownTimer(180000,1000) {
            override fun onFinish() {
                TODO("Not yet implemented")
            }

            override fun onTick(millisUntilFinished: Long) {
                segundos--
                if (segundos<0){
                    segundos=59
                    minutos--
                }

                mibinding.tiempo.text
            }
        }
    }

    private fun inicializarComponentes() {
        //Definimos el listaener para el boton comenzar juego
        mibinding.btJugar.setOnClickListener {

            //Habilitamos el editText
            mibinding.etpalabra.isEnabled=true
            mibinding.btComprobar.isEnabled=true
            mibinding.btJugar.isEnabled=false
            mibinding.ivResultado.visibility= View.INVISIBLE

            //Mostrarmos la palabra transformada
            //Generamos un numero aleatorio entre 0 y 3 para la definir
            //el modo de transformar la palabra
            var num = Random.nextInt(0, 3)

            mibinding.tvpista.text= objpalabras.obtener_Pista(num)
            var palabraCambiada:String=""
            when(num){
                //transformacion faltan caracteres
                0->
                    palabraCambiada = objpalabras.obtener_Palabra().transformar(
                        Random.nextBoolean()){c, pos ->
                        if (Random.nextBoolean())
                        {
                            '_'
                        }
                        else
                            c

                    }

                1->
                    palabraCambiada =objpalabras.obtener_Palabra().transformar(true){
                        c, pos->
                        if(c =='a')
                            'e'
                        else if (c == 'e')
                            'i'
                        else if (c == 'i')
                            'o'
                        else if (c == 'o')
                            'u'
                        else if (c == 'u')
                            'a'
                        else
                            c
                    }

                2->
                    palabraCambiada =objpalabras.obtener_Palabra().transformar(false){
                            c, pos->
                        if(pos%2 == 0){
                            (c.lowercaseChar().code-'a'.code+1) as Char
                        }
                        else
                            c
                    }

                /*
                3->
                    palabraCambiada =objpalabras.obtener_Palabra().transformar(false){
                            c, pos->
                        if(pos%2 == 0){
                            (c.lowercaseChar().code-'a'.code+1) as Char
                        }
                        else
                            c
                    }
                    */
            }


        }
    }



}