package com.example.testhh1.presentation.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testhh1.R
import com.example.testhh1.presentation.viewmodels.SaveViewModel

class SaveFragment : Fragment() {

    companion object {
        fun newInstance() = SaveFragment()
    }

    private val viewModel: SaveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_save, container, false)
    }
}