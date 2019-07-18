package tn.yoodev.gestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    Button txtlogin;
    EditText txtuser,txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        txtlogin =  findViewById(R.id.blogin);
        txtuser = (EditText) findViewById(R.id.ETuser) ;
        txtpass = (EditText)  findViewById(R.id.ETpass);

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtuser.getText().toString().equals("commercial")&& txtpass.getText().toString().equals("commercial"))
                {

                    Intent Principal = new Intent(getApplicationContext(),Commercial.class);
                    startActivity(Principal);
                    finish();
                }else
                if (txtuser.getText().toString().equals("lc")&& txtpass.getText().toString().equals("lc")){
                    Intent Principal1 = new Intent(getApplicationContext(),L_commercial.class);
                    startActivity(Principal1);
                    finish();
                }else
                if (txtuser.getText().toString().equals("admin")&& txtpass.getText().toString().equals("admin")){
                    Intent Principal2 = new Intent(getApplicationContext(),admin.class);
                    startActivity(Principal2);
                    //System.out.println("succesfull");
                    finish();
                }else {
                    txtuser.setError("Nom d'utiliisateur ou le mot de passe est incorrect !");
                    txtpass.setError("Nom d'utiliisateur ou le mot de passe est incorrect !");

                }




            }
        });

    }}
