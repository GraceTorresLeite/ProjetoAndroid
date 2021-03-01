package com.example.projetoandroid.ui.subscriber

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetoandroid.R
import com.example.projetoandroid.repository.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

//proteger multiplos acessos ao meu LiveDta com o private
    private val _subscriberStateEventData = MutableLiveData<SubscriberState>()
    val subscriberStateEventData: LiveData<SubscriberState>
        get() = _subscriberStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _messageEventData

    //dados recebidos pelos usuários na view (name, email), agora aplicar métodos do repositório
    fun addSubscriber(name: String, email: String) = viewModelScope.launch {
        try {
            val id = repository.insertSubscriber(name, email)
            if (id > 0) { //se for maior que 0, o registro foi inserido com sucesso
                _subscriberStateEventData.value = SubscriberState.Inserted
                _messageEventData.value = R.string.subscriber_inserted_successfully
            }
        } catch (ex: Exception) {
            _messageEventData.value = R.string.subscriber_error_to_insert
            Log.e(TAG, ex.toString())
        }
    }
//padrão mvi - representa o estado da View
    sealed class SubscriberState {
        object Inserted : SubscriberState()
    }
//criando a minha TAG para os LOGs
    companion object {
        private val TAG = SubscriberViewModel::class.java.simpleName
    }
}