package com.example.dicegamekt

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sum=0
        var r: Random
        var points=0
        val b_even = findViewById<Button>(R.id.b_even)
        val b_odd = findViewById<Button>(R.id.b_odd)
        val b_roll = findViewById<Button>(R.id.b_roll)
        val tv_points = findViewById<TextView>(R.id.tv_points)
        val iv_dice1 = findViewById<ImageView>(R.id.iv_dice1)
        val iv_dice2 = findViewById<ImageView>(R.id.iv_dice2)
        val tv_status = findViewById<TextView>(R.id.tv_status)
        b_roll.setOnClickListener(View.OnClickListener {
            r = Random()
            val a = r.nextInt(6) + 1
            r = Random()
            val b = r.nextInt(6) + 1
            setimages(a, b)
            sum = a + b
            tv_status.setText("status:$sum")
            b_roll.setVisibility(View.INVISIBLE)
            b_even.setVisibility(View.VISIBLE)
            b_odd.setVisibility(View.VISIBLE)
        })
        b_even.setOnClickListener(View.OnClickListener {
            if (sum % 2 == 0) points++ else {
                b_roll.setEnabled(false)
                Toast.makeText(this@MainActivity, "GAME OVER", Toast.LENGTH_SHORT).show()
            }
            tv_points.setText("POINTS:$points")
            b_roll.setVisibility(View.VISIBLE)
            b_even.setVisibility(View.INVISIBLE)
            b_odd.setVisibility(View.INVISIBLE)
        })
        b_odd.setOnClickListener(View.OnClickListener {
            if (sum % 2 != 0) points++ else {
                b_roll.setEnabled(false)
                Toast.makeText(this@MainActivity, "GAME OVER", Toast.LENGTH_SHORT).show()
            }
            tv_points.setText("POINTS:$points")
            b_roll.setVisibility(View.VISIBLE)
            b_even.setVisibility(View.INVISIBLE)
            b_odd.setVisibility(View.INVISIBLE)
        })
    }

    private fun setimages(a: Int, b: Int) {
        when (a) {
            1 -> iv_dice1.setImageResource(R.drawable.dice1)
            2 -> iv_dice1.setImageResource(R.drawable.dice2)
            3 -> iv_dice1.setImageResource(R.drawable.dice3)
            4 -> iv_dice1.setImageResource(R.drawable.dice4)
            5 -> iv_dice1.setImageResource(R.drawable.dice5)
            6 -> iv_dice1.setImageResource(R.drawable.dice6)
        }
        when (b) {
            1 -> iv_dice2.setImageResource(R.drawable.dice1)
            2 -> iv_dice2.setImageResource(R.drawable.dice2)
            3 -> iv_dice2.setImageResource(R.drawable.dice3)
            4 -> iv_dice2.setImageResource(R.drawable.dice4)
            5 -> iv_dice2.setImageResource(R.drawable.dice5)
            6 -> iv_dice2.setImageResource(R.drawable.dice6)
        }
    }
}