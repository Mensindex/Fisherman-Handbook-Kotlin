package com.example.fishermanhandbook

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvDescription: TextView = findViewById(R.id.tvDescription)
        val ivImage: ImageView = findViewById(R.id.ivItem)
        tvTitle.text = intent.getStringExtra("title")
        tvDescription.text = intent.getStringExtra("content")
        ivImage.setImageResource(intent.getIntExtra("image", R.drawable.som))
    }
}