package lib.kalu.camerax;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
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

        startActivityForResult(fragment, 0);
    }


    public final static void startActivityForResult(@NonNull Fragment fragment,
                                                    @IntRange(from = 1000, to = 10000) int requestCode) {

        Context context = fragment.getContext();
        Intent intent = new Intent(context, CameraxActivity.class);

        if (requestCode == 0) {
            fragment.startActivity(intent);
        } else {
            fragment.startActivityForResult(intent, requestCode);
        }
    }

    @SuppressLint("Range")
    public final static void startActivity(@NonNull Activity activity) {

        startActivityForResult(activity, 0);
    }

    public final static void startActivityForResult(@NonNull Activity activity,
                                                    @IntRange(from = 1000, to = 10000) int requestCode) {

        Context context = activity.getApplicationContext();
        Intent intent = new Intent(context, CameraxActivity.class);

        if (requestCode == 0) {
            activity.startActivity(intent);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    @Keep
    public final static class Build {

        private boolean isVideo = true;
        private boolean isImage = true;
    }
}
