package com.example.a1st_week.adapter

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.a1st_week.R
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactAdapter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_contact)

        read()
    }

    fun read() {
        var cursor : Cursor? = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
        startManagingCursor(cursor)

        var from = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID)

        var to = intArrayOf(android.R.id.text1,android.R.id.text2)

        var simple : SimpleCursorAdapter = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to)
        listView.adapter = simple
    }
}