package cl.telematica.android.rexceta;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HorizontalListFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    protected RecyclerView.Adapter myadapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_imagen_list, container, false);

        final RecyclerView myRecyclerView = (RecyclerView) view.findViewById(R.id.list_imagenes);
        myRecyclerView.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        myRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {


            @Override
            protected void onPreExecute() {

            }

            @Override
            protected String doInBackground(Void... params) {
                String resultado = new httpServerConnection().
                        connectToServer("http://alumnos.inf.utfsm.cl/~nvalenzu/json/pizzas_filtro", 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String result) {
                if (result != null) {
                    System.out.println(result);

                    myadapter = new HorizontalRecyclerViewAdapter(getImagenes(result));
                    myRecyclerView.setAdapter(myadapter);
                } else
                    System.out.println("No existe el usuario ingresado");
            }

        };

        task.execute();
        return view;
    }

    private List<item_recomendados> getImagenes(String result) {
        List<item_recomendados> imagenes = new ArrayList<item_recomendados>();

        try
        {
            JSONArray lista = new JSONArray(result);
            int size = lista.length();
            for (int i = 0; i < size; i++) {
                item_recomendados item_reco = new item_recomendados();
                JSONObject objeto = lista.getJSONObject(i);
                item_reco.setImagen(objeto.getString("imagen"));
                imagenes.add(item_reco);
            }
            return imagenes;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            return imagenes;
        }
    }


    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(Uri uri);
    }
}

