package com.example.sqlliteexampleinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), HomeFragment.OnOptionsCheckListener {
    lateinit var fragmentManager:FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(findViewById<FrameLayout>(R.id.frameLayoutContainer) != null){

            if(savedInstanceState != null){
                return
            }

            fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.frameLayoutContainer, HomeFragment(), null).commit()
        }


    }

    override fun OnCheckMethod(method: Int) {

        when(method){
            0 -> fragmentManager.beginTransaction().replace(R.id.frameLayoutContainer, AddContactFragment(), null).addToBackStack(null).commit()
            1 -> fragmentManager.beginTransaction().replace(R.id.frameLayoutContainer, DisplayContactFragment(), null).addToBackStack(null).commit()
            2 -> fragmentManager.beginTransaction().replace(R.id.frameLayoutContainer, UpdateContactFragment(), null).addToBackStack(null).commit()
            3 -> fragmentManager.beginTransaction().replace(R.id.frameLayoutContainer, DeleteContactFragment(), null).addToBackStack(null).commit()
        }
    }
}