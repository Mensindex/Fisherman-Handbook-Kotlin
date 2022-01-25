package com.example.fishermanhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_fish -> Toast.makeText(this, "Id fish", Toast.LENGTH_SHORT).show()
            R.id.id_na -> Toast.makeText(this, "Id na", Toast.LENGTH_SHORT).show()
            R.id.id_sna -> Toast.makeText(this, "Id sna", Toast.LENGTH_SHORT).show()
            R.id.id_history -> Toast.makeText(this, "Id history", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}