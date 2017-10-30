package mapp.nnp.n.testjsonfile.sampleJSONSaving;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import mapp.nnp.n.testjsonfile.R;

import static mapp.nnp.n.testjsonfile.R.id.floatingActionButton;

/**
 * Created by nithin on 10/25/2017.
 */

public class SampleActivity extends AppCompatActivity {

    public static final String FILENAME = "dataValue.json";


    StoreRetrieveDataValues storeRetrieveData;
    private ArrayList<DataValueItems> mToDoItemsArrayList;

    public  ArrayList<DataValueItems> getLocallyStoredData(StoreRetrieveDataValues storeRetrieveData){
        ArrayList<DataValueItems> items = null;

        try {
            items  = storeRetrieveData.loadFromFile();

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        if(items == null){
            items = new ArrayList<>();
        }
        return items;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_sample);



        storeRetrieveData = new StoreRetrieveDataValues(this, FILENAME);
        mToDoItemsArrayList =  getLocallyStoredData(storeRetrieveData);


        FloatingActionButton fab=(FloatingActionButton)findViewById(floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"pop",Toast.LENGTH_SHORT).show();

                DataValueItems item=new DataValueItems("Hii");
                mToDoItemsArrayList.add(item);

                try {
                    StoreRetrieveDataValues.saveToFile(mToDoItemsArrayList);
                } catch (Exception e) {
//                    e.printStackTrace();
                    Log.e("TEST"," error"+e);

                }


            }
        });


        for(int i = 0; i<mToDoItemsArrayList.size();i++){

            Log.e("TEST","tets:"+mToDoItemsArrayList.get(i).getItemTEXTData());
//            if(item.getIdentifier().equals(mToDoItemsArrayList.get(i).getIdentifier())){
//                mToDoItemsArrayList.set(i, item);
//                existed = true;
//                adapter.notifyDataSetChanged();
//                break;
//            }
        }

//        for(int i = 0; i<mToDoItemsArrayList.size();i++){
//            if(item.getIdentifier().equals(mToDoItemsArrayList.get(i).getIdentifier())){
//                mToDoItemsArrayList.set(i, item);
//                existed = true;
//                adapter.notifyDataSetChanged();
//                break;
//            }
//        }

    }

    private void addToDataStore(DataValueItems item){
        mToDoItemsArrayList.add(item);


//        Log.e("TEST","value:"+mToDoItemsArrayList.size() - 1);
//        adapter.notifyItemInserted(mToDoItemsArrayList.size() - 1);


    }




}
