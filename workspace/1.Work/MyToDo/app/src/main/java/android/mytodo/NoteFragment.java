package android.mytodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by TNGP17-001 on 25-Oct-17.
 */

public class NoteFragment extends Fragment {

    private TextView topicView;
    private TextView contentView;
    public static final String VIEW_TOPIC = "viewTopic";
    public static final String VIEW_CONTENT = "viewContent";
    private Menu mMenu;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.show_note, container, false);
        initInstances(rootView);
        return rootView;
    }

    public void initInstances(View v) {
        topicView = v.findViewById(R.id.viewTopic);
        contentView = v.findViewById(R.id.viewContent);

        Bundle bundle = getArguments();
        String topic = bundle.getString(VIEW_TOPIC);
        String content = bundle.getString(VIEW_CONTENT);

        topicView.setText(topic);
        contentView.setText(content);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       inflater.inflate(R.menu.menu_note_option, menu);
        mMenu = menu;
        MenuItem delMenu = menu.findItem(R.id.action_delete);
        MenuItem editMenu = menu.findItem(R.id.action_edit);

    }
}
