package com.example.testhh1.di.components

import com.example.testhh1.presentation.viewmodels.SearchViewModel
import dagger.Subcomponent

@Subcomponent
interface SearchComponent {
    fun viewModel(): SearchViewModel
}