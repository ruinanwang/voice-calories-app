package com.practice.jinghua_z.mycalary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {

    protected static final int RESULT_SPEECH = 1;
    private TextView txtText, txtTextInt;
    private Button voice_button;
    private int total_calaries = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voice_button = (Button) findViewById(R.id.voice_button);
        txtTextInt = (TextView) findViewById(R.id.textView1);
        txtText = (TextView) findViewById(R.id.textView2);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/handwriting.ttf");
        txtText.setTypeface(font);
        txtText.setText(Integer.toString(total_calaries));


        voice_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                } catch (ActivityNotFoundException a) {
                    Log.d("tag", a.toString());
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtText.setText(total_calaries);
                    break;
                }
            }
        }
    }


}
