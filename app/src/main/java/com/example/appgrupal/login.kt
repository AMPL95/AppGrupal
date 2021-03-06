package com.example.appgrupal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class login : AppCompatActivity() {
    private val GOOGLE_SIGN_IN=100
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_AppGrupal)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



    }




    private fun showError() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error con firebase")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun checkSession() {
        val preferences =
            getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE)
        val email = preferences.getString("email", null)
        if (email != null) {
            irNavigationDrawer()
        }

    }
    private fun irNavigationDrawer(){
        val menuIntent= Intent(this, NavigationDrawer::class.java)
        startActivity(menuIntent)
    }
    private fun irCambiarActivity(){
        val changeIntent= Intent(this, PasswordReset::class.java)
        startActivity(changeIntent)
    }



    fun onClickEntrar(view: View) {
        val email: EditText = findViewById(R.id.editEmail);
        val passw: EditText = findViewById(R.id.editPassword);

        if (email.text.isNotEmpty() && passw.text.isNotEmpty()) {
            try {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email.text.toString(), passw.text.toString())
                    .addOnCompleteListener() {
                        if (it.isSuccessful) {

                            irNavigationDrawer()
                        } else {
                            showError()
                        }
                    }
            } catch (ex: Exception) {

                showError()
            }

        }
    }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == GOOGLE_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    if (account != null) {
                        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                        FirebaseAuth.getInstance().signInWithCredential(credential)
                            .addOnCompleteListener() {

                                if (it.isSuccessful) {
                                    irNavigationDrawer()
                                } else {

                                }
                            }
                    }
                } catch (e: ApiException) {

                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("La contrase??a o el email es incorrecto")
                    builder.setMessage(e.message)
                    builder.setPositiveButton("Aceptar", null)
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
            }
        }


    fun onClickRegistrar(view:View){
        val inicioIntent= Intent(this,RegistroPantalla::class.java)
        startActivity(inicioIntent)
    }
    fun onClickClikable(view:View){
        irCambiarActivity()
    }


}