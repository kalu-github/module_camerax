package lib.kalu.camerax.executor;

import android.os.Handler;
import android.os.Looper;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;

/**
 * description: 异步
 * created by kalu on 2021-03-03
 */
public class ThreadExecutor implements Executor {

    private Handler mHandler = null;

    public ThreadExecutor() {
        this.mHandler = new Handler(Looper.myLooper());
    }

    public ThreadExecutor(Handler mHandler) {
        this.mHandler = mHandler;
    }

    @Override
    public void execute(@NotNull Runnable runnable) {

        if(null == mHandler){
            runnable = null;
        }
        else{
            mHandler.post(runnable);
        }
    }
}
