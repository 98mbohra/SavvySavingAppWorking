package com.example.bohra.savvysavingappworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreatePinActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createpin);

        //this activity  uses the same pinfile from PinEnter that it writes the content to

        Button confirmButton2 = (Button) findViewById(R.id.ConfirmPinCreatebutton);
        confirmButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText enterPinText = (EditText) findViewById(R.id.enterPinText);


                //int pinSupply = Integer.parseInt(enterPinText.getText().toString());


                IO io = new IO();
                io.writeFile("pin.txt",enterPinText.getText().toString());

                Intent incomeSetIntent = new Intent(getApplicationContext(), SetIncomeActivity.class);


                startActivity(incomeSetIntent);
            }
        });

        Button returnToLogInButton = (Button) findViewById(R.id.Returnbutton);
        returnToLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent returnPinEnterActivity = new Intent(getApplicationContext(), PinEnterActivity.class);


                startActivity(returnPinEnterActivity);
            }
        });
    }









}
