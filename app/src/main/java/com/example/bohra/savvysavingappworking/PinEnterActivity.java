package com.example.bohra.savvysavingappworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    private static int checkPinCode(int suppliedPin) {
        //Functionality to load file and set get the pincode value
        int pin = 2346; // this will become output of file io
        int checker = 0;
        if (suppliedPin == pin) {
            checker = 1;
        }

        return checker;
    }


}
