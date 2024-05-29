package com.example.tipcalculator;

import android.media.MediaTimestamp;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tipcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        call();

        calculate();

    }
    private void call(){
        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               binding.editText.setText(binding.editText.getText().toString()+"0");
               calculate(3);
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              binding.editText.setText(binding.editText.getText().toString()+"1");
              calculate(2);
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              binding.editText.setText(binding.editText.getText().toString()+"2");
              calculate(3);
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText().toString()+"3");
                calculate(4);
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText().toString()+"4");
                calculate(3);
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText().toString()+"5");
                calculate(4);
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText().toString()+"6");
                calculate(2);
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText().toString()+"7");
                calculate(3);
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText().toString()+"8");
                calculate(4);
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText().toString()+"9");
                calculate(4);
            }
        });
        binding.btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(binding.editText.getText().toString().contains(".")))
                    binding.editText.setText(binding.editText.getText().toString()+".");
                calculate(4);
            }
        });
        binding.btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText("");
                calculate(5);
            }
        });
        binding.btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String temp= binding.editText.getText().toString();

               if(temp.length()>0){
                   temp=temp.substring(0,temp.length()-1);
                   binding.editText.setText(temp);
               }
                calculate(3);
            }
        });

    }
    private  void calculate(){
        SeekBar seekBar=findViewById(R.id.tip_percentage);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                double percentage=i%1000.00;
                binding.textPercentage.setText(percentage+"%");
                String text= binding.editText.getText().toString().trim();
                double textNum=Double.parseDouble(text);

                double tip=textNum*percentage/100;
                binding.showTip.setText(tip+"");
                double total=textNum+tip;
                binding.showTotal.setText(total+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
     };
    private void calculate(int i){
        SeekBar seekBar=findViewById(R.id.tip_percentage);
        int progress= seekBar.getProgress();
        double percentage=progress;

        binding.textPercentage.setText(percentage+"%");
        String text= binding.editText.getText().toString().trim();
        if(text.length()>0) {
            double textNum = Double.parseDouble(text);

            double tip = textNum * percentage / 100;
            binding.showTip.setText(tip + "");
            double total = textNum + tip;
            binding.showTotal.setText(total + "");
        }else{
            binding.showTotal.setText(0+"");
            binding.showTip.setText(0+"");
        }
    }
}