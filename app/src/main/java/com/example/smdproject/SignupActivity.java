package com.example.smdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    EditText username;// = findViewById(R.id.username);
    EditText password;// = findViewById(R.id.password);
    EditText name;//= findViewById(R.id.fullname);
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        name = findViewById(R.id.fullname);
        signup = findViewById(R.id.signup_button);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

    }
    private void InsertData(){
        String fname = name.getText().toString();
        String fusername = username.getText().toString();
        String fpassword = password.getText().toString();

        String id = databaseReference.push().getKey();

        User user = new User(fname, fusername, fpassword);
        databaseReference.child("users").child(id).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast toast = Toast.makeText(getApplicationContext(), "User Added Successfully",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

}