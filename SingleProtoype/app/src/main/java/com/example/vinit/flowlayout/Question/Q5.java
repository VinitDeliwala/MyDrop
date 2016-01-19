package com.example.vinit.flowlayout.Question;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinit.flowlayout.R;
import com.example.vinit.flowlayout.VerifyActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q5 extends Activity {
    View rootView;
    String a1,a2,a3,a4;
    EditText qq1, qq2, qq3, qq4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        qq1 = (EditText) findViewById(R.id.q1);
        qq2 = (EditText) findViewById(R.id.q2);
        qq3 = (EditText) findViewById(R.id.q3);
        qq4 = (EditText) findViewById(R.id.q4);
        ArrayList<String> arr = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
        QuestionActivity q5 = new QuestionActivity();

        arr = q5.getArray(arr);

        qq1.setText(arr.get(0));
        qq2.setText(arr.get(1));
        qq3.setText(arr.get(2));
        qq4.setText(arr.get(3));


	}
    public void security(View v) {
//        insertToDatabase("Vinit","Manan");
        Intent newActivity = new Intent(Q5.this, VerifyActivity.class);
        startActivity(newActivity);
        finish();
    }
    private void insertToDatabase(String name, String add){
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String paramUsername = params[0];
                String paramAddress = params[1];

                //InputStream is = null;

                String id = "1705151515054_1515126611618515";
                String q1 = a1;
                String q2 = a2;
                String q3 = a3;
                String q4 = a4;


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("id", id));
                nameValuePairs.add(new BasicNameValuePair("q1", q1));
                nameValuePairs.add(new BasicNameValuePair("q2", q2));
                nameValuePairs.add(new BasicNameValuePair("q3", q3));
                nameValuePairs.add(new BasicNameValuePair("q4", q4));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://android1992.comyr.com/try.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    //is = entity.getContent();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "success";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(name, add);
    }
}
