package deloof.wouter.gigglify.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import deloof.wouter.gigglify.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    private View.OnClickListener startButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(R.id.start_to_jokelist);
        }
    };

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);

        Button btnStart = rootView.findViewById(R.id.btn_start);
        btnStart.setOnClickListener(startButtonListener);

        return rootView;
    }

}
