package com.example.marcin.zamawiaczpizzy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button bsummary;
    RadioButton rthin, rthick, rsmall, rmedium, rbig;
    CheckBox cham, ccheese, cmuschrom, colives, cbacon, conion, cchicken, cgarlic, csalami, cshrimp, ccapers, ctuna, csostom, csosgarl, coregano;
    int ingredients = 0;
    int ingredientsOptional = 0;
    int price = 0;
    String doughInfo, sizeInfo;
    List<String> ingrMand = new ArrayList<String>();
    List<String> ingrOpti = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bsummary = (Button) findViewById(R.id.btSummary);
        rthin = (RadioButton) findViewById(R.id.rThin);
        rthick = (RadioButton) findViewById(R.id.rThick);
        rsmall = (RadioButton) findViewById(R.id.rSmall);
        rmedium = (RadioButton) findViewById(R.id.rMedium);
        rbig = (RadioButton) findViewById(R.id.rBig);
        cham = (CheckBox) findViewById(R.id.cHam);
        ccheese = (CheckBox) findViewById(R.id.cCheese);
        cmuschrom = (CheckBox) findViewById(R.id.cMuschrom);
        colives = (CheckBox) findViewById(R.id.cOlives);
        cbacon = (CheckBox) findViewById(R.id.cBacon);
        conion = (CheckBox) findViewById(R.id.cOnion);
        cchicken = (CheckBox) findViewById(R.id.cChicken);
        cgarlic = (CheckBox) findViewById(R.id.cGarlic);
        csalami = (CheckBox) findViewById(R.id.cSalami);
        cshrimp = (CheckBox) findViewById(R.id.cShrimp);
        ccapers = (CheckBox) findViewById(R.id.cCapers);
        ctuna = (CheckBox) findViewById(R.id.cTuna);
        csostom = (CheckBox) findViewById(R.id.cSosTom);
        csosgarl = (CheckBox) findViewById(R.id.cSosGarl);
        coregano = (CheckBox) findViewById(R.id.cOregano);

        bsummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 0;
                ingredientsOptional = 0;
                ingredients = 0;
                ingrMand.clear();
                ingrOpti.clear();
                if (rthick.isChecked()){
                    doughInfo = "Ciasto grube";
                    price += 3.5;
                }
                if (rthin.isChecked()){
                    doughInfo = "Ciasto cienkie";
                    price += 3.0;
                }
                if (rsmall.isChecked()){
                    sizeInfo = "Pizza mała";
                    price += 5.0;
                }
                if (rmedium.isChecked()){
                    sizeInfo = "Pizza średnia";
                    price += 7.5;
                }
                if (rbig.isChecked()){
                    sizeInfo = "Pizza duża";
                    price += 10.0;
                }
                if (cham.isChecked()){
                    price += 2.5;
                    ingrMand.add(cham.getText().toString());
                    ingredients++;
                }
                if (ccheese.isChecked()){
                    price += 2.5;
                    ingrMand.add(ccheese.getText().toString());
                    ingredients++;
                }
                if (cmuschrom.isChecked()){
                    price += 2.5;
                    ingrMand.add(cmuschrom.getText().toString());
                    ingredients++;
                }
                if (colives.isChecked()){
                    price += 2.5;
                    ingrMand.add(colives.getText().toString());
                    ingredients++;
                }
                if (cbacon.isChecked()){
                    price += 2.5;
                    ingrMand.add(cbacon.getText().toString());
                    ingredients++;
                }
                if (conion.isChecked()){
                    price += 2.5;
                    ingrMand.add(conion.getText().toString());
                    ingredients++;
                }
                if (cchicken.isChecked()){
                    price += 2.5;
                    ingrMand.add(cchicken.getText().toString());
                    ingredients++;
                }
                if (cgarlic.isChecked()){
                    price += 3.5;
                    ingrOpti.add(cgarlic.getText().toString());
                    ingredientsOptional++;
                }
                if (csalami.isChecked()){
                    price += 3.5;
                    ingrOpti.add(csalami.getText().toString());
                    ingredientsOptional++;
                }
                if (cshrimp.isChecked()){
                    price += 3.5;
                    ingrOpti.add(cshrimp.getText().toString());
                    ingredientsOptional++;
                }
                if (ccapers.isChecked()){
                    price += 3.5;
                    ingrOpti.add(ccapers.getText().toString());
                    ingredientsOptional++;
                }
                if (ctuna.isChecked()){
                    price += 3.5;
                    ingrOpti.add(ctuna.getText().toString());
                    ingredientsOptional++;
                }
                if (csostom.isChecked()){
                    price += 3.5;
                    ingrOpti.add(csostom.getText().toString());
                    ingredientsOptional++;
                }
                if (csosgarl.isChecked()){
                    price += 3.5;
                    ingrOpti.add(csosgarl.getText().toString());
                    ingredientsOptional++;
                }
                if (coregano.isChecked()){
                    price += 3.5;
                    ingrOpti.add(coregano.getText().toString());
                    ingredientsOptional++;
                }
                if (ingredients >= 3 && ingredientsOptional <= 2){
                    AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
                    message.setTitle("Podsumowanie");
                    message.setMessage(doughInfo + '\n' + sizeInfo + '\n' + "Składniki: " + ingrMand + '\n' + "Składniki dodatkowe: " + ingrOpti + '\n' + "Cena: " + Integer.toString(price));
                    message.setPositiveButton("OK", null);
                    AlertDialog alertDialog = message.create();
                    alertDialog.show();
                }
                else{
                    if (ingredients < 3){
                        Toast.makeText(getApplicationContext(), "Podano za mało składników", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Podano za dużo składników opcjonalnych", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
