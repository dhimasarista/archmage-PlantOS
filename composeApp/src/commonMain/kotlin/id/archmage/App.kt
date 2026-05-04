package id.archmage

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

import id.archmage.Greeting
import plantos.composeapp.generated.resources.Res
import plantos.composeapp.generated.resources.compose_multiplatform

import com.shadcn.ui.components.Accordion
import com.shadcn.ui.components.*
import com.shadcn.ui.components.Button
import com.shadcn.ui.components.Input
import com.shadcn.ui.themes.ShadcnTheme

@Composable
@Preview
fun App() {
    ShadcnTheme {
        BoxWithConstraints(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            val isDesktop = maxWidth > 800.dp
            if (isDesktop) {
                Row(modifier = Modifier.fillMaxSize()) {
                    DesktopSidebar(modifier = Modifier.width(250.dp).fillMaxHeight())
                    VerticalDivider()
                    ComponentShowcase(modifier = Modifier.weight(1f).fillMaxHeight())
                }
            } else {
                Column(modifier = Modifier.fillMaxSize()) {
                    ComponentShowcase(modifier = Modifier.weight(1f).fillMaxWidth())
                    HorizontalDivider()
                    MobileBottomMenu(modifier = Modifier.fillMaxWidth().height(60.dp))
                }
            }
        }
    }
}

@Composable
fun DesktopSidebar(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("PlantOS", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))
        Text("Home", modifier = Modifier.padding(vertical = 8.dp))
        Text("Components", modifier = Modifier.padding(vertical = 8.dp), color = MaterialTheme.colorScheme.primary)
        Text("Settings", modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun MobileBottomMenu(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.background(MaterialTheme.colorScheme.surface),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Home", modifier = Modifier.padding(8.dp))
        Text("Components", modifier = Modifier.padding(8.dp), color = MaterialTheme.colorScheme.primary)
        Text("Settings", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun ComponentShowcase(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 24.dp),
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        item {
            Text("Shadcn-Compose Showcase", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
            Text("Menampilkan UI lengkap berdasarkan urutan yang diminta.")
        }
        
        item { ComponentSection("1. Accordion") { AccordionSample() } }
        item { ComponentSection("2. Alert") { Placeholder("Alert") } }
        item { ComponentSection("3. Alert Dialog") { Placeholder("Alert Dialog") } }
        item { ComponentSection("4. Avatar") { Placeholder("Avatar") } }
        item { ComponentSection("5. Badge") { Placeholder("Badge") } }
        item { ComponentSection("6. Button") { ButtonSample() } }
        item { ComponentSection("7. Calendar") { Placeholder("Calendar") } }
        item { ComponentSection("8. Card") { Placeholder("Card") } }
        item { ComponentSection("9. Carousel") { Placeholder("Carousel") } }
        item { ComponentSection("10. Checkbox") { Placeholder("Checkbox") } }
        item { ComponentSection("11. Combobox") { Placeholder("Combobox") } }
        item { ComponentSection("12. Date Picker") { Placeholder("Date Picker") } }
        item { ComponentSection("13. Dialog") { Placeholder("Dialog") } }
        item { ComponentSection("14. Drawer (Bottom Sheet)") { Placeholder("Drawer") } }
        item { ComponentSection("15. Dropdown Menu") { Placeholder("Dropdown Menu") } }
        item { ComponentSection("16. Input") { InputSample() } }
        item { ComponentSection("17. Popover") { Placeholder("Popover") } }
        item { ComponentSection("18. Progress") { Placeholder("Progress") } }
        item { ComponentSection("19. Radio Group") { Placeholder("Radio Group") } }
        item { ComponentSection("20. Select") { Placeholder("Select") } }
        item { ComponentSection("21. Sidebar") { Placeholder("Sidebar (Implemented basic layout above)") } }
        item { ComponentSection("22. Skeleton") { Placeholder("Skeleton") } }
        item { ComponentSection("23. Slider") { Placeholder("Slider") } }
        item { ComponentSection("24. Sonner") { Placeholder("Sonner") } }
        item { ComponentSection("25. Switch") { Placeholder("Switch") } }
        item { ComponentSection("26. Tabs") { Placeholder("Tabs") } }
    }
}

@Composable
fun ComponentSection(title: String, content: @Composable () -> Unit) {
    Column {
        Text(title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(12.dp))
        Box(modifier = Modifier.fillMaxWidth().padding(start = 8.dp)) {
            content()
        }
    }
}

@Composable
fun Placeholder(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant, shape = MaterialTheme.shapes.medium)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("Sample / Code untuk $name sesuai library shadcn-ui-kmp")
    }
}

@Composable
fun AccordionSample() {
    val accordionItems = listOf(
        AccordionItemData(
            id = "item-1",
            header = { Text("Is it accessible?") },
            content = { Text("Yes. It adheres to the WAI-ARIA design pattern.") }
        ),
        AccordionItemData(
            id = "item-2",
            header = { Text("Is it styled?") },
            content = { Text("Yes. It comes with default styles.") }
        )
    )
    Accordion(items = accordionItems)
}

@Composable
fun ButtonSample() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = {}) { Text("Default Button") }
    }
}

@Composable
fun InputSample() {
    var text by remember { mutableStateOf("") }
    Input(
        value = text,
        onValueChange = { text = it },
        placeholder = "Ketik sesuatu...",
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.5f)
    )
}
