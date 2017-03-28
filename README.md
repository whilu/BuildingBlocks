# BuildingBlocks

Assembly RecyclerView is as easy as building blocks!

## Usage

#### Add dependency

```groovy
dependencies {
    compile 'co.lujun:buildingblocks:1.0.0'
}
```

#### Create model and delegate

Model example:

```java
package co.lujun.sample.bean;

public class Text {}
```

Delegate example:

```java
package co.lujun.sample.blocks;

// import ...
import co.lujun.buildingblocks.BaseDelegate;
import co.lujun.sample.R;
import co.lujun.sample.bean.Text;

public class TextDelegate extends BaseDelegate<List> {

    @Override
    public boolean isForViewType(@NonNull List items, int position) {
        return items.get(position) instanceof Text;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new TextHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.xxx, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder holder) {
    }

    class TextHolder extends RecyclerView.ViewHolder{

        public TextHolder(View v){
            super(v);
        }
    }
}
```

#### Building!

```java
RecyclerView recyclerView = ...;

List list = ...;

Text text = new Text();
Image image = new Image();
Multi multi = new Multi();

list.add(text);
list.add(image);
list.add(multi);

BaseAdapter adapter = new BaseAdapter()
    .addDelegate(new TextDelegate())
    .addDelegate(new ImageDelegate())
    .addDelegate(new MultiDelegate())
    .buildWith(list);

recyclerView.setAdapter(adapter);
```

## Change logs

### 1.0.0(2017-3-28)
- First release(1.0.0)

## About

If you have any questions, contact me: [lujun.byte#gmail.com](mailto:lujun.byte@gmail.com).

## License

[MIT](LICENSE)
