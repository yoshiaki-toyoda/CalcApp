package jp.techacademy.yoshiaki.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calc.*
import java.lang.Exception
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value:Float=intent.getFloatExtra("DATA1",0.2f)
        text2.text=value.toString()











    }
}
