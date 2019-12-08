package id.co.aplikasiretur

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_yanapp.*

class YanappActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yanapp)
        toolbarhome.setTitle("Daftar Pelanggan")
        setSupportActionBar(toolbarhome)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_yanapp, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
