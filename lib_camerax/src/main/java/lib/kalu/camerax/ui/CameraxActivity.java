package lib.kalu.camerax.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import lib.kalu.camerax.R;

/**
 * description: camerax ui
 * created by kalu on 2021-03-24
 */
public class CameraxActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data", "4321");
        setResult(1234, intent);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onBackPressed();
    }

    @Override
    public void finish() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setting
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // ui
        setContentView(R.layout.lib_camerax_activity_camerax);
    }
}