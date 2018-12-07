package k.dalal.ccm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProjects extends AppCompatActivity {

    private EditText editTextProjectName;
    private EditText editTextProjectDescription;
    private EditText editTextProjectSize;

    private FirebaseAuth mAuth;

    String myProjectName;
    String myProjectDescription;
    String myProjectSize;

    private DatabaseReference databaseReference;
    private  DatabaseReference databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_projects);


    }

    public void myProjectAdd(View view) {

       databaseReference = FirebaseDatabase.getInstance().getReference("projects");
       databaseReference1 = FirebaseDatabase.getInstance().getReference("usersInProjects");


        editTextProjectName = (EditText)findViewById(R.id.editTextProjectName);
        myProjectName = editTextProjectName.getText().toString();

        editTextProjectDescription = (EditText)findViewById(R.id.editTextProjectDescription);
        myProjectDescription = editTextProjectDescription.getText().toString();

        editTextProjectSize = (EditText)findViewById(R.id.editTextProjectSize);
        myProjectSize = editTextProjectSize.getText().toString();

        if(myProjectName.isEmpty())
        {
            editTextProjectName.setError("Please enter a Project Name.");
            editTextProjectName.requestFocus();
            return;
        }

        if(myProjectDescription.isEmpty())
        {
            editTextProjectDescription.setError("Please enter a Project Description");
            editTextProjectDescription.requestFocus();
            return;
        }

        if(myProjectSize.isEmpty())
        {
            editTextProjectSize.setError("Please enter a size");
            editTextProjectSize.requestFocus();
            return;
        }

        if(Integer.parseInt(myProjectSize)>30)
        {
            editTextProjectSize.setError("Size must be less then 30, please try again");
            editTextProjectSize.requestFocus();
            return;
        }

        // Get user from Auth and add to RealTimeDB

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Project project = new Project(myProjectName, myProjectDescription, myProjectSize);


        // databaseReference.push().setValue(project);

        // Key of project
        String mProjectId = databaseReference.push().getKey();
        databaseReference.child(mProjectId).setValue(project);

        // Getting key of push so it can used
        Project project1 = new Project(currentFirebaseUser.getUid());
        databaseReference1.child(mProjectId).setValue(project1);

        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);

        Toast.makeText(this.getApplicationContext(), "Project has been created.", Toast.LENGTH_SHORT).show();
    }
}
