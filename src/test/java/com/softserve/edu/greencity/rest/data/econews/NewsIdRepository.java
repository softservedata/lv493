package com.softserve.edu.greencity.rest.data.econews;

import com.softserve.edu.greencity.rest.data.User;

import java.util.ArrayList;
import java.util.List;

public class NewsIdRepository {
    private static NewsIdRepository instance = null;

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
