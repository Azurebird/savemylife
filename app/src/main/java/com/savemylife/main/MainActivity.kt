package com.savemylife.main

import android.os.Bundle
import com.savemylife.R
import com.savemylife.repository.SettingsRepository
import com.savemylife.sensor.Accelerometer
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var accelerometer: Accelerometer

    @Inject
    lateinit var settingsRepository: SettingsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActions()
    }

    override fun onPause() {
        super.onPause()
        accelerometer.unregister()
    }

    private fun setActions() {
        this.btn_save.setOnClickListener {
            settingsRepository.saveSettings(txt_phone_number.text.toString(), txt_user_code.text.toString())
        }
    }
}
