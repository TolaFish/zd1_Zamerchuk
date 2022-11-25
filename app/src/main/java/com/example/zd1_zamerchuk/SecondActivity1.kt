package com.example.zd1_zamerchuk

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView


class SecondActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second1)
        val intent = intent
        var txt1 = findViewById<TextView>(R.id.textView3)
        var txt2 = findViewById<TextView>(R.id.textView4)
        var l = getIntent().getStringExtra("log")
        var p = getIntent().getStringExtra("pas")
        txt1.text = "Login:${l}"
        txt2.text = "Password:${p}"
    }
}
class Spinner : AppCompatActivity () {
    lateinit var spin: Spinner
    lateinit var adapter: ArrayAdapter<String>

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second1)
        val spin = findViewById<Spinner>(R.id.sp)
        ArrayAdapter.createFromResource(
            this,
            R.array.catNames,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )

            spin.adapter = adapter
        }
    }
}