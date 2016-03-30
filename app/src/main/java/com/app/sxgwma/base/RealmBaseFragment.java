package com.app.sxgwma.base;

import android.graphics.Color;
import android.graphics.Typeface;

import com.app.sxgwma.R;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.formatter.PercentFormatter;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * 图片基本类
 */
public class RealmBaseFragment  extends  SimpleBaseFragment{
    protected Realm mRealm;
    protected void setup(Chart<?> chart){
        // no description text
        chart.setDescription("");
        chart.setNoDataTextDescription("");

        // enable touch gestures
        chart.setTouchEnabled(true);

        if (chart instanceof BarLineChartBase) {

            BarLineChartBase mChart = (BarLineChartBase) chart;

            mChart.setDrawGridBackground(false);

            // enable scaling and dragging
            mChart.setDragEnabled(true);
            mChart.setScaleEnabled(true);

            // if disabled, scaling can be done on x- and y-axis separately
            mChart.setPinchZoom(false);

            YAxis leftAxis = mChart.getAxisLeft();
            leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
            leftAxis.setTextSize(8f);
            leftAxis.setTextColor(Color.DKGRAY);
            leftAxis.setValueFormatter(new PercentFormatter());

            XAxis xAxis = mChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setTextSize(8f);
            xAxis.setTextColor(Color.DKGRAY);

            mChart.getAxisRight().setEnabled(false);
        }
    }

    protected void styleData(ChartData data) {
        data.setValueTextSize(8f);
        data.setValueTextColor(getResources().getColor(R.color.c1184ee));
        data.setValueFormatter(new PercentFormatter());
    }
    @Override
    public void onResume() {
        super.onResume();
        RealmConfiguration config = new RealmConfiguration.Builder(getContext())
                .name("myrealm.realm")
                .build();

        Realm.deleteRealm(config);

        Realm.setDefaultConfiguration(config);

        mRealm = Realm.getInstance(config);
    }

    @Override
    public void onPause() {
        super.onPause();
        mRealm.close();
    }


}
