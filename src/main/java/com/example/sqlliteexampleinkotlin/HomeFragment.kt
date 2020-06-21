package com.example.sqlliteexampleinkotlin

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.lang.ClassCastException


class HomeFragment : Fragment(), View.OnClickListener {

    lateinit var buttonHomeFragmentAddContact: Button
    lateinit var buttonHomeFragmentDisplayContact: Button
    lateinit var buttonHomeFragmentUpdateContact: Button
    lateinit var buttonHomeFragmentDeleteContact: Button

    lateinit var onOptionsCheckListener: OnOptionsCheckListener

    public interface OnOptionsCheckListener{

        public fun OnCheckMethod(method: Int)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)

        buttonHomeFragmentAddContact = view.findViewById(R.id.buttonHomeFragmentAddContact)
        buttonHomeFragmentAddContact.setOnClickListener(this)


        buttonHomeFragmentDisplayContact = view.findViewById(R.id.buttonHomeFragmentDisplayContact)
        buttonHomeFragmentDisplayContact.setOnClickListener(this)

        buttonHomeFragmentUpdateContact = view.findViewById(R.id.buttonHomeFragmentUpdateContact)
        buttonHomeFragmentUpdateContact.setOnClickListener(this)


        buttonHomeFragmentDeleteContact = view.findViewById(R.id.buttonHomeFragmentDeleteContact)
        buttonHomeFragmentDeleteContact.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {

        when(v?.id){

            R.id.buttonHomeFragmentAddContact -> onOptionsCheckListener.OnCheckMethod(0)
            R.id.buttonHomeFragmentDisplayContact -> onOptionsCheckListener.OnCheckMethod(1)
            R.id.buttonHomeFragmentUpdateContact -> onOptionsCheckListener.OnCheckMethod(2)
            R.id.buttonHomeFragmentDeleteContact -> onOptionsCheckListener.OnCheckMethod(3)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val activity:Activity = context as Activity

        try{

            onOptionsCheckListener = activity as OnOptionsCheckListener
        } catch (e:ClassCastException){

            throw ClassCastException("${activity.toString()} + OnOptionCheck method must be implimented")
        }
    }

}