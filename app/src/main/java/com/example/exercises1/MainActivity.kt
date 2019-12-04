package com.example.exercises1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.exercises1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener { carLoan(it) }
        binding.buttonReset.setOnClickListener { reset(it) }
    }

    private fun carLoan(view: View) {
        val carPrice = binding.editTextCarPrice.text.toString().toIntOrNull()
        val downPayment = binding.editTextDownPayment.text.toString().toIntOrNull()
        val loanP = binding.editTextLoanPeriod.text.toString().toIntOrNull()
        val interestR = binding.editTextInterestRate.text.toString().toIntOrNull()


        if(carPrice != null && downPayment != null && loanP != null && interestR != null){
            val num1 = carPrice - downPayment
            val num2 = num1 * interestR * loanP
            val num3 = (num1 + num2)/loanP/12
            binding.textViewLoan.text = getString(R.string.loan) + "$num1"
            binding.textViewInterest.text = getString(R.string.interest) + "$num2"
            binding.textViewMonthlyRepayment.text = getString(R.string.monthly_repayment) + "$num3"

            val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)}

        else{
            binding.textViewLoan.text = "Please enter number to calculate"
            binding.textViewInterest.text = "Please enter number to calculate"
            binding.textViewMonthlyRepayment.text = "Please enter number to calculate"

        }

    }

    private fun reset(view: View){
        binding.editTextCarPrice.setText("")
        binding.editTextDownPayment.setText("")
        binding.editTextInterestRate.setText("")
        binding.editTextLoanPeriod.setText("")
        binding.textViewLoan.text = "Loan :"
        binding.textViewInterest.text = "Interest :"
        binding.textViewMonthlyRepayment.text = "Monthly Repayment :"

    }

}
