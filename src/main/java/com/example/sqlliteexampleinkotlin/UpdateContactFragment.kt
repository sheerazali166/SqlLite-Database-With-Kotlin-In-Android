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


class UpdateContactFragment : Fragment() {

    lateinit var editTextUpdateContactId: EditText
    lateinit var editTextUpdateContactName: EditText
    lateinit var editTextUpdateContactEmail: EditText
    lateinit var buttonUpdateContactUpdateContact: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_update_contact, container, false)

        editTextUpdateContactId = view.findViewById(R.id.editTextUpdateContactId)
        editTextUpdateContactName = view.findViewById(R.id.editTextUpdateContactName)
        editTextUpdateContactEmail = view.findViewById(R.id.editTextUpdateContactEmail)

        buttonUpdateContactUpdateContact = view.findViewById(R.id.buttonUpdateContactUpdateContact)
        buttonUpdateContactUpdateContact.setOnClickListener {

            Update_The_Record()
        }


        return view

    }

    private fun Update_The_Record() {

        var id: Int = editTextUpdateContactId.text.toString().toInt()
        var name: String = editTextUpdateContactName.text.toString()
        var email: String = editTextUpdateContactEmail.text.toString()

        val dbOpenHelper: DbOpenHelper = DbOpenHelper(activity)
        val sqLiteDatabase: SQLiteDatabase = dbOpenHelper.writableDatabase
        dbOpenHelper.UpdateContact(id, name, email, sqLiteDatabase)
        dbOpenHelper.close()

        editTextUpdateContactId.text.clear()
        editTextUpdateContactName.text.clear()
        editTextUpdateContactEmail.text.clear()

        Toast.makeText(activity, "Record successfully updated", Toast.LENGTH_LONG).show()

    }


}