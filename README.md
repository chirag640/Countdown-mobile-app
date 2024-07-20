# Timer App

## Overview

The Timer App is an Android application that provides a customizable timer with an animated dial and sound alerts. Users can set a timer for a specific number of seconds, and the app will display the remaining time on a visually appealing circular dial. The dial displays numbers around the circle, and the animation transitions smoothly between consecutive numbers. Additionally, a sound alert is played during the last 3 seconds of the timer.

## Features

- **Customizable Timer:** Users can enter the desired time in seconds.
- **Visual Timer Dial:** A circular dial displays the elapsed time with animated transitions.
- **Sound Alert:** Plays a sound effect during the last 3 seconds of the timer.
- **Responsive UI:** Designed to fit various screen sizes and orientations.

## Requirements

- Android Studio
- Android SDK 29 or higher
- Java 8 or higher

## Setup

### Clone the Repository

To get started, clone the repository using Git:

```bash
git clone https://github.com/chirag640/Countdown-mobile-app.git
```

### Open the Project
- Open Android Studio.
- Select "Open an existing Android Studio project".
- Navigate to the cloned repository and open it.

### Build and Run

- Ensure that you have an Android emulator or a physical device connected.
- Click on the "Run" button in Android Studio to build and run the app.

### Usage
  ## Start Timer:
- Enter the desired time in seconds in the input field.
- Click the "Start Timer" button to begin the countdown.

  ## Timer Display:
  - The timer dial will show the remaining time as a circular progress indicator.
  - The numbers around the dial will be spaced out if the total time exceeds 30 seconds to avoid congestion.
  ## Sound Alert:

  - A beep sound will play during the last 3 seconds of the timer to alert the user.

### Code Explanation
 - MainActivity.java: Handles user input and starts the timer by passing the total time to TimerActivity. 
 - TimerActivity.java: Manages the countdown logic, triggers animations, and plays the sound alert.
 - TimerView.java: Custom view that draws the timer dial and numbers. Handles animation for smooth transitions between consecutive numbers.
 - res/raw/race_start_beeps.mp3: Sound file used for the alert during the last 3 seconds of the timer.
