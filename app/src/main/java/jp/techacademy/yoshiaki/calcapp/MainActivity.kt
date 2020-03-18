package jp.techacademy.yoshiaki.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calc.*

open class MainActivity : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        //ボタンを宣言
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var calctype: Int = 0
        //null値判別（文字長さを取得し、0ならnullとする）
        var text1: Int =editText1.text.toString().length
        var text2:Int=editText2.text.toString().length

        if (text1!=0&&text2!=0) {
            val data1 = editText1.text.toString().toFloat()
            val data2 = editText2.text.toString().toFloat()
            var calcr: Float = 0.0f

            if (v != null) {
                when (v.id) {
                    R.id.button1 -> {
                        calctype = 1//足し算
                        calcr = Calc(calctype, data1, data2).res.toFloat()
                    }
                    R.id.button2 -> {
                        calctype = 2//引き算
                        calcr = Calc(calctype, data1, data2).res.toFloat()
                    }
                    R.id.button3 -> {
                        calctype = 3//掛け算
                        calcr = Calc(calctype, data1, data2).res.toFloat()
                    }
                    R.id.button4 -> {
                        calctype = 4//割り算
                        when(data2){
                            0.0f-> {
                                textViewE.text = "0で割りました。計算値2を0以外にしてください"
                                calcr = Calc(calctype, data1, data2).res.toFloat()
                            }
                            else ->{
                                calcr = Calc(calctype, data1, data2).res.toFloat()
                            }
                        }
                    }
                }
            }
            val intent = Intent(this, CalcActivity::class.java)
            intent.putExtra("DATA1", calcr)

            //0で割った場合にStartActivityを起動させない
            if (data2==0.0f&&calctype==4) {
            }
            else{
                startActivity(intent)
            }
        }
        else{
            textViewE.text = "計算値1,計算値2を入力してください"
        }
    }
    //実計算部分
    public class Calc(calctype: Int,data1:Float,data2:Float) {
        init {
            var calctype: Int
            var res: Float
            var data1: Float
            var data2: Float
        }

        public var res = calc(calctype,data1,data2)
        public fun calc(calctype: Int,data1:Float,data2:Float): Float {
            var calcr: Float
            calcr = 0.1f
            when (calctype) {
                1 -> {//足し算
                    calcr = data1 + data2
                }
                2 -> {//引き算
                    calcr = data1 - data2
                }
                3 -> {//掛け算
                    calcr = data1 * data2
                }
                4 -> {//割り算
                    calcr = data1 / data2
                }
            }
            return calcr
        }
    }
}












