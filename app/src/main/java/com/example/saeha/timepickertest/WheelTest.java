package com.example.saeha.timepickertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.List;

public class WheelTest extends AppCompatActivity implements WheelPicker.OnItemSelectedListener{
    private WheelPicker main_wheel_hour;
    private WheelPicker main_wheel_ampm;
    private WheelPicker main_wheel_min;

    List<String> ampmStr = new ArrayList<>();
    List<Integer> hourNumber;
    List<String> minNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_test);
        main_wheel_ampm = (WheelPicker)findViewById(R.id.main_wheel_ampm);
        main_wheel_ampm.setOnItemSelectedListener(this);
        main_wheel_hour = (WheelPicker)findViewById(R.id.main_wheel_hour);
        main_wheel_hour.setOnItemSelectedListener(this);
        main_wheel_min = (WheelPicker)findViewById(R.id.main_wheel_min);
        main_wheel_min.setOnItemSelectedListener(this);

        //오전 오후 set
        ampmStr.add("오전");
        ampmStr.add("오후");
        main_wheel_ampm.setData(ampmStr);

        // 시간 set
        hourNumber = new ArrayList<>();
        for(int i = 0; i<13;i++){
            hourNumber.add(i);
        }
        main_wheel_hour.setData(hourNumber);

        // 분 set
        minNumber = new ArrayList<>();
        for(int i = 0; i<60;i++){
            if(i<10){
                minNumber.add("0".concat(String.valueOf(i)));
            }else{
                minNumber.add(String.valueOf(i));
            }
        }
        main_wheel_min.setData(minNumber);


        // wheel 특정 포지션 지정
        main_wheel_min.setSelectedItemPosition(50);

//      koltlin
//      main_wheel_min.selectedItemPosition = 50

    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        String text = "";
        switch (picker.getId()) {
            case R.id.main_wheel_ampm:
                text = "Left:";
                break;
            case R.id.main_wheel_hour:
                text = "Center:";
                break;
            case R.id.main_wheel_min:
                text = "Right:";
                break;
        }
        Toast.makeText(this, text + String.valueOf(data), Toast.LENGTH_SHORT).show();
    }

}
