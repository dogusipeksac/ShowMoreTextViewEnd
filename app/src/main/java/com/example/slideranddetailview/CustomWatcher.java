package com.example.slideranddetailview;

import android.graphics.Color;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class CustomWatcher implements TextWatcher {

    int beforeChangeSize = 0, afterChangeSize = 0, cusrsorPos = 0, posOflastSpace = 0;
    String lastcursorSubString = "";


    public CustomWatcher(TextView textView){

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable editable) {



    }
}
