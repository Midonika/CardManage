package com.example.dimilkowska.android_cards

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.ajts.androidmads.sqliteimpex.SQLiteImporterExporter
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat


@SuppressLint("ValidFragment")
class FragmentListCardView(val MainActivity: MyMainActivity) : Fragment() {

    internal var listView: ListView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list_card_view, container, false);

        listView = view.findViewById(R.id.list_view_cards)

        val adapter = ArrayListCardAdapter(MainActivity.items, this.activity!!.baseContext, MainActivity)
        listView!!.adapter = adapter


        val addCardBtn = view.findViewById<Button>(R.id.add_card)
        val exportDatabase = view.findViewById<Button>(R.id.export_database)

        addCardBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                MainActivity.replaceFragment(2)
            }
        })

        exportDatabase.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var sqLiteImporterExporter = SQLiteImporterExporter(MainActivity.applicationContext, "cardManagev2")

                val MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1

                if (ContextCompat.checkSelfPermission(MainActivity.applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity,
                            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                            MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
                }

                sqLiteImporterExporter.setOnExportListener(object : SQLiteImporterExporter.ExportListener {
                    override fun onSuccess(message: String) {
                        Toast.makeText(MainActivity.applicationContext, message, Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(exception: Exception) {
                        Toast.makeText(MainActivity.applicationContext, exception.message, Toast.LENGTH_SHORT).show()
                    }
                })

                sqLiteImporterExporter.exportDataBase("//sdcard//Download//")
            }
        })

        return view
    }

}
