package kr.co.widgetsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creator : Yeonju Kim
 * Date : 2020년 02월 17일.
 * File Description :
 */


public class BtnTextViewActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_button_textview);


        Button button = findViewById(R.id.button_plus);
        final TextView textView = findViewById(R.id.textview_counter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("" + count++);
            }
        });
    }
}
