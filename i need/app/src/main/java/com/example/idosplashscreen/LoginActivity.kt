package com.example.idosplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

import android.view.View
import android.widget.EditText
import org.json.JSONObject

import java.math.BigInteger
import java.security.MessageDigest
import android.os.StrictMode
import android.widget.Toast
import com.example.idosplashscreen.Model.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        tcadastro.setOnClickListener {
            val tela2 = Intent(this,CadastroDadosUsuarios ::class.java)
            startActivity(tela2)
        }
    }

    fun goToCadastro(v:View) {
        var editTextLogin = findViewById(R.id.tLogin) as EditText
        var editTextSenha = findViewById(R.id.tsenha) as EditText
        var email = editTextLogin.getText().toString()
        var senha = editTextSenha.getText().toString()

        //var reqParam = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(login, "UTF-8")
        //reqParam += "&" + URLEncoder.encode("senha", "UTF-8") + "=" + URLEncoder.encode(senha, "UTF-8")

        val http = Http()
        var url = getString(R.string.api_login)

        var login: Login =
            Login(email, senha)

        handleJson(http.post(url,login.toJson()))
        //println(http.post(url,login.toJson()))

        var url2 = "http://ravenamy.azurewebsites.net/Servicos/Categoria?categoria=47&login=69"

        //println(http.get(url2))

        //Login().execute(reqParam)

        if(UsuarioLogado.idUsuario > 0){
            //var home = Intent(this, GridCategorias::class.java)
            var home = Intent(this, HomeActivity::class.java)
            // enviando valores para a outra activity
            home.putExtra("idUsuario", UsuarioLogado.idUsuario)
            home.putExtra("nome", UsuarioLogado.nomeUsuario)

            startActivity(home)
        }else{
            Toast.makeText(this, "Usuário ou senha incorretos!!", Toast.LENGTH_SHORT).show()
        }

    }

    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

   /* inner class Login : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg parts: String): String? {
            //val requestURL = parts.first()
            var requestURL ="http://10.0.2.2:3000/usuario/login"
            val queryString = parts.last()

            // Set up request
            val connection = URL(requestURL).openConnection() as HttpURLConnection

            // Default is GET so you must override this for post
            connection.requestMethod = "POST"
            // To send a post body, output must be true
            connection.doOutput = true

            // Create the stream
            val outputStream = connection.outputStream as OutputStream
            // Create a writer container to pass the output over the stream
            val outputWriter = OutputStreamWriter(outputStream)
            // Add the string to the writer container
            outputWriter.write(queryString)
            // Send the data
            outputWriter.flush()
            // Container for input stream data
            val response = StringBuffer()

            // Create an input stream to read the response
            BufferedReader(InputStreamReader(connection.inputStream)).use {

                var inputLine = it.readLine()

                // Add each line to the response container
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
                println("resposta: "+response)
            }

            return response.toString()

            connection.disconnect()
        }

        protected fun onProgressUpdate(vararg progress: Int) {
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            handleJson(result)
        }
    }*/

    private fun handleJson(jsonString: String?) : Usuario {

        var jsonObject = JSONObject(jsonString)

        var endereco = Endereco(
        )

        var usuario = Usuario(
            jsonObject.getInt("idUsuario"),
            jsonObject.getString("RG"),
            jsonObject.getString("CpfCnpj"),
            jsonObject.getString("dataNascimento"),
            jsonObject.getString("email"),
            jsonObject.getString("estadoCivil"),
            jsonObject.getString("nome"),
            jsonObject.getBoolean("prestador"),
            jsonObject.getString("senha"),
            jsonObject.getString("sexo"),
            jsonObject.getString("telefone"),
            endereco//id endereco
        )

        UsuarioLogado(usuario.id_usuario, usuario.nome)
        return usuario
    }

}
