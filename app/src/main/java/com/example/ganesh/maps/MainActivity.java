package com.example.ganesh.maps;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.model.TileOverlay;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(googleServicesAvailable()){
            Toast.makeText(this,"Perfect!", Toast.LENGTH_LONG).show();
        }

    }

    public boolean googleServicesAvailable(){
        GoogleApiAvailability api=GoogleApiAvailability.getInstance();
        int isAvailable=api.isGooglePlayServicesAvailable(this);
        if(isAvailable== ConnectionResult.SUCCESS){
            return true;
        }else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog=api.getErrorDialog(this,isAvailable,0);
            dialog.show();

        }else{
            Toast.makeText(this,"cant connect to google services",Toast.LENGTH_LONG).show();

        }
        return false;
    }
}
