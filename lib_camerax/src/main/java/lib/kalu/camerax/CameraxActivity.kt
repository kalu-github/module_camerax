package lib.kalu.camerax

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class CameraxActivity : AppCompatActivity() {

    override fun onBackPressed() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onBackPressed()
    }

    override fun finish() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.lib_camerax_activity_camerax)
    }
}
