package com.kanishk.prototypes.mvvm_sample.Model;

/**
 * Created by kanishk on 03/06/17.
 */

public class DashboardItem {

    private int dashboardItemPhoto;
    private String dashboardItemName;

    public DashboardItem(int dashboardItemPhoto, String dashboardItemName) {
        this.dashboardItemPhoto = dashboardItemPhoto;
        this.dashboardItemName = dashboardItemName;
    }

    public int getDashboardItemPhoto() {
        return dashboardItemPhoto;
    }

    public String getDashboardItemName() {
        return dashboardItemName;
    }
}
