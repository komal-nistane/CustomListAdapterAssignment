package com.example.employeeinformation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.employeeinformation.R;

public class DetailedViewFragment extends Fragment  {

    private static String TAG = DetailedViewFragment.class.getSimpleName();
    /**
     * Holds employee name text view instance
     */
    private  TextView mNameView;
    /**
     * Holds employee profession text view instance
     */
    private TextView mprofessionView;
    /**
     * Holds employee image view instance
     */
    private ImageView mEmployeeImageView;
    /**
     * Holds back  button  view instance
     */
    private Button mButtonBack ;

    public DetailedViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fragment_detailed_view, container, false);

        if (getArguments() != null) {

            mNameView = (TextView) layoutView.findViewById(R.id.edit_text_empName);
            mprofessionView = (TextView) layoutView.findViewById(R.id.text_view_designation);
            mEmployeeImageView = (ImageView) layoutView.findViewById(R.id.image_view_employee_image);
            mButtonBack = (Button) layoutView.findViewById(R.id.button_back_fragment);

            int employeeImage = getArguments().getInt("EmployeeImage");
            String empName = getArguments().getString("EmployeeName");
            String empProf = getArguments().getString("EmployeeProfession");

            mEmployeeImageView.setImageResource(employeeImage);
            mNameView.setText(empName);
            mprofessionView.setText(empProf);
            mButtonBack.setOnClickListener(listener);
        }

        return layoutView;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_back_fragment:
                    Log.v(TAG,"Back Button clicked");
                    FragmentTransaction fragment =  getFragmentManager().beginTransaction();
                    fragment.replace(R.id.content ,new CustomListFragment());
                    fragment.commit();
                    break;

            }
        }
    };
}


