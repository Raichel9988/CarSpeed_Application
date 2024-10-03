package com.example.carspeedapplication;
import android.app.Notification;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived( RemoteMessage remotemessage) {
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        super.onMessageReceived(remotemessage);


        getFirebaseMessage(remotemessage.getNotification().getTitle(), remotemessage.getNotification().getBody());

    }

    private void getFirebaseMessage(String title, String body) {

        NotificaionCompat.Builder builder = new Builder(this, "notify")
        .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("speed limit Exceeded")
                .setContentTitle(body)
                .setAutoCancel(true);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        managerCompat.notify();

    }

   private class Builder {
        public Builder(MyFirebaseMessagingService myFirebaseMessagingService, String notify) {
        }

       public NotificationCompat.Builder setSmallIcon(int ic_notification) {
           return null;
       }
   }
}



