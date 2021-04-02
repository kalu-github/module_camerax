package lib.kalu.camerax.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;

import lib.kalu.camerax.ui.fragment.CameraFragment;
import lib.kalu.camerax.ui.fragment.VideoFragment;

/**
 * description:
 * created by kalu on 2021-04-02
 */
public class CameraXAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {

    private CameraXAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    private CameraXAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public CameraXAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? new CameraFragment() : new VideoFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
