
package com.example.vinit.mydrop.listviewitems;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;

import com.example.vinit.mydrop.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

public class MultiPieChartItem extends ChartItem {

    private Typeface mTf;
    private SpannableString mCenterText;

    public MultiPieChartItem(ChartData<?> cd, Context c) {
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
                    R.layout.multi_list_item_piechart, null);
            holder.chart = (PieChart) convertView.findViewById(R.id.chart);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // apply styling
        holder.chart.setDescription("");
        holder.chart.setHoleRadius(80f);
        holder.chart.setHoleColorTransparent(true);
//        holder.chart.setHoleRadius(70f);
        holder.chart.setTransparentCircleRadius(57f);
        holder.chart.setCenterText(mCenterText);
        holder.chart.setCenterTextTypeface(mTf);
        holder.chart.setCenterTextSize(9f);
        holder.chart.setUsePercentValues(true);
//        holder.chart.setExtraOffsets(5, 10, 50, 10);
        holder.chart.setExtraOffsets(5, 10, 5, 10);

        mChartData.setValueFormatter(new PercentFormatter());
        mChartData.setValueTypeface(mTf);
        mChartData.setValueTextSize(0f);
//        mChartData.setValueTextSize(7f);
        mChartData.setValueTextColor(Color.WHITE);


        // set data
        holder.chart.setData((PieData) mChartData);

        Legend l = holder.chart.getLegend();
        l.setPosition(LegendPosition.RIGHT_OF_CHART);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        l.setEnabled(false);

   //    holder.chart.setClickable(false);
        holder.chart.setHighlightPerTapEnabled(false);
        holder.chart.setTouchEnabled(false);
        // do not forget to refresh the chart
        // holder.chart.invalidate();
        holder.chart.animateXY(900, 900);

        return convertView;
    }

    private SpannableString generateCenterText() {
        SpannableString s = new SpannableString("16%\n9 Points\n8 Shares");
        s.setSpan(new RelativeSizeSpan(0.5f), 0, 3, 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.VORDIPLOM_COLORS[0]), 0, 3, 0);
        s.setSpan(new RelativeSizeSpan(0.5f), 3, 12 , 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 3, 12, 0);
        s.setSpan(new RelativeSizeSpan(0.5f), 12, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), 12, s.length(), 0);
        return s;
    }

    private static class ViewHolder {
        PieChart chart;
    }
}
