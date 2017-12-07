package com.darkkillen.pocbotapi;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.darkkillen.pocbotapi.model.Data;
import com.darkkillen.pocbotapi.model.DataDetail;
import com.darkkillen.pocbotapi.model.ExchangeRateModel;
import com.google.gson.Gson;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnCall;
    private Button btnShoot;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private final int REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION = 101;
    private File output=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCall = findViewById(R.id.btn_call);
        btnShoot = findViewById(R.id.btn_shoot);
        btnShoot.setEnabled(false);
        requestPermission();
        btnShoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ExchangeRateModel> call = HttpManager.getInstance().getService().getExchangeRate(
                        Constant.APIKEY,
                        "2017-06-30", // startDate
                        "2017-06-30"  // endDate
                );
                call.enqueue(new Callback<ExchangeRateModel>() {
                    @Override
                    public void onResponse(@NonNull Call<ExchangeRateModel> call, @NonNull Response<ExchangeRateModel> response) {
                        if (response.isSuccessful()) {
                            // 2oo
                            ExchangeRateModel rawData = response.body();
                            if (rawData != null && rawData.getResult() != null && rawData.getResult().getData() != null) {
                                Data data = rawData.getResult().getData(); //  using this data
                                for (DataDetail currency : data.getDataDetail()) {
                                    if (currency.getCurrencyId().equals("USD")) {
                                        String buyingTransferOfUSD = currency.getBuyingTransfer();
                                    }
                                }
                                Gson gson = new Gson();
                                String json = gson.toJson(data);
                                saveLatestData(json);
                            }
//
                        } else {
                            // body null
                            Data data = getLatestCurrency();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ExchangeRateModel> call, @NonNull Throwable t) {
                        // 400+, 500+
                        Data data = getLatestCurrency();
                    }
                });
            }
        });
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            btnShoot.setEnabled(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btnShoot.setEnabled(true);
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    requestPermission(); // request until granted.
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void saveLatestData(String json) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("currency",json);
        editor.apply();
    }

    private Data getLatestCurrency() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String json = preferences.getString("currency", "");
        return new Gson().fromJson(json, Data.class);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        output=new File(dir, "PocBotApi" + timeStamp + ".jpeg");
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                FileProvider.getUriForFile(MainActivity.this,
                BuildConfig.APPLICATION_ID + ".provider",
                output));
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Intent i = new Intent(MainActivity.this, ResultActivity.class);
            i.putExtra("mOutputFile", output.getAbsolutePath());
            startActivity(i);
        }
    }

}
