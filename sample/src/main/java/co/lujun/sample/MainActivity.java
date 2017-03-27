package co.lujun.sample;

import android.os.Bundle;
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
        list.add(multi1);

        BaseAdapter adapter = new BaseAdapter()
                .prepare(list)
                .putBlock(new TextDelegate())
                .putBlock(new ImageDelegate())
                .putBlock(new MultiDelegate());
        recyclerView.setAdapter(adapter);
    }
}
