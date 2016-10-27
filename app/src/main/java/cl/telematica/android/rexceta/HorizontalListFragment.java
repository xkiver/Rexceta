package cl.telematica.android.rexceta;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;


public class HorizontalListFragment extends Fragment {

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myadapter;
    private RecyclerView.LayoutManager mylayoutManager;

    private OnFragmentInteractionListener mListener;



    public interface OnFragmentInteractionListener{

        public void onFragmentInteraction(Uri uri);
    }


}
