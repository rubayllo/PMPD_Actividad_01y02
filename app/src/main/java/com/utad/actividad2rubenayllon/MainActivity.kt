package com.utad.actividad2rubenayllon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utad.actividad2rubenayllon.databinding.ActivityMainBinding
import com.utad.actividad2rubenayllon.fragments.WellcomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding: ActivityMainBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val goToWellcomeFragment = WellcomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.fcvMain.id, goToWellcomeFragment)
        transaction.commit()

    }
}