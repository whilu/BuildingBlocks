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

package co.lujun.sample;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.lujun.buildingblocks.BaseAdapter;
import co.lujun.sample.bean.Image;
import co.lujun.sample.bean.Multi;
import co.lujun.sample.bean.Text;
import co.lujun.sample.blocks.ImageDelegate;
import co.lujun.sample.blocks.MultiDelegate;
import co.lujun.sample.blocks.TextDelegate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        List list = new ArrayList();

        Text text = new Text();
        Text text1 = new Text();
        Image image = new Image();
        Image image1 = new Image();
        Multi multi = new Multi();
        Multi multi1 = new Multi();

        list.add(text);
        list.add(image);
        list.add(image1);
        list.add(multi);
        list.add(text1);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.show();
        list.add(multi1);

        BaseAdapter adapter = new BaseAdapter()
                .addDelegate(new TextDelegate())
                .addDelegate(new ImageDelegate())
                .addDelegate(new MultiDelegate())
                .buildWith(list);
        recyclerView.setAdapter(adapter);
    }
}
