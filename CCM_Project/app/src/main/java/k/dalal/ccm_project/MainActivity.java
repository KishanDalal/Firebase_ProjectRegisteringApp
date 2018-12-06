package k.dalal.ccm_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    String myEmail;
    String myPassword;

    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


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

        //Toast.makeText(getApplicationContext(), myPassword, Toast.LENGTH_SHORT).show();


        mAuth.signInWithEmailAndPassword(myEmail, myPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Worked", Toast.LENGTH_LONG).show();
                    //Intent intent1 = new Intent(MainActivity.this, HomePage.class);
                    //startActivity(intent1);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
