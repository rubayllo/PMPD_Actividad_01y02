package com.utad.actividad2rubenayllon.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.utad.actividad2rubenayllon.NewsActivity
import com.utad.actividad2rubenayllon.R

import com.utad.actividad2rubenayllon.databinding.FragmentWellcomeBinding

class WellcomeFragment : Fragment() {

    private lateinit var _binding: FragmentWellcomeBinding
    private val binding: FragmentWellcomeBinding get() = _binding

    private var checkID: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWellcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etName.doAfterTextChanged { buttonEnabled() }

        binding.cbWellcomeMostrarTodas.setOnClickListener() {
            binding.cbWellcomeDeportes.isChecked = false
            binding.cbWellcomeTecnologA.isChecked = false
            checkID = "all"
            buttonEnabled()
        }

        binding.cbWellcomeDeportes.setOnClickListener() {
            binding.cbWellcomeMostrarTodas.isChecked = false
            binding.cbWellcomeTecnologA.isChecked = false
            checkID = "sports"
            buttonEnabled()
        }

        binding.cbWellcomeTecnologA.setOnClickListener() {
            binding.cbWellcomeMostrarTodas.isChecked = false
            binding.cbWellcomeDeportes.isChecked = false
            checkID = "technology"
            buttonEnabled()
        }

        binding.btnWellcomeContinue.setOnClickListener() {
            goToTerms()
        }

    }

    private fun goToTerms() {
        val nameIsBlank = binding.etName.text.isBlank()
        val bundle = Bundle()

        if (nameIsBlank) {
            Toast.makeText(activity, "Por favor completa los datos", Toast.LENGTH_SHORT).show()
        } else {
            val name = binding.etName.text.toString()

            bundle.putString("name", name)
            bundle.putString("checkID", checkID)
            val goToTermsFragment = TermsFragment()
            goToTermsFragment.arguments = bundle

            val transaction = parentFragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            transaction.addToBackStack(null)
            transaction.replace(R.id.fcv_main, goToTermsFragment)
            transaction.commit()

        }
    }

    private fun buttonEnabled() {
        val todas = binding.cbWellcomeMostrarTodas.isChecked
        val deportes = binding.cbWellcomeDeportes.isChecked
        val tecnologia = binding.cbWellcomeTecnologA.isChecked

        if (todas || deportes || tecnologia) {
            binding.btnWellcomeContinue.setBackgroundColor(Color.parseColor("#3070A3"))
            binding.btnWellcomeContinue.isEnabled = true
        } else {
            binding.btnWellcomeContinue.setBackgroundColor(Color.parseColor("#B9BBBC"))
            binding.btnWellcomeContinue.isEnabled = false
        }
    }
}

