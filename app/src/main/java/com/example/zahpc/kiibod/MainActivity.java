package com.example.zahpc.kiibod;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    SoundPool.Builder soundPoolBuilder;

    AudioAttributes audioAttributes;
    AudioAttributes.Builder audioAttributesBuilder;

    AudioManager audioManager;
    float curVol, maxVol, vol;

    Button one, two, three, four, five, six, seven, eight;
    int sound_one, sound_two, sound_three, sound_four, sound_five, sound_six, sound_seven, sound_eight, cart,
            marimba_one, marimba_two, marimba_three, marimba_four, marimba_five, marimba_six, marimba_seven, marimba_eight,
            hamonica_one, hamonica_two_, hamonica_three, hamonica_four, hamonica_five, hamonica_six, hamonica_seven, hamonica_eight,
            comb_one, comb_two, comb_three, comb_four, comb_five, comb_six, comb_seven, comb_eight;

    RadioButton marimba, hamonica, comb, piano, record;

    ImageView imageView, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        CreateSoundPool();
        VolumeSounds();

        sound_one = soundPool.load(this, R.raw.c1, 1);
        sound_two = soundPool.load(this, R.raw.dm2, 1);
        sound_three = soundPool.load(this, R.raw.em3, 1);
        sound_four = soundPool.load(this, R.raw.f4, 1);
        sound_five = soundPool.load(this, R.raw.g5, 1);
        sound_six = soundPool.load(this, R.raw.am6, 1);
        sound_seven = soundPool.load(this, R.raw.bsus7, 1);
        sound_eight = soundPool.load(this, R.raw.c8, 1);

        marimba_one = soundPool.load(this, R.raw.marim_one, 1);
        marimba_two = soundPool.load(this, R.raw.marim_two, 1);
        marimba_three = soundPool.load(this, R.raw.marim_three, 1);
        marimba_four = soundPool.load(this, R.raw.marim_four, 1);
        marimba_five = soundPool.load(this, R.raw.marim_five, 1);
        marimba_six = soundPool.load(this, R.raw.marim_six, 1);
        marimba_seven = soundPool.load(this, R.raw.marim_seven, 1);
        marimba_eight = soundPool.load(this, R.raw.marim_eight, 1);

        hamonica_one = soundPool.load(this, R.raw.ham_one, 1);
        hamonica_two_ = soundPool.load(this, R.raw.ham_two, 1);
        hamonica_three = soundPool.load(this, R.raw.ham_three, 1);
        hamonica_four = soundPool.load(this, R.raw.ham_four, 1);
        hamonica_five = soundPool.load(this, R.raw.ham_five, 1);
        hamonica_six = soundPool.load(this, R.raw.ham_six, 1);
        hamonica_seven = soundPool.load(this, R.raw.ham_seven, 1);
        hamonica_eight = soundPool.load(this, R.raw.ham_eight , 1);

        comb_one = soundPool.load(this, R.raw.com_one, 1);
        comb_two = soundPool.load(this, R.raw.com_two, 1);
        comb_three = soundPool.load(this, R.raw.com_three, 1);
        comb_four = soundPool.load(this, R.raw.com_four, 1);
        comb_five = soundPool.load(this, R.raw.com_five, 1);
        comb_six = soundPool.load(this, R.raw.com_six, 1);
        comb_seven = soundPool.load(this, R.raw.com_seven, 1);
        comb_eight = soundPool.load(this, R.raw.com_eight, 1);


        one = (Button) findViewById(R.id.button1);
        two = (Button)  findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);
        five = (Button) findViewById(R.id.button5);
        six = (Button)  findViewById(R.id.button6);
        seven = (Button) findViewById(R.id.button7);
        eight = (Button) findViewById(R.id.button8);
        marimba = (RadioButton) findViewById(R.id.radio_marimba);
        hamonica = (RadioButton) findViewById(R.id.radio_hamonica);
        comb = (RadioButton) findViewById(R.id.radio_comb);
        piano = (RadioButton) findViewById(R.id.radio_piano);
        imageView=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);


        piano.setChecked(true);

        PushDownAnim.setPushDownAnimTo(one).setScale(MODE_SCALE,
                PushDownAnim.DEFAULT_PUSH_SCALE /*| PushDownAnim.DEFAULT_PUSH_STATIC  */)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawableCompat.setTint(imageView.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                DrawableCompat.setTint(imageView2.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                if (piano.isChecked()) {
                    soundPool.play(sound_one, 1, 1, 0, 0, 1);
                }
                else if (marimba.isChecked()) {
                    soundPool.play(marimba_one, 1, 1, 0, 0, 1);
                }
                else if (hamonica.isChecked()) {
                    soundPool.play(hamonica_one, 1, 1, 0, 0, 1);
                }

                else if (comb.isChecked()) {
                    soundPool.play(comb_one, 1, 1, 0, 0, 1);
                }
                else  {

                }
            }
        });

        PushDownAnim.setPushDownAnimTo(two).setScale(MODE_SCALE,
                PushDownAnim.DEFAULT_PUSH_SCALE /*| PushDownAnim.DEFAULT_PUSH_STATIC  */)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawableCompat.setTint(imageView.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorDarkGreen));
                DrawableCompat.setTint(imageView2.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorDarkGreen));
                if (piano.isChecked()) {
                    soundPool.play(sound_two, 1, 1, 0, 0, 1);
                }
                else if (marimba.isChecked()) {
                    soundPool.play(marimba_two, 1, 1, 0, 0, 1);
                }
                else if (hamonica.isChecked()) {
                    soundPool.play(hamonica_two_, 1, 1, 0, 0, 1);
                }

                else if (comb.isChecked()) {
                    soundPool.play(comb_two, 1, 1, 0, 0, 1);
                }
                else  {

                }
            }
        });

        PushDownAnim.setPushDownAnimTo(three).setScale(MODE_SCALE,
                PushDownAnim.DEFAULT_PUSH_SCALE /*| PushDownAnim.DEFAULT_PUSH_STATIC  */)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawableCompat.setTint(imageView.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                DrawableCompat.setTint(imageView2.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
                if (piano.isChecked()) {
                    soundPool.play(sound_three, 1, 1, 0, 0, 1);
                }
                else if (marimba.isChecked()) {
                    soundPool.play(marimba_three, 1, 1, 0, 0, 1);
                }
                else if (hamonica.isChecked()) {
                    soundPool.play(hamonica_three, 1, 1, 0, 0, 1);
                }

                else if (comb.isChecked()) {
                    soundPool.play(comb_three, 1, 1, 0, 0, 1);
                }
                else  {

                }
            }
        });

        PushDownAnim.setPushDownAnimTo(four).setScale(MODE_SCALE,
                PushDownAnim.DEFAULT_PUSH_SCALE /*| PushDownAnim.DEFAULT_PUSH_STATIC  */)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawableCompat.setTint(imageView.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorYellow));
                DrawableCompat.setTint(imageView2.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorYellow));
                if (piano.isChecked()) {
                    soundPool.play(sound_four, 1, 1, 0, 0, 1);
                }
                else if (marimba.isChecked()) {
                    soundPool.play(marimba_four, 1, 1, 0, 0, 1);
                }
                else if (hamonica.isChecked()) {
                    soundPool.play(hamonica_four, 1, 1, 0, 0, 1);
                }

                else if (comb.isChecked()) {
                    soundPool.play(comb_four, 1, 1, 0, 0, 1);
                }
                else  {

                }
            }
        });

        PushDownAnim.setPushDownAnimTo(five).setScale(MODE_SCALE,
                PushDownAnim.DEFAULT_PUSH_SCALE /*| PushDownAnim.DEFAULT_PUSH_STATIC  */)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawableCompat.setTint(imageView.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorPurple));
                DrawableCompat.setTint(imageView2.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorPurple));
                if (piano.isChecked()) {
                    soundPool.play(sound_five, 1, 1, 0, 0, 1);
                }
                else if (marimba.isChecked()) {
                    soundPool.play(marimba_five, 1, 1, 0, 0, 1);
                }
                else if (hamonica.isChecked()) {
                    soundPool.play(hamonica_five, 1, 1, 0, 0, 1);
                }

                else if (comb.isChecked()) {
                    soundPool.play(comb_five, 1, 1, 0, 0, 1);
                }
                else  {

                }
            }
        });

        PushDownAnim.setPushDownAnimTo(six).setScale(MODE_SCALE,
                PushDownAnim.DEFAULT_PUSH_SCALE /*| PushDownAnim.DEFAULT_PUSH_STATIC  */)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawableCompat.setTint(imageView.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
                DrawableCompat.setTint(imageView2.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
                if (piano.isChecked()) {
                    soundPool.play(sound_six, 1, 1, 0, 0, 1);
                }
                else if (marimba.isChecked()) {
                    soundPool.play(marimba_six, 1, 1, 0, 0, 1);
                }
                else if (hamonica.isChecked()) {
                    soundPool.play(hamonica_six, 1, 1, 0, 0, 1);
                }

                else if (comb.isChecked()) {
                    soundPool.play(comb_six, 1, 1, 0, 0, 1);
                }
                else  {

                }
            }
        });

        PushDownAnim.setPushDownAnimTo(seven).setScale(MODE_SCALE,
                PushDownAnim.DEFAULT_PUSH_SCALE /*| PushDownAnim.DEFAULT_PUSH_STATIC  */)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawableCompat.setTint(imageView.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorMaroon));
                DrawableCompat.setTint(imageView2.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorMaroon));
                if (piano.isChecked()) {
                    soundPool.play(sound_seven, 1, 1, 0, 0, 1);
                }
                else if (marimba.isChecked()) {
                    soundPool.play(marimba_seven, 1, 1, 0, 0, 1);
                }
                else if (hamonica.isChecked()) {
                    soundPool.play(hamonica_seven, 1, 1, 0, 0, 1);
                }

                else if (comb.isChecked()) {
                    soundPool.play(comb_seven, 1, 1, 0, 0, 1);
                }
                else  {

                }
            }
        });

        PushDownAnim.setPushDownAnimTo(eight).setScale(MODE_SCALE,
                PushDownAnim.DEFAULT_PUSH_SCALE /*| PushDownAnim.DEFAULT_PUSH_STATIC  */)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawableCompat.setTint(imageView.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorBlack));
                DrawableCompat.setTint(imageView2.getDrawable(),ContextCompat.getColor(getApplicationContext(), R.color.colorBlack));
                if (piano.isChecked()) {
                    soundPool.play(sound_eight, 1, 1, 0, 0, 1);
                }
                else if (marimba.isChecked()) {
                    soundPool.play(marimba_eight, 1, 1, 0, 0, 1);
                }
                else if (hamonica.isChecked()) {
                    soundPool.play(hamonica_eight, 1, 1, 0, 0, 1);
                }

                else if (comb.isChecked()) {
                    soundPool.play(comb_eight, 1, 1, 0, 0, 1);
                }
                else  {

                }
            }
        });


    }

    protected void VolumeSounds() {
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        curVol = (float)audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVol = (float)audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        vol = curVol / maxVol;
    }

    protected void CreateSoundPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            audioAttributesBuilder = new AudioAttributes.Builder();
            audioAttributesBuilder.setUsage(AudioAttributes.USAGE_GAME);
            audioAttributesBuilder.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
            audioAttributes=audioAttributesBuilder.build();

            soundPoolBuilder = new SoundPool.Builder();
            soundPoolBuilder.setAudioAttributes(audioAttributes);
            soundPool = soundPoolBuilder.build();
        }
        else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }

    }
}
