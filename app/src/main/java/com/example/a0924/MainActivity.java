package com.example.a0924;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    RadioButton r1,r2;
    TextView ta;
    EditText ed1,ed2;
    Spinner sp;
    ListView li;
    String s1[]={"1학년","3학년","5학년"};
    String s2[]={"상","중","하"};

    //가져올 값
    String v;//level
    int num,result;//grade
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinner_choose the grade
        sp = (Spinner) findViewById(R.id.sp);
        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,s1);
        sp.setAdapter(ad1);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0) num=10; //1
                else if(i==1) num=20; //3
                else num=30; //5

            }

            @Override

            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        //ListView choose  the level
        li = (ListView) findViewById(R.id.li);
        ArrayAdapter<String> ad2=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s2);
        li.setAdapter(ad2);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0) v="상:";
                else if(i==1) v="중:";
                else v="하";

            }

        });


        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new Op());
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        ta=(TextView)findViewById(R.id.ta);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                String s=ed2.getText().toString().trim();
                int is=Integer.parseInt(s);
                String n=ed1.getText().toString();
                String r;

                if(result==is) r=n+"정답";
                else r=n+"오답";

                Intent it=new Intent(getApplication(),sub.class);
                it.putExtra("toss",r);
                startActivity(it);

            }

        });
    }//onCreate

    class Op implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(r1.isChecked()){
                int n1=(int)(Math.random()*num+1);
                int n2=(int)(Math.random()*num+1);
                result=n1+n2;
                ta.setText(v+n1+"+"+n2);
            }else{
                int n1=(int)(Math.random()*num+1);
                int n2=(int)(Math.random()*num+1);
                result=n1*n2;
                ta.setText(v+n1+"*"+n2);
            }//else
            //ta print

        }//onClick
    }//Op

}//class