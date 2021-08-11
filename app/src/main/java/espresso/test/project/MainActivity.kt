package espresso.test.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var textInputView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInputView = findViewById<View>(R.id.textInput) as TextView
        findViewById<View>(R.id.clickMeTenderBtn).setOnClickListener(this)
    }

    @Override
    override fun onClick(p0: View?) {
        textInputView?.setText("You clicked me!")
    }
}