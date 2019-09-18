package com.example.savemylife

import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.savemylife.di.component.DaggerAlertComponent
import com.example.savemylife.sensor.Accelerometer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var accelerometer: Accelerometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accelerometer = Accelerometer(getSystemService(Context.SENSOR_SERVICE) as SensorManager, this::showTotalAcceleration)
        DaggerAlertComponent.create().inject(accelerometer)
    }

    override fun onPause() {
        super.onPause()
        accelerometer.unregister()
    }

    private fun showTotalAcceleration(totalAcceleration: Float) {
        val format = "%.4f"
        acc_total.text = format.format(totalAcceleration)
    }
}
