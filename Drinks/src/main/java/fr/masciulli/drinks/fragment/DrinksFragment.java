package fr.masciulli.drinks.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import fr.masciulli.drinks.activity.DrinkActivity;
import fr.masciulli.drinks.adapter.DrinksListAdapter;
import fr.masciulli.drinks.R;

public class DrinksFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private DrinksListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_drinks, container, false);

        mListView = (ListView) root.findViewById(R.id.list);
        mListView.setOnItemClickListener(this);
        mListAdapter = new DrinksListAdapter(getActivity());
        mListView.setAdapter(mListAdapter);

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), DrinkActivity.class);
        intent.putExtra("drink_name", mListAdapter.getItem(i).getName());
        startActivity(intent);
    }
}
