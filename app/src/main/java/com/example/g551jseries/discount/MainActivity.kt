package com.example.g551jseries.discount

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var progressBar = 0

        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressBar = progress
                val price  = editText.text.toString().toInt()
                val afterDiscountPrice = price - (price * progress / 100)
                percentageTextView.text = "打折 : $progress %"
                priceTextView.text = "價錢 : $afterDiscountPrice"
            }
        })

     editText.addTextChangedListener(object :TextWatcher{
         override fun afterTextChanged(s: Editable?) {
             val price  = editText.text.toString().toInt()
             val afterDiscountPrice = price - (price * progressBar / 100)
             priceTextView.text ="價錢 : $afterDiscountPrice"
         }

         override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
         }

         override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
             // 在 EditText 發生變化的同時，改變顯示的 TextView

              priceTextView.text = s.toString()

             if(editText.text.toString() != "")
                 priceTextView.setText("價錢:${editText.text.toString().toInt() * progressBar/100 }")
             else priceTextView.setText("價錢:${0}")

         }

     })
    }

}
