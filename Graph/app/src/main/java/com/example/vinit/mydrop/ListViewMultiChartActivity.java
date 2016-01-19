
package com.example.vinit.mydrop;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vinit.mydrop.notimportant.DemoBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.vinit.mydrop.listviewitems.ChartItem;
import com.example.vinit.mydrop.listviewitems.LineChartItem;
import com.example.vinit.mydrop.listviewitems.PieChartItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the use of charts inside a ListView. IMPORTANT: provide a
 * specific height attribute for the chart inside your listview-item
 * 
 * @author Philipp Jahoda
 */
public class ListViewMultiChartActivity extends DemoBase {


    MyDBHandler dbHandler;
    int in,in1,in2,in3,in4,in5,in6,in7,in8,in9,in10,in11,in12;
    int value;
    String names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_listview_chart);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            names =(String) b.get("names");
            value =(int) b.get("value");

        }

        dbHandler = new MyDBHandler(this, null, null, 2);


        Cursor cursor = dbHandler.fetchFav();
        cursor.moveToPosition(1);
        String countryCode =
                cursor.getString(cursor.getColumnIndexOrThrow("attr"));
        String countryCode1 =
                cursor.getString(cursor.getColumnIndexOrThrow("JAN"));
        String countryCode2 =
                cursor.getString(cursor.getColumnIndexOrThrow("FEB"));
        String countryCode3 =
                cursor.getString(cursor.getColumnIndexOrThrow("MAR"));
        String countryCode4 =
                cursor.getString(cursor.getColumnIndexOrThrow("APR"));
        String countryCode5 =
                cursor.getString(cursor.getColumnIndexOrThrow("MAY"));
        String countryCode6 =
                cursor.getString(cursor.getColumnIndexOrThrow("JUN"));
        String countryCode7 =
                cursor.getString(cursor.getColumnIndexOrThrow("JUL"));
        String countryCode8 =
                cursor.getString(cursor.getColumnIndexOrThrow("AUG"));
        String countryCode9 =
                cursor.getString(cursor.getColumnIndexOrThrow("SEP"));
        String countryCode10 =
                cursor.getString(cursor.getColumnIndexOrThrow("OCT"));
        String countryCode11 =
                cursor.getString(cursor.getColumnIndexOrThrow("NOV"));
        String countryCode12 =
                cursor.getString(cursor.getColumnIndexOrThrow("DEC"));
        String countryCode13 =
                cursor.getString(cursor.getColumnIndexOrThrow("idd"));

        //      in = Integer.valueOf(countryCode.toString());
        in1 = Integer.valueOf(countryCode1.toString());
        in2 = Integer.valueOf(countryCode2.toString());
        in3 = Integer.valueOf(countryCode3.toString());
        in4 = Integer.valueOf(countryCode4.toString());
        in5 = Integer.valueOf(countryCode5.toString());
        in6 = Integer.valueOf(countryCode6.toString());
        in7 = Integer.valueOf(countryCode7.toString());
        in8 = Integer.valueOf(countryCode8.toString());
        in9 = Integer.valueOf(countryCode9.toString());
        in10 = Integer.valueOf(countryCode10.toString());
        in11 = Integer.valueOf(countryCode11.toString());
        in12 = Integer.valueOf(countryCode12.toString());



        Toast.makeText(getApplicationContext(), countryCode,
                Toast.LENGTH_LONG).show();


        ListView lv = (ListView) findViewById(R.id.listView1);

        ArrayList<ChartItem> list = new ArrayList<ChartItem>();

        // 30 items
        for (int i = 0; i < 2; i++) {
            
            if(i % 3 == 0) {
                list.add(new PieChartItem(generateDataPie(i + 1), getApplicationContext()));
            } else if(i % 3 == 1) {
                list.add(new LineChartItem(generateDataLine(i + 1), getApplicationContext()));
            }
        }

        ChartDataAdapter cda = new ChartDataAdapter(getApplicationContext(), list);
        lv.setAdapter(cda);
    }

    /** adapter that supports 3 different item types */
    private class ChartDataAdapter extends ArrayAdapter<ChartItem> {
        
        public ChartDataAdapter(Context context, List<ChartItem> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getItem(position).getView(position, convertView, getContext());
        }
        
        @Override
        public int getItemViewType(int position) {           
            // return the views type
            return getItem(position).getItemType();
        }
        
        @Override
        public int getViewTypeCount() {
            return 3; // we have 3 different item-types
        }
    }
    
    /**
     * generates a random ChartData object with just one DataSet
     * 
     * @return
     */
    private LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

//        for (int i = 0; i < 12; i++) {
            e1.add(new Entry((int) (10), 0));
        e1.add(new Entry((int) (20), 1));
        e1.add(new Entry((int) (30), 2));
        e1.add(new Entry((int) (40), 3));
        e1.add(new Entry((int) (50), 4));
        e1.add(new Entry((int) (60), 5));
        e1.add(new Entry((int) (65), 6));
        e1.add(new Entry((int) (70), 7));
        e1.add(new Entry((int) (80), 8));
        e1.add(new Entry((int) (65), 9));
        e1.add(new Entry((int) (70), 10));
        e1.add(new Entry((int) (100), 11));
//        e1.add(new Entry((int) (Math.random() * 65), i));

  //      }

        LineDataSet d1 = new LineDataSet(e1, "New DataSet " + cnt + ", (1)");
        d1.setLineWidth(2.5f);
        d1.setCircleSize(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);
        
//        ArrayList<Entry> e2 = new ArrayList<Entry>();
//
//        for (int i = 0; i < 12; i++) {
//            e2.add(new Entry(e1.get(i).getVal() - 30, i));
//        }

//        LineDataSet d2 = new LineDataSet(e2, "New DataSet " + cnt + ", (2)");
//        d2.setLineWidth(2.5f);
//        d2.setCircleSize(4.5f);
//        d2.setHighLightColor(Color.rgb(244, 117, 117));
//        d2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
//        d2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);
//        d2.setDrawValues(false);
        
        ArrayList<LineDataSet> sets = new ArrayList<LineDataSet>();
        sets.add(d1);
//        sets.add(d2);
        
        LineData cd = new LineData(getMonths(), sets);
        return cd;
    }
    
    /**
     * generates a random ChartData object with just one DataSet
     * 
     * @return
     */

    /**
     * generates a random ChartData object with just one DataSet
     * 
     * @return
     */
    private PieData generateDataPie(int cnt) {

        ArrayList<Entry> entries = new ArrayList<Entry>();

//        for (int i = 0; i < 2; i++) {
//        entries.add(new Entry((int) (0.8 * 70)+30, 0));
        entries.add(new Entry((int) (value), 0));
        entries.add(new Entry((int) (100-value), 1));
//        }

        PieDataSet d = new PieDataSet(entries, "");
        
        // space between slices
        d.setSliceSpace(2f);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        
        PieData cd = new PieData(getQuarters(), d);
        return cd;
    }
    
    private ArrayList<String> getQuarters() {
        
        ArrayList<String> q = new ArrayList<String>();
        q.add("1st Quarter");
        q.add("2nd Quarter");
        q.add("3rd Quarter");
        q.add("4th Quarter");
        
        return q;
    }

    private ArrayList<String> getMonths() {

        ArrayList<String> m = new ArrayList<String>();
        m.add("Jan");
        m.add("Feb");
        m.add("Mar");
        m.add("Apr");
        m.add("May");
        m.add("Jun");
        m.add("Jul");
        m.add("Aug");
        m.add("Sep");
        m.add("Okt");
        m.add("Nov");
        m.add("Dec");

        return m;
    }
}
