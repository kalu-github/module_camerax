package lib.kalu.camerax.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * description: 异步
 * created by kalu on 2021-03-03
 */
public final class MainExecutor extends ThreadExecutor {

    public MainExecutor() {
        super(new Handler(Looper.getMainLooper()));
    }
}
