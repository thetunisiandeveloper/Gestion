package tn.yoodev.gestion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tn.yoodev.gestion.Connection.RetrofitInstance;

public class add extends AppCompatActivity {
    private EditText etcode, etmarque;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);






        etcode = findViewById(R.id.fcode);
        etmarque = findViewById(R.id.fmarque);
        btn = findViewById(R.id.btnadd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

    }


    private void insertData() {
        String code = etcode.getText().toString().trim();
        String marque = etmarque.getText().toString().trim();

        if (code.isEmpty()) {
            etcode.setError("Enter name");
            etcode.requestFocus();
            return;
        }
        if (marque.isEmpty()) {
            etmarque.setError("enter email");
            etmarque.requestFocus();
            return;
        }
        Call<ResponseBody> call = RetrofitInstance.getInstance().getMyApi().insertdata(code, marque);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}
