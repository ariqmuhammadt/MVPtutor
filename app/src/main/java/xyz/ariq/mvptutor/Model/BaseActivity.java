package xyz.ariq.mvptutor.Model;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AriqMT on 20/12/2017.
 */

public class BaseActivity extends AppCompatActivity{

    ApiRequest api;
    private SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);
        Retrofit base = new Retrofit.Builder()
                .baseUrl("http://192.168.8.102/mvptutor/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        api = base.create(ApiRequest.class);
    }

    public ApiRequest getApi() {
        return api;
    }
    public SharedPreferences getSp() {
        return sp;
    }
    public void makeErrorDialog(String msg) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.dismiss();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void log(String log) {
        if (true) {
            Log.d("Login",log);
        }
    }
}
