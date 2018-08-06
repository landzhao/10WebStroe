package com.cskaoyan.dao;


import com.cskaoyan.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    boolean saveProduct(Product product) throws SQLException;

    boolean isPidAvailable(int pid) throws SQLException;

    int findAllProductCount() throws SQLException;

    List<Product> findPartProduct(int limit, int offset) throws SQLException;

    String deleteProduct(String pid) throws SQLException;

    Product findProductByPid(String pid) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;


    List<Product> findProductByCid(String cid) throws SQLException;



    List<Object> findProductByName(String name) throws SQLException;

 }
