package com.example.merrychristmas;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private ViewFlipper viewFlipper;
    private Handler handler;
    private Runnable imageRunnable;

    private int[] christmasImages = {
        R.drawable.christmas_tree_img,
        R.drawable.christmas_gift_img,
        R.drawable.christmas_santa_img,
        R.drawable.christmas_snowman_img,
        R.drawable.christmas_bells_img,
        R.drawable.christmas_wreath_img,
        R.drawable.christmas_candy_img,
        R.drawable.christmas_stocking_img,
        R.drawable.christmas_reindeer_img,
        R.drawable.christmas_star_img,
        R.drawable.christmas_angel_img
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        setContentView(R.layout.activity_main);

        setupViewFlipper();
        startImageSlideshow();
        playChristmasMusic();
    }

    private void setupViewFlipper() {
        viewFlipper = findViewById(R.id.imageFlipper);
        viewFlipper.setInAnimation(this, android.R.anim.fade_in);
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out);
    }

    private void startImageSlideshow() {
        handler = new Handler(Looper.getMainLooper());
        imageRunnable = new Runnable() {
            @Override
            public void run() {
                viewFlipper.showNext();
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(imageRunnable, 3000);
    }

    private void playChristmasMusic() {
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.christmas_music);
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(0.5f, 0.5f);
                mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        if (handler != null && imageRunnable != null) {
            handler.removeCallbacks(imageRunnable);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
        if (handler != null && imageRunnable != null) {
            handler.postDelayed(imageRunnable, 3000);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (handler != null && imageRunnable != null) {
            handler.removeCallbacks(imageRunnable);
        }
    }
}
