package com.utad.actividad2rubenayllon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.utad.actividad2rubenayllon.databinding.ActivityNewsBinding
import com.utad.actividad2rubenayllon.fragments.AllNewsFragment

class NewsActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityNewsBinding
    private val binding: ActivityNewsBinding get() = _binding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperación de la variable escogida en el checkbox
        val selection = intent.getStringExtra("checkID")

        setButtonNavigation(selection)
    }



    private fun setButtonNavigation(selection: String?) {
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(binding.nhfNews.id) as NavHostFragment
        navController = navHostFragment.findNavController()

        if(navHostFragment!=null){
            binding.bnMenuNews.setupWithNavController(navController)
        }

        when (selection) {
            "all" -> binding.bnMenuNews.selectedItemId = R.id.allNewsFragment
            "sports" -> binding.bnMenuNews.selectedItemId = R.id.sportsFragment
            "technology" -> binding.bnMenuNews.selectedItemId = R.id.technologyFragment
        }
    }

}