package test.com.test;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class VariantTwoActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_variant_two;

    private VideoView mVideoView;
    private ImageView mIvPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        /* Find views */
        mVideoView = (VideoView) findViewById(R.id.videoView);

        mIvPlay = (ImageView) findViewById(R.id.iv_play);

        /* Set views changes */
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mIvPlay.setVisibility(View.VISIBLE);
            }
        });

        mIvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvPlay.setVisibility(View.INVISIBLE);
                playShortVideo();
            }
        });

        playLongVideo();
    }

    private void playLongVideo() {
        Uri longVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.f20);
        mVideoView.setVideoURI(longVideoUri);
        mVideoView.start();
    }

    private void playShortVideo() {
        Uri shortVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.f10);
        mVideoView.setVideoURI(shortVideoUri);
        mVideoView.start();
    }
}
