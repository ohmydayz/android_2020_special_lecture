package kr.co.widgetsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MainFragment extends Fragment {
    private String[] widgetList = new String[]{"Button", "TextView", "EditText", "ImageView", "Switch", "RadioGroup & RadioButton", "Checkbox", "RecyclerView"};

    private ArrayAdapter<String> listAdapter;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = rootView.findViewById(R.id.listview);
        listAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View itemView = super.getView(position, convertView, parent);
                TextView textView = itemView.findViewById(android.R.id.text1);
                textView.setText(getItem(position));
                return itemView;
            }
        };
        listAdapter.addAll(widgetList);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getActivity().setTitle(widgetList[i] + " Sample");
                MainFragmentDirections.MoveAction action = MainFragmentDirections.moveAction();
                action.setId(i);
                Navigation.findNavController(view).navigate(action);
            }
        });


        return rootView;
    }

}
