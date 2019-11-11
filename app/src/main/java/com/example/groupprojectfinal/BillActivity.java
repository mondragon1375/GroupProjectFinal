package com.example.groupprojectfinal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BillActivity extends Fragment {
    private OnFragmentInteractionListener mListener;

    DatabaseHelper mDatabaseHelper;
    private ListView mListView;
    private TextView totalBill;
    double itemCost = 0;

    public BillActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mListView = (ListView)getView().findViewById(R.id.runListView);
        totalBill = (TextView)getView().findViewById(R.id.totalCost);
        mDatabaseHelper = new DatabaseHelper(getContext());

        DecimalFormat df  = new DecimalFormat("#,###,##0.00");
        Cursor data = mDatabaseHelper.getData();

        ArrayList<String> runData = new ArrayList<>();
        while (data.moveToNext()) {
            runData.add(data.getString(1) + ", " + data.getString(2) + " dollars");     // Name of runner
            itemCost += Double.parseDouble(data.getString(2));
            totalBill.setText("The bill today is $ " + df.format(itemCost));
        }
        ListAdapter adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, runData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String food = adapterView.getItemAtPosition(i).toString();
                String shortName = "";
                int loc = food.indexOf(",");

                if (loc != -1)
                    shortName = food.substring(0, loc);
                else
                    shortName = food;

                Cursor data = mDatabaseHelper.getItemID(shortName);
                int itemID = -1;

                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                }

                if (itemID > -1) {
                    Intent intent = new Intent(getContext(), EditFoodItemActivity.class);
                    intent.putExtra(EditFoodItemActivity.ID, itemID);
                    intent.putExtra(EditFoodItemActivity.NAME, shortName);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getContext(), "No ID associated with that name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return inflater.inflate(R.layout.fragment_bill, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
