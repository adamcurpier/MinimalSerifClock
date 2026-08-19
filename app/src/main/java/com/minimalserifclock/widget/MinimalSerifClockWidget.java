package com.minimalserifclock.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class MinimalSerifClockWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager manager, int[] ids) {
        Intent launcherIntent = new Intent(context, AlarmLauncherActivity.class);
        launcherIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent clockPendingIntent = PendingIntent.getActivity(
                context,
                1400,
                launcherIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        for (int id : ids) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_clock);

            // HyperOS can be picky about parent click targets, so make every visible
            // part of the widget independently tappable as well as the root.
            views.setOnClickPendingIntent(R.id.widget_root, clockPendingIntent);
            views.setOnClickPendingIntent(R.id.day, clockPendingIntent);
            views.setOnClickPendingIntent(R.id.hour, clockPendingIntent);
            views.setOnClickPendingIntent(R.id.divider, clockPendingIntent);
            views.setOnClickPendingIntent(R.id.minute, clockPendingIntent);

            manager.updateAppWidget(id, views);
        }
    }
}
