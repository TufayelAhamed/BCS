package com.example.bcspreparations.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.bcspreparations.MainActivity;
import com.example.bcspreparations.MainActivity;
import com.example.bcspreparations.Mood;
import com.example.bcspreparations.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
    private EditText emailET, passET;
    private TextView statusTV;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;
    Button loginHeadBTN,signupHeadBTN;
    private static final String TAG = "SignIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_test);
        setTitle("BCS প্রস্তুতি");
        emailET = findViewById(R.id.emailET);
        passET = findViewById(R.id.passwordET);
        statusTV = findViewById(R.id.status);
        loginHeadBTN = findViewById(R.id.loginHeadBTN);
        signupHeadBTN = findViewById(R.id.signupHeadBTN);
        auth = FirebaseAuth.getInstance();
    }
    public void loginUser(View view) {
        try {
            String email = emailET.getText().toString();
            String pass = passET.getText().toString();
            Task<AuthResult> task = auth.signInWithEmailAndPassword(email,pass);
            task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        currentUser = auth.getCurrentUser();
                        Toast.makeText(SignIn.this,"Log In with "+emailET.getText().toString()+" is successful",Toast.LENGTH_SHORT).show();
                        //statusTV.setText("Logged in as "+currentUser.getEmail());
                        if (emailET.getText().toString().equals("ayrin.riva@gmail.com")||emailET.getText().toString().equals("subrota.shuvro@gmail.com")){
                            startActivity(new Intent(SignIn.this, Mood.class));
                        }else {
                            startActivity(new Intent(SignIn.this,MainActivity.class));
                        }

                    }
                }
            });
            task.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    statusTV.setText(e.getMessage());
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }


       }

    public void createUser(View view) {
        try {
            String email = emailET.getText().toString();
            String pass = passET.getText().toString();
            Task<AuthResult> task = auth.createUserWithEmailAndPassword(email,pass);
            task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        currentUser = auth.getCurrentUser();
                        //statusTV.setText("Logged in as "+currentUser.getEmail());
                        Toast.makeText(SignIn.this,"Sign Up with "+emailET.getText().toString()+" is successful",Toast.LENGTH_SHORT).show();

                        if (emailET.getText().toString().equals("ayrin.riva@gmail.com")){
                            startActivity(new Intent(SignIn.this, Mood.class));
                        }else {
                            startActivity(new Intent(SignIn.this,MainActivity.class));
                        }


                    }
                }
            });
            task.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    statusTV.setText(e.getMessage());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void LogInHeadBTN(View view) {
        loginHeadBTN.setVisibility(View.VISIBLE);
        signupHeadBTN.setVisibility(View.GONE);
    }

    public void SignUpHeadBTN(View view) {
        loginHeadBTN.setVisibility(View.GONE);
        signupHeadBTN.setVisibility(View.VISIBLE);
    }
}
