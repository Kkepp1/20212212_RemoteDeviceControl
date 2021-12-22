package com.example.a11_9_2021_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    CardView cardt1,cardt2,cardt3,cardp1,cardp2,cardp3,cardq1,cardq2;
    TextView ttt1,ttt2,ttt3,ttp1,ttp2,ttp3,ttq1,ttq2,textView1,texttemp,texthumidity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardt1 = (CardView) findViewById(R.id.cardt1);
        cardt2 = (CardView) findViewById(R.id.cardt2);
        cardt3 = (CardView) findViewById(R.id.cardt3);
        cardp1 = (CardView) findViewById(R.id.cardp1);
        cardp2 = (CardView) findViewById(R.id.cardp2);
        cardp3 = (CardView) findViewById(R.id.cardp3);
        cardq1 = (CardView) findViewById(R.id.cardq1);
        cardq2 = (CardView) findViewById(R.id.cardq2);
        ttt1 = (TextView)findViewById(R.id.ttt1);
        ttt2 = (TextView)findViewById(R.id.ttt2);
        ttt3 = (TextView)findViewById(R.id.ttt3);
        ttp1 = (TextView)findViewById(R.id.ttp1);
        ttp2 = (TextView)findViewById(R.id.ttp2);
        ttp3 = (TextView)findViewById(R.id.ttp3);
        ttq1 = (TextView)findViewById(R.id.ttq1);
        ttq2 = (TextView)findViewById(R.id.ttq2);
        textView1 = (TextView)findViewById(R.id.textView1);
        texttemp = (TextView)findViewById(R.id.texttemp);
        texthumidity = (TextView)findViewById(R.id.texthumidity);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference denT1 = database.getReference("denT1");
        DatabaseReference denT2 = database.getReference("denT2");
        DatabaseReference denT3 = database.getReference("denT3");
        DatabaseReference denP1 = database.getReference("denP1");
        DatabaseReference denP2 = database.getReference("denP2");
        DatabaseReference denP3 = database.getReference("denP3");
        DatabaseReference quat1 = database.getReference("quat1");
        DatabaseReference quat2 = database.getReference("quat2");
        DatabaseReference mydata = FirebaseDatabase.getInstance().getReference();

//////////// den trai khi nhán nút
        cardt1.setOnClickListener(new View.OnClickListener() {
            Boolean ttcardt1 = false;
            @Override
            public void onClick(View view) {
                ttcardt1 = !ttcardt1;
                if (ttcardt1==true){
                    cardt1.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttt1.setText("Bật");
                    denT1.setValue("bat");
                }else {
                    cardt1.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttt1.setText("Tắt");
                    denT1.setValue("tat");
                }
            }

        });

        cardt2.setOnClickListener(new View.OnClickListener() {
            Boolean ttcardt2 = false;
            @Override
            public void onClick(View view) {
                ttcardt2 = !ttcardt2;
                if (ttcardt2==true){
                    cardt2.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttt2.setText("Bật");
                    denT2.setValue("bat");
                }else {
                    cardt2.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttt2.setText("Tắt");
                    denT2.setValue("tat");
                }
            }

        });
        cardt3.setOnClickListener(new View.OnClickListener() {
            Boolean ttcardt3 = false;
            @Override
            public void onClick(View view) {
                ttcardt3 = !ttcardt3;
                if (ttcardt3==true){
                    cardt3.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttt3.setText("Bật");
                    denT3.setValue("bat");
                }else {
                    cardt3.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttt3.setText("Tắt");
                    denT3.setValue("tat");
                }
            }

        });

    /////////// khi ấn nút ấn ở giữa
        cardp1.setOnClickListener(new View.OnClickListener() {
            Boolean ttcardp1 = false;
            @Override
            public void onClick(View view) {
                ttcardp1 = !ttcardp1;
                if (ttcardp1==true){
                    cardp1.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttp1.setText("Bật");
                    denP1.setValue("bat");
                }else {
                    cardp1.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttp1.setText("Tắt");
                    denP1.setValue("tat");
                }
            }

        });
        cardp2.setOnClickListener(new View.OnClickListener() {
            Boolean ttcardp2 = false;
            @Override
            public void onClick(View view) {
                ttcardp2 = !ttcardp2;
                if (ttcardp2==true){
                    cardp2.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttp2.setText("Bật");
                    denP2.setValue("bat");
                }else {
                    cardp2.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttp2.setText("Tắt");
                    denP2.setValue("tat");
                }
            }

        });
        cardp3.setOnClickListener(new View.OnClickListener() {
            Boolean ttcardp3 = false;
            @Override
            public void onClick(View view) {
                ttcardp3 = !ttcardp3;
                if (ttcardp3==true){
                    cardp3.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttp3.setText("Bật");
                    denP3.setValue("bat");
                }else {
                    cardp3.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttp3.setText("Tắt");
                    denP3.setValue("tat");
                }
            }

        });
        ////////// khi ấn vào nút quạt bên phải
        cardq1.setOnClickListener(new View.OnClickListener() {
            Boolean ttcardq1 = false;
            @Override
            public void onClick(View view) {
                ttcardq1 = !ttcardq1;
                if (ttcardq1==true){
                    cardq1.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttq1.setText("Bật");
                    quat1.setValue("bat");
                }else {
                    cardq1.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttq1.setText("Tắt");
                    quat1.setValue("tat");
                }
            }

        });
        cardq2.setOnClickListener(new View.OnClickListener() {
            Boolean ttcardq2 = false;
            @Override
            public void onClick(View view) {
                ttcardq2 = !ttcardq2;
                if (ttcardq2==true){
                    cardq2.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttq2.setText("Bật");
                    quat2.setValue("bat");
                }else {
                    cardq2.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttq2.setText("Tắt");
                    quat2.setValue("tat");
                }
            }

        });
