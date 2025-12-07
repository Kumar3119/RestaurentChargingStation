package com.restaurant.chargingstation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.restaurant.chargingstation.controller.ApplicationController

/**
 * LauncherActivity is the explicit entry point of the application.
 *
 * Responsibilities:
 * - Launched when the user taps the app icon
 * - Acts as a trigger for starting the core business logic
 * - Does NOT show any UI (as per assignment requirement)
 * - Immediately finishes after triggering the flow
 *
 * Why this exists:
 * - Android system requires a launcher Activity to start any app
 * - The assignment explicitly states that no UI is required
 */
class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start the core application flow
        ApplicationController.start()

        // Immediately close since no UI is needed
        finish()
    }
}