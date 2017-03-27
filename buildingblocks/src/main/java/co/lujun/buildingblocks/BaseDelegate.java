package co.lujun.buildingblocks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Author: lujun(http://blog.lujun.co)
 * Date: 2017-3-27 23:20
 */

public abstract class BaseDelegate<T> {

    int mViewType;

    void setItemViewType(int type){
        mViewType = type;
    }

    int getItemViewType(){
        return mViewType;
    }

    public abstract boolean isForViewType(@NonNull T items, int position);

    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);

    public abstract void onBindViewHolder(@NonNull T items, int position, @NonNull RecyclerView.ViewHolder holder);
}
