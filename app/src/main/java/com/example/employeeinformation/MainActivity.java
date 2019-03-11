package com.example.employeeinformation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

    EditText userName, password;
    Button btnLogin;
    private String myUserName, myPassword;
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

    }

    private void initComponents() {

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(listener);
        myUserName = "komal";
        myPassword = "komal@12345";
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.login) {
                loginAction();
            }
        }
    };

    private void loginAction() {

        String userNameStr = userName.getText().toString().trim();
        String passwordStr = password.getText().toString().trim();
        if (emptyFieldValidation()) {
            if (userNameStr.equals(myUserName) && passwordStr.equals(myPassword)) {

                openEmployeeActivity();
            } else {

                openResetPasswordActivity();

            }
        }
    }

    private void openEmployeeActivity() {
        Log.v("In User activity", "employee Activity");
        Intent intent = new Intent(this, EmployeeHomePageActivity.class);
        startActivity(intent);
    }

    private void openResetPasswordActivity() {
        AlertDialog resetPassAlert = new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Wrong UserName or Password").
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                clearFields();
                            }
                        }).setNegativeButton("Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clearFields();
                        Intent intent = new Intent(MainActivity.this,
                                ResetPasswordActivity.class);
                        startActivityForResult(intent, REQUEST_CODE);
                    }
                }).show();
    }

    public void clearFields() {
        userName.getText().clear();
        password.getText().clear();
        userName.requestFocus();
    }

    public boolean emptyFieldValidation() {
        if (userName.getText().toString().trim().equalsIgnoreCase("")) {
            userName.setError("Enter User Name");
            userName.requestFocus();
            return false;
        } else if (password.getText().toString().trim().equalsIgnoreCase("")) {
            password.setError("Enter Password");
            password.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.v("in main activity", "main activity");
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("newPassword")) {
                String result = data.getExtras().getString("newPassword");
                if (result != null && result.length() > 0) {
                    myPassword = result;
                }
            }
        }
    }
}
