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