///////////////////////////////////////////////////////////////////////đọc trạng thái từ firebase
        ///////////////cập nhật trạng thái ở giữa
        mydata.child("denP1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("bat")){
                    cardp1.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttp1.setText("Bật");
                }else if(snapshot.getValue().toString().equals("tat")){
                    cardp1.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttp1.setText("Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mydata.child("denP2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("bat")){
                    cardp2.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttp2.setText("Bật");
                }else if(snapshot.getValue().toString().equals("tat")){
                    cardp2.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttp2.setText("Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mydata.child("denP3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("bat")){
                    cardp3.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttp3.setText("Bật");
                }else if(snapshot.getValue().toString().equals("tat")){
                    cardp3.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttp3.setText("Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
      ///////////// khi nhấn vào bên trai
        mydata.child("denT1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("bat")){
                    cardt1.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttt1.setText("Bật");
                }else if(snapshot.getValue().toString().equals("tat")){
                    cardt1.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttt1.setText("Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mydata.child("denT2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("bat")){
                    cardt2.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttt2.setText("Bật");
                }else if(snapshot.getValue().toString().equals("tat")){
                    cardt2.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttt2.setText("Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mydata.child("denT3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("bat")){
                    cardt3.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttt3.setText("Bật");
                }else if(snapshot.getValue().toString().equals("tat")){
                    cardt3.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttt3.setText("Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /////////// khi nhấn vào nút quạt
        mydata.child("quat1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("bat")){
                    cardq1.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttq1.setText("Bật");
                }else if(snapshot.getValue().toString().equals("tat")){
                    cardq1.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttq1.setText("Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mydata.child("quat2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("bat")){
                    cardq2.setCardBackgroundColor(Color.parseColor("#88EA8C"));
                    ttq2.setText("Bật");
                }else if(snapshot.getValue().toString().equals("tat")){
                    cardq2.setCardBackgroundColor(Color.parseColor("#A15A5252"));
                    ttq2.setText("Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /////// khi nhấn thể hiện trạng thái kết nối wifi
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "Đã kết nối";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        });
        ////////////////////////////cập nhật nhiêt độ độ ẩm
        mydata.child("temp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                texttemp.setText(snapshot.getValue().toString() + "°C ");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mydata.child("humidity").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                texthumidity.setText(snapshot.getValue().toString()+ "%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//////////////////////////////////////////////////////////////////////// buttom navigation
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.m1);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id){
                    //check id
                    case R.id.m1:
                    case R.id.m2:
                        startActivity(new Intent(getApplicationContext(),m2.class));
                        finish();
                        overridePendingTransition(0,0);
                }
                return true;
            }
        });
    }
}