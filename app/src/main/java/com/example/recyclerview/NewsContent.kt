package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsContent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)

        val imgResId = intent.getIntExtra("img", 0) // 0 is the default value if "img" is not found
        val txt = intent.getStringExtra("text")

        val image = findViewById<ImageView>(R.id.imageView)
        val texts = findViewById<TextView>(R.id.text)

        texts.text = txt
        image.setImageResource(imgResId)
    }
}
