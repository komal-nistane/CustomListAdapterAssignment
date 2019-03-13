package com.example.employeeinformation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.employeeinformation.R;
import com.example.employeeinformation.model.Employee;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    /**
     * Holds list of employees
     */
    ArrayList<Employee> employees;
    /**
     * Holds application context
     */
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
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