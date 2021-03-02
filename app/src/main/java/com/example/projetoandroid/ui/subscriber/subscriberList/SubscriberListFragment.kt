package com.example.projetoandroid.ui.subscriber.subscriberList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.projetoandroid.R
import com.example.projetoandroid.data.db.entity.SubscriberEntity
import kotlinx.android.synthetic.main.subscriber_list_fragment.*

// definir recurso de layout- não precisa mais do oncreateview
class SubscriberListFragment : Fragment(R.layout.subscriber_list_fragment) {
    private lateinit var viewModel: SubscriberListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//instanciar adapter - lista fake
        val subscriberListAdapter = SubscriberListAdapter(
            listOf(
                SubscriberEntity(1, "Grace", "grace@teste1.com"),
                SubscriberEntity(2, "Fundatec", "fundatec@teste2.com")
            )
        )

        with(recycler_subscribers) {
            setHasFixedSize(true)
            adapter = subscriberListAdapter
        }
    }
                                           }