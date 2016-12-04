package com.example.honey.application;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutView1, linearLayoutChild, linearLayoutChild1, linearLayoutView2;
    TextView textView;
    ScrollView scrollView;
    Button button, button1, button2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Note here we didnt added setcontentview it is added at bottom

        //VIEW 2
        linearLayoutView2 = new LinearLayout(this);
        linearLayoutView2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayoutView2.setOrientation(LinearLayout.VERTICAL);
        linearLayoutView2.setWeightSum(1);


        editText = new EditText(this);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.99F);
        layoutParams5.setMargins(10, 5, 10, 5);
        editText.setLayoutParams(layoutParams5);
        editText.setGravity(Gravity.CENTER);


        button2 = new Button(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.01F);
        layoutParams6.setMargins(10, 5, 10, 10);
        button2.setLayoutParams(layoutParams6);
        button2.setText("VIEW 1");
        button2.setTextColor(getResources().getColor(R.color.colorAccent));
        button2.setBackgroundColor(Color.parseColor("#eeeeee"));

        linearLayoutView2.addView(editText);
        linearLayoutView2.addView(button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(linearLayoutView1);
            }
        });


        //VIEW 1
        linearLayoutView1 = new LinearLayout(this);
        linearLayoutView1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayoutView1.setOrientation(LinearLayout.VERTICAL);
        linearLayoutView1.setWeightSum(100);

        scrollView = new ScrollView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 99);
        scrollView.setLayoutParams(layoutParams);


        linearLayoutChild = new LinearLayout(this);
        linearLayoutChild.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayoutChild.setOrientation(LinearLayout.VERTICAL);
        linearLayoutChild.setPadding(5, 5, 5, 5);

        linearLayoutChild1 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        linearLayoutChild1.setLayoutParams(layoutParams1);
        linearLayoutChild1.setWeightSum(1);
        linearLayoutChild1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutChild1.setPadding(5, 5, 5, 5);


        button = new Button(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.5F);
        layoutParams2.setMargins(5, 5, 5, 5);
        button.setLayoutParams(layoutParams2);
        button.setText("ADD");
        button.setTextColor(getResources().getColor(R.color.colorAccent));
        button.setBackgroundColor(Color.parseColor("#eeeeee"));

        button1 = new Button(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.5F);
        layoutParams3.setMargins(5, 5, 5, 5);
        button1.setLayoutParams(layoutParams3);
        button1.setText("VIEW 2");
        button1.setTextColor(getResources().getColor(R.color.colorAccent));
        button1.setBackgroundColor(Color.parseColor("#eeeeee"));

        //Adding scrollview to root
        linearLayoutView1.addView(scrollView);
        linearLayoutView1.addView(linearLayoutChild1);

        //Adding linearlayout child to scrollview
        scrollView.addView(linearLayoutChild);


        //Adding button to its root
        linearLayoutChild1.addView(button);
        linearLayoutChild1.addView(button1);

        //Finally set content view to linear layout
        setContentView(linearLayoutView1);

        final LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50);
        layoutParams4.setMargins(5, 5, 5, 5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = new TextView(getApplicationContext());
                textView.setLayoutParams(layoutParams4);
                textView.setBackgroundColor(Color.parseColor("#80d8ff"));
                textView.setGravity(Gravity.CENTER);
                scrollView.fullScroll(View.FOCUS_DOWN);
                linearLayoutChild.addView(textView);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(linearLayoutView2);
            }
        });



    }
}
