package com.practice.jinghua_z.mycalary.requestModel;

/**
 * Created by nancy on 10/20/18.
 */

public class GetCaloriesBodyString {
    private String voiceInput;
    public GetCaloriesBodyString(String voiceInput) {
        this.voiceInput = voiceInput;
    }

    public String getVoiceInput(){
        return voiceInput;
    }
}
