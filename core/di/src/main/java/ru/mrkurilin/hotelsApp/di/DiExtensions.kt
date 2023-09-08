package ru.mrkurilin.hotelsApp.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel

fun Fragment.requireSubComponentsProvider(): SubComponentsProvider {
    val subComponentsProviderProvider =
        requireActivity().application as SubComponentsProviderProvider
    return subComponentsProviderProvider.getSubComponentsProvider()
}

inline fun <reified T : ViewModel> Fragment.lazyViewModel(
    noinline create: () -> T,
): Lazy<T> {
    return viewModels {
        ViewModelFactory(this, create)
    }
}