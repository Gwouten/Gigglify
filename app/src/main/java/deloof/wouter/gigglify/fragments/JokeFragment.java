package deloof.wouter.gigglify.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import deloof.wouter.gigglify.R;
import deloof.wouter.gigglify.model.Joke;
import deloof.wouter.gigglify.model.JokeViewModel;
import deloof.wouter.gigglify.utils.JokeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeFragment extends Fragment {


    public JokeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);

        RecyclerView rvJokes = rootView.findViewById(R.id.rv_jokes);
        // oriëntatie recycler, als lijst of grid
        RecyclerView.LayoutManager manager;

//        manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        manager = new GridLayoutManager(getContext(), 2);

        rvJokes.setLayoutManager(manager);
        //adpater om data in te vullen in de card layout
        final JokeAdapter adapter = new JokeAdapter();
        rvJokes.setAdapter(adapter);

        // verwijzen naar ViewModel
        JokeViewModel model = new ViewModelProvider(this).get(JokeViewModel.class);
        model.getJokes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Joke>>() {
            @Override
            public void onChanged(ArrayList<Joke> jokes) {
                adapter.addItems(jokes);
            }
        });

        return rootView;
    }

}
