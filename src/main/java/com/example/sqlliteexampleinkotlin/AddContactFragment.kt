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



class AddContactFragment : Fragment() {

    lateinit var editTextAddContactId: EditText
    lateinit var editTextAddContactName: EditText
    lateinit var editTextAddContactEmail: EditText
    lateinit var buttonAddContactSaveContact: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_add_contact, container, false)

        editTextAddContactId = view.findViewById(R.id.editTextAddContactId)
        editTextAddContactName = view.findViewById(R.id.editTextAddContactName)
        editTextAddContactEmail = view.findViewById(R.id.editTextAddContactEmail)

        buttonAddContactSaveContact = view.findViewById(R.id.buttonAddContactSaveContact)
        buttonAddContactSaveContact.setOnClickListener {

            Save_Records_In_The_Database()
        }

        return view
    }

    private fun Save_Records_In_The_Database() {

        val dbOpenHelper:DbOpenHelper = DbOpenHelper(activity)

        val sqLiteDatabase:SQLiteDatabase = dbOpenHelper.writableDatabase

        var id: Int = editTextAddContactId.text.toString().toInt()
        var name: String = editTextAddContactName.text.toString()
        var email: String = editTextAddContactEmail.text.toString()

        dbOpenHelper.AddContact(id, name, email, sqLiteDatabase)
        dbOpenHelper.close()

        editTextAddContactId.text.clear()
        editTextAddContactName.text.clear()
        editTextAddContactEmail.text.clear()

        Toast.makeText(activity, "Record successfully added into the database", Toast.LENGTH_LONG).show()

    }


}