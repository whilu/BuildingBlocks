/*
 * MIT License
 *
 * Copyright (c) 2017 lujun
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
     * The data for building blocks
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

    public BaseAdapter buildWith(List items){
        mItems = items;
        return this;
    }

    public BaseAdapter addDelegate(BaseDelegate delegate){
        delegate.setItemViewType(mAdapterDelegateManager.addDelegate(delegate));
        return this;
    }

    public BaseAdapter addDelegates(List<BaseDelegate> delegates){
        for (BaseDelegate delegate : delegates) {
            addDelegate(delegate);
        }
        return this;
    }
}
