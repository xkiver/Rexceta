package cl.telematica.android.rexceta;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaRecetas extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myadapter;
    private RecyclerView.LayoutManager mylayoutManager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

        myRecyclerView = (RecyclerView) findViewById(R.id.recicler_view);
        myRecyclerView.setHasFixedSize(true);
        mylayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        myRecyclerView.setLayoutManager(mylayoutManager);

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected String doInBackground(Void... params) {
                String resultado = new httpServerConnection().connectToServer("http://alumnos.inf.utfsm.cl/~nvalenzu/json/pizzas_filtro", 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String result) {
                if (result != null) {
                    System.out.println(result);
                    final List lista = getLista(result);
                    myadapter = new UIAdapter(lista);
                    myRecyclerView.setAdapter(myadapter);
                    myRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                            myRecyclerView, new ClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            Item_Receta rec = (Item_Receta) lista.get(position);
                            String json = rec.getlinkJS();
                            Intent i = new Intent(ListaRecetas.this, RecetaMain.class);
                            i.putExtra("json", json);
                            startActivity(i);
                        }
                        @Override
                        public void onLongClick(View view, int position) {

                        }
                    }));
                }
            }
        };

        task.execute();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private List<Item_Receta> getLista(String result) {
        List<Item_Receta> listarepos = new ArrayList<Item_Receta>();
        try {
            JSONArray lista = new JSONArray(result);

            int size = lista.length();
            for (int i = 0; i < size; i++) {
                Item_Receta item_receta = new Item_Receta();
                JSONObject objeto = lista.getJSONObject(i);

                item_receta.setNombre(objeto.getString("nombre"));
                item_receta.setDescripcion(objeto.getString("descripcion"));
                item_receta.setValoracion(objeto.getInt("valoracion"));
                item_receta.setVideo(objeto.getString("video"));
                item_receta.setImagen(objeto.getString("imagen"));
                item_receta.setLinkJS(objeto.getString("json"));
                //item_receta.setDificultad(objeto.getString("dificultad"));


                listarepos.add(item_receta);
            }
            return listarepos;
        } catch (JSONException e) {
            e.printStackTrace();
            return listarepos;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ListaRecetas Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

