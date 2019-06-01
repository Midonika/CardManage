package com.example.dimilkowska.android_cards

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.dimilkowska.android_cards.entity.Card
import com.example.dimilkowska.android_cards.entity.Transaction

@SuppressLint("ValidFragment")
class FragmentTransactionListView(val MainActivity: MyMainActivity, val cardId: Int, val card: Card) : Fragment() {

    internal var listView: ListView? = null
    internal var items = ArrayList<Transaction>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list_transaction_view, container, false)

        listView = view.findViewById(R.id.list_view_transaction)

        val db = MainActivity.db

        val tmpItems = db?.transactionDao()?.getAllTransactions(cardId)
        items = ArrayList(tmpItems)

        val adapter = ArrayListTransactionAdapter(items, this.activity!!.baseContext, MainActivity)
        listView!!.adapter = adapter

        val addCardBtn = view.findViewById<Button>(R.id.list_cards)

        addCardBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                MainActivity.replaceFragment(1)
            }
        })

        var from = getfirstPeriodDay(card.period)
        var to = System.currentTimeMillis()

        var sumTransactions = (db?.transactionDao()!!.sumAllTransactionsByDate(from, to, card.id!!))

        if(card.free_100 && sumTransactions < 100){
            var message = "Wykonaj jeszcze transakcji na kwotę "
            var amount = 100 - sumTransactions
            message = message + amount + " aby nie płacić opłaty za kartę!"
            Toast.makeText(MainActivity.applicationContext, message, Toast.LENGTH_LONG).show()
        }

        return view
    }

}