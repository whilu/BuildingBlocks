package co.lujun.buildingblocks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lujun(http://blog.lujun.co)
 * Date: 2017-3-27 23:20
 */

public class AdapterDelegateManager<T> {

    private List<BaseDelegate> mAdapterDelegates;

    public AdapterDelegateManager(){
        mAdapterDelegates = new ArrayList<BaseDelegate>();
    }

    public int addDelegate(@NonNull BaseDelegate delegate){
        if (isDelegateIn(delegate)){
            throw new RuntimeException(delegate.getClass() + " has already in current manager!");
        }
        if (mAdapterDelegates.add(delegate)) {
            return mAdapterDelegates.size() - 1;
        }else {
            return -1;
        }
    }

    public int getItemViewType(@NonNull T items, int position){
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (delegate.isForViewType(items, position)){
                return delegate.getItemViewType();
            }
        }
        throw new RuntimeException("No delegate match!");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (delegate.getItemViewType() == viewType){
                return delegate.onCreateViewHolder(parent);
            }
        }
        throw new RuntimeException("Error delegate!");
    }

    public void onBindViewHolder(@NonNull T items, int position,
                                 @NonNull RecyclerView.ViewHolder holder){
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (holder.getItemViewType() == delegate.getItemViewType()){
                delegate.onBindViewHolder(items, position, holder);
            }
        }
    }

    private boolean isDelegateIn(BaseDelegate inDelegate){
        boolean in = false;
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (inDelegate.getClass().equals(delegate.getClass())){
                in = true;
                break;
            }
        }
        return in;
    }
}
