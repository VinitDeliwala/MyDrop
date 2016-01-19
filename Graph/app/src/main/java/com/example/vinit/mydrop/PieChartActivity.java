
package com.example.vinit.mydrop;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.vinit.mydrop.notimportant.DemoBase;

import java.util.ArrayList;

public class PieChartActivity extends DemoBase implements OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private PieChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY,t1;
    
    private Typeface tf;
    private Cursor cursor;
    //Context context;

    MyDBHandler dbHandler;
    int in,in1,in2,in3,in4,in5,total;
    float ain1,ain2,ain3,ain4,ain5;
    float zin1,zin2,zin3,zin4,zin5;

    private String[] title = {
            "Likes",
            "Comments",
            "Shares",
            "Events",
            "Albums"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_piechart);
        t1 = (TextView) findViewById(R.id.upcorner);
        ImageView i1 = (ImageView) findViewById(R.id.imageView);


        dbHandler = new MyDBHandler(this, null, null, 2);


        Cursor cursor = dbHandler.fetchFavMovies();
        String countryCode =
                cursor.getString(cursor.getColumnIndexOrThrow("nname"));
        String countryCode1 =
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
        total = in1+in2+in3+in4+in5;

        zin1 = ((float)in1/total)*360;
        zin2 = ((float)in2/total)*360;
        zin3 = ((float)in3/total)*360;
        zin4 = ((float)in4/total)*360;
        zin5 = ((float)in5/total)*360;

        ain1 = (270- (zin1/2));
        ain2 =(270- zin1 - (zin2/2));
        ain3 =270- zin1-zin2-(zin3/2);
        ain4 =270-zin1-zin2-zin3-(zin4/2);
        ain5 =270-zin1-zin2-zin3-zin4-(zin5/2);
//        tvX = (TextView) findViewById(R.id.tvXMax);
//        tvY = (TextView) findViewById(R.id.tvYMax);
//
//        mSeekBarX = (SeekBar) findViewById(R.id.seekBar1);
//        mSeekBarY = (SeekBar) findViewById(R.id.seekBar2);
//
//        mSeekBarY.setProgress(10);
//
//        mSeekBarX.setOnSeekBarChangeListener(this);
//        mSeekBarY.setOnSeekBarChangeListener(this);

        mChart = (PieChart) findViewById(R.id.chart1);
        mChart.setUsePercentValues(true);
        mChart.setDescription("");
        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

        tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

        mChart.setCenterTextTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
        mChart.setCenterText(generateCenterSpannableText());
//        mChart.setCenterText("0");
//        mChart.setCenterTextSize(150f);

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        mChart.setOnChartValueSelectedListener(this);

        setData(3, 100,0);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mChart.getLegend();
        l.setPosition(LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        l.setEnabled(false);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(PieChartActivity.this, MultiPieChartActivity.class);
                startActivity(newActivity);
                finish();
            }
        });
