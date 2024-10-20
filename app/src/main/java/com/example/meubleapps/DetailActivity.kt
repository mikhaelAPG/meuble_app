package com.example.meubleapps

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.meubleapps.model.Article

class DetailActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var descriptionTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleTextView = findViewById(R.id.article_title_detail)
        imageView = findViewById(R.id.article_image_detail)
        descriptionTextView = findViewById(R.id.article_description_detail)
        backButton = findViewById(R.id.button_back)

        val article: Article? = intent.getParcelableExtra("article")

        article?.let {
            titleTextView.text = it.title
            imageView.setImageResource(it.imageResId)
            descriptionTextView.text = it.description
        } ?: run {
            titleTextView.text = "Article not found"
            descriptionTextView.text = "No description available"
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
