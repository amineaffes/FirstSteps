package com.example.amine.firststeps;

import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Words extends AppCompatActivity {

    ImageView imageView;
    int[] images = new int[]{R.drawable.apple2, R.drawable.ball2, R.drawable.cat2};//, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z};
    int[] sounds = new int[]{R.raw.apple, R.raw.ball, R.raw.cat};//, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.h, R.raw.i, R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.o, R.raw.p, R.raw.q, R.raw.r, R.raw.s, R.raw.t, R.raw.u, R.raw.v, R.raw.w, R.raw.x, R.raw.y, R.raw.z};
    int i=0;

    private SpeechRecognizer speech = null;
    private Intent recognizerIntent;
    private String LOG_TAG = "VoiceRecognitionActivity";
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(images[i]);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        speech = SpeechRecognizer.createSpeechRecognizer(this);
        speech.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
                Log.i(LOG_TAG, "onReadyForSpeech");
            }

            @Override
            public void onBeginningOfSpeech() {
                Log.i(LOG_TAG, "onBeginningOfSpeech");
            }

            @Override
            public void onRmsChanged(float rmsdB) {
                Log.i(LOG_TAG, "onRmsChanged: " + rmsdB);
            }

            @Override
            public void onBufferReceived(byte[] buffer) {
                Log.i(LOG_TAG, "onBufferReceived: " + buffer);
            }

            @Override
            public void onEndOfSpeech() {
                Log.i(LOG_TAG, "onEndOfSpeech");
                toggleButton.setChecked(false);
            }

            @Override
            public void onError(int error) {
                String errorMessage = getErrorText(error);
                Log.d(LOG_TAG, "FAILED " + errorMessage);
                toggleButton.setChecked(false);
            }

            @Override
            public void onResults(Bundle results) {
                Log.i(LOG_TAG, "onResults");
                ArrayList<String> matches = results
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                String text = "";
                for (String result : matches) {
                    text += result + "\n";

                }

                String x ="";
                int j;
                boolean test = false;
                switch (i) {
                    case 0:
                        for(j=0;j<matches.size();j++) {
                            if(matches.get(j).toString().toUpperCase().contains("APPLE")) {
                                test = true;
                            }
                        }
                        if(test)
                        {
                            Toast.makeText(Words.this, "Good", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Words.this, "Wrong", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        for(j=0;j<matches.size();j++) {
                            if(matches.get(j).toString().toUpperCase().contains("BALL")) {
                                test = true;
                            }
                        }
                        if(test)
                        {
                            Toast.makeText(Words.this, "Good", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Words.this, "Wrong", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        for(j=0;j<matches.size();j++) {
                            if(matches.get(j).toString().toUpperCase().contains("CAT")) {
                                test = true;
                            }
                        }
                        if(test)
                        {
                            Toast.makeText(Words.this, "Good", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Words.this, "Wrong", Toast.LENGTH_SHORT).show();
                        }
                        break;



                }

                //Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPartialResults(Bundle partialResults) {
                Log.i(LOG_TAG, "onPartialResults");
            }

            @Override
            public void onEvent(int eventType, Bundle params) {
                Log.i(LOG_TAG, "onEvent");
            }
        });
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,
                "en");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                this.getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {

                    speech.startListening(recognizerIntent);
                } else {

                    speech.stopListening();
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (speech != null) {
            speech.destroy();
            Log.i(LOG_TAG, "destroy");
        }

    }


    public void onBeginningOfSpeech() {

    }


    public void onBufferReceived(byte[] buffer) {

    }


    public void onEndOfSpeech() {

    }


    public void onError(int errorCode) {

    }


    public void onEvent(int arg0, Bundle arg1) {

    }

    public void onPartialResults(Bundle arg0) {

    }


    public void onReadyForSpeech(Bundle arg0) {

    }


    public void onResults(Bundle results) {

    }


    public void onRmsChanged(float rmsdB) {

    }

    public static String getErrorText(int errorCode) {
        String message;
        switch (errorCode) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        return message;

    }



    public void back(View view) {

        if(i>0) {
            i--;
            imageView.setImageResource(images[i]);
        }
    }


    public void playSound(View view) {

        MediaPlayer player = MediaPlayer.create(this,sounds[i]);
        player.start();
    }

    public void forward(View view) {

        if (i<2) {
            i++;
            imageView.setImageResource(images[i]);
        }
    }







}
