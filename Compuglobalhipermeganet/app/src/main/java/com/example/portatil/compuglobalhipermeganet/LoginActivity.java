package com.example.portatil.compuglobalhipermeganet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText etEmailLogin;
    private EditText etPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance(); //Instanciamos el login de firebase
        etEmailLogin = (EditText)findViewById(R.id.etEmailLogin);
        etPasswordLogin = (EditText)findViewById(R.id.etPasswordLogin);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Comprobamos si el usuario ya se habia logueado antes
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void logIn(View view){
        if (!validateForm()) {
            return;
        }
        String email = etEmailLogin.getText().toString();
        String password = etPasswordLogin.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                       /*if (!task.isSuccessful()) {
                           mStatusTextView.setText(R.string.auth_failed);
                       }
                       hideProgressDialog();
                       // [END_EXCLUDE]*/
                    }
                });
    }
    private boolean validateForm() {
        boolean valid = true;

        String email = etEmailLogin.getText().toString();
        if (TextUtils.isEmpty(email)) {
            etEmailLogin.setError("Required.");
            valid = false;
        } else {
            etEmailLogin.setError(null);
        }

        String password = etPasswordLogin.getText().toString();
        if (TextUtils.isEmpty(password)) {
            etPasswordLogin.setError("Required.");
            valid = false;
        } else {
            etPasswordLogin.setError(null);
        }

        return valid;
    }

    private void updateUI(FirebaseUser user) {
        //hideProgressDialog();
        if (user != null) {
            //mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,
            //user.getEmail(), user.isEmailVerified()));
            //mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            //findViewById(R.id.email_password_buttons).setVisibility(View.GONE);
            //findViewById(R.id.email_password_fields).setVisibility(View.GONE);
            //findViewById(R.id.signed_in_buttons).setVisibility(View.VISIBLE);

            //findViewById(R.id.verify_email_button).setEnabled(!user.isEmailVerified());
        } else {
            //mStatusTextView.setText(R.string.signed_out);
            //mDetailTextView.setText(null);

            /*findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
            findViewById(R.id.email_password_fields).setVisibility(View.VISIBLE);
            findViewById(R.id.signed_in_buttons).setVisibility(View.GONE);
            */
        }
    }
}
