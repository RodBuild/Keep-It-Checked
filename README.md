# Overview

I have always had an interest in creating usable software; working on an Android app seemed like a great idea. This project has helped learn about the development of android apps.

This project has been really challenging, between using the right dependecies, understanding Kotlin, and trying to find information online. I have a software that do what I inteded to do in the first time. 

While deciding on what type of app to create, I came accros the idea of creating an app that works as a shopping list. The reason for this is because while doing my own shopping, I tend to forget the items I need. I ended up including the shopping list and one extra window for interacting with the user. I will later work on the app and use the thrid window to connect to an API.

[Software Demo Video](https://www.youtube.com/watch?v=j1qmoDDmJ4A)

# Development Environment

The tools used for this program are Android Studio and GitHub. I decided to creat my app using Kotlin instead of Java. The following are the dependencies I used for my app; check the complete gradle file on my GitHub.

``` kotlin
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.0'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.19'
    implementation 'com.google.code.gson:gson:2.8.6'
```

# Useful Websites


* [Android for Developers](https://developer.android.com/)
* [Creating a list](https://www.youtube.com/watch?v=BBWyXo-3JGQ)
* [Creating fragments](https://www.youtube.com/watch?v=ZxK7GomWRP8)

# Future Work


* Find a way to save the state of the app
* Add an API on the thrid window of the app
* Improve the overall design
