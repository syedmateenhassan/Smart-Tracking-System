package com.example.sts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CreateNewUserActivity extends AppCompatActivity {
    TextView a,b,c,d,e,f,g,h,i;
    Button ab,bc;
    String aa,bb,cc,dd,ee,ff,gg,hh,ii;
    RadioGroup Etype;
    RadioButton Atype;
    DatabaseReference rootRef,demoRef,useRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);
         a = (TextView)findViewById(R.id.editTextId);
         b = (TextView)findViewById(R.id.editTextName);
         c = (TextView)findViewById(R.id.editTextContact);
         d = (TextView)findViewById(R.id.editTextEmail);
         e = (TextView)findViewById(R.id.editTextMailingAdd);
         f = (TextView)findViewById(R.id.editTextDepartment);
         g = (TextView)findViewById(R.id.textConfirmPassword);
         i = (TextView)findViewById(R.id.editTextPassword);

          ab = (Button) findViewById(R.id.saveButton);
          bc = (Button) findViewById(R.id.cancelButton);

          Etype =  (RadioGroup) findViewById(R.id.eTypegroup);

        rootRef = FirebaseDatabase.getInstance().getReference();

//database reference pointing to demo node
        demoRef = rootRef.child("EMPLOYEES");
        useRef = rootRef.child("USERS");

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        aa = a.getText().toString();
                        bb = b.getText().toString();
                        cc = c.getText().toString();
                        dd = d.getText().toString();
                        ee = e.getText().toString();
                        ff = f.getText().toString();
                        gg = g.getText().toString();
                        ii = i.getText().toString();
                        demoRef.child(aa).child("Name").setValue(bb);
                        demoRef.child(aa).child("Contact").setValue(cc);
                        demoRef.child(aa).child("Email").setValue(dd);
                        demoRef.child(aa).child("Mail").setValue(ee);
                        demoRef.child(aa).child("Depart").setValue(ff);

                        int selectedId = Etype.getCheckedRadioButtonId();
                        Atype = (RadioButton) findViewById(selectedId);

                        useRef.child(aa).child("Acctype").setValue(Atype.getText());
                        useRef.child(aa).child("Username").setValue(dd);
                        useRef.child(aa).child("Password").setValue(ii);
                        useRef.child(aa).child("Id").setValue(aa);
                        useRef.child(aa).child("Name").setValue(bb);

                Toast.makeText(CreateNewUserActivity.this, "New User Added", Toast.LENGTH_LONG).show();
                finish();
                setContentView(R.layout.activity_home);
                       }
        });

       /* bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                demoRef.child("notes").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List notes = new ArrayList<>();
                        for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                            ContactsContract.CommonDataKinds.Note note = noteDataSnapshot.getValue(ContactsContract.CommonDataKinds.Note.class);
                            notes.add(note);
                        }
                        adapter.updateList(notes);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                }
        }); */
    }
}
