package com.example.vinit.mydrop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * Created by manan on 11/23/15.
 */
public class Main extends AppCompatActivity {

    private static final String TAG = Main.class.getSimpleName();

    private JSONArray js2,js1;
    private JSONArray jsonArra;
    private String name1;
    private ProgressDialog pDialog;
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 2);



    private int currentPosition;
    private JSONArray array1 = new JSONArray();
//    private String url_path="http://www.mydrop.byethost10.com/display.php";
    String url_path;
    private String url_path1;


    //private String new_url_path="http://www.android1992.comyr.com/index";
    //private int current_page=2;
    private long id=1720494948169408L;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        url_path="http://www.android1992.comyr.com/display.php?id=1720494948169408";
  //      url_path = url_path + id;

        if((new ConnectionDetector(Main.this)).isConnectingToInternet()){
 //           Log.d("internet status","Internet Access");
  //          dbHandler.deletemovietable();


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HashMap<String, String> user = dbHandler.getUserDetails();

        name1 = user.get("email");
   //      url_path1="http://www.android1992.comyr.com/index3.php?name="+name1;



        new GetAllCustomerTask().execute();
        /*try {
            Thread.sleep(1500);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }*/

        }else{
            //          Log.d("internet status","no Internet Access");
            Intent newActivity = new Intent(Main.this, MainActivity.class);
            startActivity(newActivity);
            finish();
        }
    }

    public void setListAdapter(JSONArray jsonArray) {
        this.jsonArra=jsonArray;
        //      currentPosition = GetAllCustomerListView.getFirstVisiblePosition();

//        adapter= new ListViewAdapter(jsonArray,MainActivity.this);
//        this.GetAllCustomerListView.setAdapter(adapter);
    }
    private class GetAllCustomerTask extends AsyncTask<Void,Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... unused) {

//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
/*                    current_page+=1;
                    new_url_path="http://www.android1992.comyr.com/index";
                    new_url_path = new_url_path+current_page+".php";
                    //int currentPosition = GetAllCustomerListView.getFirstVisiblePosition();

                    try {
                        js=concatArray(js,js1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    */
                    //adapter= new ListViewAdapter(js,MainActivity.this);
            js1=ApiConnector.GetAllCustomers(url_path);
      //      js2 = ApiConnector.GetAllCustomers(url_path1);

            StoreAllMovie(js1);
//            if(js2!=null) {
//                StoreRMovie(js2);
//            }
//                }
//            });
            return (null);
        }

        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Intent newActivity = new Intent(Main.this, MainActivity.class);
            startActivity(newActivity);
            finish();

        }
    }
    private JSONArray concatArray(JSONArray... arrs)
            throws JSONException {
        JSONArray result = new JSONArray();
        for (JSONArray arr : arrs) {
            for (int i = 0; i < arr.length(); i++) {
                result.put(arr.get(i));
            }
        }
        return result;
    }

    //    private JSONArray divider(JSONArray array) throws JSONException {
//
//        JSONObject object = null;
//        for(int i=0;i<1;i++) {
//            try {
//                object = array.getJSONObject(sample);
//                sample++;
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
////        JSONArray array1 = new JSONArray();
//            array1.put(object);
//        }
//        Log.d("try", array1.toString());
//        return array1;
//    }
    @Override
    public void onDestroy()
    {


        super.onDestroy();
    }
    public void StoreAllMovie(JSONArray js){
//        for(int i=0;i<js.length();i++) {
            try {
                JSONObject jo = js.getJSONObject(0);
                String s = jo.getString("nid");
                String s1 = jo.getString("nlike");
                String s2 = jo.getString("nshare");
                String s3 = jo.getString("ncomment");
                String s4 = jo.getString("nevents");
                String s5 = jo.getString("nalbums");
//                String[] tokens = s5.split(" ");
//                Log.d("year", tokens[2]);
                String month;
                //int year = Integer.parseInt(tokens[2]);
                for(int i=1;i<js.length();i++) {
                    JSONObject jos = js.getJSONObject(i);
                    String p1 = jos.getString("pageid");
                    String p2 = jos.getString("attr");
                    String p3 = jos.getString("jan");
                    String p4 = jos.getString("feb");
                    String p5 = jos.getString("mar");
                    String p6 = jos.getString("apr");
                    String p7 = jos.getString("may");
                    String p8 = jos.getString("jun");
                    String p9 = jos.getString("jul");
                    String p10 = jos.getString("aug");
                    String p11 = jos.getString("sep");
                    String p12 = jos.getString("oct");
                    String p13 = jos.getString("nov");
                    String p14 = jos.getString("dec");
                DateDB dataDB = new DateDB(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14);
                    System.out.println(dataDB);
                    dbHandler.addall(dataDB);
                }

                 MovieFav movie = new MovieFav(s, s1, s2, s3, s4, s5);
                dbHandler.add(movie);

            } catch (JSONException e) {
                e.printStackTrace();
            }
   //     }

    }

    public void StoreRMovie(JSONArray js) {

            for (int i = 0; i < js.length(); i++) {
                try {
                    JSONObject jo = js.getJSONObject(i);
                    String s = jo.getString("Title");
                    String s1 = jo.getString("Genre");
                    String s2 = jo.getString("Plot");
                    String s3 = jo.getString("sender");
                    String s4 = jo.getString("Youtube");
                    String s5 = jo.getString("Released");
                    String s6 = jo.getString("Poster");
                    String s7 = jo.getString("Actors");
                    String s8 = jo.getString("CURRENT");
                    String[] tokens = s5.split(" ");
//                Log.d("year", tokens[2]);
                    String month;
                    //int year = Integer.parseInt(tokens[2]);


                    switch (tokens[1]) {
                        case "Jan":
                            month = '0' + Integer.toString(1);
                            break;
                        case "Feb":
                            month = '0' + Integer.toString(2);
                            break;
                        case "Mar":
                            month = '0' + Integer.toString(3);
                            break;
                        case "Apr":
                            month = '0' + Integer.toString(4);
                            break;
                        case "May":
                            month = '0' + Integer.toString(5);
                            break;
                        case "Jun":
                            month = '0' + Integer.toString(6);
                            break;
                        case "Jul":
                            month = '0' + Integer.toString(7);
                            break;
                        case "Aug":
                            month = '0' + Integer.toString(8);
                            break;
                        case "Sep":
                            month = '0' + Integer.toString(9);
                            break;
                        case "Oct":
                            month = '1' + Integer.toString(0);
                            break;
                        case "Nov":
                            month = '1' + Integer.toString(1);
                            break;
                        case "Dec":
                            month = '1' + Integer.toString(2);
                            break;
                        default:
                            month = '0' + Integer.toString(0);
                    }
                    int month1 = Integer.parseInt(month) + 1;
                    String date = tokens[2] + month + tokens[0];
                    //               System.out.println(s + date);
                    MovieFav movie = new MovieFav(s, s1, s2, s3, s4, s5);
             //       dbHandler.R_add(movie);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }


}
