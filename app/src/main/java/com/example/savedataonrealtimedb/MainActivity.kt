package com.example.savedataonrealtimedb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        update_bt.setOnClickListener {
            val intent=Intent(this,UpdateDataActivity::class.java)
            startActivity(intent)
        }
        create_bt.setOnClickListener {
            val intent=Intent(this,AddDataActivity::class.java)
            startActivity(intent)
        }

    }
}
