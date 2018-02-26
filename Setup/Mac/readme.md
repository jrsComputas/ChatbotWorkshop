# Setup for MacOS


## What you need

- Android Studio
 (steps required)
- Android SDK
 (steps required)
- Java 8
 (steps may be required)
- Android device: either physical or emulator (steps may be required)
- Google account

 (steps probably not required)

## How to install:

### Android Studio
1. Download
  * Follow this [link](https://developer.android.com/studio/index.html) to the download page for Android Studio.
  
2. Double click on the downloaded file.
3. Drag Android Studio to the Applications folder


### Android SDK
1. Open Android Studio, if it's the first time go to "Opening Android Studio for the first time"
* Start a new project if you haven't already done it
2. Go to Tools>Android>SDK Manager
3. Select Android 6.0 (API level 23).
4. Check the "Show package details" box and make sure you are downloading every component you need. You can skip everything with the words "wear" or "tv" in them, but you should download the rest.
* If you have enough space and time, you can include Android 7.0 and 7.1
5. Press apply and wait for download to finish


#### Opening Android Studio for the first time

1. Choose Custom setup, press next

2. Choose the color theme, press next

3. Also select Android Virtual Device, press next

4. Wait for download to finish


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

### Java 8

1. Go to the [Java web page](https://java.com/en/download/mac_download.jsp) and download the dmg-file.

2. Open the file

3. Double click icon to install

4. Follow the installation guide.
