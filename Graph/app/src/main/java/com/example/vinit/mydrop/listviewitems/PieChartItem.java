
package com.example.vinit.mydrop.listviewitems;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.vinit.mydrop.R;

public class PieChartItem extends ChartItem {

    private Typeface mTf;
    private SpannableString mCenterText;

    public PieChartItem(ChartData<?> cd, Context c) {
        super(cd);

        mTf = Typeface.createFromAsset(c.getAssets(), "OpenSans-Regular.ttf");
        mCenterText = generateCenterText();
    }

    @Override
    public int getItemType() {
        return TYPE_PIECHART;
    }

    @Override
    public View getView(int position, View convertView, Context c) {

        ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();

            convertView = LayoutInflater.from(c).inflate(
                    R.layout.list_item_piechart, null);
            holder.chart = (PieChart) convertView.findViewById(R.id.chart);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // apply styling
        holder.chart.setDescription("");
        holder.chart.setHoleColorTransparent(true);
        holder.chart.setHoleRadius(70f);
        holder.chart.setTransparentCircleRadius(57f);
        holder.chart.setCenterText(mCenterText);
        holder.chart.setCenterTextTypeface(mTf);
        holder.chart.setCenterTextSize(9f);
        holder.chart.setUsePercentValues(true);
        holder.chart.setExtraOffsets(50, 20, 50, 20);

        mChartData.setValueFormatter(new PercentFormatter());
        mChartData.setValueTypeface(mTf);
        mChartData.setValueTextSize(0f);
//        mChartData.setValueTextSize(11f);
        mChartData.setValueTextColor(Color.WHITE);
        // set data
        holder.chart.setData((PieData) mChartData);

        String[] VALUES = new String[] {"Albums"};
        Legend l = holder.chart.getLegend();
        int x[] = new int[]{l.getColors()[1]};
        l.setPosition(LegendPosition.LEFT_OF_CHART);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        l.setTextSize(20.0f);
//        x[0]=l.getColors()[0];


        l.setCustom(x,VALUES);
        l.setEnabled(true);


        // do not forget to refresh the chart
        // holder.chart.invalidate();
        holder.chart.animateXY(900, 900);

        return convertView;
    }

    private SpannableString generateCenterText() {
        SpannableString s = new SpannableString("16%\n9 Points\n8 Shares");
        s.setSpan(new RelativeSizeSpan(3.0f), 0, 3, 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.VORDIPLOM_COLORS[0]), 0, 3, 0);
        s.setSpan(new RelativeSizeSpan(3.0f), 3, 12 , 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 3, 12, 0);
        s.setSpan(new RelativeSizeSpan(3.0f), 12, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), 12, s.length(), 0);
        return s;
    }

    private static class ViewHolder {
        PieChart chart;
    }
}
