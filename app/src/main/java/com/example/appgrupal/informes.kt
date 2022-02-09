package com.example.appgrupal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView



class informes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informes)
    }


/*
    private val storage = FirebaseStorage.getInstance()
    private val storageRef = storage.getReferenceFromUrl("gs://appgrupal-a11b0.appspot.com/pdf/prueba.pdf")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informes)

        val miboton: ImageView = findViewById(R.id.imagepdf)
        miboton.setOnClickListener {

            storageRef.child("pdf/prueba.pdf").downloadUrl.addOnSuccessListener {

            }.addOnFailureListener {

            }


        }


    }


 */
}