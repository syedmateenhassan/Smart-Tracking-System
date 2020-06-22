//package com.example.sts;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.InputType;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//public class LogInActivity extends AppCompatActivity {
//
//    EditText mEmail;
//    FirebaseAuth firebaseAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_log_in);
//        Toast.makeText(LogInActivity.this,"sign in connected",Toast.LENGTH_LONG).show();
//        firebaseAuth = FirebaseAuth.getInstance();
//        mEmail = (EditText) findViewById(R.id.email1);
//        FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    Toast.makeText(LogInActivity.this, "User logged in ", Toast.LENGTH_SHORT).show();
//                    Intent I = new Intent(LogInActivity.this, HomeActivity.class);
//                    startActivity(I);
//                } else {
//                    Toast.makeText(LogInActivity.this, "Login to continue", Toast.LENGTH_SHORT).show();
//                }
//            }
//        };
//        final EditText Password = (EditText) findViewById(R.id.password1);
//        Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//        Button log = (Button) findViewById(R.id.loginAccount);
//        log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String mEmail1 = mEmail.getText().toString().trim();
//                String mPass1 = Password.getText().toString().trim();
//                if (mEmail1.isEmpty()) {
//                    mEmail.setError("Provide your Email first!");
//                    mEmail.requestFocus();
//                } else if (mPass1.isEmpty()) {
//                    Password.setError("Enter Password!");
//                    Password.requestFocus();
//                } else if (mEmail1.isEmpty() && mPass1.isEmpty()) {
//                    Toast.makeText(LogInActivity.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
//                } else if (!(mEmail1.isEmpty() && mPass1.isEmpty())) {
//                    firebaseAuth.signInWithEmailAndPassword(mEmail1, mPass1).addOnCompleteListener(LogInActivity.this, new OnCompleteListener() {
//                        @Override
//                        public void onComplete(@NonNull Task task) {
//                            if (!task.isSuccessful()) {
//                                Toast.makeText(LogInActivity.this, "Not sucessfull", Toast.LENGTH_SHORT).show();
//                            } else {
//                                startActivity(new Intent(LogInActivity.this, HomeActivity.class));
//                            }
//                        }
//                    });
//                } else
//                    {
//                    Toast.makeText(LogInActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//}