//        setData(mSeekBarX.getProgress(), mSeekBarY.getProgress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pie, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionToggleValues: {
                for (DataSet<?> set : mChart.getData().getDataSets())
                    set.setDrawValues(!set.isDrawValuesEnabled());

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleHole: {
                if (mChart.isDrawHoleEnabled())
                    mChart.setDrawHoleEnabled(false);
                else
                    mChart.setDrawHoleEnabled(true);
                mChart.invalidate();
                break;
            }
            case R.id.actionDrawCenter: {
                if (mChart.isDrawCenterTextEnabled())
                    mChart.setDrawCenterText(false);
                else
                    mChart.setDrawCenterText(true);
                mChart.invalidate();
                break;
            }
            case R.id.actionToggleXVals: {

                mChart.setDrawSliceText(!mChart.isDrawSliceTextEnabled());
                mChart.invalidate();
                break;
            }
            case R.id.actionSave: {
                // mChart.saveToGallery("title"+System.currentTimeMillis());
                mChart.saveToPath("title" + System.currentTimeMillis(), "");
                break;
            }
            case R.id.actionTogglePercent:
                mChart.setUsePercentValues(!mChart.isUsePercentValuesEnabled());
                mChart.invalidate();
                break;
            case R.id.animateX: {
                mChart.animateX(1400);
                break;
            }
            case R.id.animateY: {
                mChart.animateY(1400);
                break;
            }
            case R.id.animateXY: {
                mChart.animateXY(1400, 1400);
                break;
            }
        }
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        tvX.setText("" + (mSeekBarX.getProgress() + 1));
        tvY.setText("" + (mSeekBarY.getProgress()));

        setData(mSeekBarX.getProgress(), mSeekBarY.getProgress(),0);
    }

    private void setData(int count, float range,int color) {

        float mult = range;
        count=4;
        int x=color;

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
//        for (int i = 0; i < count + 1; i++) {
//            yVals1.add(new Entry((float) (Math.random() * mult) + mult / 5, i));
//            yVals1.add(new Entry((int) (in), 0));
        yVals1.add(new Entry((int) (in1), 0));
        yVals1.add(new Entry((int) (in2), 1));
        yVals1.add(new Entry((int) (in3), 2));
        yVals1.add(new Entry((int) (in4), 3));
        yVals1.add(new Entry((int) (in5), 4));
//        yVals1.add(new Entry((int) (20), 0));
//        yVals1.add(new Entry((int) (20), 1));
//        yVals1.add(new Entry((int) (20), 2));
//        yVals1.add(new Entry((int) (20), 3));
//        yVals1.add(new Entry((int) (20), 4));
            //       }

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < count + 1; i++)
//            xVals.add(mParties[i % mParties.length]);
            xVals.add(title[i]);

        PieDataSet dataSet = new PieDataSet(yVals1, "Election Results");
        dataSet.setSliceSpace(2f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();
        if(x==0) {
            for (int c : ColorTemplate.VINIT_COLORS)
                colors.add(c);
        }
        if(x==1) {
            for (int c : ColorTemplate.LIKE_COLORS)
                colors.add(c);
        }
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        data.setValueTypeface(tf);

        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }

    private SpannableString generateCenterSpannableText() {

//        SpannableString s = new SpannableString("MPAndroidChart developed by Philipp Jahoda");
//        s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
//        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
//        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
//        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
//        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
//        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        SpannableString s = new SpannableString("0 \nPoints");
        s.setSpan(new RelativeSizeSpan(10.0f), 0, 1, 0);
        s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 1, 0);
        s.setSpan(new RelativeSizeSpan(2.0f), 1, 9 , 0);
        s.setSpan(new ForegroundColorSpan(Color.WHITE), 1, 9, 0);
//        s.setSpan(new RelativeSizeSpan(3.0f), 12, s.length(), 0);
//        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), 12, s.length(), 0);
        return s;
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        if(e.getXIndex()==0){
            mChart.setRotationAngle(ain1);
            t1.setText(" Total = " + in1 + " Likes ");
            t1.setVisibility(View.VISIBLE);
//            setData(3, 100, 1);
//            Toast.makeText(getApplicationContext(), "Fuck you shwet Maroo",
//                    Toast.LENGTH_LONG).show();
        }
        if(e.getXIndex()==1){
            mChart.setRotationAngle(ain2);
            t1.setText(" Total = "+ in2 + " Comments ");
//            t1.setVisibility(View.VISIBLE);
//            Toast.makeText(getApplicationContext(), "Fuck you shwet Maroo",
//                    Toast.LENGTH_LONG).show();
        }
        if(e.getXIndex()==2){
            mChart.setRotationAngle(ain3);
            t1.setText(" Total = "+ in3 + " Shares ");
//            t1.setVisibility(View.VISIBLE);
//            Toast.makeText(getApplicationContext(), "Fuck you shwet Maroo",
//                    Toast.LENGTH_LONG).show();
        }
        if(e.getXIndex()==3){
            mChart.setRotationAngle(ain4);
            t1.setText(" Total = "+ in4 + " Events ");
//            t1.setVisibility(View.VISIBLE);
//            Toast.makeText(getApplicationContext(), "Fuck you shwet Maroo",
//                    Toast.LENGTH_LONG).show();
        }
        if(e.getXIndex()==4){
            mChart.setRotationAngle(ain5);
            t1.setText(" Total = "+ in5 + " Albums ");
//            t1.setVisibility(View.VISIBLE);
//            Toast.makeText(getApplicationContext(), "Fuck you shwet Maroo",
//                    Toast.LENGTH_LONG).show();
        }
//
//        if(e.getXIndex()==1){
//            mChart.setRotationAngle(160);
////            Toast.makeText(getApplicationContext(), "Fuck you shwet Maroo",
////                    Toast.LENGTH_LONG).show();
//        }
        if (e == null)

            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }
}
