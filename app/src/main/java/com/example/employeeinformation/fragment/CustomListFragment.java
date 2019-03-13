package com.example.employeeinformation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.employeeinformation.R;
import com.example.employeeinformation.model.Employee;

import java.util.ArrayList;

public class CustomListFragment extends Fragment {

    private static final String TAG = CustomListFragment.class.getSimpleName();

    CustomAdapter mCustomAdapter ;

    public CustomListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_list, container, false);

        final ListView listView = (ListView) view.findViewById(R.id.employeeList);

        mCustomAdapter = new CustomAdapter(getContext(), new Employee());
        listView.setAdapter(mCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailedViewFragment detailedViewFragment = new DetailedViewFragment();

                Employee employeeItem =(Employee) mCustomAdapter.getItem(position);
                Bundle bundle = new Bundle();
                Log.v(TAG,"emp name: "+  mCustomAdapter.getItem(position).toString());
                bundle.putInt("EmployeeImage",employeeItem.getImage());
                bundle.putString("EmployeeName" ,employeeItem.getName());
                bundle.putString("EmployeeProfession" ,employeeItem.getProfession());
                detailedViewFragment.setArguments(bundle);
                FragmentTransaction fragment =  getFragmentManager().beginTransaction();
                fragment.replace(R.id.content ,detailedViewFragment);
                fragment.commit();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    class CustomAdapter extends BaseAdapter {
        ArrayList<Employee> employees;
        Context context;

        public CustomAdapter(Context c, Employee emp) {
            context = c;
            employees = emp.getEmployeeList();
        }

        @Override
        public int getCount() {
            return employees.size();
        }

        @Override
        public Object getItem(int position) {
            return employees.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.fragment_custom_row, parent, false);
            ImageView img = (ImageView) row.findViewById(R.id.imageView);
            TextView name = (TextView) row.findViewById(R.id.textViewName);
            TextView profession = (TextView) row.findViewById(R.id.textViewProfession);
            Employee employee = employees.get(position);

            img.setImageResource(employee.getImage());
            name.setText(employee.getName());
            profession.setText(employee.getProfession());

            return row;
        }
    }
}