package k.dalal.ccm_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.*;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private RecyclerView mPeopleRv;
    private ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference("projects");


        mListView = (ListView) findViewById(R.id.listView);

        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(this,
                String.class, android.R.layout.simple_list_item_1, mDatabase.child("projectName")) {
            @Override
            protected void populateView(View v, String model, int position) {

                TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
            }
        };

        mListView.setAdapter(firebaseListAdapter);


    }




    public void AddProject(View view) {
        Intent intent = new Intent(this, AddProjects.class);
        startActivity(intent);
    }


}
