package com.example.sts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sts.model.User;
import com.example.sts.ui.Data;
import com.example.sts.ui.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserLogInActivity extends AppCompatActivity {
    EditText mEmail, mPassword;
    String e,p;
    FirebaseAuth firebaseAuth;
    Button ab;
    String id;
    List<String> list;
    List<String> passwordlist;
    List<String> acctypelist;
   static List<String> idlist;
    static List<String> namelist;
    User fuser;
    Data Duser;
    static String hh;
    static String gh;
    public static String name;
    public void end(){
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        boolean check = false;

        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(email)&&passwordlist.get(i).equals(password)){
                if(acctypelist.get(i).equals("ADMIN")){
                    //Log.i("ok","ok");
                    hh=""+idlist.get(i);
                   Log.i("seeeee",""+namelist.get(i));
                   name = namelist.get(i);
                    Intent inte = new Intent(UserLogInActivity.this, AdminDashBoard.class);
                    check=true;
                    Toast.makeText(UserLogInActivity.this, "Welcome!", Toast.LENGTH_LONG).show();
                    startActivity(inte);
                }
                else if(acctypelist.get(i).equals("STANDARD")){
                    hh=""+idlist.get(i);
//                    gh=""+namelist.get(i);
                    Intent intu = new Intent(UserLogInActivity.this, HomeActivity.class);
                    Toast.makeText(UserLogInActivity.this, "Welcome!", Toast.LENGTH_LONG).show();
                    check=true;
                    startActivity(intu);
                }
            }
        }
        if(check==false){
            Toast.makeText(UserLogInActivity.this,"Wrong Email or Password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log_in);
      //  Toast.makeText(UserLogInActivity.this,"sign in connected",Toast.LENGTH_LONG).show();
        firebaseAuth = FirebaseAuth.getInstance();
        mEmail = (EditText) findViewById(R.id.emailText);
        mPassword = (EditText) findViewById(R.id.passwordText);
        e = String.valueOf(mEmail);
        p = String.valueOf(mPassword);
        ab = (Button)findViewById(R.id.signInButton);
            list = new ArrayList<>();
            namelist = new ArrayList<>();
            passwordlist = new ArrayList<>();
            acctypelist= new ArrayList<>();
       idlist= new ArrayList<>();
        final DatabaseReference DBref = FirebaseDatabase.getInstance().getReference("USERS");
        DBref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    fuser = dataSnapshot.getValue(User.class);
                    Log.i("asd",""+fuser.Username);
                    list.add(fuser.Username);
                    passwordlist.add(fuser.Password);
                    acctypelist.add(fuser.Acctype);
                    idlist.add(fuser.Id);
                    namelist.add(fuser.Name);
                    //Log.i("asfffffd",""+fuser.Name);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    end();

            }
        });


    }
}
