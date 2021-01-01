package com.example.bcspreparations.syllabuses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.bcspreparations.R;

public class SyllabusMath extends AppCompatActivity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_math);
        setTitle("গণিত সিলেবাস");
    }
}
