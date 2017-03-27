package co.lujun.buildingblocks;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author: lujun(http://blog.lujun.co)
 * Date: 2017-3-27 23:20
 */

public class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * Data stream
     */
    private List mItems;

    /**
     * Adapter delegate manager
     */
    private AdapterDelegateManager mAdapterDelegateManager;

    public BaseAdapter(){
        mAdapterDelegateManager = new AdapterDelegateManager();
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems == null){
            throw new RuntimeException("Data has not been prepared!");
        }
        return mAdapterDelegateManager.getItemViewType(mItems, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mAdapterDelegateManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mAdapterDelegateManager.onBindViewHolder(mItems, position, holder);
    }

    public BaseAdapter prepare(List items){
        mItems = items;
        return this;
    }

    public BaseAdapter putBlock(BaseDelegate delegate){
        delegate.setItemViewType(mAdapterDelegateManager.addDelegate(delegate));
        return this;
    }

    public BaseAdapter putBlocks(List<BaseDelegate> delegates){
        for (BaseDelegate delegate : delegates) {
            putBlock(delegate);
        }
        return this;
    }
}
