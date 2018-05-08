package com.baeldung;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringIncrementor {

    public StringIncrementor(){

    }
    private Character[] zeroToNineArray = {'0','1','2','3','4','5','6','7','8','9'};
    private List<Character> zeroToNineList = new ArrayList<Character>(Arrays.asList(zeroToNineArray));

    public String tokenizeAndIncrement(String input){
        String token = "", result = "";
        int startingIndex = -1;
        for(int i=0;i<input.length();i++){
            char currentChar = input.charAt(i);
            if(token == "" && currentChar == '-'){
                token = "-";
                startingIndex = i;
                continue;
            }
            if(zeroToNineList.contains(currentChar)){
                token += String.valueOf(currentChar);
                if(startingIndex<0){
                    startingIndex = i;
                }
                if(i+1<input.length())
                    continue;
            }
            if(token.length()>0){
                int tokenInt = Integer.valueOf(token);
                tokenInt++;
                token = String.valueOf(tokenInt);
                result += token;
                token = "";
                startingIndex = -1;
                if(i+1<input.length())
                    result += String.valueOf(currentChar);
            }else{
                result += String.valueOf(currentChar);
            }
        }
        return result;
    }
}
