package login.com.girish.volleydemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<Bitmap> {
    private ImageView imageView;
    private RequestQueue requestQueue;
    private String url = "https://pbs.twimg.com/profile_images/707557253637742592/8xPxraAg_400x400.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        requestQueue = Volley.newRequestQueue(this);
    }


    public void download(View view){
        if (NetworkConnectivity.isConnected(this)){
            //download
            ImageRequest imageRequest = new ImageRequest(url,this,300,300, ImageView.ScaleType.CENTER,null,this);
            requestQueue.add(imageRequest);

            //ViewGroup.LayoutParams layoutparams = new ViewGroup.LayoutParams();
            ///imageView.setLayoutParams(layoutparams);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //by showing some kind do something with error

    }

    @Override
    public void onResponse(Bitmap response) {
        imageView.setImageBitmap(response);
    }
}
