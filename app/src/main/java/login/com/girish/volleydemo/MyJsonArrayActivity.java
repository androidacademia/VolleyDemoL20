package login.com.girish.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyJsonArrayActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONArray> {
    private ListView listView;
    private MyAdapter adapter;
    private RequestQueue requestQueue;
    private String url = "https://api.androidhive.info/volley/person_array.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_json_array);
        listView = findViewById(R.id.listViewPerson);
        requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,this,this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONArray response) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (int i = 0 ;i<response.length();i++){
            try {
                JSONObject personResponse = response.getJSONObject(i);
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
                personArrayList.add(person);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        adapter = new MyAdapter(this,personArrayList);
        listView.setAdapter(adapter);

    }
}
















