package com.example.employeeinformation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.employeeinformation.R;

public class DetailedViewFragment extends Fragment {

    public DetailedViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fragment_detailed_view, container, false);

        if (getArguments() != null) {

            TextView names = (TextView) layoutView.findViewById(R.id.empName);
            TextView profession = (TextView) layoutView.findViewById(R.id.empProfession);
            ImageView image = (ImageView) layoutView.findViewById(R.id.employeeImage);

            int employeeImage1 = getArguments().getInt("EmployeeImage");
            String empName = getArguments().getString("EmployeeName");
            String empProf = getArguments().getString("EmployeeProfession");

            image.setImageResource(employeeImage1);
            names.setText(empName);
            profession.setText(empProf);

        }

        return layoutView;
    }
}


