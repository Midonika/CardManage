package com.example.dimilkowska.android_cards


import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.SQLException
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.example.dimilkowska.android_cards.entity.Card


@SuppressLint("ValidFragment")
class FragmentEditCard(var card: Card?, var cardIdx: Int, val MainActivity: MyMainActivity) : Fragment() {


    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_edit_card, container, false)

        var cardNameEdit = view.findViewById(R.id.card_name_edit) as EditText
        var cardNumberEdit = view.findViewById(R.id.card_number_edit) as EditText

        var billingPeriodWeekBtn = view.findViewById(R.id.billing_period_week_btn) as RadioButton
        var billingPeriodMonthBtn = view.findViewById(R.id.billing_period_month_btn) as RadioButton

        var transactionLimitTotalEdit = view.findViewById(R.id.transaction_limit_total_edit) as EditText
        var transactionLimitCountEdit = view.findViewById(R.id.transaction_limit_count_edit) as EditText

        var freeAbove100Btn = view.findViewById(R.id.free_above_100_id) as CheckBox

        if (card != null) {
            cardNameEdit.setText(card!!.name)
            cardNumberEdit.setText(AddAccountSeparators(card!!.account))

            when (card!!.period) {
                7 -> billingPeriodWeekBtn.setChecked(true)
                else -> billingPeriodMonthBtn.setChecked(true)

            }

            if (card!!.limit_total > 0.0) transactionLimitTotalEdit!!.setText(card!!.limit_total.toString())
            if (card!!.limit_count > 0.0) transactionLimitCountEdit!!.setText(card!!.limit_count.toString())

            freeAbove100Btn.setChecked(card!!.free_100)
        }

        var cardSubmitBtn = view.findViewById(R.id.card_submit_btn) as ImageButton
        var cardCancelBtn = view.findViewById(R.id.card_cancel_btn) as ImageButton

        cardCancelBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                MainActivity.replaceFragment(1)
            }
        })

        cardSubmitBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                // nazwa
                var cardNameEditStr = cardNameEdit.getText().toString()
                if (cardNameEditStr.length <= 0) {
                    cardNameEdit.setError(getString(R.string.name_is_required_error)); return
                }

                // numer
                var cardNumberEditStr: String = cardNumberEdit.getText().toString()
                var cardNumberEditStrNew = RemoveAccountSeparators(cardNumberEditStr)
                var cardNumberEditStrSpaced = AddAccountSeparators(cardNumberEditStrNew)

                /*for(i in cardNumberEditStrNew.indices){
                    if (((i%4)==0) && (i>0)) cardNumberEditStrSpaced += " ";
                    cardNumberEditStrSpaced += cardNumberEditStrNew[i]
                }*/

                if (!cardNumberEditStrSpaced.equals(cardNumberEditStr)) cardNumberEdit.setText(cardNumberEditStrSpaced)

                if (cardNumberEditStrNew.length != 16) {
                    cardNumberEdit.setError(getString(R.string.number_is_required_error)); return
                } else {
                    var myVal1 = cardNumberEditStrNew.toLongOrNull()
                    if (myVal1 == null || myVal1 < 0) {
                        cardNumberEdit.setError(getString(R.string.number_is_required_error)); return
                    }
                }

                // okres rozliczeniowy
                if (!billingPeriodWeekBtn.isChecked && !billingPeriodMonthBtn.isChecked) {
                    billingPeriodWeekBtn.setError(getString(R.string.period_is_required_error));
                    billingPeriodMonthBtn.setError(getString(R.string.period_is_required_error));
                    return
                } else {
                    billingPeriodWeekBtn.setError(null);
                    billingPeriodMonthBtn.setError(null);
                }

                // limit kwoty
                var transactionLimitTotalEditStr = transactionLimitTotalEdit.getText().toString()
                var transactionLimitTotalEditVal = transactionLimitTotalEditStr.toDoubleOrNull()
                if (transactionLimitTotalEditStr.length > 0) {
                    if (transactionLimitTotalEditVal == null || transactionLimitTotalEditVal <= 0) {
                        transactionLimitTotalEdit.setError(getString(R.string.must_be_number_or_skipped_error)); return
                    }
                }

                // limit liczby op
                var transactionLimitCountEditStr = transactionLimitCountEdit.getText().toString()
                var transactionLimitCountEditVal = transactionLimitCountEditStr.toDoubleOrNull()
                if (transactionLimitCountEditStr.length > 0) {
                    if (transactionLimitCountEditVal == null || transactionLimitCountEditVal <= 0) {
                        transactionLimitCountEdit.setError(getString(R.string.must_be_number_or_skipped_error)); return
                    }
                }

                val newcard = Card(
                        null,
                        cardNameEditStr,
                        cardNumberEditStrNew,
                        when (billingPeriodWeekBtn.isChecked) {
                            true -> 7
                            else -> 30
                        },
                        when (transactionLimitTotalEditVal == null) {
                            true -> -1.0
                            false -> transactionLimitTotalEditVal
                        },
                        when (transactionLimitCountEditVal == null) {
                            true -> -1.0
                            false -> transactionLimitCountEditVal
                        },
                        freeAbove100Btn.isChecked
                )

                val db = MainActivity.db

                if (card == null) {

                    val id = db?.cardDao()!!.insertCard(newcard)
                    newcard.id = id.toInt()
                    MainActivity.items.add(newcard)
                } else {
//                    newcard.id = card!!.id

                    db?.cardDao()!!.updateCard(newcard)

                    MainActivity.items.set(cardIdx, newcard)
                }

                MainActivity.replaceFragment(1)
            }
        })


        return view
    }

}
