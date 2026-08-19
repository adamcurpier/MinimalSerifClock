# Minimal Serif Clock

A tiny native Android home-screen widget recreated from the supplied lock-screen reference.

## Current confirmed version

**v1.4** is the current confirmed working build.

It has been tested successfully on a **Xiaomi POCO X8 Pro Max running HyperOS 3 / Android 16**. The clock displays and updates correctly, and tapping the widget opens the phone's **Alarm** screen.

Compatibility with other Android launchers/skins and future HyperOS versions has not yet been verified. HyperOS 4 is therefore not claimed as supported until it is tested.

## What it does

- Live system time; no static screenshot.
- Forced 12-hour display without AM/PM.
- Two-digit hour display for visual balance, e.g. `02 | 43`.
- Full weekday above the time.
- White serif typography using Android's system `serif` family.
- Red vertical divider (`#DD4542`).
- Transparent background.
- Resizable home-screen widget.
- Tapping the widget opens the Alarm screen on the confirmed HyperOS 3 setup.
- Uses a small transparent launcher activity plus Xiaomi/Android Clock fallbacks to make the tap action reliable on HyperOS.
- No Internet permission, analytics, ads, or background service.
- Uses Android `TextClock` inside the widget, so the launcher/system maintains the visible clock.

## Install/use

1. Install the v1.4 APK on the phone.
2. Long-press an empty area of the home screen.
3. Choose **Widgets**.
4. Find **Minimal Serif Clock**.
5. Drag it to the home screen and resize/place it as desired.
6. Tap the widget to open the Alarm screen.

The package must remain installed for Android to keep the widget provider available. There is no normal app interface that needs to stay open.

## Build

The included GitHub Actions workflow builds an installable APK automatically. It uses Android API 36 and Java 17.
