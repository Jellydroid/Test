package test.com.test;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class VariantOneActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_variant_one;

    private ImageView mIvPlay;
    private VideoView mVideoView;

    private Handler mVideoDurationHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        /* Set data */
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.f20);

        /* Find views */
        mVideoView = (VideoView) findViewById(R.id.videoView);

        mIvPlay = (ImageView) findViewById(R.id.iv_play);

        /* Set views changes */
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                runVideoDurationHandler();
            }
        });

        mIvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo();
            }
        });
    }

    private void pauseVideo() {
        mVideoView.pause();
        mIvPlay.setVisibility(View.VISIBLE);
    }

    private void playVideo() {
        mVideoView.start();
        mIvPlay.setVisibility(View.INVISIBLE);
    }

    private void runVideoDurationHandler() {
        final int DELAY = 250; // ms

        if (mVideoDurationHandler == null) {
            mVideoDurationHandler = new Handler();
        }
        mVideoDurationHandler.postDelayed(new VideoDurationRunnable(), DELAY);
    }

    class VideoDurationRunnable implements Runnable {

        final int AUTO_STOP_DURATION = 15000; // ms

        @Override
        public void run() {
            if (mVideoView.getCurrentPosition() > AUTO_STOP_DURATION) {
                pauseVideo();
            } else {
                runVideoDurationHandler();
            }
        }
    }
}
