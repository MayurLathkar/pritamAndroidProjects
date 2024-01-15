package com.android.tasks

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.tasks.databinding.ActivitySignUpBinding
import java.util.Calendar
import java.util.Locale

class SignUpActivity : AppCompatActivity() {

    private lateinit var myBinding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myBinding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(myBinding.root)

        myBinding.btSignUp.setOnClickListener {
            var userName = myBinding.etEnterYourName.text
            var mailId = myBinding.etMailId.text
            var mobileNumber = myBinding.etMobileNumber.text

        }

        myBinding.tvDob.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        // Create object & Initialize calendar
        val calendar = Calendar.getInstance()

        // Get year, month and day from calendar object
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Create callback to get user selected date from Calendar view
        val selectedDate = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                var month: Int = p2
                month += 1
                myBinding.tvDob.setText("$p3 $month $p1")
            }
        }

        val myDatePickerDialog = DatePickerDialog(
            this,
            selectedDate, year, month, day
        )
        myDatePickerDialog.show()
    }
}