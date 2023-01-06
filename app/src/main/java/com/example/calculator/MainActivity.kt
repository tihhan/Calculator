package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but0.setOnClickListener{ setTextFields("0") }
        but1.setOnClickListener{ setTextFields("1") }
        but2.setOnClickListener{ setTextFields("2") }
        but3.setOnClickListener{ setTextFields("3") }
        but4.setOnClickListener{ setTextFields("4") }
        but5.setOnClickListener{ setTextFields("5") }
        but6.setOnClickListener{ setTextFields("6") }
        but7.setOnClickListener{ setTextFields("7") }
        but8.setOnClickListener{ setTextFields("8") }
        but9.setOnClickListener{ setTextFields("9") }
        dot.setOnClickListener{ setTextFields(".") }

        minus.setOnClickListener{ setTextFields("-") }
        plus.setOnClickListener{ setTextFields("+") }
        div.setOnClickListener{ setTextFields("/") }
        multiply.setOnClickListener{ setTextFields("*") }
        par1.setOnClickListener{ setTextFields("(") }
        par2.setOnClickListener{ setTextFields(")") }


        AC.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
        }

        back.setOnClickListener{
            val str = math_operation.text.toString()

            if(str.isNotEmpty()){
                math_operation.text = str.substring(0, str.length - 1)
            }

            result_text.text = ""
        }

        equal.setOnClickListener {
            try{
                val ex = ExpressionBuilder(math_operation.text.toString()).build()

                val result = ex.evaluate()

                val longRes = result.toLong()

                if(result == longRes.toDouble()){
                    result_text.text = longRes.toString()
                } else {
                    result_text.text = result.toString()
                }

            } catch (e:Exception) {
                Log.d("Error", "message: ${e.message}")
            }
        }
    }

    fun setTextFields(str:String){

        if(result_text.text != ""){
            math_operation.text =  result_text.text
            result_text.text = ""
        }
        math_operation.append(str)

    }
}