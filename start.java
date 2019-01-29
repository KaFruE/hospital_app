package com.example.owner.with;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class start extends AppCompatActivity {

    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setTitle("병원???�디??);

        l1 = (LinearLayout) findViewById(R.id.l1);

        Intent inIntent = getIntent();
        int Value1 = inIntent.getIntExtra("w1",0);
        int Value2 = inIntent.getIntExtra("w2",0);
        
        l1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(start.this,title.class);
                intent.putExtra("w1", location.getLatitude());
                intent.putExtra("w2", location.getLongitude());
                startActivity(intent);
            }
        });

    }
}
