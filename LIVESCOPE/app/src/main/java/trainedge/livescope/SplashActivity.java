package trainedge.livescope;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView ivLogo = (ImageView) findViewById(R.id.ivLogo);
        ivLogo.animate().setDuration(1500).setInterpolator(new BounceInterpolator())
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setStartDelay(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Intent goToMainActivity = new Intent(SplashActivity.this, login.class);
                        goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(goToMainActivity);
                        finish();
                    }
                });

    }
}
