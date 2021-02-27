package com.example.myproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends Activity {
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        mAuth = FirebaseAuth.getInstance();

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        findViewById(R.id.button).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button:
                    signUp();
                    break;
            }
        }
    };

    private void signUp(){

        String email = ((EditText) findViewById(R.id.EmailEditText)).getText().toString();
        final String password = ((EditText) findViewById(R.id.PasswordEditText)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.PasswordCheckEditText)).getText().toString();

        if (password.equals(passwordCheck)){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getApplicationContext(), "회원가입 성공",
                                        Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                if (password.length()<6){
                                    Toast.makeText(getApplicationContext(), "비밀번호는 6자리 이상이어야 합니다",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "이메일 형식이 잘못되었습니다. 다시 입력해주세요",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }

                            // ...
                        }
                    });
        }
        else{
            Toast.makeText(getApplicationContext(), "비밀번호가 다릅니다. 다시 확인해주세요",
                    Toast.LENGTH_SHORT).show();
        }

    }

}
