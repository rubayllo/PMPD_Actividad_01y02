package com.utad.actividad2rubenayllon.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.actividad2rubenayllon.ArticleActivity
import com.utad.actividad2rubenayllon.databinding.FragmentTechnologyBinding
import com.utad.actividad2rubenayllon.news_data.techNews
import com.utad.actividad2rubenayllon.recyclerView.New
import com.utad.actividad2rubenayllon.recyclerView.NewsRecyclerViewAdapter

class TechnologyFragment : Fragment() {

    private lateinit var _binding: FragmentTechnologyBinding
    private val binding: FragmentTechnologyBinding get() = _binding

    private lateinit var adapter: NewsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechnologyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTechnologyNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val newsList: List<New> = techNews
        adapter = NewsRecyclerViewAdapter(newsList, { openNews(it) })
        binding.rvTechnologyNews.adapter = adapter
    }

    private fun openNews(new: New) {
        val intent = Intent(requireContext(), ArticleActivity::class.java)

        intent.putExtra("title", new.title)
        intent.putExtra("image", new.image)
        intent.putExtra("author", new.author)
        intent.putExtra("article", new.description)

        startActivity(intent)
    }
}