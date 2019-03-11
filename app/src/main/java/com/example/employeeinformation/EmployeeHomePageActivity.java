package com.example.employeeinformation;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.example.employeeinformation.fragment.BaseFragment;
import com.example.employeeinformation.fragment.CustomListFragment;

public class EmployeeHomePageActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home_page);

        CustomListFragment customListFragment = new CustomListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.content,customListFragment , customListFragment.getTag()).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
