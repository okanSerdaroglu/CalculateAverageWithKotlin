package com.okanserdaroglu.calculateaveragewithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.new_lesson_layout.*
import kotlinx.android.synthetic.main.new_lesson_layout.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val constantLessons =
        arrayOf("Math", "Turkish", "Physics", "Literature", "Algorithms", "History")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, constantLessons)

        autoCompleteTextViewLessonName.setAdapter(adapter)

        val inflater: LayoutInflater = LayoutInflater.from(this)

        var newLessonView = inflater.inflate(R.layout.new_lesson_layout, null)

        var lessonName: String = autoCompleteTextViewLessonName.text.toString()
        var credit = spinnerCredit.selectedItem.toString()
        var charNote = spinnerNote.selectedItem.toString()
        newLessonView.autoCompleteTextViewLessonNameNewLesson.setText(lessonName)
        spinnerCreditNewLesson.setSelection(findSelectedIndexInSpinner(spinnerCredit,credit))
        spinnerNoteNewLesson.setSelection(findSelectedIndexInSpinner(spinnerNote,charNote))


    }

    fun calculateAverage(view: View) {


    }

    override fun onClick(view: View?) {

        if (view != null) {

            if (view.id == R.id.buttonAddLesson) {

            } else if (view.id == R.id.buttonRemoveLesson) {

            }
        }

    }

    fun convertCharToNote(charNote: String): Double { // converts char note to double value

        return when (charNote) {

            "AA" -> 4.0
            "BA" -> 3.5
            "BB" -> 3.0
            "CB" -> 2.5
            "CC" -> 2.0
            "DC" -> 1.5
            "DD" -> 1.0
            "FF" -> 0.0

            else -> 0.0
        }

    }

    fun findSelectedIndexInSpinner(spinner: Spinner, value: String): Int {

        var index = 0

        for (i in 0..spinner.count) {

            if (spinner.getItemAtPosition(i).toString() == value) {
                index = i
                return index
            }

        }

        return index

    }


}
