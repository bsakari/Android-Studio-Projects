package com.kingwanyama.tabbed;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {
    ListView products_list;
    String[] data={"Clothes","Shues","Cars","Kitchen","God","Superior","King","Officer","Manager","Cadet","Ambia","Pharao","Nimeokoka","Sitarudi","Tena","Misri","Naenda","CANAAN",""};


    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_products, container, false);
        products_list = (ListView) root.findViewById(R.id.products_list);
        //Adapter
        //ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, data);


        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.list_item_layout,R.id.list_item, data);
        products_list.setAdapter(adapter);
        products_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String product = data[position];
                Snackbar.make(view,product,Snackbar.LENGTH_LONG).show();
            }
        });
        return root;
    }

}
