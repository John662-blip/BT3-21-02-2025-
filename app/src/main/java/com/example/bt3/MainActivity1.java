package com.example.bt3;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity1 extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void ShowPopupMenu(){
        Button btnButton = (Button)findViewById(R.id.btnButton) ;
        PopupMenu popupMenu = new PopupMenu(this,btnButton);
        popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menuSetting){
                    Toast.makeText(MainActivity1.this,"Bạn đang chọn Setting",Toast.LENGTH_LONG).show();
                }
                else
                if (item.getItemId() == R.id.menuShare){
                    btnButton.setText("Chia sẻ");
                }
                else
                if (item.getItemId() == R.id.menuLogout){

                }
                return false;
            }
        });
        popupMenu.show();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuSetting){

        }
        else
        if (item.getItemId() == R.id.menuShare){

        }
        else
        if (item.getItemId() == R.id.menuLogout){

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.vdimageview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView img1= (ImageView)
                findViewById(R.id.imageView1);
        img1.setImageResource(R.drawable.pop_2);

        ConstraintLayout bg = (ConstraintLayout)
                findViewById(R.id.main);
        bg.setBackgroundColor(Color.BLUE);
        bg.setBackgroundResource(R.drawable.background);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.background);
        arrayList.add(R.drawable.background1);
        arrayList.add(R.drawable.background2);
        arrayList.add(R.drawable.background3);
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));

        ImageButton img2 = (ImageButton)
                findViewById(R.id.imageButton1);
        img2.setBackgroundResource(R.drawable.on);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.pizza);
                img1.getLayoutParams().width=550;
                img1.getLayoutParams().height=550;
            }
        });
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ //isChecked = true
                    Toast.makeText(MainActivity1.this,"Wifi đang bật",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity1.this,"Wifi đang tắt",Toast.LENGTH_LONG).show();
                }
            }
        });

        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox);
        ck1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                       @Override
                       public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                       {
                           if(isChecked){
                               bg.setBackgroundResource(R.drawable.background2);
                           }else{
                               bg.setBackgroundResource(R.drawable.background3);
                           }
                       }
                   });
        RadioGroup radioGroup = (RadioGroup)
                findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(
            new RadioGroup.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(RadioGroup group,
                                               int checkedId)
                  {
                      if (checkedId == R.id.radioButton){
                          bg.setBackgroundResource(R.drawable.background);
                      }
                      else{
                          bg.setBackgroundResource(R.drawable.background1);
                      }
                  }
              });
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
                        if (current>= progressBar.getMax()){
                            current=0;
                        }
                        progressBar.setProgress(current + 10); //thiết lập progress
                    }
                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity1.this,"Hết giờ",Toast.LENGTH_LONG).show();
                    }
                };
                countDownTimer.start();
            }
        });

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//progress: giá trị của seekbar
                Log.d("AAA","Giá trị:" + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Start");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Stop");
            }}
        );
        Button btn = (Button) findViewById(R.id.btnButton);
        btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowPopupMenu();
                }
            }
);
}
}
