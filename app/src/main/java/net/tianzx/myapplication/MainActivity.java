package net.tianzx.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 相当于一个html中的js controller web中的servlet struts2中的action
 */
public class MainActivity extends AppCompatActivity {

//    private LinearLayout layout1;
//    private LinearLayout layout11;
//    private LinearLayout layout12;
//
//    private TextView tv1;
//    private TextView tv2;
//    private TextView tv3;
//    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnToSecond = (Button) this.findViewById(R.id.btn_to_second);
//        btnToSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //
//                Intent in = new Intent();
//                in.setClass(MainActivity.this, Main2Activity.class);
////                Bundle bundle = new Bundle();
////                bundle.
//                in.putExtra("text","你好！！！！");
//
//                MainActivity.this.startActivity(in);
//            }
//        });
//        btnToSecond.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                Uri uri = Uri.parse("smsto:8856");
//                Intent in = new Intent(Intent.ACTION_SENDTO,uri);
//                in.putExtra("sms_body","发个短信玩儿玩儿");
////                in.putExtra("text","你好！！！！");
//                MainActivity.this.startActivity(in);
//            }
//        });
//        btnToSecond.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                Uri uri = Uri.parse("tel:8856");
//                Intent in = new Intent(Intent.ACTION_CALL, uri);
////                in.putExtra("sms_body","发个短信玩儿玩儿");
////                in.putExtra("text","你好！！！！");
////                MainActivity.this.startActivity(in);
//            }
//        });
        /** one is shown data part
         *1:get needed data
         *2:convert data
         *3:set data to component
         */

        /**another part is event process
         *1:collect args
         *2:organize args
         *3:invoke service api , and get return value
         *4:according to vaule, select next view
         */
        btnToSecond.setOnClickListener(new MyClick());

        /**
         * swing
         * draw UI
         * 1. define needed component
         * 2. create component instance,and set relative attribute
         * 3. swing : add component to panel, and set panel to Frame
         *
         */

        /**
         * android
         * draw UI
         * 1.define all needed view compenent in UI
         * 2.create component instance,and set realtive attribute
         * 3.add component to viewGroup,and set viewGroup to Activity
         */

//        layout1 = new LinearLayout(this);
//        layout1.setOrientation(LinearLayout.VERTICAL);
//        layout11 = new LinearLayout(this);
//        layout11.setOrientation(LinearLayout.HORIZONTAL);
//        layout12 = new LinearLayout(this);
//        tv1 = new TextView(this);
//        tv1.setText(this.getText(R.string.app_name));
//        tv2 = new TextView(this);
//        tv2.setText("tianzx v5");
//        tv2.setText("i am feeling andriod's beauty");
//        tv2.setWidth(100);
//        tv2.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        tv3 = new TextView(this);
//        tv3.setText("tianzx indeed v5");
//        tv4 = new TextView(this);
//        tv4.setText("learn andriod");
//        tv4.setWidth(100);
//        tv4.setGravity(Gravity.CENTER_HORIZONTAL);
//        layout11.addView(tv1);
//        layout11.addView(tv2);
//        layout12.addView(tv3);
//        layout12.addView(tv4);
//
//        layout1.addView(layout11);
//        layout1.addView(layout12);
//
//        this.setContentView(layout1);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("tel:8856");
            Intent in = new Intent(Intent.ACTION_CALL, uri);
            in.putExtra("sms_body", "发个短信玩儿玩儿");
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
//            MainActivity.this.startActivity(in);
        }
    }
}
