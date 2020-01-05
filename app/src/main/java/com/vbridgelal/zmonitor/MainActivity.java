package com.vbridgelal.zmonitor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.MediaPlayer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LibVLC mLibVLC = null;
    private ArrayList<VideoHelper> videoHelperArrayList;

    private LinearLayout topLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);

        topLayout = findViewById(R.id.top_layout);
        topLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), SettingsActivity.class);
                startActivity(i);

            }
        });

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

        final ArrayList<String> args = new ArrayList<>();
        args.add("-vvv");
        mLibVLC = new LibVLC(this, args);

        final ArrayList<String> streamList = new ArrayList<>();
        //streamList.add("rtsp://192.168.1.172:10554/tcp/av0_0");
        //streamList.add("rtsp://192.168.1.180:10554/tcp/av0_0");
        //streamList.add("rtsp://192.168.1.128:10554/tcp/av0_0");
        //streamList.add();
        if (pref.getString("cam1", "")!=null && (!pref.getString("cam1", "").isEmpty()))
            streamList.add(pref.getString("cam1", ""));
        if (pref.getString("cam2", "")!=null && (!pref.getString("cam2", "").isEmpty()))
            streamList.add(pref.getString("cam2", ""));
        if (pref.getString("cam3", "")!=null && (!pref.getString("cam3", "").isEmpty()))
            streamList.add(pref.getString("cam3", ""));
        if (pref.getString("cam4", "")!=null && (!pref.getString("cam4", "").isEmpty()))
            streamList.add(pref.getString("cam4", ""));

        if (streamList.size() < 4) {
            Toast.makeText(this, "tap anywhere to edit stream urls", Toast.LENGTH_LONG).show();
        }


        videoHelperArrayList = new ArrayList<>();

        MediaPlayer mMediaPlayer = null;
        VideoHelper videoHelper = null;

        int streamCount = 0;
        if (streamList.size() > streamCount) {
            //setup cam 1
            mMediaPlayer = new MediaPlayer(mLibVLC);


            videoHelper = new VideoHelper(this, mLibVLC, mMediaPlayer,
                    R.id.video_surface_frame,
                    R.id.surface_stub,
                    R.id.subtitles_surface_stub,
                    R.id.texture_stub);
            videoHelper.setVIDEO_URL(streamList.get(streamCount));
            videoHelperArrayList.add(videoHelper);

            final ProgressBar loadingBar1=findViewById(R.id.loading1);
            final MediaPlayer cam1Player=mMediaPlayer;

            loadingBar1.setVisibility(View.VISIBLE);
            mMediaPlayer.setEventListener(new MediaPlayer.EventListener() {
                float buffered=0.0f;

                @Override
                public void onEvent(MediaPlayer.Event event) {
                    if (event.type==MediaPlayer.Event.Buffering){
                        buffered=event.getBuffering();
                    }
                    if (buffered==100.0){
                        loadingBar1.setVisibility(View.GONE);
                        Log.d("EVENT",event.type+"");
                    }
                }
            });
        }
        streamCount++;

        if (streamList.size() > streamCount) {
            //setup cam 2
            mMediaPlayer = new MediaPlayer(mLibVLC);
            videoHelper = new VideoHelper(this, mLibVLC, mMediaPlayer,
                    R.id.video_surface_frame2,
                    R.id.surface_stub2,
                    R.id.subtitles_surface_stub2,
                    R.id.texture_stub2);
            videoHelper.setVIDEO_URL(streamList.get(streamCount));
            videoHelperArrayList.add(videoHelper);

            final ProgressBar loadingBar2=findViewById(R.id.loading2);
            final MediaPlayer cam2Player=mMediaPlayer;

            loadingBar2.setVisibility(View.VISIBLE);
            mMediaPlayer.setEventListener(new MediaPlayer.EventListener() {
                float buffered=0.0f;

                @Override
                public void onEvent(MediaPlayer.Event event) {
                    if (event.type==MediaPlayer.Event.Buffering){
                        buffered=event.getBuffering();
                    }
                    if (buffered==100.0){
                        loadingBar2.setVisibility(View.GONE);
                        Log.d("EVENT",event.type+"");
                    }
                }
            });
        }
        streamCount++;

        if (streamList.size() > streamCount) {
            //setup cam 3
            mMediaPlayer = new MediaPlayer(mLibVLC);
            videoHelper = new VideoHelper(this, mLibVLC, mMediaPlayer,
                    R.id.video_surface_frame3,
                    R.id.surface_stub3,
                    R.id.subtitles_surface_stub3,
                    R.id.texture_stub3);
            videoHelper.setVIDEO_URL(streamList.get(streamCount));
            videoHelperArrayList.add(videoHelper);

            final ProgressBar loadingBar3=findViewById(R.id.loading3);
            final MediaPlayer cam3Player=mMediaPlayer;

            loadingBar3.setVisibility(View.VISIBLE);
            mMediaPlayer.setEventListener(new MediaPlayer.EventListener() {
                float buffered=0.0f;

                @Override
                public void onEvent(MediaPlayer.Event event) {
                    if (event.type==MediaPlayer.Event.Buffering){
                        buffered=event.getBuffering();
                    }
                    if (buffered==100.0){
                        loadingBar3.setVisibility(View.GONE);
                        Log.d("EVENT",event.type+"");
                    }
                }
            });
        }
        streamCount++;

        if (streamList.size() > streamCount) {
            //setup cam 4
            mMediaPlayer = new MediaPlayer(mLibVLC);
            videoHelper = new VideoHelper(this, mLibVLC, mMediaPlayer,
                    R.id.video_surface_frame4,
                    R.id.surface_stub4,
                    R.id.subtitles_surface_stub4,
                    R.id.texture_stub4);
            videoHelper.setVIDEO_URL(streamList.get(streamCount));
            videoHelperArrayList.add(videoHelper);

            final ProgressBar loadingBar4=findViewById(R.id.loading4);
            final MediaPlayer cam4Player=mMediaPlayer;

            loadingBar4.setVisibility(View.VISIBLE);
            mMediaPlayer.setEventListener(new MediaPlayer.EventListener() {
                float buffered=0.0f;

                @Override
                public void onEvent(MediaPlayer.Event event) {
                    if (event.type==MediaPlayer.Event.Buffering){
                        buffered=event.getBuffering();
                    }
                    if (buffered==100.0){
                        loadingBar4.setVisibility(View.GONE);
                        Log.d("EVENT",event.type+"");
                    }
                }
            });
        }
        streamCount++;


    }

    private void setCamViewWidth(int camId, int width, int height){
        LinearLayout pcam=findViewById(camId);
        ViewGroup.LayoutParams params = pcam.getLayoutParams();
        // Changes the height and width to the specified *pixels*
        params.height = width;
        params.width = height;
        pcam.setLayoutParams(params);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (int i = 0; i < videoHelperArrayList.size(); i++) {
            videoHelperArrayList.get(i).onDestroy();
        }

        mLibVLC.release();
    }

    @Override
    protected void onStart() {
        super.onStart();

        for (int i = 0; i < videoHelperArrayList.size(); i++) {
            videoHelperArrayList.get(i).onStart();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        for (int i = 0; i < videoHelperArrayList.size(); i++) {
            videoHelperArrayList.get(i).onStop();
        }


    }

}
