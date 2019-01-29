package com.example.owner.with;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class title extends AppCompatActivity {

    ImageButton iv1,iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        setTitle("Where is the Hospital");

        iv1 = (ImageButton) findViewById(R.id.iv1);
        iv2 = (ImageButton) findViewById(R.id.iv2);


        iv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(),map.class);
                //Intent intent = new Intent(getApplicationContext(),result1.class);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ywmc.or.kr/web/www/medical_office")));
            }
        });

        iv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent inIntent = getIntent();
                int Value1 = inIntent.getIntExtra("w1",0);
                int Value2 = inIntent.getIntExtra("w2",0);

                Intent intent = new Intent(title.this,title1.class);
                intent.putExtra("w1", location.getLatitude());
                intent.putExtra("w2", location.getLongitude());
                startActivity(intent);
            }
        });
    }
}
