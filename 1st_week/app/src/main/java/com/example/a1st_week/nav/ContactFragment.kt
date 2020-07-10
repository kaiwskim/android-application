package com.example.a1st_week.nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a1st_week.R
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.SimpleCursorAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a1st_week.ContactActivity
import com.example.a1st_week.MainActivity
import kotlinx.android.synthetic.main.contact_child.view.*
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_contact,container,false);
        var view = inflater.inflate(R.layout.fragment_contact,container,false);
        (activity as MainActivity?)!!.ContactContent()
        return view
    }
}