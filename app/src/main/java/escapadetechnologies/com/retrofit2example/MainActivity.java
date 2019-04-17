package escapadetechnologies.com.retrofit2example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import escapadetechnologies.com.retrofit2example.adapter.NoticeAdapter;
import escapadetechnologies.com.retrofit2example.model.Notice;
import escapadetechnologies.com.retrofit2example.model.NoticeList;
import escapadetechnologies.com.retrofit2example.network.GetNoticeDataService;
import escapadetechnologies.com.retrofit2example.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public Notice notice;
    public NoticeAdapter noticeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);

        GetNoticeDataService getNoticeDataService = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        Call<NoticeList> call = getNoticeDataService.getNoticeData();
        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {

                generateNoticeList(response.body().getNoticeArrayList());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void generateNoticeList(ArrayList<Notice> noticeArrayList) {

        noticeAdapter = new NoticeAdapter(noticeArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(noticeAdapter);
    }
}
