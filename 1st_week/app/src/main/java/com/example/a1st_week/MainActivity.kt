package com.example.a1st_week

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.MenuItem
import android.widget.SimpleCursorAdapter
import com.example.a1st_week.nav.AlbumFragment
import com.example.a1st_week.nav.ContactFragment
import com.example.a1st_week.nav.TodoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_contact.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
            R.id.action_contact -> {
                var contactFragment = ContactFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content,contactFragment).commit()
                return true
            }
            R.id.action_album -> {
                var albumFragment = AlbumFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content,albumFragment).commit()
                return true
            }
            R.id.action_todo -> {
                var todoFragment = TodoFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content,todoFragment).commit()
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav.setOnNavigationItemSelectedListener(this)
    }

    public fun ContactContent() {
        fun readContact() {
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

        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_contact)

            readContact()
        }
    }
}