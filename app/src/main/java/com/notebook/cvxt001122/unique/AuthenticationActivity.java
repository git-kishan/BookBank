package com.notebook.cvxt001122.unique;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;
import java.util.Arrays;
import java.util.List;

public class AuthenticationActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 50;
    private FirebaseUser user = null;
    private CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        coordinatorLayout=findViewById(R.id.root_layout);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Book Bank");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white ));
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            startActivity(new Intent(AuthenticationActivity.this, MainActivity.class));
            finish();
        } else {
            authenticateUser();

        }
    }

    private void authenticateUser(){

        List<AuthUI.IdpConfig> providers=Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build()


        );

        startActivityForResult(AuthUI.getInstance().
                createSignInIntentBuilder().setAvailableProviders(providers).
                setLogo(R.drawable.icon1).
                setIsSmartLockEnabled(false).build(), RC_SIGN_IN);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){

            IdpResponse response = IdpResponse.fromResultIntent(data);

            if(resultCode==RESULT_OK){
                showToast("Signed in successfully");

                startActivity(new Intent(AuthenticationActivity.this,MainActivity. class));
                finish();

            }
            else if(response.getError().getErrorCode()==ErrorCodes.NO_NETWORK)
            {
                showSnackBar("No network");
            }
            else if(response.getError().getErrorCode()==ErrorCodes.UNKNOWN_ERROR){
                showSnackBar("Unknown error");
            }
            else if(response.getError().getErrorCode()==ErrorCodes.PROVIDER_ERROR){
                showSnackBar("Unknown error");

            }
        }
        else
        {
            showToast("Sign in failed");
        }
    }
    private void showToast(String message){
        Toast.makeText(AuthenticationActivity.this,message  , Toast.LENGTH_SHORT).show();
    }
    private void showSnackBar(String message){
        Snackbar.make(coordinatorLayout,message ,Snackbar.LENGTH_SHORT ).show();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
