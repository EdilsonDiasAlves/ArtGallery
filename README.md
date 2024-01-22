# Task Manager App

## Description

App created as a challenge using jetpack compose.  
Application that simulates a virtual gallery, with some famous artworks  
where you can exchange images by clicking on buttons to go forward or backward.

![artWorkPreview](https://github.com/EdilsonDiasAlves/ArtGallery/assets/5980465/31f7169d-ee6b-4993-b3c9-ef9dc42b34aa)

## Getting Started

### Before install, You must have at least

* Android Studio
* An Emulator or Device
* Android SDK 34

### Executing program

* Import the project on Android Studio and run it on a Emulator or device

### Details about the implementation

1. The navigation logic via the "Previous" and "Next" has implemented using an index (currentIndex). This provides a smooth browsing experience between artworks.  
2. Created reusable composables such as ArtWorkIllustration, ArtWorkDetails, and ButtonSection, which makes the code easier to maintain and increases readability.  
3. Using state hoisting by use remember for the state (currentIndex) and passing functions to ButtonSection composables, a recommended practice in Jetpack Compose.
4. Adding a GreetingPreview for visually checking how composables will appear during development.


