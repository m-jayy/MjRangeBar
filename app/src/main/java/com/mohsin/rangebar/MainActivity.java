package com.mohsin.rangebar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.mohsin.rangebar_graph.RangeBarGraph;

public class MainActivity extends AppCompatActivity {
    RangeBarGraph RangeBarGraph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RangeBarGraph = (RangeBarGraph) findViewById(R.id.RangeBarGraph);
        RangeBarGraph.setValues(0.0, 400.0, 130.0, 350.0, 140.0);

//        RangeBarGraph.setRangeBarBackgroundColor("00ffffff");
//        RangeBarGraph.setRangeBarStrokeColor("#eaeaea");
//        RangeBarGraph.setRangeBarSelectedColor("#eaeaea");
//        RangeBarGraph.setRangeBarValueTextColor("#333333");
//        RangeBarGraph.setRangeBarMinMaxTextColor("#333333");
//        RangeBarGraph.setvalueCircleColor("#333333");
//        RangeBarGraph.setoutOfBoundColor("#FF0000");



    }
}
