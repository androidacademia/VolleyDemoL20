package login.com.girish.volleydemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<Person> personArrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context,ArrayList<Person> personArrayList){
        this.context = context;
        this.personArrayList = personArrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return personArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return personArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null){
            view = layoutInflater.inflate(R.layout.list_item,null);
        }

        TextView textViewPN = (TextView)view.findViewById(R.id.textViewPersonName);
        TextView textViewEmail = (TextView)view.findViewById(R.id.textViewEmail);
        TextView textViewHome = (TextView)view.findViewById(R.id.textViewHome);
        TextView textViewMobile = (TextView)view.findViewById(R.id.textViewMobile);
        textViewPN.setText(personArrayList.get(position).getName());
        textViewEmail.setText(personArrayList.get(position).getEmail());
        textViewHome.setText(personArrayList.get(position).getPhone().getHome());
        textViewMobile.setText(personArrayList.get(position).getPhone().getMobile());
        return view;
    }
}






















