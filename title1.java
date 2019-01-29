package com.example.owner.with;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


public class title1 extends AppCompatActivity {
    EditText edit;
    TextView tv1;
    XmlPullParser xpp;
    String key="Km0pitW94QX5zKboPHeA7ak3tjx572i3EygG9ledB49F642EgjMP1FRgBKUNsBUcWlDa3rJFLpZqAEvOxmnubg%3D%3D";
    String data;
    String dep;
    String time;
    String a;
    StringBuffer a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8,c1,c2,c3,c4,c5,c6,c7,c8;
    ArrayList<String> midlist = new ArrayList<String>();
    ArrayAdapter<String> adapter1;
    StringBuffer[] r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20 ={};
    int i =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title1);
        LinearLayout activitymain = (LinearLayout) findViewById(R.id.activity_main);
        //TextView result = (TextView) findViewById(R.id.result);
        Button button = (Button) findViewById(R.id.button);
        setTitle("Where is the Hospital");
        StrictMode.enableDefaults();
        edit= (EditText)findViewById(R.id.edit);
        edit.setPrivateImeOptions("defaultInputmode=korean;");
        Button b1 = (Button) findViewById(R.id.b1);
        //TextView tv1 = (TextView) findViewById(R.id.tv1);
        final CheckBox c1 = (CheckBox) findViewById(R.id.c1);
        final CheckBox c2 = (CheckBox) findViewById(R.id.c2);
        final CheckBox c3 = (CheckBox) findViewById(R.id.c3);
        final CheckBox c4 = (CheckBox) findViewById(R.id.c4);
        final CheckBox c5 = (CheckBox) findViewById(R.id.c5);
        final CheckBox c6 = (CheckBox) findViewById(R.id.c6);
        final CheckBox c7 = (CheckBox) findViewById(R.id.c7);
        final CheckBox c8 = (CheckBox) findViewById(R.id.c8);
        //TextView tv1 = (TextView) findViewById(R.id.tv1);


        //text= (TextView)findViewById(R.id.result);
        final String[] departments = { "내과", "소아청소년과", "신경과", "정신건강의학과", "피부과", "외과",
                "흉부외과", "정형외과", "신경외과", "성형외과",  "산부인과", "안과", "이비인후과", "비뇨가과", "재활의학과",
                "마취통증의학과", "영상의학과", "치료방사선과", "임상병리과","해부병리과", "가정의학과","핵의학과", "응급의학과", "치과","구강악안면외과"};

        final String[] dgid = { "D001","D002","D003","D004","D005","D006","D007","D008","D009","D010",
                "D011","D012","D013","D014","D016","D017","D018","D019","D020",
                "D021","D022","D023","D024","D026","D034"
        };

        final String[] week = { "월","화","수","목","금","토","일","공휴일"
        };

        final String[] weekid = { "1","2","3","4","5","6","7","8"
        };

        ListView list = (ListView) findViewById(R.id.lv1);

        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,midlist);
        list.setAdapter(adapter1);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, departments);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                dep=dgid[arg2];
                //text.setText(dep);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c1.isChecked()==true){
                    a ="1";
                }
                if(c2.isChecked()==true){
                    a ="2";
                }
                if(c3.isChecked()==true){
                    a ="3";
                }
                if(c4.isChecked()==true){
                    a ="4";
                }
                if(c5.isChecked()==true){
                    a ="5";
                }
                if(c6.isChecked()==true){
                    a ="6";
                }
                if(c7.isChecked()==true){
                    a ="7";
                }
                if(c8.isChecked()==true){
                    a ="8";
                }
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(title1.this,result.class);
                //intent.putExtra("a1",r1[i]);
                //startActivity(intent);
            }
        });
    }


    public void mOnClick(View v){
        switch( v.getId() ){
            case R.id.button:

                //Android 4.0 이상 부터는 네트워크를 이용할 때 반드시 Thread 사용해야 함
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        data= getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                        //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                        //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                //text.setText(data); //TextView에 문자열  data 출력
                               // midlist.add(data);
                                adapter1.notifyDataSetChanged();

                            }
                        });
                    }
                }).start();

                break;
        }
    }//mOnClick method..
    //XmlPullParser를 이용하여 Naver 에서 제공하는 OpenAPI XML 파일 파싱하기(parsing)
    String getXmlData() {

        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        StringBuffer buffer3 = new StringBuffer();
        StringBuffer buffer4= new StringBuffer();

        //String str = edit.getText().toString();//EditText에 작성된 Text얻어오기
        String str = "원주시";
        String str1 = "개운동";
        String location2 = URLEncoder.encode(str1);
        String location = URLEncoder.encode(str);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding..
        String location1 = URLEncoder.encode(dep);
        //String location = URLEncoder.encode(dep);
        //String location1 = URLEncoder.encode(time);
        //String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire?"//요청 URL
                          + "&pageNo=1&numOfRows=1000&ServiceKey=" + key +"&QD=" + location1+"&Q0="+location + "&Q1="+location2;


        try {
            URL url = new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is = url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream 으로부터 xml 입력받기

            String parser;

            xpp.next();
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        //buffer.append("파싱 시작...\n\n");
                        break;
                    case XmlPullParser.START_TAG:
                        parser = xpp.getName();//테그 이름 얻어오기
                        if (parser.equals("item")) ;// 첫번째 검색결과
                        else if (parser.equals("dutyName")) { //mapy 만나면 내용을 받을수 있게 하자
                            buffer.append("기관명 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                            midlist.add(buffer.toString());
                            buffer.setLength(0);
                            //r1[i] = buffer.toString();
                            //r1[i] = xpp.getText().toString();
                        }else if (parser.equals("dutyAddr")) { //title 만나면 내용을 받을수 있게 하자
                            buffer.append("주소 : ");
                            xpp.next();
                            //midlist.add(xpp.getText()+"\n");
                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가

                        } else if (parser.equals("dutyDivNam")) { //mapx 만나면 내용을 받을수 있게 하자
                            //buffer.append("병원분류명 : ");
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyEtc")) { //mapy 만나면 내용을 받을수 있게 하자
                            buffer.append("비고 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyTel1")) { //mapy 만나면 내용을 받을수 있게 하자
                            buffer.append("대표전화 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyTime1s")) { //mapy 만나면 내용을 받을수 있게 하자
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가\
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyTime1c")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("월요일 진료 시간 : ");
                            xpp.next();
                            //buffer.append(xpp.getText()+" ~ ");//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        } else if (parser.equals("dutyTime2s")) { //mapy 만나면 내용을 받을수 있게 하자
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        }else if (parser.equals("dutyTime2c")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("화요일 진료 시간 : ");
                            xpp.next();
                            //buffer.append(xpp.getText()+" ~ ");//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        }  else if (parser.equals("dutyTime3s")) { //mapy 만나면 내용을 받을수 있게 하자
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyTime3c")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("수요일 진료 시간 : ");
                            xpp.next();
                            //buffer.append(xpp.getText()+" ~ ");//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        } else if (parser.equals("dutyTime4s")) { //mapy 만나면 내용을 받을수 있게 하자
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyTime4c")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("목요일 진료 시간 : ");
                            xpp.next();
                            //buffer.append(xpp.getText()+" ~ ");//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        }  else if (parser.equals("dutyTime5s")) { //mapy 만나면 내용을 받을수 있게 하자
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyTime5c")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("금요일 진료 시간 : ");
                            xpp.next();
                            //buffer.append(xpp.getText()+" ~ ");//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        } else if (parser.equals("dutyTime6s")) { //mapy 만나면 내용을 받을수 있게 하자
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyTime6c")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("토요일 진료 시간 : ");
                            xpp.next();
                            //buffer.append(xpp.getText()+" ~ ");//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        } else if (parser.equals("dutyTime7s")) { //mapy 만나면 내용을 받을수 있게 하자
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("dutyTime7c")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("일요일 진료 시간 : ");
                            xpp.next();
                            //buffer.append(xpp.getText()+" ~ ");//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        } else if (parser.equals("dutyTime8s")) { //mapy 만나면 내용을 받을수 있게 하자
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        }  else if (parser.equals("dutyTime8c")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("공휴일 진료 시간 : ");
                            xpp.next();
                            //buffer.append(xpp.getText()+" ~ ");//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                        } else if (parser.equals("wgs84Lon")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("병원 경도 : ");
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        } else if (parser.equals("wgs84Lat")) { //mapy 만나면 내용을 받을수 있게 하자
                            //buffer.append("병원 위도 : ");
                            xpp.next();
                            //buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            //buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        parser = xpp.getName(); //테그 이름 얻어오기
                        //buffer = null;
                        if (parser.equals("item")) i++;       // tv1.setText(buffer.toString());  //buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
                        break;
                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }

        //buffer.append("파싱 끝\n");
        return buffer.toString();//StringBuffer 문자열 객체 반환


    }
}