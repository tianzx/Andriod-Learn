package net.tianzx.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button button = (Button) this.findViewById(R.id.btn);
        button.setOnClickListener(new MyBtnListener());
    }

    class MyBtnListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(ButtonActivity.this, "点击了", Toast.LENGTH_LONG).show();
        }
    }
}
