package com.fe.mylibrary;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class NotificationHandler extends FirebaseMessagingService {
    private static final String TAG = "FCMService";
    private static final String CHANNEL_ID = "notifications_channel";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // Log the received notification
        Log.d(TAG, "From Module: " + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {
            String title = remoteMessage.getNotification().getTitle();
            String message = remoteMessage.getNotification().getBody();

            Log.d(TAG, "Notification Title From Module: " + title);
            Log.d(TAG, "Notification Message From Module: " + message);
            Intent intent = new Intent("com.fe.mylibrary.NOTIFICATION_RECEIVED");
            intent.putExtra("title", "Notification title");
            intent.putExtra("body", "Notification body");
            sendBroadcast(intent);
//            showNotification(title, message);
        }
    }



    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d(TAG, "New Token: " + token);
        // Send token to your backend if needed
    }
}