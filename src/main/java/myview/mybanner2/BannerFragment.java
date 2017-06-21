package myview.mybanner2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lib_sunshaobei2015.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BannerFragment extends Fragment {


    private ArrayList<String> list;
    private int position;

    public BannerFragment() {
        // Required empty public constructor
    }

    public BannerFragment(ArrayList<String> list, int position) {

        this.list = list;
        this.position = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO 由于使用state适配器所以不需要进行优化
        View view =  inflater.inflate(R.layout.fragment_banner, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Picasso.with(getActivity()).load(list.get(position)).into(imageView);
        return view;
    }

}
