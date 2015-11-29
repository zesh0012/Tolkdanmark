package com.example.zeshan.tolkdanmark;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Zeshan on 26-11-2015.
 */
public class Godkendelse extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    Button Afvis,Godkend;
    public Godkendelse() {
    }

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        View rod = i.inflate(R.layout.godkendelse, container, false);

        String[] Tolkning = {"Tolkning1", "Tolkning2","Tolkning3"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listviewlayout, R.id.tvSimpletext, Tolkning){

            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Afvis = (Button) view.findViewById(R.id.Afvis);
                Godkend = (Button) view.findViewById(R.id.Godkend);
                Godkend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String value = (String) getItem(position);
                        onButtonClick(value, "godkendt");
                    }
                });
                Afvis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String value = (String) getItem(position);
                        onButtonClick(value, "afvis");
                    }
                });
                return view;
            }

        };
        listView = (ListView) rod.findViewById(R.id.listView);
        listView.setOnItemClickListener(Godkendelse.this);

        listView.setAdapter(adapter);
        return rod;

    }

    private void onButtonClick(String value, String type) {
    System.out.println(value+" "+type);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(position);
    }
}