package com.example.two_wheeler_schedule_management_system;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.riyagayasen.easyaccordion.AccordionView;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        AccordionView accordionView = (AccordionView) findViewById(R.id.first_accordion);
        TextView textView = (TextView) accordionView.findViewById(R.id.firstans);
        textView.setText("This is a demo accordion with text added dynamically This is a demo accordion with text added dynamically This is a demo accordion with text added dynamically This is a demo accordion with text added dynamically This is a demo accordion with text added dynamically This is a demo accordion with text added dynamically This is a demo accordion with text added dynamically");
    }
}
