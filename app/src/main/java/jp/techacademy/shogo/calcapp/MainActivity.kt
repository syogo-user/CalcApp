package jp.techacademy.shogo.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        multiply.setOnClickListener(this)
        division.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (input1.text.length != 0  && input2.text.length != 0) {
            //入力の値が両方ともnullでなければ
            var in1 = input1.text.toString().toDouble()
            var in2 = input2.text.toString().toDouble()

            var result = 0.0
            when(v?.id){
                R.id.plus -> result = in1 + in2
                R.id.minus ->result = in1 - in2
                R.id.multiply -> result = in1 * in2
                R.id.division -> result = in1 / in2
            }



            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }else {
            if (v != null) {
                Snackbar.make(v, "数値が入力されていません。", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }
}
