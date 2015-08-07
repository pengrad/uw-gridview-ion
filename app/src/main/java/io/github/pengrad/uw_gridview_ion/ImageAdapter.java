package io.github.pengrad.uw_gridview_ion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

/**
 * stas
 * 8/7/15
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private ImageSource[] images;


    public ImageAdapter(Context context, ImageSource[] images) {
        this.mContext = context;
        this.images = images;
    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {
        return images[position];
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new SquareImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        Ion.with(imageView)
                .placeholder(R.drawable.ic_placeholder)
                .animateIn(android.R.anim.fade_in)
                .load(images[position].image_url);

        return imageView;
    }
}
