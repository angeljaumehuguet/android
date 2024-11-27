package com.example.one
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.one.R
import java.time.LocalDate
import java.time.Period

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etDay: EditText = findViewById(R.id.et_day)
        val etMonth: EditText = findViewById(R.id.et_month)
        val etYear: EditText = findViewById(R.id.et_year)
        val btnCalculate: Button = findViewById(R.id.btn_calculate)
        val tvResult: TextView = findViewById(R.id.tv_result)
        val tvDetails: TextView = findViewById(R.id.tv_details)

        btnCalculate.setOnClickListener {
            val day = etDay.text.toString().toIntOrNull()
            val month = etMonth.text.toString().toIntOrNull()
            val year = etYear.text.toString().toIntOrNull()

            if (day != null && month != null && year != null) {
                val birthDate = LocalDate.of(year, month, day)
                val currentDate = LocalDate.now()
                val period = Period.between(birthDate, currentDate)

                val years = period.years
                val months = period.months
                val days = period.days

                tvResult.text = "Han passat:"
                tvDetails.text = "$years anys, $months mesos, $days dies"
            } else {
                tvResult.text = "Error: Entrada invàlida"
                tvDetails.text = ""
            }
        }
    }
}

