package android.com.padhlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
    TextView img;
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        img = (TextView)findViewById(R.id.splash_image);
        fadeOutAndHideImage(img);

    }
    // Create a method called fadeOutAndHideImage that takes in an ImageView
    private void fadeOutAndHideImage(final TextView img)
    {
        // Fade Animation code
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(5000); // How long it takes for the animation to complete in milliseconds

        fadeOut.setAnimationListener(new Animation.AnimationListener()
        {
            // Once the animation is done, set the visibility of the logo to GONE and navigate to the MainActivity after the set amount of time.
            public void onAnimationEnd(Animation animation)
            {
                img.setVisibility(View.GONE);

                /* New Handler to start the Menu-Activity
                 * and close this Splash-Screen after some seconds.*/
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        /* Create an Intent that will start the Menu-Activity. */
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();

                    }
                }, SPLASH_DISPLAY_LENGTH);
            }
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationStart(Animation animation) {}
        });

        img.startAnimation(fadeOut);
    }
}