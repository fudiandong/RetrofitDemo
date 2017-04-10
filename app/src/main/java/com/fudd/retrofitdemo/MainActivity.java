package com.fudd.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fudd.retrofitdemo.api.GitService;
import com.fudd.retrofitdemo.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String API_BASE_URL = "https://api.github.com";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

    }
    public void getDate(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(API_BASE_URL)
                .build();
        GitService gitService = retrofit.create(GitService.class);
        Call call = gitService.getUser("fudiandong");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                User user = (User) response.body();
                textView.setText(user.getName() +"--" + user.getBlog());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                textView.setText("失败");
            }
        });

    }
}
