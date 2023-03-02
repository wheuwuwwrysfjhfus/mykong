package com.example.mykong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_update extends AppCompatActivity{
    EditText eid,euser,upass,uphone,uemail;
    Button bsub,blog;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        eid = findViewById(R.id.txtuId);
        euser = findViewById(R.id.txtuUsername);
        upass = findViewById(R.id.txtuPassword);
        uphone = findViewById(R.id.txtuPhone);
        uemail = findViewById(R.id.txtuEmail);
        bsub = findViewById(R.id.btnuUpdate);
        blog = findViewById(R.id.btnusignin);
        myDatabase = new MyDatabase(this);
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr, pass, phone, email;
                int uId;
                uId = Integer.parseInt(eid.getText().toString());
                usr = euser.getText().toString();
                pass = upass.getText().toString();
                phone = uphone.getText().toString();
                email = uemail.getText().toString();
                boolean update = myDatabase.Updatedata(uId, usr, pass, phone, email);
                if (update == true) {
                    Toast.makeText(getApplication(), "ທ່ານໄດ້ແກ້ໄຂຂໍ້ມູນຮຽບນຮ້ອຍແລ້ວ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplication(), "ທ່ານແກ້ໄຂຂໍ້ມູນບໍ່ສຳເລັດ ກລູນາລອງໃໝ່", Toast.LENGTH_LONG).show();
                }
                clearData();
            }
        });
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logInten = new Intent(getApplication(),MainActivity.class);
                startActivity(logInten);
            }
        });

    }
    private void clearData() {
        euser.setText("");
        upass.setText("");
        uphone.setText("");
        uemail.setText("");
    }
}