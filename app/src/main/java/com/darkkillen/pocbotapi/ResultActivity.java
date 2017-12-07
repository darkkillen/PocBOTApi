package com.darkkillen.pocbotapi;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Created by darkkillen on 12/6/2017 AD.
 */

public class ResultActivity extends Activity {

    private ImageView ivResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ivResult = findViewById(R.id.iv_result);
        String mOutputFile = getIntent().getStringExtra("mOutputFile");
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(mOutputFile,bmOptions);
        ivResult.setImageBitmap(bitmap);
    }
}
