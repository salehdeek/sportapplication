package edu.birzeit.sport.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.birzeit.sport.R;
import edu.birzeit.sport.playersPages.Benzima;
import edu.birzeit.sport.playersPages.Cristiano;
import edu.birzeit.sport.playersPages.Liva;
import edu.birzeit.sport.playersPages.Messi;
import edu.birzeit.sport.services.PlayerService;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StaticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StaticsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String[] players;
    ListView listView;
    Spinner spinner;
    private PlayerService playerService = PlayerService.getPlayerService();

    private String mParam1;
    private String mParam2;

    public StaticsFragment() {
    }

    public static StaticsFragment newInstance(String param1, String param2) {
        StaticsFragment fragment = new StaticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.statics_page, container, false);
        setPlayersListView();
        listView = (ListView) view.findViewById(R.id.players_list);


        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.support_simple_spinner_dropdown_item, players
        );
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = null;
                if (position == 0) {
                    intent = new Intent(getActivity(), Cristiano.class);
                }
                if (position == 1) {
                    intent = new Intent(getActivity(), Messi.class);
                }
                if (position == 2) {
                    intent = new Intent(getActivity(), Liva.class);

                }
                if (position == 3) {
                    intent = new Intent(getActivity(), Benzima.class);

                }
                startActivity(intent);
            }
        });


        return view;
    }


    public void setPlayersListView() {
        List<String> playersNames = playerService.getPlayersNames();
        players = new String[playersNames.size()];
        players = playersNames.toArray(players);

    }

}