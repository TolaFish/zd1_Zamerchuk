package com.example.zd1_zamerchuk

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var APP_PREFERENS = "mysettings";
    public var PREF_NAME = "Name";
    public var PREF_PAS = "Pas";
    lateinit var settings: SharedPreferences
    private lateinit var nameBox: EditText
    lateinit var nameView: TextView
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settings = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }
    fun saveName(view: View)
    {
        nameBox=findViewById(R.id.editTextTextEmailAddress)
        var name = nameBox.text.toString()
        var prefEditor = settings.edit()
        prefEditor.putString(PREF_NAME,name)
        prefEditor.apply()

    }
    public fun getName(view: View)
    {
        nameView = findViewById(R.id.editTextTextEmailAddress)
        var name = settings.getString(PREF_NAME,"NOT EXIST")
        nameView.setText(name)
    }


    fun GoToActivity(view: View){
        var log1  = findViewById<EditText>(R.id.editTextTextEmailAddress)
        var pas1 = findViewById<EditText>(R.id.editTextTextPassword)

             if (log1.text.toString().isNotEmpty() || pas1.text.toString().isNotEmpty())
             {
                 val randomIntent = Intent(this, SecondActivity1::class.java)
                 randomIntent.putExtra("pas",pas1.text.toString())
                 randomIntent.putExtra("log",log1.text.toString())

                startActivity(randomIntent)
             }

    }

}