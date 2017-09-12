#Setup for MacOS

## What you need
 - Java 8
 - Android Studio
 - Android SDK
 - Android device: either physical or emulator.
 - Google account

 ## How to install:
 ### Java 8
 1. Go to the [Java web page](https://java.com/en/download/mac_download.jsp) and download the dmg-file.
 2. Open the file
 3. Double click icon to install
 4. Follow the installation guide.


 ### Android Studio
1. Download
  * Follow this [link](https://developer.android.com/studio/index.html) to the download page for Android Studio.
  * or for direct download link for Mac use [this](https://dl.google.com/dl/android/studio/install/2.3.3.0/android-studio-ide-162.4069837-mac.dmg).
2. Double click on the downloaded file.
3. Drag Android Studio to the Applications folder

### Android SDK
1. Open Android Studio
* Start a new project if you haven't already done it
2. Go to Tools>Android>SDK Manager
3. Select Android 6.0 (API level 23).
* If you have enough space and time, you can include Android 7.0 and 7.1
4. Press apply and wait for download to finish

### Android emulator
* If you have an Android device with Android 6 or higher you can skip this step.
1. Open Android Studio
2. Open a project, new or existing.
3. Go to Tools>Android>AVD Manager
4. If you have a virtual device in the list, skip the rest of the steps.
5. Press "Create Virtual Device"
6. Select Nexus 5X, and press Next
7. Go to the "x86 Images" tab
8. Press download on  Marshmallow, API level 23, x86-64, Android 6.0 (Google APIs), press Finish when its done downloading
9. Select the image you just downloaded and press next. ( image is in the list, you will notice that it doesn't have a download button anymore)
10. Press Finish, and exit AVD Manager

### Google account
* If you don't have a Google account make one [here](https://accounts.google.com/SignUp)