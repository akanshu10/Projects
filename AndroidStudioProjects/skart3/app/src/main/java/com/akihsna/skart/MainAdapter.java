package com.akihsna.skart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] word;
    private int[] img;

    public MainAdapter(Context c, String[] word, int[] img) {
        context=c;
        this.word=word;
        this.img=img;

    }

    @Override
    public int getCount() {
        return word.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.collegeprofiles, null);
        }
            ImageView image=convertView.findViewById(R.id.imageView);
            TextView text=convertView.findViewById(R.id.text);
            image.setImageResource(img[position]);
            text.setText(word[position]);

        return convertView;
    }
}
