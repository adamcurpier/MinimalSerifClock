package com.minimalserifclock.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Toast;

public class AlarmLauncherActivity extends Activity {
    private static final String[] CLOCK_PACKAGES = {
            "com.android.deskclock",
            "com.google.android.deskclock",
            "com.miui.clock",
            "com.miui.deskclock"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openClock();
        finish();
    }

    private void openClock() {
        // First try the alarm screen directly inside known Clock packages.
        for (String packageName : CLOCK_PACKAGES) {
            try {
                Intent alarmIntent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                alarmIntent.setPackage(packageName);
                alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (alarmIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(alarmIntent);
                    return;
                }
            } catch (Exception ignored) {
            }
        }

        // If a package does not expose SHOW_ALARMS, open the Clock app itself.
        for (String packageName : CLOCK_PACKAGES) {
            try {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
                if (launchIntent != null) {
                    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(launchIntent);
                    return;
                }
            } catch (Exception ignored) {
            }
        }

        // Final Android-standard fallback.
        try {
            Intent genericAlarmIntent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            genericAlarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            if (genericAlarmIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(genericAlarmIntent);
                return;
            }
        } catch (Exception ignored) {
        }

        Toast.makeText(this, "Clock app could not be opened", Toast.LENGTH_SHORT).show();
    }
}
