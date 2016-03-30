package com.app.sxgwma.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.sxgwma.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by admin on 2016/3/29.
 */
public class MyPerformanceAdapter extends RecyclerView.Adapter<MyPerformanceViewHolder> {
    private LayoutInflater mInflater;
    private Context mContext;

    public MyPerformanceAdapter(Context mContext){
        this.mContext = mContext;
        mInflater=LayoutInflater.from(mContext);
    }
    //监听接口
    public  interface  OnItemClickListener{
        void OnItemClick(View view,int position);
        void OnItemLongClick(View view,int position);
    }
    private  OnItemClickListener mOnItemClickListener;
    public  void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }
    @Override
    public int getItemCount() {
        return 3;
    }
    @Override
    public void onBindViewHolder(final MyPerformanceViewHolder holder, final int position) {
//        holder.tv.setText(mDatas.get(position));
        setUpItemEvent(holder);
    }

    protected  void setUpItemEvent(final MyPerformanceViewHolder holder) {
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition=holder.getLayoutPosition();
                    mOnItemClickListener.OnItemClick(holder.itemView,layoutPosition);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition=holder.getLayoutPosition();
                    mOnItemClickListener.OnItemLongClick(holder.itemView, layoutPosition);
                    return false;
                }
            });

        }
    }

    @Override
    public MyPerformanceViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        View view=this.mInflater.inflate(R.layout.my_performance_item,arg0,false);
        MyPerformanceViewHolder myViewHolder=new MyPerformanceViewHolder(view);
        return myViewHolder;
    }
    //添加数据
    public  void addData(int pos){
        notifyItemInserted(pos);
    }
    //删除数据
    public  void delteData(int pos){
        notifyItemRemoved(pos);
    }
}
class MyPerformanceViewHolder extends RecyclerView.ViewHolder {
    TextView tv;

    public MyPerformanceViewHolder(View arg0) {
        super(arg0);
        //对于listview，注意添加这一行，即可在item上使用高度
        AutoUtils.autoSize(arg0);
        tv = (TextView) arg0.findViewById(R.id.tv_price);
    }
}