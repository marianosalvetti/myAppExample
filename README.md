# myAppExample
This file resume the command line validations for both apps
*********************************************************************************************************************
---->MyAppExample
Current Release
android:versionCode="1" android:versionName="1.0"

New release:
a) android:versionCode="2" android:versionName="1.1"
b) apk file: myappexample_RC01-signed-aligned-rc.apk
c) C:\AndroidSDK\android-sdk-windows\build-tools\22.0.1\zipalign  -c -v 4  mobile-1.0-signed-aligned.apk > output_app_zip_align.txt
d) C:\AndroidSDK\android-sdk-windows\build-tools\22.0.1\aapt l -a  mobile-1.0-signed-aligned.apk > output_appp_manifest.txt
OBS: Verification succesful

*********************************************************************************************************************