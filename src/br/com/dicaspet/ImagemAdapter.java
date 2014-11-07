package br.com.dicaspet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImagemAdapter extends BaseAdapter{

    private Context mContext;
	private int[] pets = { R.drawable.ic_cachorro, R.drawable.ic_gato };
	
    public ImagemAdapter(Context c){
        mContext = c;
    }
 
    public int getCount() {
        return pets.length;
    }
 
    public Object getItem(int position) {
        return pets[position];
    }
 
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	int h = mContext.getResources().getDisplayMetrics().densityDpi;
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(pets[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(h-45, h-39));
        //imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        imageView.setAdjustViewBounds(true);
        return imageView;
    }

	

}
