package com.example.dimilkowska.android_cards

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.dimilkowska.android_cards.entity.Card
import com.example.dimilkowska.android_cards.entity.Transaction
import java.util.*


@SuppressLint("ValidFragment")
class FragmentAddTransaction(var transaction: Transaction?, var cardIdx: Int, var card: Card, val MainActivity: MyMainActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_transaction, container, false)

        var transactionTitle = view.findViewById(R.id.transaction_title) as EditText

        var transactionAmount = view.findViewById(R.id.transaction_amount) as EditText
        var transactionToAccount = view.findViewById(R.id.transaction_to_account) as EditText

        if (transaction != null) {
            transactionTitle.setText(transaction!!.title)
            transactionToAccount.setText(AddAccountSeparators(transaction!!.account))
        }

        var transactionSubmitBtn = view.findViewById(R.id.transaction_submit_btn) as ImageButton
        var transactionCancelBtn = view.findViewById(R.id.transaction_cancel_btn) as ImageButton

        transactionCancelBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                MainActivity.replaceFragment(1)
            }
        })

        transactionSubmitBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {

                // tytuł
                var transactionTitleStr = transactionTitle.getText().toString()
                if (transactionTitleStr.length <= 0) {
                    transactionTitle.setError(getString(R.string.name_is_required_error)); return
                }

                // konto odbiorcy
                var transactionToAccountStr: String = transactionToAccount.getText().toString()
                var transactionToAccountStrNew = RemoveAccountSeparators(transactionToAccountStr)
                var transactionToAccountStrSpaced = AddAccountSeparators(transactionToAccountStrNew)


                if (!transactionToAccountStrSpaced.equals(transactionToAccountStr)) transactionToAccount.setText(transactionToAccountStrSpaced)

                if (transactionToAccountStrNew.length != 16) {
                    transactionToAccount.setError(getString(R.string.number_is_required_error)); return
                } else {
                    var myVal1 = transactionToAccountStrNew.toLongOrNull()
                    if (myVal1 == null || myVal1 < 0) {
                        transactionToAccount.setError(getString(R.string.number_is_required_error)); return
                    }
                }

                // kwota
                var transactionAmountStr = transactionAmount.getText().toString()
                var transactionAmountVal = transactionAmountStr.toFloatOrNull()
                if (transactionAmountStr.length > 0) {
                    if (transactionAmountVal == null || transactionAmountVal <= 0) {
                        transactionAmount.setError(getString(R.string.must_be_number_error)); return
                    }
                }

                val db = MainActivity.db

                var from = getfirstPeriodDay(card.period)
                var to = System.currentTimeMillis()

                var countTransactions = db?.transactionDao()!!.noAllTransactionsByDate(from, to, card.id!!)
                var sumTransactions = (db?.transactionDao()!!.sumAllTransactionsByDate(from, to, card.id!!)) + transactionAmountVal!!

                if ((card.limit_count > 0 && card.limit_count <= countTransactions) || (card.limit_total > 0 && card.limit_total <= sumTransactions)) {
                    transactionAmount.setError(getString(R.string.to_much_amount_or_count)); return
                }

                val newtransaction = Transaction(
                        null,
                        transactionTitleStr,
                        transactionAmountVal!!,
                        transactionToAccountStrNew,
                        cardIdx,
                        System.currentTimeMillis()
                )

                if (transaction == null) {
                    db?.transactionDao()!!.insertTransaction(newtransaction)
                }

                MainActivity.replaceFragment(FragmentTransactionListView(MainActivity, cardIdx, card))
            }
        })

        return view
    }


}
