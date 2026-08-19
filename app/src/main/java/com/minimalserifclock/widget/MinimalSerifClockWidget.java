package com.minimalserifclock.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.widget.RemoteViews;

public class MinimalSerifClockWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager manager, int[] ids) {
        Intent alarmIntent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        PendingIntent alarmPendingIntent = PendingIntent.getActivity(
                context,
                0,
                alarmIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        for (int id : ids) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_clock);
            views.setOnClickPendingIntent(R.id.widget_root, alarmPendingIntent);
            manager.updateAppWidget(id, views);
        }
    }
}
