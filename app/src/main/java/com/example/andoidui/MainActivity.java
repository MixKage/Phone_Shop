package com.example.andoidui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, null);

        userNameEditText = findViewById(R.id.nameEditText);

        createSpinner();
        createMap();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exemple_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent SettingsActivity = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(SettingsActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
    }
    }

    void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("Select phone");
        spinnerArrayList.add("Samsung");
        spinnerArrayList.add("iPhone 8");
        spinnerArrayList.add("Lumia 950");
        spinnerArrayList.add("LG G6");
        spinnerArrayList.add("Sony xperia");
        spinnerArrayList.add("Huawei");

        spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap(){
        goodsMap = new HashMap();
        goodsMap.put("Select phone",0.0);
        goodsMap.put("Samsung",150.0);
        goodsMap.put("iPhone 8",800.0);
        goodsMap.put("Lumia 950",600.0);
        goodsMap.put("LG G6",500.0);
        goodsMap.put("Sony xperia",700.0);
        goodsMap.put("Huawei",400.0);
    }

    public void plus(View view) {
        if(goodsName=="Select phone"){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Телефон не выбран!",
                    Toast.LENGTH_SHORT);
            toast.show();
            quantity=0;
            TextView Kol = findViewById(R.id.quantityText);
            Kol.setText(""+quantity);
            TextView priceTextView = findViewById(R.id.priceTextView);
            priceTextView.setText(""+quantity*price);
        }
        else{
            TextView Kol = findViewById(R.id.quantityText);
            quantity=quantity+1;
            Kol.setText(""+quantity);
            TextView priceTextView = findViewById(R.id.priceTextView);
            priceTextView.setText(""+quantity*price);}
    }

    public void minus(View view) {
        Button minusButtin = findViewById(R.id.minusButton);
        //minusButtin.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100);//УДАЛИТЬ
        if(goodsName=="Select phone"){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Телефон не выбран!",
                    Toast.LENGTH_SHORT);
            toast.show();
            quantity=0;
            TextView Kol = findViewById(R.id.quantityText);
            Kol.setText(""+quantity);
            TextView priceTextView = findViewById(R.id.priceTextView);
            priceTextView.setText(""+quantity*price);
        }
        else {
            TextView Kol = findViewById(R.id.quantityText);
            if (quantity <= 0) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Выбрано минимальное количество товара!",
                        Toast.LENGTH_SHORT);
                toast.show();
            } else {
                quantity = quantity - 1;
            }
            Kol.setText("" + quantity);
            TextView priceTextView = findViewById(R.id.priceTextView);
            priceTextView.setText("" + quantity * price);
        }
        //minusButtin.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100);//УДАЛИТЬ
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        Button addToCard;
        addToCard = findViewById(R.id.addToCard);
        boolean TF = false;

        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText(""+quantity*price);

        ImageView goodsImageView = findViewById(R.id.imageView3);

        switch (goodsName){
            case "Select phone":
                TF=false;
                goodsImageView.setImageResource(R.drawable.phone_1);
                quantity=0;
                TextView Kol = findViewById(R.id.quantityText);
                Kol.setText(""+quantity);
                TextView priceTextView2 = findViewById(R.id.priceTextView);
                priceTextView2.setText(""+quantity*price);
                addToCard.animate().alpha(0).translationY(10).setDuration(800);
                break;
            case "Samsung":
                goodsImageView.setImageResource(R.drawable.samsung);
                if(!TF){
                addToCard.animate().alpha(1).translationY(-10).setDuration(800);}
                TF=true;
                break;
            case "iPhone 8":
                goodsImageView.setImageResource(R.drawable.iphone_8);
                if(!TF){
                    addToCard.animate().alpha(1).translationY(-10).setDuration(800);}
                TF=true;
                break;
            case "Lumia 950":
                goodsImageView.setImageResource(R.drawable.lumia950);
                if(!TF){
                    addToCard.animate().alpha(1).translationY(-10).setDuration(800);}
                TF=true;
                break;
            case "LG G6":
                goodsImageView.setImageResource(R.drawable.lg_g6);
                if(!TF){
                addToCard.animate().alpha(1).translationY(-10).setDuration(800);}
                TF=true;
                break;
            case "Sony xperia":
                goodsImageView.setImageResource(R.drawable.sony);
                if(!TF){
                    addToCard.animate().alpha(1).translationY(-10).setDuration(800);}
                TF=true;
                break;
            case "Huawei":
                goodsImageView.setImageResource(R.drawable.huawei);
                if(!TF){
                    addToCard.animate().alpha(1).translationY(-10).setDuration(800);}
                TF=true;
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        ImageView goodsImageView2 = findViewById(R.id.imageView3);
        goodsImageView2.setImageResource(R.drawable.phone_1);
    }

    public void addToCard(View view) {
        String nameUser;
        nameUser = userNameEditText.getText().toString();
        if(quantity==0){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Выбрано недопустимое количество телефонов!",
                    Toast.LENGTH_SHORT);
            toast.show();}
        else if(nameUser.equals("") ){//Проверка на отсутствие символов в имени
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Отсутствует имя пользователя!",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(quantity<0||price<0){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Невозможное значение!",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            if(quantity*price<1000.0){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Если стоимость заказа будет превышать 1000$, сработает скидка 30%!",
                        Toast.LENGTH_LONG);
                toast.show();
            }
            else if(quantity*price>=1000.0){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Сработала скидка 30%!",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            Order order = new Order();

            order.userName = userNameEditText.getText().toString();
            order.goodsName = goodsName;
            order.quantity = quantity;
            if(quantity*price>=1000.0){
                order.orderPrice = quantity * price / 100.0 * 70.0;
                order.priceSkidka = quantity * price / 100.0 * 30.0;
                order.skidka=true;
            }
            else {
                order.orderPrice = quantity * price;
                order.skidka=false;
            }
            Intent orderIntent = new Intent(MainActivity.this,OrderActivity.class);//Из какой активити в какую

            orderIntent.putExtra("userNameForIntent",order.userName);//передаём данные
            orderIntent.putExtra("goodsName",order.goodsName);
            orderIntent.putExtra("quantity",order.quantity);
            orderIntent.putExtra("orderPrice",order.orderPrice);
            orderIntent.putExtra("skidka",order.skidka);
            orderIntent.putExtra("priceSkidka",order.priceSkidka);

            startActivity(orderIntent);//Включаем активити
        }
    }
}