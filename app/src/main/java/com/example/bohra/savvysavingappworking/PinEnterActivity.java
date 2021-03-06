package com.example.bohra.savvysavingappworking;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class PinEnterActivity extends AppCompatActivity {

    private int attemptCounter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         *
         * In the check pincode file method or where ever add file io
         * Then this class is done
         *
         */

        setContentView(R.layout.pinenteractivity);

        Button confirmButton = (Button) findViewById(R.id.ConfirmPinCreatebutton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView countView = (TextView) findViewById(R.id.countView);
                EditText pinNumber = (EditText) findViewById(R.id.pinEntryFieldText);

                int pinNum = Integer.parseInt(pinNumber.getText().toString());

                if (checkPinCode(pinNum) == 1)
                {
                    //Will send user to the home screen
                    Intent startHomeScreenIntent = new Intent(getApplicationContext(), HomeScreen.class);
                    startActivity(startHomeScreenIntent);
                }

//THIS does not work. It crashes the application rather than showing this error message.

                if((checkPinCode(pinNum) != 1) && (attemptCounter == 1))
                {
                    Toast deniedToast = Toast.makeText(getApplicationContext(), "Too many incorrect entries!", Toast.LENGTH_SHORT);
                    deniedToast.show();
                    finish();
                }

                if(checkPinCode(pinNum) != 1)
                {
                    --attemptCounter;
                    Toast invalidToast = Toast.makeText(getApplicationContext(), "Please enter a valid PIN!", Toast.LENGTH_SHORT);
                    invalidToast.show();
                    countView.setText(attemptCounter+  " Attempts Left");
                    pinNumber.setText("");

                }
            }
        });

        Button setupButton = (Button) findViewById(R.id.SetUpbutton);
        setupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Intent to go to pin setup screen

                Intent createPinIntent = new Intent(getApplicationContext(), CreatePinActivity.class);
                startActivity(createPinIntent);
            }
        });
    }

    //Eric could you please try get the encryption working on this method. The encrypted code variable is io.pinDecrypt in the IO class.
    //It needs to check the value of the pin file and divide by the io.pinDecrypt integer. Thanks
    private int checkPinCode(int suppliedPin){
        //Functionality to load file and set get the pincode value
        //int pin = 2346; // this will become output of file io

        //createFile("pin.txt","1111");

        IO io = new IO();
        int pin = Integer.parseInt(io.readPinFile("pin.txt"));
        int checker = 0;
        if (suppliedPin == pin) {
            checker = 1;
        }

        return checker;
    }


}


