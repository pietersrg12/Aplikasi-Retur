package id.co.aplikasiretur

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_yantek.*

class YantekActivity : AppCompatActivity() {

    var gps: GPSTracker? = null
    val REQUEST_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yantek)

        val daftarIzin = mutableListOf<String>()

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            daftarIzin.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            daftarIzin.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }
        if (daftarIzin.size > 0) {
            val iz = arrayOfNulls<String>(daftarIzin.size)
            for (i in 0 until daftarIzin.size) {
                iz[i] = daftarIzin.get(i)
            }
            ActivityCompat.requestPermissions(this, iz, REQUEST_PERMISSION_CODE)
        } else {
            gps = GPSTracker(this)
        }


        val spinner : Spinner = findViewById(R.id.sp_tindakan)
        ArrayAdapter.createFromResource(
            this,
                    R.array.ar_tindakan,
                    android.R.layout.simple_spinner_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinner.adapter = arrayAdapter
        }

        getkordinat.setOnClickListener {
            kordinat.text = "${gps?.getLatitude()},${gps?.getLongitude()}"

        }

    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        gps = GPSTracker(this)
    }

}
