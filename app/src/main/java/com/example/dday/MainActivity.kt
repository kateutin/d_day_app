package com.example.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.time.Month
import java.time.Year
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startBtn)//start 버튼 정의
        val endButton = findViewById<Button>(R.id.endBtn)//end 버튼 정의

        var startDate = ""
        var endDate = ""

        val calendar_start = Calendar.getInstance()
        val calendar_end = Calendar.getInstance()

        startButton.setOnClickListener {

            val today = GregorianCalendar()//캘린더에서 값을 가지고 와라
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

                    startDate = year.toString() + (month + 1).toString() + dayOfMonth.toString()//month는 항상 +1 해줘야 함

                    calendar_start.set(year, month + 1, dayOfMonth)//캘린더에서 년, 월, 일 가져오기


                    Log.d("day : ", startDate)

                }//start 버튼 누를 시 이벤트

            }, year, month, day)
            dlg.show()

        }

        endButton.setOnClickListener {

            val today = GregorianCalendar()ㄴㅇ
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

                    endDate = year.toString() + (month + 1).toString() + dayOfMonth.toString()
                    Log.d("day : ", endDate)

                    calendar_end.set(year, month + 1, dayOfMonth)

                    val finalDate = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)
                    //현재 end시간과 start에 있는 값을 가지고 와서 finalDate로 정의함

                    val textArea = findViewById<TextView>(R.id.finalDate)

                    textArea.setText(finalDate.toString())//finalDate를 텍스트로 보여줌

                }//end 버튼 누를 시 이벤트트
            }, year, month, day)
            dlg.show()
        }

    }

}
