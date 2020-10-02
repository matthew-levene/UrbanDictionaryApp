package com.ml.urbandictionaryapp.viewmodel

import androidx.lifecycle.ViewModel
import com.ml.urbandictionaryapp.repository.TermRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

class DefinitionDisplayViewModel(
    private val termRepository: TermRepository
) : ViewModel()
{
    private val supervisor = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + supervisor)

    val definitionSuccess = termRepository.definitionSuccess
    val definitionError = termRepository.definitionError

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}