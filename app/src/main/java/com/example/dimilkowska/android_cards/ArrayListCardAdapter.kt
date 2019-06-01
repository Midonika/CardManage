package com.example.dimilkowska.android_cards


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.ImageButton

import com.example.dimilkowska.android_cards.entity.Card

class ArrayListCardAdapter(var list: ArrayList<Card>, private val context: Context, val MainActivity: MyMainActivity) : BaseAdapter()  {

    override fun getViewTypeCount(): Int {
        return 1
    }


    override fun getItemViewType(position: Int): Int {
        return 0
    }
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(pos: Int): Any {
        return list[pos]
    }

    override fun getItemId(pos: Int): Long {
        return 0
        //just return 0 if your list items do not have an Id variable.
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.card_list_layout, null, true)
        }

        //Handle TextView and display string from your list
        val listItemText = view!!.findViewById(R.id.list_item_string) as TextView
        listItemText.text = list[position].name

        val listItemDesc = view.findViewById(R.id.list_item_desc) as TextView
        if (list[position].account.length==16)
            listItemDesc.text = "....."+list[position].account.substring(12, 16)
        else
            listItemDesc.text =""


        val deleteBtn = view.findViewById(R.id.delete_btn) as ImageButton
        val editBtn = view.findViewById(R.id.edit_btn) as ImageButton
        val transferHistoryBtn = view.findViewById(R.id.transfer_history_btn) as ImageButton
        val addTransferBtn = view.findViewById(R.id.transfer_btn) as ImageButton

        deleteBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val db = MainActivity.db

                db?.transactionDao()!!.deleteTransactionByCardId(list[position].id!!)
                db?.cardDao()!!.deleteCard(list[position])

                list.removeAt(position) //or some other task
                notifyDataSetChanged()
            }
        })

        editBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {

                MainActivity.replaceFragment(  FragmentEditCard( list[position], position, MainActivity ) )
                notifyDataSetChanged()
            }
        })

        transferHistoryBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                MainActivity.replaceFragment( FragmentTransactionListView(MainActivity, list[position].id!!, list[position]) )
            }
        })

        addTransferBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                MainActivity.replaceFragment( FragmentAddTransaction(null, list[position].id!!, list[position], MainActivity) )
            }
        })

        return view
    }
}