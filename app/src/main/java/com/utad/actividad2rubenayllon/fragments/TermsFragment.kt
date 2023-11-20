package com.utad.actividad2rubenayllon.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.utad.actividad2rubenayllon.NewsActivity
import com.utad.actividad2rubenayllon.R
import com.utad.actividad2rubenayllon.databinding.FragmentTermsBinding


class TermsFragment : Fragment() {

    private lateinit var _binding: FragmentTermsBinding
    private val binding: FragmentTermsBinding get() = _binding

    private var name: String? = null
    private var checkID: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTermsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(requireArguments().containsKey("name")){
            name = requireArguments().getString("name")
        }
        val nombreUsuario = name + binding.tvTerminosSaludo.text.toString()
        binding.tvTerminosSaludo.setText(/* text = */ nombreUsuario)

        binding.swTerminos.setOnClickListener(){
            buttonEnabled()
        }

        binding.btnTermsAceptar.setOnClickListener(){
            if(binding.swTerminos.isChecked == true) {
                val intent = Intent(requireContext(), NewsActivity::class.java)
                if(requireArguments().containsKey("checkID")){
                    checkID = requireArguments().getString("checkID")
                    intent.putExtra("checkID", checkID)
                }
                startActivity(intent)
            }
        }
    }

    private fun buttonEnabled() {
        if (binding.swTerminos.isChecked) {
            Snackbar.make(binding.root, "Confirmas", Snackbar.LENGTH_SHORT).show()

            binding.btnTermsAceptar.setBackgroundColor(Color.parseColor("#3070A3"))
            binding.btnTermsAceptar.isEnabled = true
        } else {
            Snackbar.make(binding.root, "No confirmas", Snackbar.LENGTH_SHORT).show()

            binding.btnTermsAceptar.setBackgroundColor(Color.parseColor("#B9BBBC"))
            binding.btnTermsAceptar.isEnabled = false
        }
    }
}