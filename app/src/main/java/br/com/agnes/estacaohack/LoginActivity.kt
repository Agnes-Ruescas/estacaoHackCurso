package br.com.agnes.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Criando o clique do botão Entrar
        btnEntrar.setOnClickListener {
            //Recuperando os valores digitados
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenhaLogin.text.toString().trim()

            val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)
            val emailCorreto = minhaPreferencia.getString("email", "Falha ao obter dado")
            val senhaCorreta = minhaPreferencia.getString("senha", "Falha ao obter dado")

            //Criando a condição para vereficar se usuário e/ou senhas estão vazios e corretos
            if(usuario.isEmpty()){
                Toast.makeText(this@LoginActivity, "Usuário vazio!", Toast.LENGTH_LONG).show()
            }else if(senha.isEmpty()){
                Toast.makeText(this@LoginActivity, "Senha vazia!", Toast.LENGTH_LONG).show()
            }else if(usuario == "$emailCorreto"){
                if(senha == "$senhaCorreta"){
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }else{
                    Toast.makeText(this@LoginActivity, "Senha incorreta!", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this@LoginActivity, "Usuário incorreto!", Toast.LENGTH_LONG).show()
            }
        }

        //Criando a interação do botão Cadastrar
        btnCadastro.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }
    }
}
