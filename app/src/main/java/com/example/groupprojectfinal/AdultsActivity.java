package com.example.groupprojectfinal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class AdultsActivity extends Fragment {
    private OnFragmentInteractionListener mListener;

    DatabaseHelper mDatabaseHelper;
    private Button buttonAdd;
    private TextView foodNameTV, foodCostTV;

    public AdultsActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        foodNameTV = (TextView)getView().findViewById(R.id.foodName);
        foodCostTV = (TextView)getView().findViewById(R.id.foodCost);
        buttonAdd = (Button)getView().findViewById(R.id.btnAdd);

        mDatabaseHelper = new DatabaseHelper(getContext());

        final ArrayAdapter<Food> listAdapter = new ArrayAdapter<>
                (getContext(), android.R.layout.simple_list_item_1, Food.adultsMenu);
        ListView listFoods = (ListView)getView().findViewById(R.id.listFoodChoices);
        listFoods.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listFoods, View itemView, int position, long id) {
                DecimalFormat df = new DecimalFormat("#,###,##0.00");

                String[] food = new String[Food.adultsMenu.length];
                Double[] cost = new Double[Food.adultsMenu.length];

                int i = position;
                food[i] = Food.adultsMenu[i].getFoodName();
                cost[i] = Food.adultsMenu[i].getFoodCost();

                String roundedValue = df.format(cost[i]);

                foodNameTV.setText(food[i]);
                foodCostTV.setText(roundedValue);
            }
        };
        listFoods.setOnItemClickListener(itemClickListener);

        addData();

        return inflater.inflate(R.layout.fragment_adults, container, false);
    }

    public void addData() {
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String food = foodNameTV.getText().toString();
                String cost = foodCostTV.getText().toString();

                if (food.length()!= 0 && cost.length() != 0) {
                    boolean insertData = mDatabaseHelper.addData(food, cost);
                    if(insertData) {
                        Toast.makeText(getContext(), "Successfully Added to Bill", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();

                    foodNameTV.setText("");
                    foodCostTV.setText("");
                }
                else
                    Toast.makeText(getContext(), "Please Choose an Item", Toast.LENGTH_SHORT).show();
            }
        });
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
