package com.example.mylogpage3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val welcomeTextView = findViewById<TextView>(R.id.welcome)
        val welcome = welcomeTextView.text.toString()
        name = intent.getStringExtra("name").toString()

        welcomeTextView.text = welcome.plus(name)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.actionProfile -> {
                val intentToSecondActivity = Intent(this, ProfileActivity::class.java)
                intentToSecondActivity.putExtra("name",name)
                startActivity(intentToSecondActivity)
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