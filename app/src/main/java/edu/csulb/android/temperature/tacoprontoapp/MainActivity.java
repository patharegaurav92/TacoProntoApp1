package edu.csulb.android.temperature.tacoprontoapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import android.telephony.SmsManager;

import static android.R.attr.phoneNumber;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
RadioButton large,medium;
    CheckBox beef,chicken,whitefish;
    boolean isLarge,isMedium,hasBeef,hasChicken,hasWhitefish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){
    large = (RadioButton)findViewById(R.id.large_rb);
        medium = (RadioButton)findViewById(R.id.medium_rb);
        beef = (CheckBox)findViewById(R.id.Beef_cb);
        chicken = (CheckBox)findViewById(R.id.Chicken_cb);
        whitefish = (CheckBox)findViewById(R.id.WhiteFish_cb);
        isLarge=large.isChecked();
        isMedium=medium.isChecked();
        hasBeef = beef.isChecked();
        hasChicken = chicken.isChecked();
        hasWhitefish= whitefish.isChecked();
        float price = calculateSizePrice(isLarge,isMedium)+calculateToppingsPrice(hasBeef,hasChicken,hasWhitefish);
        Toast.makeText(this,"Price is "+price,Toast.LENGTH_LONG).show();
        String phoneNo= "5627575766";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNo));
        intent.putExtra("sms_body","The Price is "+price);
        startActivity(intent);
    }

    private float calculateToppingsPrice(boolean hasBeef, boolean hasChicken, boolean hasWhitefish) {
        float sum=0;
        if(hasBeef) sum+=2.5;
        if(hasChicken) sum+=2;
        if(hasWhitefish) sum+=3;
            return sum;
    }

    private float calculateSizePrice(boolean isLarge, boolean isMedium) {
        float sum = 0;
        if(isLarge)sum+=2;
        else sum+=1.5;
        return sum;

    }
}
