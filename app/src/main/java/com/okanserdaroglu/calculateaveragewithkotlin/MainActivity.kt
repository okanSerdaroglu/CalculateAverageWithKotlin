package com.okanserdaroglu.calculateaveragewithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import java.util.zip.Inflater

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inflater : LayoutInflater = LayoutInflater.from(this)

        var newLessonView = inflater.inflate(R.layout.new_lesson_layout,null)



    }

    fun calculateAverage(view: View) {


    }

    override fun onClick(view: View?) {



    }


}
