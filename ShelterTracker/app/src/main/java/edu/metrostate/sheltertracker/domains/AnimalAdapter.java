import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import edu.metrostate.sheltertracker.R;

public class AnimalAdapter extends ArrayAdapter<Animal> {
    public AnimalAdapter(Context context, List<Animal> animalList) {
        super(context, R.layout.animal_list_item, animalList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.animal_list_item, parent, false);
        }

        TextView id = convertView.findViewById(R.id.animal_id);
        TextView name = convertView.findViewById(R.id.animal_name);

        id.setText(getItem(position).getAnimalId());
        name.setText(getItem(position).getAnimalName());

        return convertView;
    }
}
