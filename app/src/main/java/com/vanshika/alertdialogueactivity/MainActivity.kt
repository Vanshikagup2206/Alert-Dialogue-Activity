package com.vanshika.alertdialogueactivity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vanshika.alertdialogueactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding?=null
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btCalculate?.setOnClickListener{
            if(binding?.etEnterNumber?.text.toString().trim().isNullOrEmpty()){
                binding?.etEnterNumber?.error=resources.getString(R.string.enter_any_number)
            }
            else{
                binding?.btCalculate?.setOnClickListener {
                    var alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Perform calculation on ${binding?.etEnterNumber}")
                    alertDialog.setMessage("Add ${binding?.etEnterNumber} in number\n" +
                            "Subtract ${binding?.etEnterNumber} in number\n" +
                            "Press reset to set to 0")
                    alertDialog.setCancelable(false)
                    alertDialog.setPositiveButton("Add ${binding?.etEnterNumber}",{_,_->
                        binding?.etEnterNumber += binding?.etEnterNumber
                        binding?.etEnterNumber?.setText(binding?.etEnterNumber.toString())
                        Toast.makeText(this, "${binding?.etEnterNumber} added", Toast.LENGTH_LONG).show()
                    })
                    alertDialog.setNegativeButton("Sub ${binding?.etEnterNumber}",{_,_->
                        binding?.etEnterNumber -= binding?.etEnterNumber
                        binding?.etEnterNumber?.setText(binding?.etEnterNumber.toString())
                        Toast.makeText(this, "${binding?.etEnterNumber} subtracted", Toast.LENGTH_LONG).show()
                    })
                    alertDialog.setNeutralButton("Reset", {_,_->
                        binding?.etEnterNumber?.setText({binding?.etEnterNumber}=0)
                        Toast.makeText(this, "Reset Done", Toast.LENGTH_LONG).show()
                    })
                    alertDialog.show()
                }
            }
        }
        binding?.btCalculate?.setOnClickListener{
            if(binding?.etEnterNumber?.text.toString().trim().isNullOrEmpty()){
                binding?.etEnterNumber?.error=resources.getString(R.string.enter_any_number)
            }
            else{
                binding?.btCalculate?.setOnClickListener {
                    var alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Perform calculation on ${number}")
                    alertDialog.setMessage("Add ${number} in number\n" +
                            "Subtract ${number} in number\n" +
                            "Press reset to set to 0")
                    alertDialog.setCancelable(false)
                    alertDialog.setPositiveButton("Add ${number}",{_,_->
                        number += number
                        binding?.etEnterNumber?.setText(number.toString())
                        Toast.makeText(this, "${number} added", Toast.LENGTH_LONG).show()
                    })
                    alertDialog.setNegativeButton("Sub ${number}",{_,_->
                        number -= number
                        binding?.etEnterNumber?.setText(number.toString())
                        Toast.makeText(this, "${number} subtracted", Toast.LENGTH_LONG).show()
                    })
                    alertDialog.setNeutralButton("Reset", {_,_->
                        binding?.etEnterNumber?.setText(number.toString())
                        Toast.makeText(this, "Reset Done", Toast.LENGTH_LONG).show()
                    })
                    alertDialog.show()
                }
            }
        }

        }
}