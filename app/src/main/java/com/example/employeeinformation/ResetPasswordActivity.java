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

    /**
     * Holds new password edit text  view instance
     */
    private EditText mNewPassword;
    /**
     * Holds confirm password edit text  view instance
     */
    private EditText mConfirmPassword ;
    /**
     * Holds submit button view instance
     */
    private Button mButtonsubmit ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initializeComponents();

    }

    /**
     * Initialise View Components
     */
    private void initializeComponents() {
        mNewPassword = (EditText)findViewById(R.id.edit_text_newPassword);
        mConfirmPassword =(EditText)findViewById(R.id.edit_text_confirmPassword);
        mButtonsubmit =(Button)findViewById(R.id.button_submit);
        mButtonsubmit.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button_submit:
                resetPassword();
                break;
            }
        }
    };

    /**
     * reset password if new password matches confirm password
     */
    private void resetPassword() {
        String newPassword = mNewPassword.getText().toString();
        String confirmPassword = mConfirmPassword.getText().toString();
        Log.v("New Password ", newPassword);
        Log.v("confirm Password ", confirmPassword);
        if(newPassword.isEmpty())
        {
            mNewPassword.setError("New Password can not be empty");
            mNewPassword.requestFocus();
        }else if (confirmPassword.isEmpty()){
            mConfirmPassword.setError("Confirm Password can not be empty");
            mConfirmPassword.requestFocus();
        }
        else if(newPassword.equals(confirmPassword))
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
                            mNewPassword.getText().clear();
                            mConfirmPassword.getText().clear();
                            mNewPassword.requestFocus();
                        }
                    }).show();
        }
    }

}
