package com.cskaoyan.servcie;

import com.cskaoyan.dao.CategoryDao;

public class CategoryService {

    CategoryDao dao ;



    public boolean addCategory(String cname) {
        return  dao.addCategory(cname);
    }
}
