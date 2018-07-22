package login.com.girish.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONDemoActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {
    private TextView textView;
    private RequestQueue requestQueue;
    private String url = "https://api.androidhive.info/volley/person_object.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsondemo);
        textView = findViewById(R.id.textViewOut);
        requestQueue = Volley.newRequestQueue(this);
    }

    public void downloadJSON(View view){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,this,this);
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject personResponse) {

        try {
            String name = personResponse.getString("name");
            String email = personResponse.getString("email");
            JSONObject phoneObject = personResponse.getJSONObject("phone");
            String home = phoneObject.getString("home");
            String mobile = phoneObject.getString("mobile");

            Person person = new Person();
            Phone phone = new Phone();
            phone.setHome(home);
            phone.setMobile(mobile);
            person.setName(name);
            person.setEmail(email);
            person.setPhone(phone);

            textView.setText(person.getName());



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

















