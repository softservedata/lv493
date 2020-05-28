package com.softserve.edu.greencity.rest.entity;

import java.util.ArrayList;

public class AllNewsResponseEntity {
    private ArrayList<EcoNewsEntity> page;
    private int totalElements;
    private int currentPage;

    public AllNewsResponseEntity() {
        page = new ArrayList<EcoNewsEntity>();
        totalElements = -1;
        currentPage = -1;
    }

    public AllNewsResponseEntity(ArrayList<EcoNewsEntity> page, int totalElements, int currentPage) {
        this.page = page;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
    }

    public ArrayList<EcoNewsEntity> getPage() {
        return page;
    }

    public void setPage(ArrayList<EcoNewsEntity> page) {
        this.page = page;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
