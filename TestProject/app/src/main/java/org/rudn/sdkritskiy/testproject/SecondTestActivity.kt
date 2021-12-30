package org.rudn.sdkritskiy.testproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondTestActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_test)

        var btn : Button
        var txt : TextView
        var messagetxt : TextView

        btn = findViewById(R.id.welcomebtnkotlin)
        txt = findViewById(R.id.welcometxtkotlin)
        messagetxt = findViewById(R.id.textFromMain)

        messagetxt.setText(Sender.GetMessage())

        btn.setOnClickListener(){
            txt.setText("Why did you do that?")
        }
    }
}