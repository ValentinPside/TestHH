package com.example.testhh1.presentation.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testhh1.app.App
import com.example.testhh1.databinding.FragmentSaveBinding
import com.example.testhh1.presentation.VacanciesAdapter
import com.example.testhh1.presentation.viewmodels.SaveViewModel
import com.example.testhh1.utils.Factory
import com.example.testhh1.utils.GrammaUtils
import kotlinx.coroutines.launch

class SaveFragment : Fragment() {

    private var _binding: FragmentSaveBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SaveViewModel> {
        Factory {
            App.appComponent.saveComponent().viewModel()
        }
    }

    private lateinit var vacanciesAdapter: VacanciesAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVacanciesRecycler()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observeUi().collect { state ->
                    state.vacancies?.let {
                        vacanciesAdapter.submitList(it)
                        binding.vacancyCountTv.text = GrammaUtils.getStringCount(it.size)
                    }
                    state.error?.let {
                        Toast.makeText(
                            requireContext(),
                            getString(it),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun setupVacanciesRecycler() {
        vacanciesAdapter = VacanciesAdapter()
        binding.vacanciesRV.adapter = vacanciesAdapter
        binding.vacanciesRV.layoutManager =
            LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}