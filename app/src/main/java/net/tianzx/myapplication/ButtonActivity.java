package net.tianzx.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button button = (Button) this.findViewById(R.id.btn);
//        button.setOnClickListener(new MyBtnListener());
    }

//    class MyBtnListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(ButtonActivity.this, "点击了", Toast.LENGTH_LONG).show();
//        }
//    }
    private int num = 0;
    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            num++;
            Log.i("tianzx","now handle"+num);
        }
    };

    Runnable r = new Runnable() {
        @Override
        public void run() {
            Message msg = h.obtainMessage();
            h.sendMessage(msg);

            h.postDelayed(r,1000L);
        }
    };

    public void start(View v) {
        h.post(r);
    }

    public void stop(View v) {h.removeCallbacks(r);
    }

}
