package com.example.bohra.savvysavingappworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PinSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Instantiate a finance class which will populate from all dbs etc,
        //if finance class has no data run activities to set up the app, else, run home screen

        setContentView(R.layout.pinsetactivity);

    Button confirmButton = (Button) findViewById(R.id.ConfirmPinbutton);
    confirmButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            TextView resultView = (TextView) findViewById(R.id.testField);

            EditText pinNumber = (EditText) findViewById(R.id.pinEntryFieldText);

            int pinNum = Integer.parseInt(pinNumber.getText().toString());



            int ecryptedPin = pinNum * 11;

            resultView.setText(ecryptedPin + "");

            //must send the pin to the db, use a specific encryption method
            Intent startIntent = new Intent(getApplicationContext(), IncomeSetActivity.class);


        }
    });
    }
}
