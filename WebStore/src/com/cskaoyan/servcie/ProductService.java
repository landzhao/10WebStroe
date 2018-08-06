package com.cskaoyan.servcie;

import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Product;
import com.cskaoyan.utils.PageHelper;


import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    boolean saveProduct(Product product) throws SQLException;

    String validateProduct(Product product) throws SQLException;

    boolean isPidAvailable(int pid) throws SQLException;

    PageHelper findPartProduct(List<Category> categories, String num) throws SQLException;

    String deleteProduct(String pid) throws SQLException;

    Product findProductByPid(String pid) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;



    String findProductByName(String key) throws SQLException;
}
