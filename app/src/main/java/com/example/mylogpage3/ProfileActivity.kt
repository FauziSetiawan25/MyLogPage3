package com.example.mylogpage3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val name = intent.getStringExtra("name")

        val nameTextView = findViewById<TextView>(R.id.name)
        val nameT = nameTextView.text.toString()

        nameTextView.text = nameT.plus(name)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.actionProfile -> {
                true
            }
            R.id.actionClose -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}