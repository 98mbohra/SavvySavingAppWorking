package com.example.bohra.savvysavingappworking;


import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;


public class SavingSetup extends AppCompatActivity {

    //This app will open the finance db and send the saving set up data

    android.icu.util.Calendar currentTime = android.icu.util.Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_setup);
        Long min = currentTime.getTime().getTime();
        CalendarView savingCalendar = (CalendarView) findViewById(R.id.calendarView);
        savingCalendar.setMinDate(min);
        final EditText goalAmount = (EditText) findViewById(R.id.savingAmountEditText);
        final EditText pledgeAmount = (EditText) findViewById(R.id.pledgeAmountEditText);

        Button goHomeBtn = (Button) findViewById(R.id.continueDateButton);
        goHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int goalAmountToSend = Integer.parseInt(goalAmount.getText().toString());
                int pledgeAmountToSend = Integer.parseInt(pledgeAmount.getText().toString());
                Spinner incomePeriodSpinner = (Spinner)  findViewById(R.id.incomePeriodSpinner);
                //Period incomePeriod = Period.valueOf(incomePeriodSpinner.getSelectedItem().toString());



                if ((goalAmountToSend < 0) || (pledgeAmountToSend < 0))
                {
                    Toast goalLowToast = Toast.makeText(getApplicationContext(), "Your must set a pledge and goal!", Toast.LENGTH_SHORT);
                    goalLowToast.show();
                }
                else
                {
                    Intent goToHome = new Intent(getApplicationContext(), HomeScreen.class);
                    startActivity(goToHome);
                    //send goal amount, pledge amount, period value to db

                }



            }
        });







    }
}
