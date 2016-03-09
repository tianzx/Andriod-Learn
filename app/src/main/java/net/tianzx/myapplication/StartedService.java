package net.tianzx.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StartedService extends Service {
    public StartedService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
