package net.tianzx.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId) {

        Log.i("tianzx","what a beauty");
        return super.onStartCommand(intent,flags,startId);
    }
}
