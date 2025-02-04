package com.fe.mylibrary;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.concurrent.ExecutionException;

public class NotificationModule {

    public static void initializeFirebase(Context context) {



        try {
            FirebaseApp.initializeApp(context, new FirebaseOptions.Builder()
                    .setApplicationId("1:590518950252:android:3d8a285c539311fdaf7b49")
                    .setApiKey("AIzaSyDIj0uxxxvRplSnhKeTzaWCfesZH2AA9dI")
                    .setProjectId("parent-app-eb9dd")
                    .build(), "ITS_LIB");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static final String TAG = "LibraryTAG";

    public static void getFcmToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.e(TAG, "Fetching FCM token failed", task.getException());
                        return;
                    }

                    // Get the FCM token
                    String token = task.getResult();
                    Log.d(TAG, "FCM Token: " + token);

                    // You can store this token or pass it to your library's consumer
                });
    }
}
