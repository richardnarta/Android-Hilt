
# Dagger Hilt Implementation

This is dagger-hilt implementation to inject multiple constructor automatically


## Dependency Installation

libs.version

```kotlin
  [versions]
  ksp = "1.9.0-1.0.13"
  hiltAndroidCompiler = "2.49"

  [libraries]
  hilt-android = { 
  module = "com.google.dagger:hilt-android", version.ref = "hiltAndroidCompiler" }
  hilt-android-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hiltAndroidCompiler" }

  [plugins]
  daggerHiltAndroid = { id = "com.google.dagger.hilt.android", version.ref = "hiltAndroidCompiler"}
  devtoolsKsp = { id = "com.google.devtools.ksp", version.ref = "ksp"}
```

build.gradle (Project)

```kotlin
  plugins {
    alias(libs.plugins.daggerHiltAndroid) apply false
    alias(libs.plugins.devtoolsKsp) apply false
  }
```

build.gradle (Module)

```kotlin
  plugins {
    alias(libs.plugins.daggerHiltAndroid) apply false
    alias(libs.plugins.devtoolsKsp) apply false
  }
  
  dependencies {
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
  }
```
    
## Implementation

- Create Custom Application Class

```kotlin
@HiltAndroidApp
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

class Application: Application()
```

- Add To Manifest

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:name=".{Your Custom Application File Name}"
    </application>

</manifest>
```

- Add Entry Point on View

```kotlin
import dagger.hilt.android.AndroidEntryPoint
import androidx.appcompat.app.AppCompatActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {}
```

- Create Hilt Module

```kotlin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleName {

    @Provides
    @Singleton <optional>
    fun functionName(
        params
    ): ClassName {
        return ClassName(params)
    }
}
```

- Inject Constructor

```kotlin
import javax.inject.Inject

class ClassName @Inject constructor(
    private val param
) {}
```

- Add Hilt ViewModel

```kotlin
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val param
): ViewModel() {}
```

