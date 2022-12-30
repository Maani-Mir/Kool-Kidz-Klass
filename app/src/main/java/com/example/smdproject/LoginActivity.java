package com.example.smdproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {


    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        Button login_button = findViewById(R.id.account_login);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fusername = username.getText().toString();
                String fpassword = password.getText().toString();

                Log.e("Username is", fusername);
                databaseReference = FirebaseDatabase.getInstance().getReference();

                databaseReference.child("users").orderByChild("username").equalTo(fusername).addListenerForSingleValueEvent(new ValueEventListener() {
                    public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
//                        Map userRetrieved = dataSnapshot.getValue(Map.class);
//                        String userNameRetrieved = userRetrieved.get("username").toString();
//                        Log.e("user retrieved", user.getUsername());
//                        String userNameRetrieved = user.getUsername();
//                        Log.e("on datachange", userNameRetrieved);
                        if (dataSnapshot.exists()) {
                            // use "username" already exists
                            Log.e("checking", "password...");
                            String name = "user";
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            intent.putExtra("name", "user");

                            startActivity(intent);


                        } else {
                            // User does not exist.
                            // here we call the signup code to enter info cause it's the new user
                            Toast toast = Toast.makeText(getApplicationContext(), "Invalid username", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//                String text = "Teacher clicked";
//                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
//                toast.show();
//                Intent intent = new Intent("SignupActivity");
//                startActivity(intent);
//                Intent intent = googleSignInClient.getSignInIntent();
//                startActivity(intent);
            }
        });

//        student_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String text = "Student clicked";
//                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
//                toast.show();
//
//            }
//        });

    }
//    private void homeActivity(){
//        finish();
//        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//        startActivity(intent);
//    }

}