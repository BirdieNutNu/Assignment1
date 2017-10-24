package android.mytodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by TNGP17-001 on 24-Oct-17.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    private ImageButton addButton;
    private ListView listView;
    private ArrayList<Items> itemsArrayList;
    private ItemsListAdapter listAdapter;
    public static final String TOPIC = "Topic";
    public static final String CONTENT = "Content";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_note, container, false);
        initInstances(rootView);
        return rootView;
    }

    public void initInstances(View v) {
        addButton = v.findViewById(R.id.add_button);
        addButton.setOnClickListener(this);
        listView = v.findViewById(R.id.list_item);
        itemsArrayList = new ArrayList<>();
//        itemsArrayList.add(new Items("yo mama","let go yaya"));
        listAdapter = new ItemsListAdapter(itemsArrayList,getContext());
        listView.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.add_button){
            DialogFragment dialogFragment = MyToDoDialogFragment.newInstances();
            dialogFragment.setTargetFragment(this,2);
            dialogFragment.show(getFragmentManager(),"My To Do Dialog");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case 2:
                if (resultCode == Activity.RESULT_OK){
                    itemsArrayList.add(new Items(data.getStringExtra(TOPIC),data.getStringExtra(CONTENT)));
                    listAdapter.notifyDataSetChanged();
                }
        }

    }
}
