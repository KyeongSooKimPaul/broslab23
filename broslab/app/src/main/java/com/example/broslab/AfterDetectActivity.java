package com.example.broslab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AfterDetectActivity extends AppCompatActivity {


    ImageView imageView;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_detect);


        txtResult = findViewById(R.id.textView);


        Intent intent = getIntent();


        String message1 = intent.getStringExtra("EXTRA_MESSAGE1");
        String message2 = intent.getStringExtra("EXTRA_MESSAGE2");
        String message3 = intent.getStringExtra("EXTRA_MESSAGE3");
        String message4 = intent.getStringExtra("EXTRA_MESSAGE4");
        String message5 = intent.getStringExtra("EXTRA_MESSAGE5");
        String message6 = intent.getStringExtra("EXTRA_MESSAGE6");
        String message7 = intent.getStringExtra("EXTRA_MESSAGE7");
        String message8 = intent.getStringExtra("EXTRA_MESSAGE8");
        String message9 = intent.getStringExtra("EXTRA_MESSAGE9");
        String message10 = intent.getStringExtra("EXTRA_MESSAGE10");
        String message11 = intent.getStringExtra("EXTRA_MESSAGE11");
        String message12 = intent.getStringExtra("EXTRA_MESSAGE12");
        String message13 = intent.getStringExtra("EXTRA_MESSAGE13");
        String message14 = intent.getStringExtra("EXTRA_MESSAGE14");
        String message15 = intent.getStringExtra("EXTRA_MESSAGE15");
        String message16 = intent.getStringExtra("EXTRA_MESSAGE16");
        String message17 = intent.getStringExtra("EXTRA_MESSAGE17");
        String message18 = intent.getStringExtra("EXTRA_MESSAGE18");
        String message19 = intent.getStringExtra("EXTRA_MESSAGE19");
        String message20 = intent.getStringExtra("EXTRA_MESSAGE20");
        String message21 = intent.getStringExtra("EXTRA_MESSAGE21");
        String message22 = intent.getStringExtra("EXTRA_MESSAGE22");
        String message23 = intent.getStringExtra("EXTRA_MESSAGE23");
        String message24 = intent.getStringExtra("EXTRA_MESSAGE24");
        String message25 = intent.getStringExtra("EXTRA_MESSAGE25");
        String message26 = intent.getStringExtra("EXTRA_MESSAGE26");
        String message27 = intent.getStringExtra("EXTRA_MESSAGE27");
        String message28 = intent.getStringExtra("EXTRA_MESSAGE28");
        String message29 = intent.getStringExtra("EXTRA_MESSAGE29");
        String message30 = intent.getStringExtra("EXTRA_MESSAGE30");


        String color1 = message1 + "," + message11 + "," + message21;
        String color2 = message2 + "," + message12 + "," + message22;
        String color3 = message3 + "," + message13 + "," + message23;
        String color4 = message4 + "," + message14 + "," + message24;
        String color5 = message5 + "," + message15 + "," + message25;
        String color6 = message6 + "," + message16 + "," + message26;
        String color7 = message7 + "," + message17 + "," + message27;
        String color8 = message8 + "," + message18 + "," + message28;
        String color9 = message9 + "," + message19 + "," + message29;
        String color10 = message10 + "," + message20 + "," + message30;


        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);
        TextView textView7 = findViewById(R.id.textView7);
        TextView textView8 = findViewById(R.id.textView8);
        TextView textView9 = findViewById(R.id.textView9);
        TextView textView10 = findViewById(R.id.textView10);
        TextView textView11 = findViewById(R.id.textView11);

        textView2.setText(color1);
        textView3.setText(color2);
        textView4.setText(color3);
        textView5.setText(color4);
        textView6.setText(color5);
        textView7.setText(color6);
        textView8.setText(color7);
        textView9.setText(color8);
        textView10.setText(color9);
        textView11.setText(color10);


    }

   /* public void mOnPopupClick(View v){
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }


        }
    }
}
