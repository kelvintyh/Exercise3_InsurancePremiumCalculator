package com.example.android.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{insurancePremiumCalculate()}
        findViewById<Button>(R.id.buttonReset).setOnClickListener{reset()}
    }

    private fun insurancePremiumCalculate(){

        val age : Spinner = findViewById(R.id.spinnerAge)
        val isMale: RadioButton = findViewById(R.id.radioButtonMale)
        val isSmoker: CheckBox = findViewById(R.id.checkBoxSmoker)
        var payment = 0

        if(age.selectedItem.toString().contentEquals("Less than 17")){
            payment += 60
        }
        else if(age.selectedItem.toString().contentEquals("17 to 25")){
            payment += 70
            if(isMale.isChecked){
                payment += 50
            }
            if(isSmoker.isChecked){
                payment += 100
            }
        }
        else if(age.selectedItem.toString().contentEquals("26 to 30")){
            payment += 90
            if(isMale.isChecked){
                payment += 100
            }
            if(isSmoker.isChecked){
                payment += 150
            }
        }
        else if(age.selectedItem.toString().contentEquals("31 to 40")){
            payment += 120
            if(isMale.isChecked){
                payment += 150
            }
            if(isSmoker.isChecked){
                payment += 200
            }
        }
        else if(age.selectedItem.toString().contentEquals("41 to 55")){
            payment += 150
            if(isMale.isChecked){
                payment += 200
            }
            if(isSmoker.isChecked){
                payment += 250
            }
        }
        else if(age.selectedItem.toString().contentEquals("More than 55")) {
            payment += 150
            if (isMale.isChecked) {
                payment += 200
            }
            if (isSmoker.isChecked) {
                payment += 300
            }
        }
        findViewById<TextView>(R.id.textViewPremium).text = payment.toString()//String.format("Life Insurance Premium : %.2f",payment)
    }

    private fun reset(){
        val age : Spinner = findViewById(R.id.spinnerAge)
        val gender: RadioGroup = findViewById(R.id.radioGroupGender)
        val isSmoker: CheckBox = findViewById(R.id.checkBoxSmoker)
        findViewById<TextView>(R.id.textViewPremium).text = null
        age.setSelection(0)
        gender.clearCheck()
        isSmoker.setChecked(false)

    }
}
