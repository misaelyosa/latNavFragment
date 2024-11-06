package paba.b.latihannavigationfragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        var number = 99;

        val mFragmentManager = supportFragmentManager
        val mfSatu = f1()

        mFragmentManager.findFragmentByTag(f1::class.java.simpleName)
        mFragmentManager
            .beginTransaction()
            .add(R.id.frameContainer, mfSatu, f1::class.java.simpleName)
            .commit()

        val _btnFragment1 = findViewById<Button>(R.id.btnFragment1)
        _btnFragment1.setOnClickListener {

            val mfSatu = f1()
            val mBundle = Bundle()
            number -= 1
            mBundle.putString("HASIL" , number.toString())
            mfSatu.arguments = mBundle

            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameContainer, mfSatu, f1::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        val _btnFragment2 = findViewById<Button>(R.id.btnFragment2)
        _btnFragment2.setOnClickListener {

            val mfDua = f2()
            val mBundle = Bundle()
            number -= 2
            mBundle.putString("HASIL" , number.toString())
            mfDua.arguments = mBundle

            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameContainer, mfDua, f2::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        val _btnFragment3 = findViewById<Button>(R.id.btnFragment3)
        _btnFragment3.setOnClickListener {

            val mfTiga = f3()
            val mBundle = Bundle()
            number -= 3
            mBundle.putString("HASIL" , number.toString())
            mfTiga.arguments = mBundle

            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameContainer, mfTiga, f3::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}