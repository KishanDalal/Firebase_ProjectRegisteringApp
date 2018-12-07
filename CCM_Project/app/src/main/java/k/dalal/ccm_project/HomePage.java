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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private DatabaseReference mDatabase1;

    private RecyclerView recyclerView;
    private ProjectAdapter adapter;
    List<Project> projectList;

    private ListView mListView;
    private TextView Name;
    private TextView Email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        projectList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.mRecycler);
        recyclerView.setHasFixedSize(true);

        // Default Vertical
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        projectList.add(new Project("Apple", "Food", "3"));
        projectList.add(new Project("Apple2", "Food", "3"));
        projectList.add(new Project("Apple3", "Food", "3"));
        projectList.add(new Project("Apple3", "Food", "3"));
        projectList.add(new Project("Apple3", "Food", "3"));
        projectList.add(new Project("Apple3", "Food", "3"));
        projectList.add(new Project("Apple3", "Food", "3"));

        adapter = new ProjectAdapter(this, projectList);
        recyclerView.setAdapter(adapter);

        //mDatabase = FirebaseDatabase.getInstance().getReference("projects");
        //mDatabase1 = FirebaseDatabase.getInstance().getReference();

        //mDatabase = FirebaseDatabase.getInstance().getReference("projects").orderByChild("projectName");


        //mListView = (ListView) findViewById(R.id.listView);
        Name = (TextView) findViewById(R.id.name);
        Email = (TextView) findViewById(R.id.email);
/*
        FirebaseDatabase.getInstance().getReference().child("users")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            User user = snapshot.getValue(User.class);

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });


        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(this,
                String.class, android.R.layout.simple_list_item_1, mDatabase) {
            @Override
            protected void populateView(View v, String model, int position) {

                TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
            }
        };

        mListView.setAdapter(firebaseListAdapter);

*/
    }




    public void AddProject(View view) {
        Intent intent = new Intent(this, AddProjects.class);
        startActivity(intent);
    }


}
