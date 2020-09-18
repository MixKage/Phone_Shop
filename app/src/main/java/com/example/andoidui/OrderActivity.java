package com.example.andoidui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

public class OrderActivity extends AppCompatActivity {

    String[] addresses={"shishov_v@inbox.ru"};
    String subject = "Заказ из приложения Phone Shop";
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //StatusBarUtil.setTranslucentForImageViewInFragment(OrderActivity.this, null);

        Button send;
        send= findViewById(R.id.submitOrder);

        send.animate().setDuration(3000).alpha(1).translationY(-10).setDuration(2000);

        Intent recivedOrderIntent = getIntent();
        String userName = recivedOrderIntent.getStringExtra("userNameForIntent");
        String goodsName = recivedOrderIntent.getStringExtra("goodsName");
        int quantity = recivedOrderIntent.getIntExtra("quantity",0);
        double orderPrice = recivedOrderIntent.getDoubleExtra("orderPrice",0.0);
        boolean Skidka = recivedOrderIntent.getBooleanExtra("skidka",false);
        double priceSkidka = recivedOrderIntent.getDoubleExtra("priceSkidka",0.0);
        TextView orderTextView = findViewById(R.id.orderTextView);
        if(Skidka==true){
            orderTextView.setText("Имя покупателя: " + userName + "\n" +
                    "Товар: " + goodsName + "\n" +
                    "Количество: " + quantity + "\n" +
                    "Скидка 30%:  " + priceSkidka + "$\n" +
                    "Итоговая цена: " + orderPrice + "$");
        }
        else{
        orderTextView.setText("Имя покупателя: " + userName + "\n" +
                "Товар: " + goodsName + "\n" +
                "Количество: " + quantity + "\n" +
                "Итоговая цена: " + orderPrice + "$");}
        text = "Имя покупателя: " + userName + "\n" +
                "Товар: " + goodsName + "\n" +
                "Количество: " + quantity + "\n" +
                "Скидка 30%:  " + priceSkidka + "$\n" +
                "Итоговая цена: " + orderPrice + "$";
    }
    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}