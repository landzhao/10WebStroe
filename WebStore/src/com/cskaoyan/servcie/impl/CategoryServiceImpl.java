package com.cskaoyan.servcie.impl;

import com.cskaoyan.bean.Category;
import com.cskaoyan.dao.CategoryDao;
import com.cskaoyan.dao.impl.CategoryDaoImpl;
import com.cskaoyan.servcie.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao=new CategoryDaoImpl();

    private static  final int PAGE_COUNT=3;

    @Override
    public boolean addCategory(String cname) throws SQLException {

        return categoryDao.addCategory(cname);
    }

    @Override
    public List<Category> findAllCategory() throws SQLException {
        return categoryDao.findAllCategory();
    }




    @Override
    public boolean updateCategory(Category category) throws SQLException {
        // TODO Auto-generated method stub
        return categoryDao.updateCategory(category);
    }
    @Override
    public boolean deleteCategory(int cid) throws SQLException {
        // TODO Auto-generated method stub
        return categoryDao.deleteCategoryById(cid);
    }

    @Override
    public void deleteCategories(String[] cids) {
        // TODO Auto-generated method stub

        categoryDao.deleteCategoriesByIds(cids);
    }

    @Override
    public Category getCategoryByCid(String cid) throws SQLException, Exception {
        int intcid = Integer.parseInt(cid);

        return categoryDao.getCategoryByCid(intcid);
    }




    @Override
    public boolean isCategoryNameAvailable(String cname) throws SQLException {
        return categoryDao.isCategoryNameAvailable(cname);
    }

}
