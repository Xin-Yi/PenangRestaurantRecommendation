package com.example.penangrestaurantrecommendation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {

    private EditText mEmail, mUsername, mPassword, mConfirmPassword;
    private Button btnRegister;
    private FirebaseAuth auth;
    private DatabaseReference ref;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        mDialog = new ProgressDialog(this);

        mEmail = (EditText) findViewById(R.id.email);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mConfirmPassword = (EditText) findViewById(R.id.confirmPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String name = mUsername.getText().toString();
                String password = mPassword.getText().toString().trim();
                String confirmPassword = mConfirmPassword.getText().toString().trim();
                String validEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!email.matches(validEmail)) {
                    Toast.makeText(getApplicationContext(), "Invalid email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password is too short! Minimum 8 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Confirm again the password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!password.equals(confirmPassword)){
                    Toast.makeText(getApplicationContext(), "Password is not same!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mDialog.setMessage("Processing");
                mDialog.show();

                //Create User
                //Handle both success and failure action
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    mDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                    finish();

                                    //Add new user's details to realtime database
                                    String userType = "user";
                                    String currentID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                    User user = new User(email, name, password, userType,currentID);
                                    ref = FirebaseDatabase.getInstance().getReference("Users");
                                    ref.push().setValue(user);

                                    //Proceed to homepage after register
                                    Intent home = new Intent(getApplicationContext(), Homepage.class);
                                    startActivity(home);
                                    finish();

                                }else {

                                    mDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Registration Failed! "+ task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}
