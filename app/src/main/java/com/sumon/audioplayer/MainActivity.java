package com.sumon.audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play,stop,next;
    TextView tv;
    MediaPlayer mediaPlayer;
    String[] songs ={"emotional","song1","song2","song3","song4","song5"};
    int pauseCourentPosition,songNo=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.btn1);
        next=findViewById(R.id.btn2);
        stop=findViewById(R.id.btn3);
        tv=findViewById(R.id.tv);
        play.setOnClickListener(this);
        next.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

          switch (view.getId()){
              case R.id.btn2:
                  songNo++;
                  tv.setText("Please on play/pause");
                  mediaPlayer.stop();
                  //tv.setTextColor(999000);
                  mediaPlayer=null;
                  if(songNo>5){
                      songNo=0;
                  }
                  break;
              case R.id.btn1:
                  next.setText("next");
                  if(mediaPlayer==null){
                      switch (songNo){
                          case 0: mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.emotional);
                              mediaPlayer.start();
                              tv.setText("Emotional(Kolkata)");
                              play.setText("pause");
                              break;

                          case 1: mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.song1);
                              mediaPlayer.start();
                              play.setText("pause");
                              tv.setText("Teri mohabbatne dilme maka(hindi)");
                              break;

                          case 2: mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.song2);
                              mediaPlayer.start();
                              play.setText("pause");
                              tv.setText("Porena chokher polok");
                              break;

                          case 3: mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.song3);
                              mediaPlayer.start();
                              play.setText("pause");
                              tv.setText("");
                              break;
                          case 4: mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.song4);
                              mediaPlayer.start();
                              play.setText("pause");
                              tv.setText("Tumi ki dekhecho kovu(bangla)");
                              break;

                          case 5: mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.song5);
                              mediaPlayer.start();
                              play.setText("pause");
                              tv.setText("Hal yeh dil (hindi)");
                              break;
                         }
                      }

                  else if(!mediaPlayer.isPlaying()){
                      mediaPlayer.seekTo(pauseCourentPosition);
                      mediaPlayer.start();
                      play.setText("pause");
                  }
                  else if(mediaPlayer!=null){
                      mediaPlayer.pause();
                      pauseCourentPosition=mediaPlayer.getCurrentPosition();
                      play.setText("play");
                  }
                  break;

              case R.id.btn3:
                  if(mediaPlayer!=null){
                      mediaPlayer.stop();
                      mediaPlayer=null;
                      play.setText("play");
                      songNo=0;
                  }
                  break;
          }
    }
}
