# Setup for Ubuntu

## What you need
 - Java 8
 - Android Studio
 - Android SDK
 - Android device: either physical or emulator.
 - Google account

 ## How to install:
 ### Java 8
 1. Open a terminal and paste this in
 ```
 sudo add-apt-repository ppa:webupd8team/java
 sudo apt-get update
 sudo apt-get install oracle-java8-installer
```
2. and then paste this in
```
sudo apt-get install oracle-java8-set-default
```
 ### Android Studio
1. Download
  * Follow this [link](https://developer.android.com/studio/index.html) to the download page for Android Studio.
  * or for direct download link for Ubuntu/linux use [this](https://dl.google.com/dl/android/studio/ide-zips/2.3.3.0/android-studio-ide-162.4069837-linux.zip).
2. Extract the archive file into an appropriate location for your applications, eg: /opt. Use the filename of your downloaded archive
```
sudo unzip android-studio-ide-162.4069837-linux.zip -d /opt
```
3. If you are running a 64-bit version of Ubuntu, you need to install some 32-bit libraries with the following command:
```
sudo apt-get install libc6:i386 libncurses5:i386 libstdc++6:i386 lib32z1 libbz2-1.0:i386
```
4. To start Android Studio, navigate to the directory /opt/android-studio/bin in a terminal and execute ./studio.sh
5. Alternatively you can make a desktop file:
 #### Create a desktop entry file
 ##### The easy way
1. Open Android studio (step 4)
2. Click on Configure
3. Choose Create Desktop Entry
 ##### The Terminal way
 1. Create a new file androidstudio.desktop by running the command:
```
nano ~/.local/share/applications/androidstudio.desktop
```
2. Paste this in and save:
```
[Desktop Entry]
Version=1.0
Type=Application
Name=Android Studio
Exec="/opt/android-studio/bin/studio.sh" %f
Icon=/opt/android-studio/bin/studio.png
Categories=Development;IDE;
Terminal=false
StartupNotify=true
StartupWMClass=android-studio
```
3. You can now open Android Studio from the launcher


### Android SDK
1. Open Android Studio, if its the first time jump down to "Opening Android Studio for the first time"
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
