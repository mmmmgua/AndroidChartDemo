package com.example.androidchartdemo;

import androidx.appcompat.app.AppCompatActivity;
import com.example.androidchartdemo.databinding.ActivityMainBinding;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 @Author:mmmmgua
 @date: 2022/01/22 1:39
 **/
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    //作为整个图表的数据汇总,可以有多个dataset.
    private LineData lineData;
    //1个set代表图表上1根线,1根线可以有多个entry.
    private LineDataSet dataSet;
    //作为1根线的所有数据
    private final List<Entry> entryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initLineChart();
        initViewEventHandler();
    }

    void initLineChart(){
        //无数据显示一段文字
        binding.lineChart.setNoDataText("暂无数据");
    }

    void initViewEventHandler(){
        binding.addEntry.setOnClickListener(view -> {
            entryList.add(new Entry(0,(float) Math.random()));
            dataSet = new LineDataSet(entryList,"模拟数据");
            lineData = new LineData(dataSet);
            binding.lineChart.setData(lineData);
            //通知图表更新数据
            binding.lineChart.notifyDataSetChanged();
            binding.lineChart.invalidate();
        });
    }
}