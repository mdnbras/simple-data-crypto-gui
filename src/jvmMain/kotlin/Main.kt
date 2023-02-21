import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import crypto.Crypto

@Composable
@Preview
fun App() {
    var valueEncrypt by remember { mutableStateOf("") }
    var valueDecrypt by remember { mutableStateOf("") }
    var resultValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier.Companion.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = valueEncrypt,
                onValueChange = { valueEncrypt = it },
                label = { Text("Data") }
            )
            Button(onClick = {
                resultValue = Crypto.encrypt(valueEncrypt)
            }) {
                Text("Encrypt")
            }
            TextField(
                value = valueDecrypt,
                onValueChange = { valueDecrypt = it },
                label = { Text("Data") }
            )
            Button(onClick = {
                resultValue = Crypto.decrypt(valueDecrypt)
            }) {
                Text("Decrypt")
            }
            TextField(
                value = resultValue,
                maxLines = 6,
                onValueChange = { resultValue = it },
                label = { Text("Result") },
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

fun main() = application {
    val windowState = rememberWindowState(position = WindowPosition(Alignment.Center))

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "Simple Data Crypto"
    ) {
        App()
    }
}
