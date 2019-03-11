package com.example.employeeinformation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResetPasswordActivity extends BaseActivity {

    EditText newPass ,confirmPass ;
    Button submit ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initializeComponents();

    }

    private void initializeComponents() {
        newPass = (EditText)findViewById(R.id.newPass);
        confirmPass =(EditText)findViewById(R.id.confirmPass);
        submit =(Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnSubmit) {
                resetPassword();
            }
        }
    };

    private void resetPassword() {
        String newPassword = newPass.getText().toString();
        String confirmPassword = confirmPass.getText().toString();
        Log.v("New Password ", newPassword);
        Log.v("confirm Password ", confirmPassword);
        if(newPassword.equals(confirmPassword))
        {
            Log.v("Password Matches", confirmPassword);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("newPassword", newPassword);
            setResult(RESULT_OK, intent);
            super.finish();
        }else{
            AlertDialog resetPassAlert = new AlertDialog.Builder(this)
                    .setTitle("Alert")
                    .setMessage("New password and Confirm Password does not matches.").
                            setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            newPass.getText().clear();
                            confirmPass.getText().clear();
                            newPass.requestFocus();
                        }
                    }).show();
        }
    }

}
