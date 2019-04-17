package escapadetechnologies.com.retrofit2example.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import escapadetechnologies.com.retrofit2example.R;
import escapadetechnologies.com.retrofit2example.model.Notice;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>{

    private ArrayList<Notice> dataList;

    public NoticeAdapter(ArrayList<Notice> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_view,null,false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder noticeViewHolder, int i) {

        noticeViewHolder.title.setText(dataList.get(i).getTitle());
        noticeViewHolder.brief.setText(dataList.get(i).getBrief());
        noticeViewHolder.path.setText(dataList.get(i).getFileSource());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder{

        TextView title,brief,path;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            brief = itemView.findViewById(R.id.brief);
            path = itemView.findViewById(R.id.path);
        }
    }
}
