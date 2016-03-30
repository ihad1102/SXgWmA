package com.app.sxgwma.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sxgwma.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.HashMap;
import java.util.logging.Handler;

/**
 * Created by admin on 2016/3/29.
 */
public class BecomwAgentAdapter extends RecyclerView.Adapter<BecomwAgentViewHolder> implements View.OnClickListener{
    private LayoutInflater mInflater;
    private Context mContext;
    private Handler handler;
    //默认设置几级代理
    public int DefaultAgent;
    //选择
    private final static Boolean CHOICE=true;
    //不选择
    private final static Boolean UNCHOICE=false;
    private HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();

    public BecomwAgentAdapter(Context mContext,int DefaultAgent){
        this.mContext = mContext;
        this.DefaultAgent=DefaultAgent;
        mInflater=LayoutInflater.from(mContext);
        for (int i=0;i<4;i++){
            if(i==DefaultAgent){
                map.put(i,CHOICE);
            }else{
                map.put(i,UNCHOICE);
            }
        }
    }
    @Override
    public void onClick(View v){
       switch (v.getId()){
           case R.id.iv_becom_agent:
               int ag0=(Integer)v.getTag(R.id.iv_becom_agent);
               DefaultAgent=ag0;
               for(int i=0;i<4;i++){
                   if(i==DefaultAgent){
                       map.put(i,CHOICE);
                   }else{
                       map.put(i,UNCHOICE);
                   }
               }
               notifyDataSetChanged();
               break;
       }
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
        return 4;
    }
    @Override
    public void onBindViewHolder(final BecomwAgentViewHolder holder, final int position) {
//        holder.tv.setText(mDatas.get(position));
        holder.iv_becom_agent.setSelected(map.get(position));
        holder.iv_becom_agent.setTag(R.id.iv_becom_agent,position);
        holder.iv_becom_agent.setOnClickListener(this);
        setUpItemEvent(holder);
    }

    protected  void setUpItemEvent(final BecomwAgentViewHolder holder) {
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
    public BecomwAgentViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        View view=this.mInflater.inflate(R.layout.become_agent_item,arg0,false);
        BecomwAgentViewHolder myViewHolder=new BecomwAgentViewHolder(view);
        return myViewHolder;
    }
//    //添加数据
//    public  void addData(int pos){
//        notifyItemInserted(pos);
//    }
//    //删除数据
//    public  void delteData(int pos){
//        notifyItemRemoved(pos);
//    }
}
class BecomwAgentViewHolder extends RecyclerView.ViewHolder {
     TextView tv_total,tv_price,tv_number,tv_agent_level,tv_xgwfx;
     ImageView iv_becom_agent;

    public BecomwAgentViewHolder(View arg0) {
        super(arg0);
        //对于listview，注意添加这一行，即可在item上使用高度
        AutoUtils.autoSize(arg0);
        tv_total = (TextView) arg0.findViewById(R.id.tv_total);
        tv_price = (TextView) arg0.findViewById(R.id.tv_price);
        tv_number = (TextView) arg0.findViewById(R.id.tv_number);
        tv_agent_level = (TextView) arg0.findViewById(R.id.tv_agent_level);
        tv_xgwfx = (TextView) arg0.findViewById(R.id.tv_xgwfx);
        iv_becom_agent = (ImageView) arg0.findViewById(R.id.iv_becom_agent);
    }
}