package br.com.agnes.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        /*
        Criando o Shared Preferences
        São necessários dois parâmetros dentro do parênteses:
        1 - Nome da pasta que será  criada
        2 - O modo de acesso dele
         */

        val  minhaPreferecia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)

        //Criando o Editor do SharedPreferences
        val meuEditor = minhaPreferecia.edit()

        //Criando a lista do spinner
        val listaSexo = arrayListOf("Selecione o sexo", "Feminino", "Masculino")

        //Criando o adaptador do spinner
        val  adapterSexo = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )

        //Anexando o adaptador no Spinner
        spnSexo.adapter = adapterSexo

        /*
        Evento do clique do botão Cadastrar
        Toda execução depende do clique do botão
         */

        btnCadastro.setOnClickListener {
            //Recuperando os valores digitados pelo usuário e armazenando em variáveis
            val nome = edtNome.text.toString().trim()
            val sobrenome = edtSobrenome.text.toString().trim()
            val email = edtEmail.text.toString().trim().toLowerCase()
            val senha = edtSenha.text.toString().trim()

            //Validando se todos os campos estão preenchidos e se o sexo foi selecionado
            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                //Imprimindo a mensagem de erro para o usuário no Toast
                Toast.makeText(
                    this@CadastroActivity,
                    "Preencha todos os campos!",
                    Toast.LENGTH_LONG
                ).show()
            }else if(spnSexo.selectedItem =="Selecione o sexo"){
                Toast.makeText(
                    this@CadastroActivity,
                    "Selecione o sexo!",
                Toast.LENGTH_LONG
                ).show()
            }else{
                //Salvando as informações no Shared Preferences
                meuEditor.putString("nome", nome).apply()
                meuEditor.putString("sobrenome", sobrenome).apply()
                meuEditor.putString("email", email).apply()
                meuEditor.putString("senha", senha).apply()
                meuEditor.putString("sexo", spnSexo.selectedItem.toString()).apply()

                //Imprimindo uma mensagem de cadastrado com sucesso para o usuário
                Toast.makeText(
                    this@CadastroActivity,
                    "Cadastro feito com sucesso!",
                    Toast.LENGTH_LONG
                ).show()

                //Indo para a próxima tela
                startActivity(Intent(this@CadastroActivity, MainActivity::class.java))
            }
        }
    }
}
