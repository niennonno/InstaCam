package io.niennonno.instacam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mapplinks-PC on 10-12-2015.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mCaption;
        private final ImageView mPhoto;
        private final ImageView mAvatar;
        private final TextView mUsername;

        public ViewHolder(View itemView) {
            super(itemView);
            mCaption = (TextView) itemView.findViewById(R.id.feed_item_caption);
            mPhoto = (ImageView) itemView.findViewById(R.id.feed_item_photo);
            mAvatar = (ImageView) itemView.findViewById(R.id.feed_item_user_avatar);
            mUsername = (TextView) itemView.findViewById(R.id.feed_item_user_name);
        }
    }

    private List<Photo> mPhotos;
    private Context mContext;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public FeedAdapter(Context context, List<Photo> photos) {
        mContext = context;
        mPhotos = photos;
    }
}
