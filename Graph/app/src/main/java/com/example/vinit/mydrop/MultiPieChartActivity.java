
package com.example.vinit.mydrop;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.vinit.mydrop.listviewitems.ChartItem;
import com.example.vinit.mydrop.listviewitems.MultiPieChartItem;
import com.example.vinit.mydrop.notimportant.DemoBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the use of charts inside a ListView. IMPORTANT: provide a
 * specific height attribute for the chart inside your listview-item
 *
 * @author Philipp Jahoda
 */
public class MultiPieChartActivity extends DemoBase {

    private Cursor cursor;
    //Context context;

    MyDBHandler dbHandler;
    int in1,in2,in3,in4,in5,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_multipiechart_activity);

        GridView lv = (GridView) findViewById(R.id.gridview);



        dbHandler = new MyDBHandler(this, null, null, 2);


        Cursor cursor = dbHandler.fetchFavMovies();
        String countryCode =
                cursor.getString(cursor.getColumnIndexOrThrow("nname"));
        final String countryCode1 =
                cursor.getString(cursor.getColumnIndexOrThrow("nlike"));
        String countryCode2 =
                cursor.getString(cursor.getColumnIndexOrThrow("ncomment"));
        String countryCode3 =
                cursor.getString(cursor.getColumnIndexOrThrow("nshare"));
        String countryCode4 =
                cursor.getString(cursor.getColumnIndexOrThrow("nevents"));
        String countryCode5 =
                cursor.getString(cursor.getColumnIndexOrThrow("nalbums"));

        //      in = Integer.valueOf(countryCode.toString());
        in1 = Integer.valueOf(countryCode1.toString());
        in2 = Integer.valueOf(countryCode2.toString());
        in3 = Integer.valueOf(countryCode3.toString());
        in4 = Integer.valueOf(countryCode4.toString());
        in5 = Integer.valueOf(countryCode5.toString());
        int[] intArray = new int[] {in1,in2,in3,in4,in5,in5};

        ArrayList<ChartItem> list = new ArrayList<ChartItem>();

        // 30 items
        for (int i = 0; i < 18; i++) {

            if(i % 3 == 0) {
                list.add(new MultiPieChartItem(generateDataPie(i + 1,intArray[i/3]), getApplicationContext()));
            }
        }

        ChartDataAdapter cda = new ChartDataAdapter(getApplicationContext(), list);
        lv.setAdapter(cda);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                               if(position==0){
                Intent newActivity = new Intent(MultiPieChartActivity.this, ListViewMultiChartActivity.class);
                newActivity.putExtra("names", "like");
                newActivity.putExtra("value", in1);
                startActivity(newActivity);
                finish();
                             }
            }
        });
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
    private PieData generateDataPie(int cnt,int x) {

        ArrayList<Entry> entries = new ArrayList<Entry>();
        int y = 100-x;
//        for (int i = 0; i < 2; i++) {
//        entries.add(new Entry((int) (0.8 * 70)+30, 0));
        entries.add(new Entry((int) (y), 0));
        entries.add(new Entry((int) (x), 1));
//        }

        PieDataSet d = new PieDataSet(entries, "");

        // space between slices
        d.setSliceSpace(2f);
        switch(cnt/3){
            case 0: d.setColors(ColorTemplate.VIN_COLORS); break;
            case 1: d.setColors(ColorTemplate.VIN_COLORS1); break;
            case 2: d.setColors(ColorTemplate.VIN_COLORS2); break;
            case 3: d.setColors(ColorTemplate.VIN_COLORS3); break;
            case 4: d.setColors(ColorTemplate.VIN_COLORS4); break;
            case 5: d.setColors(ColorTemplate.VIN_COLORS5); break;
            case 6: d.setColors(ColorTemplate.VIN_COLORS1); break;
            default:

        }


        PieData cd = new PieData(getQuarters(), d);
        return cd;
    }

    private ArrayList<String> getQuarters() {

        ArrayList<String> q = new ArrayList<String>();
        q.add("1st Quarter");
        q.add("2nd Quarter");
//        q.add("3rd Quarter");
//        q.add("4th Quarter");

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
