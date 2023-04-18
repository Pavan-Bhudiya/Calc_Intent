package com.example.calcintentweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var Buttoncalc:Button
    lateinit var ButtonIntent:Button
    lateinit var ButtonWeb:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Buttoncalc=findViewById(R.id.Btn_calc)
        ButtonIntent=findViewById(R.id.Btn_Intent)
        ButtonWeb=findViewById(R.id.Btn_Web)
        Buttoncalc.setOnClickListener {
            val intent=Intent(this,Calculator_Activity::class.java)
            startActivity(intent) }
        ButtonIntent.setOnClickListener {
            val intent1=Intent(this,Intent_Activity::class.java)
            startActivity(intent1) }
        ButtonWeb.setOnClickListener {
            val intent2=Intent(this,Web_Activity::class.java)
            startActivity(intent2) }

    }
}