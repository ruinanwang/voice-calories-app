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

//API call import
import com.practice.jinghua_z.mycalary.httpService.GetCaloriesService;
import com.practice.jinghua_z.mycalary.requestModel.GetCaloriesBodyString;
import com.practice.jinghua_z.mycalary.responseModel.GetCaloriesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    protected static final int RESULT_SPEECH = 1;
    private ImageView imageView;
    private TextView txtText;
    private Button voice_button, voice_clear;

    private static final String baseUrl = "http://10.0.2.2:8000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voice_button = (Button) findViewById(R.id.voice_button);
//        voice_clear = (Button) findViewById(R.id.voice_clear);
        txtText = (TextView) findViewById(R.id.textView2);

        getCalories("one cup of coffee");


//        voice_clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                backingString.setBackinng_aud("");
//                txtText.setText(" Output what you said :)");
//            }
//        });

        voice_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    txtText.setText("");
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
//                    if (text.get(0) != null) {
//                        backingString.add(1, text.get(0) + ". ");
//                        txtText.setText(backingString.getBackinng_aud());
//                    }
                    break;
                }
            }
        }
    }

    public void getCalories(String voiceInput) {

        Log.d("nancy", "inside getCalories()");

        Retrofit getCaloriesRetrofit = new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        GetCaloriesService getCaloriesService = getCaloriesRetrofit.create(GetCaloriesService.class);
        GetCaloriesBodyString getCaloriesBodyString = new GetCaloriesBodyString(voiceInput);
        Call<GetCaloriesResponse> getCaloriesResponse = getCaloriesService.getCalories("application/json",getCaloriesBodyString);

//        Log.d("nancy bodyString", getCaloriesBodyString.getVoiceInput());

        getCaloriesResponse.enqueue(new Callback<GetCaloriesResponse>() {
            @Override
            public void onResponse(Call<GetCaloriesResponse> call, Response<GetCaloriesResponse> response) {
                Log.d("nancy", response.toString());
                if (response.body() != null) {
                    Log.d("nancy", Integer.toString(response.body().getCalorie()));
                    int calorie = response.body().getCalorie();
                }
            }

            @Override
            public void onFailure(Call<GetCaloriesResponse> call, Throwable t) {
                Log.d("nancy error", t.toString());
            }
        });

    }


}
