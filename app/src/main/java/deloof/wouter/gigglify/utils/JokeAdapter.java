package deloof.wouter.gigglify.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import deloof.wouter.gigglify.R;
import deloof.wouter.gigglify.model.Joke;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    // Viewholder maken
    class JokeViewHolder extends RecyclerView.ViewHolder {

        final TextView tvJoke;
        final Button btnGiggle;

        final View.OnClickListener detailListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //welke card?
                int pos = getAdapterPosition();

                //data in bundle om door te geven
                Bundle data = new Bundle();
                data.putSerializable("passedJoke", items.get(pos));
                //navigatie starten
                Navigation.findNavController(v).navigate(R.id.jokelist_to_detail, data);
            }
        };

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJoke = itemView.findViewById(R.id.tv_joke);
            btnGiggle = itemView.findViewById(R.id.btn_giggle);
            btnGiggle.setOnClickListener(detailListener);
        }
    }

    ArrayList<Joke> items;

    public JokeAdapter() {
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View card = layoutInflater.inflate(R.layout.joke_card, parent, false);
        return new JokeViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        Joke currentJoke = items.get(position);

        holder.tvJoke.setText(currentJoke.getSetup());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems( ArrayList<Joke> jokes ){
        items.addAll(jokes);
    }

}
