package com.example.myproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        setTitle("구매");

        Button bu1 = (Button) findViewById(R.id.buyComplete);
        TextView tx1 = (TextView) findViewById(R.id.tx1);
        TextView tx2 = (TextView) findViewById(R.id.tx2);
        TextView tx3 = (TextView) findViewById(R.id.tx3);
        TextView tx4 = (TextView) findViewById(R.id.tx4);
        TextView total = (TextView) findViewById(R.id.total);
        final EditText edt1 = (EditText) findViewById(R.id.edt1);
        final EditText edt2 = (EditText) findViewById(R.id.edt2);
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

        if (tx1.getText().equals("")){
            one1.setVisibility(View.INVISIBLE);
        }
        else if (tx3.getText().equals("")){
            one2.setVisibility(View.INVISIBLE);
        }

        int totalPrice = 0;
        if(tx2.getText().equals("")){
            totalPrice = Integer.parseInt(tx4.getText().toString());
        }
        else if(tx4.getText().equals("")){
            totalPrice = Integer.parseInt(tx2.getText().toString());
        }
        else{
            totalPrice = Integer.parseInt(tx2.getText().toString()) + Integer.parseInt(tx4.getText().toString());
        }
        total.setText(Integer.toString(totalPrice));

        final String totalP = Integer.toString(totalPrice);

        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                if (edt1.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edt2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "연락처를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),
                        "구매가 완료되었습니다.\n총 결제 금액은 "+totalP+"원 입니다.", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}
