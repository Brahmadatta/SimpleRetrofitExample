package escapadetechnologies.com.retrofit2example.network;

import escapadetechnologies.com.retrofit2example.model.Notice;
import escapadetechnologies.com.retrofit2example.model.NoticeList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNoticeDataService {

    @GET("bins/1bsqcn/")
    Call<NoticeList> getNoticeData();
}
