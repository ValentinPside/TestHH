package com.example.testhh1.di.components

import com.example.testhh1.presentation.viewmodels.SaveViewModel
import dagger.Subcomponent

@Subcomponent
interface SaveComponent {
    fun viewModel(): SaveViewModel
}