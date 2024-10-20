package com.example.meubleapps

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        profileImage = findViewById(R.id.profile_image)
        nameTextView = findViewById(R.id.name)
        emailTextView = findViewById(R.id.email)
        backButton = findViewById(R.id.button_back)

        profileImage.setImageResource(R.drawable.ic_launcher_foreground)
        nameTextView.text = "Mikhael"
        emailTextView.text = "mikhael@gmail.com"

        backButton.setOnClickListener {
            finish()
        }
    }
}
