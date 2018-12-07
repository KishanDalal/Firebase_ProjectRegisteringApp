package k.dalal.ccm_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    String myEmail;
    String myPassword;

    private EditText editTextEmail;
    private EditText editTextPassword;


    private RecyclerView mRecyclerView;

    private final LinkedList<String> mWordList = new LinkedList<>();
    private List<Project> Project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    private void initalizeData() {
    }


    public void SignUp(View view) {
        Intent intent = new Intent(this, mySignUp.class);
        startActivity(intent);
    }

    public void Login(View view) {

        editTextEmail = (EditText)findViewById(R.id.inputLoginEmail);
        myEmail = editTextEmail.getText().toString().trim();

        editTextPassword = (EditText)findViewById(R.id.inputLoginPassword);
        myPassword = editTextPassword.getText().toString().trim();


        if(myEmail.isEmpty())
        {
            editTextEmail.setError("Please enter a email.");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(myEmail).matches())
        {
            editTextEmail.setError("Email is invalid, please try again.");
            editTextEmail.requestFocus();
            return;
        }

        if(myPassword.length()<6)
        {
            editTextPassword.setError("Password must be greater then 6 characters, please try again");
            editTextPassword.requestFocus();
            return;
        }

        if(myPassword.isEmpty())
        {
            editTextPassword.setError("Please enter a password.");
            editTextPassword.requestFocus();
            return;
        }




        mAuth.signInWithEmailAndPassword(myEmail, myPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {

                    Intent intent1 = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent1);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Your email or your password is incorrect, please try again.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
