package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val userName: String? = intent.getStringExtra("name")
        val userEmail: String? = intent.getStringExtra("email")
        val userPic : String? = intent.getStringExtra("pic")
        val userCell : String? = intent.getStringExtra("cell")

        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        nameTextView.text = "${userName}"
        val emailTextView = findViewById<TextView>(R.id.mailTextView)
        emailTextView.text = "${userEmail}"
        val userImageView = findViewById<ImageView>(R.id.userImageView)
        Picasso.get().load(userPic).into(userImageView)
        val userCellTextView = findViewById<TextView>(R.id.cellTextView)
        userCellTextView.text = userCell
    }
}