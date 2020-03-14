package br.com.agnes.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Abrindo o Shared Preference
        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)
        //Recuperando os dados salvos
        val nome = minhaPreferencia.getString("nome", "Falha ao obter o dado")
        val sobrenome = minhaPreferencia.getString("sobrenome", "Falha ao obter o dado")

         txvNome.text = "$nome $sobrenome"

        val email = minhaPreferencia.getString("email", "Falha ao obter dado")
        txvEmail.text = "$email"

        val sexo = minhaPreferencia.getString("sexo", "Falha ao ober dado")
        txvSexo.text = "$sexo"

        btnSair.setOnClickListener {
            //Criando a intenção de ir para a tela de Login
            val intentTelaLogin = Intent(this@MainActivity, LoginActivity::class.java)

            //Iniciando a próxima tela
            startActivity(intentTelaLogin)

            finishAffinity()
        }

        btnSite.setOnClickListener {
            val intentTelaWeb = Intent(this@MainActivity, WebActivity::class.java)
            startActivity(intentTelaWeb)
        }
    }
}
