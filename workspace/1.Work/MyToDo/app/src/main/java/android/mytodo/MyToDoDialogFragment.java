package android.mytodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by TNGP17-001 on 24-Oct-17.
 */

public class MyToDoDialogFragment extends DialogFragment implements View.OnClickListener {

    public static final String TOPIC = "Topic";
    public static final String CONTENT = "Content";
    private Button saveButton;
    private Button cancelButton;
    private EditText topic;
    private EditText content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_add_new_task, container, false);
        initInstances(rootView);
        return rootView;
    }

    public void initInstances(View v) {
        saveButton =  v.findViewById(R.id.button_save);
        saveButton.setOnClickListener(this);
        cancelButton =  v.findViewById(R.id.button_cancel);
        cancelButton.setOnClickListener(this);
        topic =  v.findViewById(R.id.inputTopic);
        content =  v.findViewById(R.id.inputContent);
    }


    public static MyToDoDialogFragment newInstances() {
        MyToDoDialogFragment myToDoDialogFragment = new MyToDoDialogFragment();
        return myToDoDialogFragment;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_save) {
            Intent intent = new Intent();
            intent.putExtra(TOPIC, topic.getText().toString());
            intent.putExtra(CONTENT, content.getText().toString());

            if (topic.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Please Fill Up Topic", Toast.LENGTH_SHORT).show();
            } else if (content.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Please Fill Up Content", Toast.LENGTH_SHORT).show();
            }else {
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
                dismiss();
            }
        } else if (view.getId() == R.id.button_cancel) {
            dismiss();
        }

    }
}

