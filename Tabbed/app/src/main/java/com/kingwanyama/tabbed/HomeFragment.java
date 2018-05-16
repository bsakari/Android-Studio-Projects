package com.kingwanyama.tabbed;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ListView home_list;
    String [] data={"kenya","Uganda","Tanzania","Zambia","Zaire","Mouritius",
            "Egypt","Canada","Morocco","Congo","Bukinafaso","Rwanda","Burundi","Nigeria","Sudan",""};


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        home_list = (ListView) root.findViewById(R.id.home_list);
       // ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, data);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.list_item_layout,R.id.list_item, data);

        home_list.setAdapter(adapter);

        home_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String product=data[position];
                Snackbar.make(view,product,Snackbar.LENGTH_LONG).show();

            }
        });



        return root;
    }

}
