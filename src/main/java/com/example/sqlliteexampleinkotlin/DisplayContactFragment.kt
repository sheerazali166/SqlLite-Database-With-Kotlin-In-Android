package com.example.sqlliteexampleinkotlin

import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayContactFragment : Fragment() {

    lateinit var textViewDisplayContactDisplay:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_display_contact, container, false)

        textViewDisplayContactDisplay = view.findViewById(R.id.textViewDisplayContactDisplay)

        Display_All_The_Records()

        return view

    }

    private fun Display_All_The_Records() {

        var dbOpenHelper:DbOpenHelper = DbOpenHelper(activity)
        val sqLiteDatabase:SQLiteDatabase = dbOpenHelper.readableDatabase
        val cursor: Cursor = dbOpenHelper.DisplayContacts(sqLiteDatabase)

        var info: String = ""

        while (cursor.moveToNext()){

            var id: Int = cursor.getInt(cursor.getColumnIndex(ContactContract.Entry.CONTACT_ID))
            var name: String = cursor.getString(cursor.getColumnIndex(ContactContract.Entry.CONTACT_NAME))
            var email: String = cursor.getString(cursor.getColumnIndex(ContactContract.Entry.CONTACT_Email))

            info = "${info}\n\nId: ${id}\nName: ${name}\nEmail: ${email}"

        }

        cursor.close()
        dbOpenHelper.close()

        textViewDisplayContactDisplay.text = info

        Toast.makeText(activity, "Data successfully readed from the database", Toast.LENGTH_LONG).show()

  


    }

}