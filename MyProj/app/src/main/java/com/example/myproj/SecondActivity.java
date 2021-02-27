package com.example.myproj;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("장바구니");

        final TextView tx1 = (TextView) findViewById(R.id.tx1);
        final TextView tx2 = (TextView) findViewById(R.id.tx2);
        final TextView tx3 = (TextView) findViewById(R.id.tx3);
        final TextView tx4 = (TextView) findViewById(R.id.tx4);
        Button home = (Button) findViewById(R.id.home);
        Button purchase = (Button) findViewById(R.id.purchase);
        final CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
        final CheckBox cb2 = (CheckBox) findViewById(R.id.cb2);
        ImageView img1 = (ImageView) findViewById(R.id.img1);
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        TextView one1 = (TextView) findViewById(R.id.one1);
        TextView one2 = (TextView) findViewById(R.id.one2);

        Intent inIntent = getIntent();

        String name1 = inIntent.getExtras().getString("name1");
        tx1.setText(name1);
        String price1 = inIntent.getExtras().getString("price1");
        tx2.setText(price1);
        String name2 = inIntent.getExtras().getString("name2");
        tx3.setText(name2);
        String price2 = inIntent.getExtras().getString("price2");
        tx4.setText(price2);

        byte[] arr = getIntent().getByteArrayExtra("image2");
        if(arr != null){
            Bitmap image2 = BitmapFactory.decodeByteArray(arr, 0, arr.length);
            img2.setImageBitmap(image2);
        }

        byte[] arr1 = getIntent().getByteArrayExtra("image1");
        if(arr1 != null){
            Bitmap image1 = BitmapFactory.decodeByteArray(arr1, 0, arr1.length);
            img1.setImageBitmap(image1);
        }


        if (tx1.getText().equals("")){
            cb1.setVisibility(View.INVISIBLE);
            one1.setVisibility(View.INVISIBLE);
        }
        else if (tx3.getText().equals("")){
            cb2.setVisibility(View.INVISIBLE);
            one2.setVisibility(View.INVISIBLE);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeIntent);
            }
        });

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buyIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                if (cb1.isChecked()){
                    buyIntent.putExtra("name1", tx1.getText());
                    buyIntent.putExtra("price1", tx2.getText());
                }
                if (cb2.isChecked()){
                    buyIntent.putExtra("name2", tx3.getText());
                    buyIntent.putExtra("price2", tx4.getText());
                }
                if(cb1.isChecked() == false && cb2.isChecked() == false){
                    Toast.makeText(getApplicationContext(), "한 개 이상의 상품을 선택해주세요.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(buyIntent);
            }
        });
    }
}
