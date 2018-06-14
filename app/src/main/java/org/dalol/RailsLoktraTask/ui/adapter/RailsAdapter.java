package org.dalol.RailsLoktraTask.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.dalol.RailsLoktraTask.Helper.DeviceDimensionHelper;
import org.dalol.RailsLoktraTask.R;
import org.dalol.RailsLoktraTask.model.Rails;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RailsAdapter extends RecyclerView.Adapter<RailsAdapter.Holder> {

    private final LayoutInflater mInflater;
    private List<Rails> rails;

    public RailsAdapter(LayoutInflater inflater) {
        mInflater = inflater;
        rails = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mInflater.inflate(R.layout.item_flower, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Rails rail = rails.get(position);

        holder.mName.setText(rail.getCommit().getAuthor().getName());
        holder.message.setText(rail.getCommit().getMessage());
        holder.commitSHA.setText(rail.getSha());
        holder.mPhoto.getLayoutParams().height =(int)(DeviceDimensionHelper.getDisplayHeight(mInflater.getContext())/8);
        holder.mPhoto.getLayoutParams().width =(int)(DeviceDimensionHelper.getDisplayWidth(mInflater.getContext())/6) ;
        Picasso.with(mInflater.getContext()).load(R.mipmap.ic_launcher).
                placeholder(R.mipmap.ic_launcher).
                into(holder.mPhoto);
        //I can't find out Image url

    }

    @Override
    public int getItemCount() {
        return rails.size();
    }

    public void addFlowers(List<Rails> railsList) {
        rails.addAll(railsList);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder  {

        private CircleImageView mPhoto;
        private TextView mName, commitSHA,message;

        public Holder(View itemView) {
            super(itemView);
            mPhoto = (CircleImageView) itemView.findViewById(R.id.flowerPhoto);
            mName = (TextView) itemView.findViewById(R.id.name);
            commitSHA = (TextView) itemView.findViewById(R.id.commitsha);
            message = (TextView) itemView.findViewById(R.id.message);
        }

    }

}
