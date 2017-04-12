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

    /**
     * The delegate collection for building blocks
     */
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

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (holder.getItemViewType() == delegate.getItemViewType()){
                delegate.onBindViewHolder(holder, position, payloads);
            }
        }
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (holder.getItemViewType() == delegate.getItemViewType()){
                delegate.onViewAttachedToWindow(holder);
            }
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (holder.getItemViewType() == delegate.getItemViewType()){
                delegate.onViewDetachedFromWindow(holder);
            }
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        for (BaseDelegate delegate : mAdapterDelegates) {
            delegate.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        for (BaseDelegate delegate : mAdapterDelegates) {
            delegate.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (holder.getItemViewType() == delegate.getItemViewType()){
                delegate.onViewRecycled(holder);
            }
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder holder) {
        for (BaseDelegate delegate : mAdapterDelegates) {
            if (holder.getItemViewType() == delegate.getItemViewType()){
                return delegate.onFailedToRecycleView(holder);
            }
        }
        throw new RuntimeException("No delegate match!");
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
