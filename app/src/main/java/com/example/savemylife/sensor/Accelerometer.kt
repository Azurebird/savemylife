package com.example.savemylife.sensor


import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Handles accelerometer information
 */
class Accelerometer(
    private val sensorManager: SensorManager,
    val sensorChanged: (totalAcceleration: Float) -> Unit
): SensorEventListener {

    /** Accelerometer sensor */
    val sensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)

    init {
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME)
    }

    /**
     * Unregisters this listener from the sensor manager
     */
    fun unregister() {
        sensorManager.unregisterListener(this)
    }

    /**
     * Not required
     */
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Nothing to do here
    }

    /**
     * Handles the event when the sensor information is changed by calling the sensorChanged function passed in the
     * constructor
     */
    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type != Sensor.TYPE_LINEAR_ACCELERATION) {
            Log.i("EVENT:", event?.sensor?.type.toString())
            return
        }
        sensorChanged(calculateAcceleration(event.values[0], event.values[1], event.values[2]))
    }

    /**
     * Calculates de total acceleration based on the 3 dimensional vectors
     */
    private fun calculateAcceleration(vectorX: Float, vectorY: Float, vectorZ: Float): Float {
        return sqrt(vectorX.pow(2) + vectorY.pow(2) + vectorZ.pow(2))
    }
}