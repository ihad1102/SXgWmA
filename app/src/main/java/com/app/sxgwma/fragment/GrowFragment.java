package com.app.sxgwma.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.sxgwma.R;
import com.app.sxgwma.activity.PersonalCenterActivity;
import com.app.sxgwma.base.RealmBaseFragment;
import com.app.sxgwma.base.SimpleBaseFragment;
import com.app.sxgwma.bean.ScoreBean;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.realm.implementation.RealmBarData;
import com.github.mikephil.charting.data.realm.implementation.RealmBarDataSet;
import com.github.mikephil.charting.data.realm.implementation.RealmLineData;
import com.github.mikephil.charting.data.realm.implementation.RealmLineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * 成长记录
 */
public class GrowFragment extends RealmBaseFragment {
    private View view;
    private LineChart lineChart;
    private BarChart barChart;
    @Nullable
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PersonalCenterActivity.persenter.selectorHideBackround(0);
        PersonalCenterActivity.persenter.selectorShowBackround(3);
        view=inflater.inflate(R.layout.grow_fragment,container,false);
        init();
        return view;
    }

    private void init() {
        lineChart = (LineChart)view.findViewById(R.id.lineChart);
        barChart = (BarChart) view.findViewById(R.id.barChart);
        setup(lineChart);
        setup(barChart);

        lineChart.setExtraBottomOffset(5f);
        barChart.setExtraBottomOffset(5f);

        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        //统计页面
        MobclickAgent.onPageStart("GrowFragment");
    }


    @Override
    public void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("GrowFragment");
    }

    private void initData() {
        mRealm.beginTransaction();
        // write some demo-data into the realm.io database
        ScoreBean score1 = new ScoreBean(100f, 0, "1月");
        mRealm.copyToRealm(score1);
        ScoreBean score2 = new ScoreBean(110f, 1, "2月");
        mRealm.copyToRealm(score2);
        ScoreBean score3 = new ScoreBean(130f, 2, "3月");
        mRealm.copyToRealm(score3);
        ScoreBean score4 = new ScoreBean(70f, 3, "4月");
        mRealm.copyToRealm(score4);
        ScoreBean score5 = new ScoreBean(80f, 4, "5月");
        mRealm.copyToRealm(score5);
        mRealm.commitTransaction();

        // add data to the chart
        setData();
    }
    private void setData() {

        // LINE-CHART
        RealmResults<ScoreBean> results = mRealm.allObjects(ScoreBean.class);

        RealmLineDataSet<ScoreBean> lineDataSet = new RealmLineDataSet<ScoreBean>(results, "totalScore", "scoreNr");
        lineDataSet.setDrawCubic(false);
        lineDataSet.setLabel("销售额/月份");
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setColor(ColorTemplate.rgb("#f75367"));
        lineDataSet.setCircleColor(ColorTemplate.rgb("#f75367"));
        lineDataSet.setLineWidth(1.8f);
        lineDataSet.setCircleSize(3.6f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lineDataSet);

        RealmLineData lineData = new RealmLineData(results, "playerName", dataSets);
        styleData(lineData);

        // set data
        lineChart.setData(lineData);
        lineChart.animateY(1400, Easing.EasingOption.EaseInOutQuart);


        // BAR-CHART
        RealmBarDataSet<ScoreBean> barDataSet = new RealmBarDataSet<ScoreBean>(results, "totalScore", "scoreNr");
        barDataSet.setColors(new int[]{ColorTemplate.rgb("#f75367"), ColorTemplate.rgb("#1184ee")});
        barDataSet.setLabel("人数/月份");

        ArrayList<IBarDataSet> barDataSets = new ArrayList<IBarDataSet>();
        barDataSets.add(barDataSet);

        RealmBarData barData = new RealmBarData(results, "playerName", barDataSets);
        styleData(barData);

        barChart.setData(barData);
        barChart.animateY(1400, Easing.EasingOption.EaseInOutQuart);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        PersonalCenterActivity.persenter.selectorHideBackround(0);
    }
}
