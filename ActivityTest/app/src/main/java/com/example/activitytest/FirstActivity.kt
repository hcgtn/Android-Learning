package com.example.activitytest

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        val button1 = findViewById<View?>(R.id.button_1) as Button
        button1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//                Toast.makeText(FourthActivity.this, "you clicked Button1", Toast.LENGTH_SHORT).show();
                finish()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.add_item) {
            Toast.makeText(this, "you clicked Add", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.remove_item) {
            Toast.makeText(this, "you clicked Remove", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}