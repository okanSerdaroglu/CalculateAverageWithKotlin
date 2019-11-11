package com.okanserdaroglu.calculateaveragewithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.new_lesson_layout.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val constantLessons =
        arrayOf("Math", "Turkish", "Physics", "Literature", "Algorithms", "History")

    private var selectedLessonList = arrayListOf<Lesson>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, constantLessons)

        autoCompleteTextViewLessonName.setAdapter(adapter)

        buttonAddLesson.setOnClickListener(this)
        buttonCalculateAverage.setOnClickListener(this)


    }

    fun calculateAverage(view: View) {


    }

    override fun onClick(view: View?) {

        if (view != null) {

            val inflater: LayoutInflater = LayoutInflater.from(this)

            var newLessonView = inflater.inflate(R.layout.new_lesson_layout, null)

            if (view.id == R.id.buttonAddLesson) {

                var lessonName: String = autoCompleteTextViewLessonName.text.toString()
                var credit = spinnerCredit.selectedItem.toString()
                var charNote = spinnerNote.selectedItem.toString()

                var selectedLesson: Lesson = Lesson(lessonName, credit.toInt(), charNote)

                newLessonView.autoCompleteTextViewLessonNameNewLesson.setText(lessonName)
                newLessonView.spinnerCreditNewLesson.setSelection(
                    findSelectedIndexInSpinner(
                        spinnerCredit,
                        credit
                    )
                )
                newLessonView.spinnerNoteNewLesson.setSelection(
                    findSelectedIndexInSpinner(
                        spinnerNote,
                        charNote
                    )
                )

                linearLayoutRootLayout.addView(newLessonView)

                buttonCalculateAverage.visibility = View.VISIBLE

                selectedLessonList.add(selectedLesson)

                newLessonView.buttonRemoveLesson.setOnClickListener {

                    linearLayoutRootLayout.removeView(newLessonView)
                    for (i in 0 until selectedLessonList.size) {
                        if (newLessonView.autoCompleteTextViewLessonNameNewLesson.text.equals(selectedLessonList[i].lessonName)) {
                            selectedLessonList.removeAt(i)
                        }
                    }

                    if (linearLayoutRootLayout.childCount == 0) {
                        buttonCalculateAverage.visibility = View.GONE
                    }

                }


            } else if (view.id == R.id.buttonCalculateAverage) {

                calculateAverageNote(selectedLessonList)

            }
        }

    }

    private fun convertCharToNote(charNote: String): Double { // converts char note to double value

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

    private fun calculateAverageNote(lessonList: ArrayList<Lesson>): Double {

        var totalNote = 0.0
        var totalCredit = 0.0
        var averageNote = 0.0

        if (lessonList.size == 0) {
            return averageNote
        }
        for (i in 0 until lessonList.size) {

            totalNote += lessonList[i].credit * convertCharToNote(lessonList[i].charNote)
            totalCredit += lessonList[i].credit

        }

        averageNote = totalNote / totalCredit
        textViewResult.text = averageNote.toString()

        return averageNote

    }

    private fun findSelectedIndexInSpinner(spinner: Spinner, value: String): Int {

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
