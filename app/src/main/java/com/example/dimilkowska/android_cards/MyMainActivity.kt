package com.example.dimilkowska.android_cards

import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.os.Bundle
import android.os.Environment

import com.example.dimilkowska.android_cards.dao.CardDao
import com.example.dimilkowska.android_cards.dataBase.AppDatabase
import com.example.dimilkowska.android_cards.entity.Card
import com.ajts.androidmads.sqliteimpex.SQLiteImporterExporter
import android.widget.Toast






class MyMainActivity : AppCompatActivity(), FragmentMainTop.ButtonPressListener {

    var db: AppDatabase? = null
    private var cardDao: CardDao? = null

    internal var items = ArrayList<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_main_activity)

        replaceFragment(1)

        db = AppDatabase.getAppDataBase(context = this)
        cardDao = db?.cardDao()

        val tmpItems = db?.cardDao()?.getCards()
        items = ArrayList(tmpItems)

    }

    //override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        val id = item.itemId
//        when (id) {
//            R.id.goto_fragment_one -> replaceFragment(1)
//            R.id.goto_fragment_two -> replaceFragment(2)
//            R.id.goto_fragment_three -> replaceFragment(3)
//        }
//        return super.onOptionsItemSelected(item)
//    }

    fun replaceFragment(frag: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragmentMainCenter, frag)
        ft.commit()
    }

    fun replaceFragment(index: Int) {
        //val anotherFragment: Fragment
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        when (index) {
            1 -> {
                ft.replace(R.id.fragmentMainCenter, FragmentListCardView(this))
            }
            2 -> {
                ft.replace(R.id.fragmentMainCenter, FragmentEditCard(null, -1, this))
            }
            3 -> {
                ft.replace(R.id.fragmentMainCenter, MyFragmentThree())
            }
        }
        ft.commit()
    }

    override fun onButtonPressed(button: Int) {
        replaceFragment(button)
    }



}
