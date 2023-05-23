package com.example.mobilProje;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class notificationsFragment extends Fragment {
    List<places> lstBook;
    public Context mContext;

    private View rootView;
    com.example.mobilProje.recyclerViewAdapter recyclerViewAdapter;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public notificationsFragment() {
    }


    public static notificationsFragment newInstance(String param1, String param2) {
        notificationsFragment fragment = new notificationsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstBook = new ArrayList<>();
        lstBook.add(new places("İstanbul","Şehir","Description book",R.drawable.izmir));
        lstBook.add(new places("İzmir","Şehir","Description book",R.drawable.istanbul));
        lstBook.add(new places("Ankara","Şehir","Description book",R.drawable.ankara));
        lstBook.add(new places("Eskişehir","Şehir","Description book",R.drawable.eskisehir));
        lstBook.add(new places("Kapadokya","Categorie Book","Description book",R.drawable.kapadokya));
        lstBook.add(new places("Mardin","Categorie Book","Description book",R.drawable.mardin));
        lstBook.add(new places("Pamukkale","Şehir","Description book",R.drawable.pamukkale));
        lstBook.add(new places("Van","Şehir","Description book",R.drawable.van));
        lstBook.add(new places("Eskişehir","Şehir","Description book",R.drawable.eskisehir));
        lstBook.add(new places("Kapadokya","Şehir","Description book",R.drawable.kapadokya));
        lstBook.add(new places("Mardin","Şehir","Description book",R.drawable.mardin));
        lstBook.add(new places("Pamukkale","Şehir","Description book",R.drawable.pamukkale));
        lstBook.add(new places("Van","Şehir","Description book",R.drawable.van));
        lstBook.add(new places("Eskişehir","Şehir","Description book",R.drawable.eskisehir));
        lstBook.add(new places("Kapadokya","Şehir","Description book",R.drawable.kapadokya));
        lstBook.add(new places("İstanbul","Şehir","Description book",R.drawable.izmir));
        lstBook.add(new places("İzmir","Şehir","Description book",R.drawable.istanbul));
        lstBook.add(new places("Ankara","Şehir","Description book",R.drawable.ankara));
        lstBook.add(new places("Eskişehir","Şehir","Description book",R.drawable.eskisehir));
        lstBook.add(new places("Kapadokya","Categorie Book","Description book",R.drawable.kapadokya));
        lstBook.add(new places("Mardin","Categorie Book","Description book",R.drawable.mardin));
        lstBook.add(new places("Pamukkale","Şehir","Description book",R.drawable.pamukkale));
        lstBook.add(new places("Van","Şehir","Description book",R.drawable.van));
        lstBook.add(new places("Eskişehir","Şehir","Description book",R.drawable.eskisehir));
        lstBook.add(new places("Kapadokya","Şehir","Description book",R.drawable.kapadokya));
        lstBook.add(new places("Mardin","Şehir","Description book",R.drawable.mardin));
        lstBook.add(new places("Pamukkale","Şehir","Description book",R.drawable.pamukkale));
        lstBook.add(new places("Van","Şehir","Description book",R.drawable.van));
        lstBook.add(new places("Eskişehir","Şehir","Description book",R.drawable.eskisehir));
        lstBook.add(new places("Kapadokya","Şehir","Description book",R.drawable.kapadokya));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_notifications, container, false);
        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.recyclerview_id);
        recyclerViewAdapter = new recyclerViewAdapter(getContext(),lstBook);
        //myrv.setAdapter(recyclerViewAdapter);
        myrv.setLayoutManager(new GridLayoutManager(getContext(),3));
            myrv.setAdapter(recyclerViewAdapter);
        return rootView;

    }
}