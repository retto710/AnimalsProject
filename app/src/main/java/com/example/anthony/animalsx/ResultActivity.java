package com.example.anthony.animalsx;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private PieChart pieChart;
    private BarChart barChart;
    private String[] interaccion;
    private Button btnAgain;
    private  int[]sale = new int[]{25,80,3};
    private int[] color = new int[]{Color.BLUE,Color.RED,Color.YELLOW,Color.MAGENTA,Color.BLACK,Color.LTGRAY,Color.GREEN,Color.DKGRAY,Color.CYAN,Color.GRAY};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //pieChart= findViewById(R.id.Piechart);
        barChart=findViewById(R.id.barChart);
        btnAgain=findViewById(R.id.btnAgain);
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        Bundle extras = getIntent().getExtras();
        sale=  extras.getIntArray("respuesta");
        interaccion=new String[sale.length];
        for (int i=0;i<sale.length;i++)
        {
            interaccion[i]=String.valueOf(i);
        }
        createCharts();
        //Intent intent = getIntent();
        //String YourtransferredData = intent.getExtras().getString("respuesta");
        //textView.setText(YourtransferredData);
    }

    private Chart getSameChar(Chart chart, String description, int textcolor, int backgroundcolor,int time){
        chart.getDescription().setText(description);
        chart.getDescription().setTextColor(textcolor);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(backgroundcolor);
        chart.animateY(time);
        return chart;
    }

    private void leyenda(Chart chart){
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ArrayList<LegendEntry> entries=new ArrayList<>();
        for (int i = 0; i< interaccion.length; i++){
            LegendEntry entry = new LegendEntry();
            entry.formColor=color[i];
            entry.label= interaccion[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }

    private ArrayList<BarEntry> getBarEntries(){
        ArrayList<BarEntry> entries= new ArrayList<>();
        for (int i=0;i<sale.length;i++){
            entries.add(new BarEntry(i,sale[i]));
        }
        return entries;
    }
    private ArrayList<PieEntry> getPieEntries(){
        ArrayList<PieEntry> entries= new ArrayList<>();
        for (int i=0;i<sale.length;i++){
            entries.add(new PieEntry(i,sale[i]));
        }
        return entries;
    }

    private void axisX(XAxis axis)
    {
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(interaccion));
    }

    private void axisLeft(YAxis axis)
    {
        axis.setSpaceTop(30);
        axis.setAxisMinimum(0);
    }
    private void axisRight(YAxis axis)
    {
        axis.setEnabled(false);
    }

    public void createCharts()
    {
        barChart= (BarChart) getSameChar(barChart,"Interacciones",Color.RED,Color.CYAN,3000);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();
        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());

    }

    private DataSet getData(DataSet dataSet)
    {
        dataSet.setColors(color);
        dataSet.setValueTextSize(10);
        dataSet.setValueTextColor(Color.WHITE);
        return dataSet;
    }

    private BarData getBarData(){
        BarDataSet barDataSet= (BarDataSet)getData(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData= new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;


    }
}
