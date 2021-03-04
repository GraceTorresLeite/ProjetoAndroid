package com.example.projetoandroid.ui.subscriber.subscriberList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetoandroid.data.db.entity.SubscriberEntity
import com.example.projetoandroid.repository.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberListViewModel(
        private val repository: SubscriberRepository
) : ViewModel() {

    private val _allSubscribersEvent = MutableLiveData<List<SubscriberEntity>>()
    val allSubscribersEvent: LiveData<List<SubscriberEntity>>
        get() = _allSubscribersEvent

    //responsavel por obter o Live Data = chmando o get subscriber
    fun getSubscribers() = viewModelScope.launch {
        _allSubscribersEvent.postValue(repository.getAllSubscribers())
    }
}