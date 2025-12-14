# Merry Christmas Android App 🎄

A beautiful, festive Android application featuring snowfall animation, Christmas music, rotating holiday images, and more!

## Features

- ❄️ **Falling Snow Animation** - Realistic snowflakes falling across the screen
- 🎵 **Christmas Music** - Background holiday music that loops
- 🖼️ **Image Slideshow** - 5 Christmas images rotate every 3 seconds
- 🎨 **Beautiful Design** - Gradient blue/purple background with festive colors
- 👑 **Custom Footer** - "Powered by 👑 John Reese"
- 🎅 **Holiday Emojis** - Christmas tree, Santa, gifts, snowman, bells, and more!

## Project Structure

```
MerryChristmasApp/
├── app/
│   ├── build.gradle
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/merrychristmas/
│       │   ├── MainActivity.java      # Main activity with music & slideshow
│       │   └── SnowfallView.java      # Custom view for snow animation
│       └── res/
│           ├── drawable/
│           │   ├── gradient_background.xml
│           │   ├── christmas_tree_img.xml
│           │   ├── christmas_gift_img.xml
│           │   ├── christmas_santa_img.xml
│           │   ├── christmas_snowman_img.xml
│           │   ├── christmas_bells_img.xml
│           │   └── ic_launcher_*.xml
│           ├── layout/
│           │   └── activity_main.xml
│           ├── mipmap-anydpi-v26/     # Adaptive icons (API 26+)
│           ├── mipmap-mdpi/           # Legacy icons
│           ├── raw/
│           │   └── (add christmas_music.mp3 here)
│           └── values/
│               ├── colors.xml
│               ├── strings.xml
│               └── themes.xml
├── gradle/wrapper/
├── build.gradle
├── gradle.properties
└── settings.gradle
```

## Requirements

- Android Studio (latest stable version)
- Android SDK 35
- Java 17
- Gradle 8.13
- Android Gradle Plugin 8.13.2

## Setup Instructions

### Step 1: Add Christmas Music

1. Download a royalty-free Christmas song (MP3 or OGG format)
2. Rename it to `christmas_music.mp3`
3. Place it in `app/src/main/res/raw/`

Free music sources:
- [Free Music Archive](https://freemusicarchive.org/)
- [Incompetech](https://incompetech.com/music/)
- [Bensound](https://www.bensound.com/)

### Step 2: Build the APK

**Option A: Android Studio**
1. Open the project in Android Studio
2. Wait for Gradle sync to complete
3. Click **Build > Build Bundle(s) / APK(s) > Build APK(s)**

**Option B: Command Line**
```bash
cd MerryChristmasApp
gradle wrapper
./gradlew assembleDebug
```

### Step 3: Install

The APK will be at: `app/build/outputs/apk/debug/app-debug.apk`

Install via ADB:
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## Technical Details

| Component | Version |
|-----------|---------|
| Android Gradle Plugin | 8.13.2 |
| Gradle | 8.13 |
| Target SDK | 35 (Android 15) |
| Min SDK | 24 (Android 7.0) |
| Java | 17 |

## App Features Explained

### Snow Animation
Custom `SnowfallView` draws 100 snowflakes with varying:
- Sizes (2-8dp radius)
- Speeds (1-5 units/frame)
- Opacity (40-100%)
- Horizontal drift

### Image Slideshow
`ViewFlipper` cycles through 5 vector drawable Christmas images:
1. Christmas Tree with ornaments
2. Gift box with ribbon
3. Santa Claus face
4. Snowman with hat
5. Golden bells

### Background Music
`MediaPlayer` plays the audio file on loop with 50% volume. Automatically pauses when app goes to background.

---

## Credits

**Powered by 👑 John Reese**

🎄 Merry Christmas & Happy New Year! 🎁
