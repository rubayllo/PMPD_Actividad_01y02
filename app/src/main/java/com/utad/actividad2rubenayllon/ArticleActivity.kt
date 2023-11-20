package com.utad.actividad2rubenayllon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.utad.actividad2rubenayllon.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityArticleBinding
    private val binding: ActivityArticleBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val image = intent.getStringExtra("image")
        val author = intent.getStringExtra("author")
        val article = intent.getStringExtra("article")

        binding.tvTitleNew.text = title
        Glide.with(binding.root).load(image).into(binding.ivImagenNew)
        binding.tvAuthorNew.text = author
        binding.tvArticleNew.text = article
    }
}