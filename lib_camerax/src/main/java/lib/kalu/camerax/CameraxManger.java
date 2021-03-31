package lib.kalu.camerax;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import lib.kalu.camerax.ui.CameraxActivity;

/**
 * description: CameraxManger
 * created by kalu on 2021-03-24
 */
@Keep
public final class CameraxManger {

    @SuppressLint("Range")
    public final static void startActivity(@NonNull Fragment fragment) {

        Context context = fragment.getContext();
        Intent intent = new Intent(context, CameraxActivity.class);
        fragment.startActivity(intent);
    }

    public final static void startActivityForResult(@NonNull Fragment fragment,
                                                    @IntRange(from = 1000, to = 10000) int requestCode) {

        Context context = fragment.getContext();
        Intent intent = new Intent(context, CameraxActivity.class);
        fragment.startActivityForResult(intent, requestCode);
    }

    @SuppressLint("Range")
    public final static void startActivity(@NonNull Activity activity) {

        Context context = activity.getApplicationContext();
        Intent intent = new Intent(context, CameraxActivity.class);
        activity.startActivity(intent);
    }

    public final static void startActivityForResult(@NonNull Activity activity,
                                                    @IntRange(from = 1000, to = 10000) int requestCode) {

        Context context = activity.getApplicationContext();
        Intent intent = new Intent(context, CameraxActivity.class);

        activity.startActivityForResult(intent, requestCode);
    }

    public final static void startActivityForResult(@NonNull AppCompatActivity activity,
                                                    @IntRange(from = 1000, to = 10000) int requestCode) {

        Context context = activity.getApplicationContext();
        Intent intent = new Intent(context, CameraxActivity.class);

        activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent data = result.getData();
                String extra = data.getStringExtra("data");
                int resultCode = result.getResultCode();
                Toast.makeText(context, extra + "--" + resultCode, Toast.LENGTH_SHORT).show();
            }
        }).launch(intent);
    }

    @Keep
    public final static class Build {

        private boolean isVideo = true;
        private boolean isImage = true;
    }
}
