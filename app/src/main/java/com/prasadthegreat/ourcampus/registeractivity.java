package com.prasadthegreat.ourcampus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class registeractivity extends AppCompatActivity
{

    private FirebaseAuth mAuth;
    private EditText mUsername;
    private  EditText mEmail;
    private EditText mPassword;
    private EditText mId;
    private Button mRegbtn;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);

        progressDialog=new ProgressDialog(registeractivity.this);
        progressDialog.setTitle("Uploading Data");
        progressDialog.setMessage("Please,wait....");
        progressDialog.setCancelable(false);

        mAuth = FirebaseAuth.getInstance();
        mUsername=(EditText)findViewById(R.id.regusername);
        mEmail=(EditText)findViewById(R.id.regemail);
        mPassword=(EditText)findViewById(R.id.regpassword);
        mId=(EditText)findViewById(R.id.regmobilenumber);
        mRegbtn=(Button)findViewById(R.id.registebtn);

        mRegbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                String name=mUsername.getText().toString();
                String mail=mEmail.getText().toString();
                String password=mPassword.getText().toString();
                String id=mId.getText().toString();

                if(name.isEmpty() || mail.isEmpty() || password.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(registeractivity.this,"Please,Fill all fields",Toast.LENGTH_SHORT).show();
                }else
                {
                    register_user(name,mail,password,id);
                }

            }
        });
    }

    private void register_user(final String name, final String mail, final String password, final String id)
    {
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    final String currentuser=FirebaseAuth.getInstance().getCurrentUser().getUid();


                    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("users");
                    final HashMap<String,String> user_details=new HashMap<>();

                    String data=currentuser.toString().trim();

                    user_details.put("name",name);
                    user_details.put("id",id);
                    user_details.put("mail",mail);
                    user_details.put("password",password);

                    myRef.child(currentuser).setValue(user_details).addOnCompleteListener(new OnCompleteListener<Void>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            if (task.isSuccessful())
                            {
                                DatabaseReference phonelist =FirebaseDatabase.getInstance().getReference().child("phonelist");
                                phonelist.child(currentuser).setValue(user_details).addOnCompleteListener(new OnCompleteListener<Void>()
                                {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task)
                                    {
                                        if (task.isSuccessful())
                                        {
                                            progressDialog.dismiss();
                                            Toast.makeText(getApplicationContext(),"Registration Success",Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(),MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                                        }

                                    }
                                });
                            }
                        }
                    });
                }else
                {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"please,try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void  loginmethod(View view)
    {
        startActivity(new Intent(registeractivity.this,loginactivity.class));
    }

    @Override
    public void onBackPressed()
    {
        finishAffinity();
        finish();
        super.onBackPressed();

    }
}