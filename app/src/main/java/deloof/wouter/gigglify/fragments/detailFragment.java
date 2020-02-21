package deloof.wouter.gigglify.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;

import deloof.wouter.gigglify.R;
import deloof.wouter.gigglify.model.Joke;

/**
 * A simple {@link Fragment} subclass.
 */
public class detailFragment extends Fragment {


    public detailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView tvJoke      = rootView.findViewById(R.id.tv_detail_joke);
        TextView tvPunchline = rootView.findViewById(R.id.tv_detail_punchline);

        Bundle receivedData = getArguments();
        if (receivedData != null) {
            if(receivedData.containsKey("passedJoke")){
                Joke joke = (Joke) receivedData.getSerializable("passedJoke");
                tvJoke.setText(joke.getSetup());
                tvPunchline.setText(joke.getPunchline());
            }
        }

        return rootView;
    }

}
