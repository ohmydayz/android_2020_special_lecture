package kr.co.widgetsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creator : Yeonju Kim
 * Date : 2020년 02월 17일.
 * File Description :
 */


public class CheckBoxActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_checkbox);

        final CheckBox checkBox1 = findViewById(R.id.cb_1);
        final CheckBox checkBox2 = findViewById(R.id.cb_2);
        final CheckBox checkBox3 = findViewById(R.id.cb_3);

        Button button = findViewById(R.id.button_sign_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBox1.isChecked() && checkBox2.isChecked()) {
                    Toast.makeText(CheckBoxActivity.this
                            , "회원가입 축하!"
                            , Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
