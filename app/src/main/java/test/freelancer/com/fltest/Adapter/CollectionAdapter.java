package test.freelancer.com.fltest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import test.freelancer.com.fltest.Model.Programs;
import test.freelancer.com.fltest.R;

/**
 * Created by V15 on 11/04/2016.
 */
public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.MyViewHolder> {
    ArrayList<Programs> data = new ArrayList<>();
    Context context;

    public CollectionAdapter(Context context, ArrayList<Programs> data) {
        this.data = new ArrayList<>(data);
        this.context = context;
    }

    public void addItemsToList(ArrayList<Programs> newItems){
        data.addAll(newItems);
        this.notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.collection_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Programs current = data.get(position);

        holder.name.setText(current.getName());
        holder.starttime.setText(current.getStart_time());
        holder.endtime.setText(current.getEnd_time());
        holder.channel.setText(current.getChannel());
        holder.rating.setText(current.getRating());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView starttime;
        TextView endtime;
        TextView channel;
        TextView rating;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            starttime = (TextView) itemView.findViewById(R.id.start_time);
            endtime = (TextView) itemView.findViewById(R.id.end_time);
            channel = (TextView) itemView.findViewById(R.id.channel);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
