# Minimal Serif Clock

A tiny native Android home-screen widget recreated from the supplied lock-screen reference.

## What it does

- Live system time; no static screenshot.
- Forced 12-hour display without AM/PM.
- Full weekday above the time.
- White serif typography using Android's system `serif` family.
- Red vertical divider (`#DD4542`).
- Transparent background.
- Resizable; compact, medium, and large layouts are selected as the widget is resized.
- No Internet permission, no analytics, no ads, no background service, and no launcher activity.
- Uses Android `TextClock` inside the widget, so the launcher/system maintains the visible clock.

## Install/use after the APK is built

1. Install `app-debug.apk` on the phone.
2. Long-press an empty area of the home screen.
3. Choose **Widgets**.
4. Find **Minimal Serif Clock**.
5. Drag it to the home screen and resize it until the proportions match the lock-screen version.

The package must remain installed for Android to keep the widget provider available, but there is no normal app screen to keep open.

## Build

The included GitHub Actions workflow builds an installable APK automatically. It uses Android API 36 and Java 17.
