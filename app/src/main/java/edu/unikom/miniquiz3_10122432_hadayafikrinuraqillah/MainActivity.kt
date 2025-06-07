package edu.unikom.miniquiz3_10122432_hadayafikrinuraqillah

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var beratEditText: EditText
    private lateinit var tinggiEditText: EditText
    private lateinit var usiaEditText: EditText
    private lateinit var priaRadio: RadioButton
    private lateinit var wanitaRadio: RadioButton
    private lateinit var hitungButton: Button
    private lateinit var hasilTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        beratEditText = findViewById(R.id.beratEditText)
        tinggiEditText = findViewById(R.id.tinggiEditText)
        usiaEditText = findViewById(R.id.usiaEditText)
        priaRadio = findViewById(R.id.priaRadio)
        wanitaRadio = findViewById(R.id.wanitaRadio)
        hitungButton = findViewById(R.id.hitungButton)
        hasilTextView = findViewById(R.id.hasilTextView)

        hitungButton.setOnClickListener {
            hitungBFP()
        }
    }

    private fun hitungBFP() {
        val berat = beratEditText.text.toString().toDoubleOrNull()
        val tinggi = tinggiEditText.text.toString().toDoubleOrNull()
        val usia = usiaEditText.text.toString().toIntOrNull()

        if (berat == null || tinggi == null || usia == null || (!priaRadio.isChecked && !wanitaRadio.isChecked)) {
            Toast.makeText(this, "Harap isi semua data dengan benar", Toast.LENGTH_SHORT).show()
            return
        }

        val tinggiMeter = tinggi / 100
        val bmi = berat / (tinggiMeter * tinggiMeter)
        val bfp = if (priaRadio.isChecked) {
            (1.20 * bmi) + (0.23 * usia) - 16.2
        } else {
            (1.20 * bmi) + (0.23 * usia) - 5.4
        }

        val kategori = when {
            bfp < 10 -> "Sangat Rendah (<10%)"
            bfp < 20 -> "Rendah (10-20%)"
            bfp <= 25 -> "Normal (21-25%)"
            bfp <= 30 -> "Tinggi (26-30%)"
            else -> "Sangat Tinggi (>30%)"
        }




        val hasil = """
            Nilai BMI Anda: ${"%.2f".format(bmi)}
            Nilai BFP Anda: ${"%.2f".format(bfp)}
            Kategori: $kategori
        """.trimIndent()

        hasilTextView.text = hasil

    }
}