package android.mytodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
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
    private Button okButton;
    public static final String VIEW_TOPIC = "viewTopic";
    public static final String VIEW_CONTENT = "viewContent";



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
        okButton = v.findViewById(R.id.buttonOk);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Bundle bundle = getArguments();
        String topic = bundle.getString(VIEW_TOPIC);
        String content = bundle.getString(VIEW_CONTENT);

        topicView.setText(topic);
        contentView.setText(content);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
