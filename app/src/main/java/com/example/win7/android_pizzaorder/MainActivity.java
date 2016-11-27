package com.example.win7.android_pizzaorder;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText tx1, tx2, tx3;
    CheckBox ch1;
    RadioButton r1, r2;
    ImageView img;
    Button btn1;
    TextView tv1, tv2, tv3;
    double a,b,c;
    double sum = 0;
    double price=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = (EditText)findViewById(R.id.editText1);
        tx2 = (EditText)findViewById(R.id.editText2);
        tx3 = (EditText)findViewById(R.id.editText3);
        ch1 = (CheckBox)findViewById(R.id.checkBox);
        r1 = (RadioButton)findViewById(R.id.radioButton1);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        img = (ImageView)findViewById(R.id.imageView);
        btn1 = (Button)findViewById(R.id.button);
        tv1 = (TextView)findViewById(R.id.textView5);
        tv2 = (TextView)findViewById(R.id.textView7);
        tv3 = (TextView)findViewById(R.id.textView8);

        r1.setChecked(true);
        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(r1.isChecked()){
                    img.setImageResource(R.drawable.p);
                    tv3.setText("피클이 선택되었습니다");
                }
                else{
                    img.setImageResource(R.drawable.s);
                    tv3.setText("소스가 선택되었습니다");
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Double.parseDouble(tx1.getText().toString());
                b = Double.parseDouble(tx2.getText().toString());
                c = Double.parseDouble(tx3.getText().toString());

                sum = a + b + c;
                price = (a * 16000) + (b * 11000) + (c * 4000);
                tv1.setText(Double.toString(sum));
                if(ch1.isChecked()){
                    price *= 0.93;
                    tv2.setText(Double.toString(price));
                }
                else
                {
                    tv2.setText(Double.toString(price));
                }
            }
        });


    }
}