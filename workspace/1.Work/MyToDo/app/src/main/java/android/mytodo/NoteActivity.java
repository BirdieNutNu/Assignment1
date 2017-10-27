package android.mytodo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {
    public static final String TOPICVIEW = "topicview";
    public static final String CONTENTVIEW = "contentview";
    public static final String VIEW_TOPIC = "viewTopic";
    public static final String VIEW_CONTENT = "viewContent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Intent i = getIntent();
        String top = i.getStringExtra(TOPICVIEW);
        String con = i.getStringExtra(CONTENTVIEW);

        NoteFragment noteFragment = new NoteFragment(); // create fragment
        Bundle bundle = new Bundle();
        bundle.putString(VIEW_TOPIC, top);
        bundle.putString(VIEW_CONTENT, con);
        noteFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentContainer1, noteFragment)
                .commit();


    }

}