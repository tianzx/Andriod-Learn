package net.tianzx.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBoundService extends Service {
    public MyBoundService() {
    }

    public class MyBinder extends Binder{
        public  MyBoundService getService() {
            return MyBoundService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String method1(int a,int b) {
        String str = "和+"+a+b;
        return str;
    }
}
