package com.alaqsa.android_lab.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.mediaPlayer=MediaPlayer.create(this,R.raw.azan);
        Log.d("s","service start");

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(!this.mediaPlayer.isPlaying()) {

            mediaPlayer.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("s","service Stop");
        if(this.mediaPlayer.isPlaying()){
        mediaPlayer.stop();
        }
    }
}