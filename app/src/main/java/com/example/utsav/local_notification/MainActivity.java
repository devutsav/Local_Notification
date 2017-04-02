package com.example.utsav.local_notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.set(java.util.Calendar.HOUR_OF_DAY,4);
                calendar.set(java.util.Calendar.MINUTE,30);
		        calendar.set(java.util.Calendar.SECOND,30);
                Intent intent = new Intent(getApplicationContext(),Notification_receiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmManager.INTERVAL_DAY,pendingIntent);
            }
        });
    }
}


