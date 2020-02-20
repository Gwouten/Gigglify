package deloof.wouter.gigglify.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class JokeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Joke>> jokes;

    private void loadJokes() {
        ArrayList<Joke> newJokes = new ArrayList<Joke>();
        newJokes.add(new Joke("Het zingt en hangt aan de muur", "Kader Abraham"));
        newJokes.add(new Joke("Het is groen en tis lekker", "Kermit de snicker"));
        newJokes.add(new Joke("Het is grijs, zwaar en hangt in een boom", "Een tros beton"));
        newJokes.add(new Joke("Het is geel, zwart en hard", "Maya de kei"));

        jokes.setValue(newJokes);
    }

    public MutableLiveData<ArrayList<Joke>> getJokes(){
        if ( jokes == null ){
            jokes = new MutableLiveData<>();
            loadJokes();
        }
        return jokes;
    }
}
