package k.dalal.ccm_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.*;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePage extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private RecyclerView recyclerView;
    private ProjectAdapter adapter;
    private  List<Project> projectList;

   // private ListView mListView;
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


        adapter = new ProjectAdapter(HomePage.this, projectList);
        recyclerView.setAdapter(adapter);

        // PROJECTS 
        mDatabase = FirebaseDatabase.getInstance().getReference("projects");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                projectList.clear();
                Iterable<DataSnapshot> dataSnapshotIterable = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = dataSnapshotIterable.iterator();
                while ((iterator.hasNext()))
                {
                    Project value = iterator.next().getValue(Project.class);
                    projectList.add(value);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // USERS
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                projectList.clear();
                Iterable<DataSnapshot> dataSnapshotIterable = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = dataSnapshotIterable.iterator();
                while ((iterator.hasNext()))
                {
                    Project value = iterator.next().getValue(Project.class);
                    projectList.add(value);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Name = (TextView) findViewById(R.id.name);
        Email = (TextView) findViewById(R.id.email);

    }




    public void AddProject(View view) {
        Intent intent = new Intent(this, AddProjects.class);
        startActivity(intent);
    }


}
