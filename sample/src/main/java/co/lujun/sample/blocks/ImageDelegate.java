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

package co.lujun.sample.blocks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.lujun.buildingblocks.BaseDelegate;
import co.lujun.sample.R;
import co.lujun.sample.bean.Image;

/**
 * Author: lujun(http://blog.lujun.co)
 * Date: 27/03/2017 23:22
 */

public class ImageDelegate extends BaseDelegate<List> {

    @Override
    public boolean isForViewType(@NonNull List items, int position) {
        return items.get(position) instanceof Image;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ImageHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_imageview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {
        ImageHolder imageHolder = (ImageHolder) holder;

    }

    class ImageHolder extends RecyclerView.ViewHolder{

        public ImageHolder(View v){
            super(v);
        }
    }
}
