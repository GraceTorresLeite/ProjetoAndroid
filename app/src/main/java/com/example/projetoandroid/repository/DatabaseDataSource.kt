package com.example.projetoandroid.repository

import androidx.lifecycle.LiveData
import com.example.projetoandroid.data.db.dao.SubscriberDAO
import com.example.projetoandroid.data.db.entity.SubscriberEntity

class DatabaseDataSource (private val subscriberDAO: SubscriberDAO) : SubscriberRepository{
//a interface DAO é que faz acesso ao banco
    override suspend fun insertSubscriber(name: String, email: String): Long {
        val subscriber = SubscriberEntity(
            name = name,
            email = email
        )

        return subscriberDAO.insert(subscriber)
    }

    override suspend fun updateSubscriber(id: Long, name: String, email: String) {
        val subscriber = SubscriberEntity(
            id = id,
            name = name,
            email = email
        )

        subscriberDAO.update(subscriber)
    }

    override suspend fun deleteSubscriber(id: Long) {
        subscriberDAO.delete(id)
    }

    override suspend fun deleteAllSubscribers() {
        subscriberDAO.deleteAll()
    }

    override suspend fun getAllSubscribers(): LiveData<List<SubscriberEntity>> {
        return subscriberDAO.getAll()
    }
}