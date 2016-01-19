package com.example.vinit.flowlayout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.vinit.flowlayout.Socialimpact.SocialActivity;
import com.example.vinit.flowlayout.app.AppConfig;
import com.example.vinit.flowlayout.app.AppController;
import com.example.vinit.flowlayout.helper.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class VerifyActivity extends Activity {
EditText e1;
    String email1;
    private ProgressDialog pDialog;
    private SessionManager session;
    private static final String TAG = VerifyActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        e1 = (EditText) findViewById(R.id.editText4);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        session = new SessionManager(getApplicationContext());


    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
    public void find1(View view){


        email1=  e1.getText().toString();

        //    String email1 = editTex.getText().toString().trim();
        //String password = inputPassword.getText().toString().trim();
//        String email1="1111";
        // Check for empty data in the form
        if (!email1.isEmpty()) {
            // login user
            findname1(email1);
        } else {
            // Prompt user to enter credentials
            Toast.makeText(getApplicationContext(),
                    "Please enter the credentials!", Toast.LENGTH_LONG)
                    .show();
        }

    }
    public void findname1(final String email1){
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_FIND, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj1 = new JSONObject(response);
                    boolean error = jObj1.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
//                        String success = "User found :)";
//                        Toast.makeText(getApplicationContext(),
//                                success, Toast.LENGTH_LONG).show();
                        Intent i=new Intent(VerifyActivity.this,SocialActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj1.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                "Invalid Password", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();

                params.put("email", email1);
//                params.put("email", email);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }
}
