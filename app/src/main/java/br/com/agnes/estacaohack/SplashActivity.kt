package br.com.agnes.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Esperando e abrindo a próxima tela
        Handler().postDelayed({
            //Criando a intenção de ir para outra tela
            val intentTelaLogin = Intent(this@SplashActivity,
                LoginActivity::class.java)

            //Iniciando a próxima activity (executando a intent)
            startActivity(intentTelaLogin)

            //Encerrando a tela de Splash
            finish()
        },3000)
    }
}
