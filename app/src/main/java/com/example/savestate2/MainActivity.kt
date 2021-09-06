package com.example.savestate2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.textservice.TextInfo
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById<Button>(R.id.myButton)
        textInfo = findViewById<TextView>(R.id.myText)

        var name = findViewById<TextView>(R.id.myNameEntry)
        var color = findViewById<RadioGroup>(R.id.myRadioGroup)
        var yesNo = findViewById<Switch>(R.id.mySwitch)
        var choice: String
        var red = findViewById<Button>(R.id.radioButton1)
        var green = findViewById<Button>(R.id.radioButton2)
        var blue = findViewById<Button>(R.id.radioButton3)
        var selectColor: String

        button.setOnClickListener {
            if(color.checkedRadioButtonId==2131231049){
                selectColor = red.text.toString()
                Toast.makeText(applicationContext,"Red", Toast.LENGTH_LONG, )
            }else if (color.checkedRadioButtonId==2131231050){
                selectColor = green.text.toString()
                Toast.makeText(applicationContext,"Green", Toast.LENGTH_LONG, )
            }else if (color.checkedRadioButtonId==2131231051){
                selectColor = blue.text.toString()
                Toast.makeText(applicationContext,"Blue", Toast.LENGTH_LONG, )
            }else{
                selectColor = color.checkedRadioButtonId.toString()
                Toast.makeText(applicationContext,"Select a Color", Toast.LENGTH_LONG, )
            }

            if(yesNo.isChecked){
                choice = "do"
            }else{
                choice = "don't"
            }

            textInfo.setText("Hi, ${name.text.toString()}! You $choice like $selectColor")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_text", textInfo.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        textInfo.setText(savedInstanceState.getString("saved_text"))
    }

}