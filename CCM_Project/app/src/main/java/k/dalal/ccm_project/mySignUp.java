package k.dalal.ccm_project;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.FirebaseDatabase;

public class mySignUp extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextName;

    private FirebaseAuth mAuth;

    String myEmail;
    String myPassword;
    String myName;

    private DatabaseReference databaseReference;

    //DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    //DatabaseReference mConditionRef = mRootRef.child("users");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sign_up);


        mAuth = FirebaseAuth.getInstance();



    }

    public void mySignUp(View view) {

        //databaseReference = FirebaseDatabase.getInstance().getReference("users");

        //FirebaseDatabase database = FirebaseDatabase.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("users");



        editTextEmail = (EditText)findViewById(R.id.inputEmail);
        myEmail = editTextEmail.getText().toString();

        editTextPassword = (EditText)findViewById(R.id.inputPassword);
        myPassword = editTextPassword.getText().toString();

        editTextName = (EditText)findViewById(R.id.inputName);
        myName = editTextName.getText().toString();

        //Toast.makeText(this, "Toast " + myEmail, Toast.LENGTH_LONG).show();
        //myRef.setValue("FishFood");

        //String email = databaseReference.push().getKey();

        //mDatabase.setValue("Food2");


        //databaseReference.child(user.getEmail()).setValue(user);

        //Toast.makeText(this, "Toast " + user.getPassword() , Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "Toast" + user.getName(), Toast.LENGTH_LONG).show();



        //databaseReference.child("users").child("Email").setValue(user.getEmail());
         // Adds Email Keyvalue to DB




        if(myEmail.isEmpty())
        {
            editTextEmail.setError("Email not there, You dumb fuck");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(myEmail).matches())
        {
            editTextEmail.setError("Email isn't valid, You dumb fuck");
            editTextEmail.requestFocus();
            return;
        }

        if(myPassword.length()<6)
        {
            editTextPassword.setError("Password is less then 6, you dumb fuck");
            editTextPassword.requestFocus();
            return;
        }

        if(myPassword.isEmpty())
        {
            editTextPassword.setError("Password empty, you dumb fuck");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(myEmail, myPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(), "Welcome to the Application, Don't fuck it up.", Toast.LENGTH_SHORT).show();

                            // Get user from Auth and add to RealTimeDB
                            User user = new User(myEmail, myPassword, myName);
                            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                            databaseReference.child(currentFirebaseUser.getUid()).setValue(user);

                        } else {

                            if(task.getException() instanceof FirebaseAuthUserCollisionException)
                            {
                                Toast.makeText(getApplicationContext(), "You are already Registered, Fk you.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "Some error occurred, give up now!", Toast.LENGTH_SHORT).show();
                            }
                        }


                    }
                });


    }
}