package com.example.home.mykotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //公斤選擇器
        NP_Weight.maxValue = 999
        NP_Weight.minValue = 0
        NP_Weight.value = 50
        var newpick_weight = NP_Weight.value
        NP_Weight.setOnValueChangedListener { picker, oldval, newVal -> newpick_weight = newVal  }
        //公尺選擇器
        NP_height.maxValue = 999
        NP_height.minValue = 0
        NP_height.value = 170
        var newpick_height = NP_height.value
        NP_height.setOnValueChangedListener { picker, oldval, newVal -> newpick_height = newVal  }

        //BMI計算區塊

        test_btn.setOnClickListener{
            var my_weight = newpick_weight
            var my_height = newpick_height.toFloat()/100
            var BMI = my_weight/(my_height*my_height)
            result.setText(BMI.toString())
            if (BMI<18.5)
            {
                thin_marker.setTextColor(Color.RED)
                normal_marker.setTextColor(Color.GRAY)
                heavy_marker.setTextColor(Color.GRAY)
            }
            if (BMI>=18.5 && BMI<24)
            {
                thin_marker.setTextColor(Color.GRAY)
                normal_marker.setTextColor(Color.RED)
                heavy_marker.setTextColor(Color.GRAY)
            }
            else
            {
                thin_marker.setTextColor(Color.GRAY)
                normal_marker.setTextColor(Color.GRAY)
                heavy_marker.setTextColor(Color.RED)
            }

        }

    }
}


