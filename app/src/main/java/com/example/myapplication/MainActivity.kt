package com.example.myapplication

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.model.ModelUser
import java.util.*
import java.util.Arrays.asList
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private var btnSignIn: Button? = null
    private var inputEmail: EditText? = null

    val list = ArrayList<ModelUser>()
    val listUsername = arrayOf(
        "alvin@member.id",
        "pocari@member.id",
        "mouse@member.id",
        "lalala",
        "yeyeye",
        "admin@member.id",
        "user@member.id"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignIn = findViewById(R.id.btnSignIn) as Button
        inputEmail = findViewById(R.id.inputEmail) as EditText

        btnSignIn!!.setOnClickListener(View.OnClickListener {
            val valueEmail = inputEmail!!.getText().toString()
            if (valueEmail.isNotEmpty() && valueEmail != null) {
                for (i in 0 until listUsername.size){
                    list.add(ModelUser(listUsername.get(i)))
                }
                cekFound()
            } else {
                Toast.makeText(applicationContext, "Mohon mengisi username anda tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun cekFound() {
        val valueEmail = inputEmail!!.getText().toString()
        val myStringArray = listUsername
        val stringToLocate = valueEmail
        var found = false
        for (element in myStringArray) {
            if (element == stringToLocate) {
                found = true
                Toast.makeText(this, "Welcome back " +inputEmail!!.text, Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext, MenuAwardsActivity::class.java)
                startActivity(intent)
            }
        }
        if (!found) {
            Toast.makeText(applicationContext, "UserNotFound! Masukkan alvin@member.id", Toast.LENGTH_SHORT).show()
        }
    }


}
