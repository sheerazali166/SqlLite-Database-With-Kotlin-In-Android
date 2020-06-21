package com.example.sqlliteexampleinkotlin

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class DeleteContactFragment : Fragment() {

    lateinit var editTextDeleteContactId: EditText
    lateinit var buttonDeleteContactDeleteContact: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_delete_contact, container, false)

        editTextDeleteContactId = view.findViewById(R.id.editTextDeleteContactId)
        buttonDeleteContactDeleteContact = view.findViewById(R.id.buttonDeleteContactDeleteContact)
        buttonDeleteContactDeleteContact.setOnClickListener {

            Delete_The_Record_From_The_Database()

        }

        return view

    }

    private fun Delete_The_Record_From_The_Database() {

        val id: Int = editTextDeleteContactId.text.toString().toInt()

        val dbOpenHelper: DbOpenHelper = DbOpenHelper(activity)
        val sqLiteDatabase: SQLiteDatabase = dbOpenHelper.writableDatabase
        dbOpenHelper.DeleteContact(id, sqLiteDatabase)
        dbOpenHelper.close()

        editTextDeleteContactId.text.clear()

        Toast.makeText(activity, "Record deleted sucessfully from the database", Toast.LENGTH_LONG).show()
    }


}