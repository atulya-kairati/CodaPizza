#### Adding Compose to a project with Framework Views

- Minimum SDK should be 24.
- Check in project level **build.gradle** that kotlin version is higher that `1.6.10` (depends on the `kotlinCompilerExtensionVersion`).
- Open module level **build.gradle** and add following in android block.
```groovy
android {
    namespace 'com.atulya.codapizza'
    
    // ....
    // ....

    buildFeatures {
        compose true
    }

    composeOptions {
        kotlinCompilerExtensionVersion '1.4.2' // this requires kotlin >= 1.8.10
    }
}
```
- Then add dependencies required for Compose:
```groovy
implementation 'androidx.compose.foundation:foundation:1.4.2'
implementation 'androidx.compose.runtime:runtime:1.4.2'
implementation 'androidx.compose.ui:ui:1.4.2'
implementation 'androidx.compose.ui:ui-tooling:1.4.2'
implementation 'androidx.compose.material:material:1.4.2'
implementation 'androidx.activity:activity-compose:1.7.1'
```

- Remove `setContentView(...)` from MainActivity.
- Delete `activity_main.xml` file
- Add following in the MainActivity.kt
```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      This
        setContent { 
            Text(text = "Hellowww! From Compose.")
        }
    }
}
```