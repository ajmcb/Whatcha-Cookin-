package com.cookApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddIngredients extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addingredients);
    }

    public void back(View view) {
       Intent intent = new Intent(this, MainActivity.class);
       startActivity(intent);
    }        
}
