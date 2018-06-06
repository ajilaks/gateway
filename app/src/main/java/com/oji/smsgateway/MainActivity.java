package com.oji.smsgateway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.oji.smsgateway.ActionSMS;
import com.oji.smsgateway.DataProvider;
import com.oji.smsgateway.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tanwir on 27/07/2017.
 */
public class MainActivity extends AppCompatActivity {

    public static DataService nService;
    private ActionSMS number;
    private EditText message, numberphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataProvider provider = new DataProvider();
        nService = provider.getTService();
    }

    public void btnSend(View v) {
        Toast.makeText(MainActivity.this, "Send message", Toast.LENGTH_SHORT).show();
        numberphone = (EditText) findViewById(R.id.editText);
        message = (EditText) findViewById(R.id.editText2);
        Call<List<ActionSMS>> call = nService.SendAction("17cerp", "wkwkwk",
                numberphone.getText().toString(), "asdasd"+"\nasdasd");
        call.enqueue(new Callback<List<ActionSMS>>() {
                         @Override
                         public void onResponse(Call<List<ActionSMS>> call, Response<List<ActionSMS>> response) {
                         }

                         @Override
                         public void onFailure(Call<List<ActionSMS>> call, Throwable t) {
                         }
                     }
        );
    }
}
