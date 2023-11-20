package com.utad.actividad2rubenayllon.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.utad.actividad2rubenayllon.ArticleActivity
import com.utad.actividad2rubenayllon.NewsActivity
import com.utad.actividad2rubenayllon.databinding.FragmentAllNewsBinding
import com.utad.actividad2rubenayllon.news_data.generalNews
import com.utad.actividad2rubenayllon.news_data.sportNews
import com.utad.actividad2rubenayllon.news_data.techNews
import com.utad.actividad2rubenayllon.recyclerView.New
import com.utad.actividad2rubenayllon.recyclerView.NewsListAdapter
import com.utad.actividad2rubenayllon.recyclerView.NewsRecyclerViewAdapter

class AllNewsFragment : Fragment() {

    private lateinit var _binding: FragmentAllNewsBinding
    private val binding: FragmentAllNewsBinding get() = _binding

    private lateinit var adapter: NewsRecyclerViewAdapter

    private var addNewsList: MutableList<New> = mutableListOf()
    private lateinit var adapterList: NewsListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvAllNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val newsList = generalNews
        adapter = NewsRecyclerViewAdapter(newsList, { openNews(it) })
        binding.rvAllNews.adapter = adapter

        binding.fbExtended.setOnClickListener(){addNews()}
    }

    private fun openNews(new: New) {
        val intent = Intent(requireContext(), ArticleActivity::class.java)

        intent.putExtra("title", new.title)
        intent.putExtra("image", new.image)
        intent.putExtra("author", new.author)
        intent.putExtra("article", new.description)

        startActivity(intent)
    }


    private fun addNews() {
        // Se añaden todos los elementos de cada categoría a la lista
        addNewsList.addAll(generalNews)
        addNewsList.addAll(sportNews)
        addNewsList.addAll(techNews)

        // shuffle desordena la lista y así sale mezclada
        addNewsList.shuffle()

        binding.rvAllNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapterList = NewsListAdapter( { openNews(it)})

        binding.rvAllNews.adapter = adapterList
        adapterList.submitList(addNewsList)

    }


}