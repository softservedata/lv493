package com.softserve.edu.greencity.rest.data.econews;

import com.softserve.edu.greencity.rest.data.User;

import java.util.ArrayList;
import java.util.List;

public class NewsIdRepository {
    private static NewsIdRepository instance = null;

    /**
     * Variable List<Integer> newsId
     * to path value from test checkUploadEcoNews to deleteNews test
     */
    private List<Integer> newsId = new ArrayList<>();

    private NewsIdRepository() {
    }

    public static NewsIdRepository get() {
        if (instance == null) {
            synchronized (NewsIdRepository.class) {
                if (instance == null) {
                    instance = new NewsIdRepository();
                }
            }
        }
        return instance;
    }

    public List<Integer> getNewsId() {
        return newsId;
    }

    public void setNewsId(List<Integer> newsId) {
        this.newsId = newsId;
    }

    public void addNewsId(int newsId) {
        this.newsId.add(newsId);
    }

    public int getDefault() {
        return 516;
    }

    public Object[][] generateData(List<Integer> newsId, User user){
        Object[][] dataArray = new Object[newsId.size()][];
        List<Object[]> dataList = new ArrayList<>();
        for (int currentId:newsId){
            Object[] data = new Object[]{user, currentId};
            dataList.add(data);
        }
        dataArray = dataList.toArray(dataArray);
        return dataArray;
    }
}
