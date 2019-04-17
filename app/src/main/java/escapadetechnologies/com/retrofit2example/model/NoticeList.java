package escapadetechnologies.com.retrofit2example.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NoticeList {

    @SerializedName("notice_list")
    private ArrayList<Notice> noticeArrayList;

    public ArrayList<Notice> getNoticeArrayList() {
        return noticeArrayList;
    }

    public void setNoticeArrayList(ArrayList<Notice> noticeArrayList) {
        this.noticeArrayList = noticeArrayList;
    }
}
