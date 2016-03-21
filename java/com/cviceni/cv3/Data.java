package com.cviceni.cv3;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Ban> bans = new ArrayList<Ban>();

    public static void LoadData() {
        bans.add(new Ban(1,"Title Ban 1","Loong description"));
        bans.add(new Ban(2,"Title Ban 2","Loong description"));
        bans.add(new Ban(3,"Title Ban 3","Loong description"));
        bans.add(new Ban(4,"Title Ban 4","Loong description"));
        bans.add(new Ban(5,"Title Ban 5","Loong description"));
    }

    public static ArrayList<Ban> getBans() {
        return bans;
    }

    public static Ban getBanById(int id) {
        return bans.get(id - 1);

    }
}