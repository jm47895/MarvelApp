# MarvelApp
This is a app that fetches a marvel comic from the marvel api

# Build Instructions
In order for this app to work, both a private and public marvel api key are needed. You can obtain these by going to the [Marvel Developer Website](https://developer.marvel.com/) and registering. 

Once you have obtained both, fork and clone this repo and go to the Constants.kt file after opening it in Android Studio. Here, there will be two variables API_KEY and PRIVATE_KEY. You can either copy and paste your api key (not recommended) or add to your local.properties file in Android Studio and reference them (recommended).

# Libraries
Testing: Junit, Espresso, and Truth<br/>
Dependency Injection: Hilt<br/>
Async operations: Coroutines/Flow<br/>
Caching: Room<br/>
Networking: Retrofit<br/>
Image processing: Glide<br/>
Leak detection: Leak Canary<br/>
Kotlin code: Kotlin Extensions
