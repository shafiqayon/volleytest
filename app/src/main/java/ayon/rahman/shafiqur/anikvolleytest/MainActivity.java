package ayon.rahman.shafiqur.anikvolleytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    final String servername = "http://shafiqurrahman.com/anik.php";
    String temp, temp2, temp3;
    RequestQueue requestQueue;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        textView = (TextView) findViewById(R.id.textView);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(servername, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i <= response.length(); i++) {
                    temp = null;
                    try {
                        JSONObject object = (JSONObject) response.get(i);
                        temp = object.getString("id");
                        temp2 = object.getString("name");
                        temp3 = object.getString("age");
                        textView.append(temp);
                        textView.append("\n");
                        textView.append(temp2);
                        textView.append("\n");
                        textView.append(temp3);
                        textView.append("\n\n");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error", e.toString());
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error", volleyError.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
