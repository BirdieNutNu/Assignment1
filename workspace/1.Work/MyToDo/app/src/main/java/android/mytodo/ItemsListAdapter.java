package android.mytodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TNGP17-001 on 24-Oct-17.
 */

public class ItemsListAdapter extends BaseAdapter {

    private ArrayList<Items> arrayList;
    private Context mContext;

    public ItemsListAdapter(ArrayList<Items> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(R.layout.items, viewGroup, false);
        } else {
            TextView topic = view.findViewById(R.id.textTopic);
            TextView content =  view.findViewById(R.id.textContent);
            topic.setText(arrayList.get(position).getTopic());
            content.setText(arrayList.get(position).getContent());
        }
        return view;
    }
}
