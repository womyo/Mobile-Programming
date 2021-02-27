package com.example.myproj;

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

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("상품 선택");

        final CheckBox checkBread = (CheckBox) findViewById(R.id.checkBread);
        final CheckBox checkOven = (CheckBox) findViewById(R.id.checkOven);
        final ImageView bread = (ImageView) findViewById(R.id.bread);
        final ImageView oven = (ImageView) findViewById(R.id.oven);
        Button btnBasket = (Button) findViewById(R.id.btnBasket);
        Button btnBuy = (Button) findViewById(R.id.btnBuy);
        final TextView name1 = (TextView) findViewById(R.id.name1);
        final TextView price1 = (TextView) findViewById(R.id.price1);
        final TextView name2 = (TextView) findViewById(R.id.name2);
        final TextView price2 = (TextView) findViewById(R.id.price2);

        btnBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.bread);
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.oven);
                ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, stream1);
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                byte[] byteArray1 = stream1.toByteArray();
                byte[] byteArray2 = stream2.toByteArray();

                if (checkBread.isChecked()){
                    intent.putExtra("image1",byteArray1);
                    intent.putExtra("image2", (byte[]) null);
                    intent.putExtra("name1", (name1.getText()));
                    intent.putExtra("price1", price1.getText());
                }
                if (checkOven.isChecked()){
                    intent.putExtra("image2",byteArray2);
                    intent.putExtra("image1", (byte[]) null);
                    intent.putExtra("name2", (name2.getText()));
                    intent.putExtra("price2", price2.getText());
                }
                if (checkBread.isChecked() && checkOven.isChecked()){
                    intent.putExtra("image1",byteArray1);
                    intent.putExtra("image2",byteArray2);
                    intent.putExtra("name1", (name1.getText()));
                    intent.putExtra("price1", price1.getText());
                    intent.putExtra("name2", (name2.getText()));
                    intent.putExtra("price2", price2.getText());
                }
                if(checkBread.isChecked() == false && checkOven.isChecked() == false){
                    Toast.makeText(getApplicationContext(),
                            "장바구니에 넣으실 상품을 한개 이상 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);

            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);

                if (checkBread.isChecked()){
                    intent.putExtra("name1", name1.getText());
                    intent.putExtra("price1", price1.getText());
                }
                if (checkOven.isChecked()){
                    intent.putExtra("name2", name2.getText());
                    intent.putExtra("price2", price2.getText());
                }
                if(checkBread.isChecked() == false && checkOven.isChecked() == false){
                    Toast.makeText(getApplicationContext(), "구매하실 상품을 한개 이상 선택해주세요.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            }
        });
    }
}