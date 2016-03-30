package com.app.sxgwma.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sxgwma.R;
import com.app.sxgwma.util.LogUtil;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by admin on 2016/3/29.
 */
public class XgwAdapter extends RecyclerView.Adapter<XgwViewHolder> implements View.OnClickListener{
    private LayoutInflater mInflater;
    private Context mContext;
    public String number="10";
    public XgwAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater=LayoutInflater.from(mContext);
        }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.iv_jia:
                int jia=Integer.valueOf(number);
                number=String.format("%d",++jia);
                LogUtil.log(number);
                break;
            case R.id.iv_jian:
                int jian=Integer.valueOf(number);
                number=String.format("%d",--jian);
                LogUtil.log(number);;
                break;
        }
        notifyDataSetChanged();
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
        return 1;
    }
    @Override
    public void onBindViewHolder(final XgwViewHolder holder, final int position) {
//        holder.tv.setText(mDatas.get(position));
        holder.tv_number.setText(number);
        holder.iv_jia.setOnClickListener(this);
        holder.iv_jian.setOnClickListener(this);
        setUpItemEvent(holder);
    }
    protected  void setUpItemEvent(final XgwViewHolder holder) {
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
    public XgwViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        View view=this.mInflater.inflate(R.layout.xgw_fragment_item,arg0,false);
        XgwViewHolder myViewHolder=new XgwViewHolder(view);
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
class XgwViewHolder extends RecyclerView.ViewHolder{
    TextView tv_wfx,tv_price,tv_number,tv_total;
    ImageView iv_jian,iv_jia,iv_trash;
    public XgwViewHolder(View arg0){
        super(arg0);
        //对于listview，注意添加这一行，即可在item上使用高度
        AutoUtils.autoSize(arg0);
        tv_wfx=(TextView)arg0.findViewById(R.id.tv_wfx);
        tv_price=(TextView)arg0.findViewById(R.id.tv_price);
        tv_number=(TextView)arg0.findViewById(R.id.tv_number);
        tv_total=(TextView)arg0.findViewById(R.id.tv_total);
        iv_jian=(ImageView)arg0.findViewById(R.id.iv_jian);
        iv_jia=(ImageView)arg0.findViewById(R.id.iv_jia);
        iv_trash=(ImageView)arg0.findViewById(R.id.iv_trash);
    }
}
