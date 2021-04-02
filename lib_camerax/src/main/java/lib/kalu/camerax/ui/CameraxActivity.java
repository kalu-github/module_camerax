package lib.kalu.camerax.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

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

        // layout
        setContentView(R.layout.lib_camerax_activity_camerax);

        // ui
        ViewPager2 viewPager2 = findViewById(R.id.lib_camerax_viewpager);
        viewPager2.setUserInputEnabled(true);

        // adapter
        CameraXAdapter cameraXAdapter = new CameraXAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(cameraXAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ViewPager2 viewPager2 = findViewById(R.id.lib_camerax_viewpager);
        viewPager2.registerOnPageChangeCallback(onPageChangeCallback);
    }

    @Override
    protected void onPause() {
        super.onPause();

        ViewPager2 viewPager2 = findViewById(R.id.lib_camerax_viewpager);
        viewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
    }

    private final ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            Toast.makeText(getApplicationContext(), position+"", Toast.LENGTH_SHORT).show();
        }
    };
}