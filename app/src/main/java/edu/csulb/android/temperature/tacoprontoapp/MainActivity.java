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
    String message;
RadioButton large,medium,corn,flour;
    CheckBox beef,chicken,whitefish,cheese,seaFood,rice,beans,pica,guaca,lbt,soda,cerveza,margarita,tequilla;
    boolean isLarge,isMedium,hasBeef,hasChicken,hasWhitefish,hasCheese,hasSeaFood,hasRice,hasBeans,hasPica,hasGuaca,hasLbt,hasSoda,hasCerverza,hasTequilla,hasMargarita,hasCorn,hasFlour;
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
        cheese = (CheckBox)findViewById(R.id.cheese_CB);
        seaFood = (CheckBox)findViewById(R.id.seafood_CB);
        rice = (CheckBox)findViewById(R.id.rice_CB);
        beans = (CheckBox)findViewById(R.id.beans_CB);
        guaca = (CheckBox)findViewById(R.id.guaca_CB);
        lbt = (CheckBox)findViewById(R.id.lbt_CB);
        soda = (CheckBox)findViewById(R.id.soda_CB);
        cerveza = (CheckBox)findViewById(R.id.cerveza_CB);
        margarita = (CheckBox)findViewById(R.id.margarita_CB);
        tequilla = (CheckBox)findViewById(R.id.tequila);
        corn = (RadioButton)findViewById(R.id.Corn_RB);
        flour = (RadioButton)findViewById(R.id.Flour_RB);
        pica = (CheckBox)findViewById(R.id.pico_CB);
        isLarge=large.isChecked();
        isMedium=medium.isChecked();
        hasBeef = beef.isChecked();
        hasChicken = chicken.isChecked();
        hasWhitefish= whitefish.isChecked();
        hasCheese =cheese.isChecked();
        hasSeaFood = seaFood.isChecked();
        hasRice = rice.isChecked();
        hasBeans = rice.isChecked();
        hasPica = pica.isChecked();
        hasGuaca = guaca.isChecked();
        hasLbt = lbt.isChecked();
        hasSoda = soda.isChecked();
        hasCerverza = cerveza.isChecked();
        hasMargarita = margarita.isChecked();
        hasTequilla = tequilla.isChecked();
        hasCorn = corn.isChecked();
        hasFlour = flour.isChecked();

        message= "The customer has ordered the following \nSize:";
        float price= 0;
        price = price + calculateSizePrice();
        message += "\nTortilla:";
        price+=calTortillaSize();
        message += "\nFillings:";
        price+=calFillingsPrice();
        message += "\nBeverages:";
        price+=calBeveragesPrice();

        String phoneNo= "5627875766";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNo));
        intent.putExtra("sms_body",message+"\nTotal price is "+price);
        startActivity(intent);
    }

    private float calFillingsPrice() {
        float sum=0;
        if(hasBeef){ sum+=2.5; message=message+" Beef";}
        if(hasChicken) { sum+=2; message=message+" Chicken";}
        if(hasWhitefish) { sum+=3; message=message+" WhiteFish";}
        if(hasGuaca) { sum+=2; message=message+" Guacamole";}
        if(hasBeans) { sum+=2.5; message=message+" Beans";}
        if(hasSeaFood) { sum+=3; message=message+" SeaFood";}
        if(hasRice) { sum+=1.5; message=message+" Rice";}
        if(hasCheese) { sum+=1; message=message+" Cheese";}
        if(hasPica) { sum+=1.5; message=message+" Pica";}
        if(hasLbt) { sum+=2; message=message+" LBT";}

        return sum;
    }

    private float calBeveragesPrice() {
        float sum=0;
        if(hasSoda){ sum+=0.5; message=message+" Soda";}
        if(hasMargarita) { sum+=1.5; message=message+" Margarita";}
        if(hasTequilla) { sum+=2.5; message=message+" Tequilla";}
        if(hasCerverza) { sum+=2.5; message=message+" Cerverza";}


        return sum;
    }

    private float calculateSizePrice() {
        float sum = 0;
        if(isLarge){ sum+=2.5; message=message+" Large";}
        else { sum+=2; message=message+" Medium";}
        return sum;

    }
    private float calTortillaSize() {
        float sum = 0;
        if(hasCorn){ sum+=2.5; message=message+" Corn";}
        else { sum+=2; message=message+" Flour";}
        return sum;

    }

}
