package id.co.aplikasiretur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yantek.setOnClickListener {
            val intentHome = Intent(this, YantekActivity::class.java)
            startActivity(intentHome)
        }
        yanapp.setOnClickListener {
            val intentHome = Intent(this, YanappActivity::class.java)
            startActivity(intentHome)
        }
    }
}
