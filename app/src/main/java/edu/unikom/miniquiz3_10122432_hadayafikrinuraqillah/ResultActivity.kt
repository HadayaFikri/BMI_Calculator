package edu.unikom.miniquiz3_10122432_hadayafikrinuraqillah

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmi = intent.getDoubleExtra("BMI", 0.0)
        val bfp = intent.getDoubleExtra("BFP", 0.0)
        val kategori = intent.getStringExtra("KATEGORI")

        findViewById<TextView>(R.id.bmiTextView).text = "Nilai BMI Anda: %.2f".format(bmi)
        findViewById<TextView>(R.id.bfpTextView).text = "Nilai BFP Anda: %.2f".format(bfp)
        findViewById<TextView>(R.id.kategoriTextView).text = "Kategori BMI: $kategori"
    }
}