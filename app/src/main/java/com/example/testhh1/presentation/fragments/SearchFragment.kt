package com.example.testhh1.presentation.fragments

import android.content.Intent
import android.net.Uri
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
import com.example.testhh1.databinding.FragmentSearchBinding
import com.example.testhh1.presentation.OffersAdapter
import com.example.testhh1.presentation.VacanciesAdapter
import com.example.testhh1.presentation.viewmodels.SearchViewModel
import com.example.testhh1.utils.Factory
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SearchViewModel> {
        Factory {
            App.appComponent.searchComponent().viewModel()
        }
    }

    private lateinit var offersAdapter: OffersAdapter
    private lateinit var vacanciesAdapter: VacanciesAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOffersRecycler()
        setupVacanciesRecycler()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observeUi().collect { state ->
                    state.offers?.let {
                        offersAdapter.submitList(it)
                    }
                    state.vacancies?.let {
                        vacanciesAdapter.submitList(it)
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

    private fun setupOffersRecycler() {
        offersAdapter = OffersAdapter { url ->
            openUrl(url)
        }
        binding.offersRV.adapter = offersAdapter
        binding.offersRV.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupVacanciesRecycler() {
        vacanciesAdapter = VacanciesAdapter()
        binding.vacanciesRV.adapter = vacanciesAdapter
        binding.vacanciesRV.layoutManager =
            LinearLayoutManager(requireContext())
    }

    private fun openUrl(url: String) {
        val urlIntent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(url)
        }
        startActivity(urlIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}