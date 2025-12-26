package com.example.testcmp.Feature.second.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.contacts.rememberContactPicker
import com.example.testcmp.Feature.second.SecondEvent
import com.example.testcmp.Feature.second.SecondState
import com.example.testcmp.Feature.second.SecondViewModel

@Composable
fun SecondScreen(viewModel: SecondViewModel) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        SecondScreenView(
            state = state,
            onUiEvent = viewModel::pushEvent)
    }
}

@Composable
fun SecondScreenView(state: SecondState,
                    onUiEvent: (SecondEvent) -> Unit) {
    val openContactPicker = rememberContactPicker { contact ->
        onUiEvent(SecondEvent.ContactPicked(contact))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello from cmp")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { openContactPicker() }) {
            Text("Open Contacts")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (!state.contactName.isNullOrBlank() || !state.contactPhone.isNullOrBlank()) {
            Text("Selected: ${state.contactName.orEmpty()}")
            Text("Phone: ${state.contactPhone.orEmpty()}")
        } else {
            Text("No contact selected")
        }
    }
}
