package net.tianzx.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ButtonActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button button = (Button) this.findViewById(R.id.btn);
//        button.setOnClickListener(new MyBtnListener());
        Toast.makeText(this, "hi,toast", Toast.LENGTH_LONG).show();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //    class MyBtnListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(ButtonActivity.this, "点击了", Toast.LENGTH_LONG).show();
//        }
//    }
//    private int num = 0;
//    Handler h = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            num++;
//            Log.i("tianzx","now handle"+num);
//            int result = 0;
//            new Thread( new Runnable(){
//                public void run(){
//                    try{
//                        Log.i("tianzx","Worker Thread ==="+Thread.currentThread().getId());
//                        Thread.sleep(5000L);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }){
//
//            }.start();
//        }
//    };
//
//    Runnable r = new Runnable() {
//        @Override
//        public void run() {
//            Message msg = h.obtainMessage();
//            h.sendMessage(msg);
//            h.postDelayed(r,1000L);
//        }
//    };
    /**
     * First start handlerThread
     * Second receive msg
     */
    HandlerThread ht = new HandlerThread("Handler Thread");
    Handler h = null;

    public void start(View v) {
//        h.post(r);
        ht.start();
        h = new Handler(ht.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                try {
                    Log.i("tianzx", "Worker Thread ===" + Thread.currentThread().getId());
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };


    }

    public void stop(View v) {

    }

    int num = 0;

    public void sendMsg(View v) {
        //send message
        Message msg = h.obtainMessage();
        msg.obj = "now is msg ==" + num;
        msg.sendToTarget();
    }

    private MyBoundService mybs = null;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            MyBoundService.MyBinder binder = (MyBoundService.MyBinder) iBinder;
            mybs = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void sendService(View v) {
        Intent intent = new Intent();
        intent.setClass(this, MyIntentService.class);
        this.startService(intent);
//        this.bindService(intent,conn,this.BIND_AUTO_CREATE);
//        String str = mybs.method1(3, 5);
//        Toast.makeText(this,"str = "+str,Toast.LENGTH_LONG).show();
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_EDIT);
        intent.putExtra("param1", "参数1");

        this.sendBroadcast(intent);
    }

    public void saveData(View v) {
        EditText keyComp = (EditText) this.findViewById(R.id.mykey);
        EditText valueComp = (EditText) this.findViewById(R.id.myvalue);

        String key = keyComp.getText().toString();
        String value = valueComp.getText().toString();
        FileOutputStream fout = null;
        ObjectOutputStream oout = null;
        try {
            fout = this.openFileOutput("MyTxt.txt", Activity.MODE_PRIVATE);
            oout = new ObjectOutputStream(fout);
            oout.writeChars(key + "-" + value + " , ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ;
        }

    }

    public void getData(View v) throws IOException {
        FileInputStream fin = null;
        ObjectInputStream oin = null;
        String str = "";
        try {
            fin = this.openFileInput("MyTxt.txt");
//            oin = new ObjectOutputStream(fin);
            oin = new ObjectInputStream(fin);
            str = oin.readUTF();
//            oin.read
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        TextView tv= (TextView)this.findViewById(R.id.textView2);


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Button Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://net.tianzx.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Button Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://net.tianzx.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
