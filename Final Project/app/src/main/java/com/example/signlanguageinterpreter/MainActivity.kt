package com.example.signlanguageinterpreter

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.signlanguageinterpreter.composite.CannyEdgeFrameProcessor
import com.example.signlanguageinterpreter.composite.ColourThresholdFrameProcessor
import com.example.signlanguageinterpreter.facade.SignLanguageInterpreterFacade
import com.example.signlanguageinterpreter.observer.LogObserver
import com.example.signlanguageinterpreter.observer.UIObserver
import com.example.signlanguageinterpreter.ui.theme.SignLanguageInterpreterTheme
import com.example.signlanguageinterpreter.utils.Frame

class MainActivity : ComponentActivity() {
    private lateinit var interpreter: SignLanguageInterpreterFacade

    @Composable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val resultText = remember { mutableStateOf("Waiting for gesture...") }

        // Initialize the facade
        interpreter = SignLanguageInterpreterFacade(this)
        interpreter.addObserver(UIObserver(TextView(this).apply {
            resultText.value = text.toString()
        }))
        interpreter.addObserver(LogObserver())

        // Add processing components
        interpreter.addProcessingComponent(ColourThresholdFrameProcessor())
        interpreter.addProcessingComponent(CannyEdgeFrameProcessor())

        // Example usage
        val sampleFrame = Frame() // Replace with actual frame initialization
        interpreter.interpretGesture(sampleFrame)

        setContent {
            SignLanguageInterpreterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = resultText.value,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignLanguageInterpreterTheme {
        Greeting("Hello Android!")
    }
}
