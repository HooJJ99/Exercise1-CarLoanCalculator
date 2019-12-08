package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculate()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset()
        }
    }
    private fun calculate() {
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val price: Int = carPrice.text.toString().toInt()
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val dPay: Int = downPayment.text.toString().toInt()
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val loanP: Int = loanPeriod.text.toString().toInt()
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)
        val inRate: Int = interestRate.text.toString().toInt()

        val carLoan:Int =  price - dPay
        val interest: Int = carLoan * inRate * loanP
        val monthly:Int =  (carLoan+interest)/loanP/12

        val viewLoan = findViewById<TextView>(R.id.textViewLoan)
        viewLoan.setText("Loan : " + carLoan.toString())
        val viewInterest = findViewById<TextView>(R.id.textViewInterest)
        viewInterest.setText("Interest : "+interest.toString())
        val viewMonthlyRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)
        viewMonthlyRepay.setText("Monthly Repayment : "+monthly.toString())

    }
    private fun reset(){
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        carPrice.setText("")
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        downPayment.setText("")
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        loanPeriod.setText("")
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)
        interestRate.setText("")
        val viewLoan = findViewById<TextView>(R.id.textViewLoan)
        viewLoan.setText("Loan : ")
        val viewInterest = findViewById<TextView>(R.id.textViewInterest)
        viewInterest.setText("Interest : ")
        val viewMonthlyRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)
        viewMonthlyRepay.setText("Monthly Repayment : ")
    }
}

