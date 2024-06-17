package com.vanshika.alertdialogueactivity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vanshika.alertdialogueactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btCalculate?.setOnClickListener {
            if (binding?.etEnterNumber?.text.toString().trim().isNullOrEmpty()) {
                binding?.etEnterNumber?.error = resources.getString(R.string.enter_any_number)
            } else {
                binding?.btCalculate?.setOnClickListener {
                    var number = binding?.etEnterNumber?.text?.toString()?.toDoubleOrNull() ?: 0.0
                    var alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Perform calculation on ${binding?.etEnterNumber?.text}")
                    alertDialog.setMessage(
                        "Add ${binding?.etEnterNumber?.text} in number\n" +
                                "Subtract ${binding?.etEnterNumber?.text} in number\n" +
                                "Press reset to set to 0"
                    )
                    alertDialog.setCancelable(false)
                    alertDialog.setPositiveButton("Add ${binding?.etEnterNumber?.text}") { _, _ ->
                        binding?.etEnterNumber?.setText((number + number).toString())
                        Toast.makeText(
                            this, "${binding?.etEnterNumber?.text} added", Toast.LENGTH_LONG).show()
                    }
                    alertDialog.setNegativeButton("Sub ${binding?.etEnterNumber?.text}") { _, _ ->
                        binding?.etEnterNumber?.setText((number - number).toString())
                        Toast.makeText(
                            this,
                            "${binding?.etEnterNumber?.text} subtracted",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    alertDialog.setNeutralButton("Reset") { _, _ ->
                        binding?.etEnterNumber?.setText((0).toString())
                        Toast.makeText(this, "Reset Done", Toast.LENGTH_LONG).show()
                    }
                    alertDialog.show()
                }
            }
        }
    }

}