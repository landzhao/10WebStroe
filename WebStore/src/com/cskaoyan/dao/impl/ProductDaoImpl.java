package com.cskaoyan.dao.impl;

 
import com.cskaoyan.bean.Product;
import com.cskaoyan.dao.ProductDao;
import com.cskaoyan.utils.MyC3P0DataSouce;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
CREATE TABLE `product` (
  `pid` INT PRIMARY KEY AUTO_INCREMENT,
  `pname` VARCHAR(200),
  `estorePrice` DOUBLE(10, 2),
  `markPrice` DOUBLE(10, 2),
  `pnum` INT,
  `cid` INT,
  `imgUrl` VARCHAR(255),
  `description` VARCHAR(255),
  CONSTRAINT FK_product_cid FOREIGN KEY (cid) REFERENCES category (cid)
);
 */

public class ProductDaoImpl implements ProductDao {


    @Override
    public List<Object> findProductByName(String name) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        String param = "%" + name + "%";
        return queryRunner.query("select pname from product where cid <> 7 and (pname like ? or description like ?) ",
                new ColumnListHandler(), param, param);
    }





    @Override
    public List<Product> findProductByCid(String cid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        return queryRunner.query("select * from product where cid = ?",
                new BeanListHandler<>(Product.class), cid);
    }

    //@Override
    public List<Product> findTopProducts() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        return queryRunner.query("select * from product where cid = 7",
                new BeanListHandler<>(Product.class));
    }

    //@Override
    public List<Product> findHotProducts() throws SQLException {
        int offset = (int) (Math.random() * 30);
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        return queryRunner.query("select * from product where cid <> 7 order by estorePrice limit 6 offset ?",
                new BeanListHandler<>(Product.class), offset);
    }




    @Override
    public Product findProductByPid(String pid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        return queryRunner.query("select * from product where pid = ?", new BeanHandler<>(Product.class), pid);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        int update = queryRunner.update(
                "update product set pname = ?, estorePrice = ?, markPrice = ?, pnum = ?, cid = ?, imgUrl = ?, description = ? where pid = ?",
                product.getPname(),
                product.getEstorePrice(),
                product.getMarkPrice(),
                product.getPnum(),
                product.getCid(),
                product.getImgUrl(),
                product.getDescription(),
                product.getPid());
        return 1 == update;
    }

    @Override
    public String deleteProduct(String pid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        Object query = queryRunner.query("select imgUrl from product where pid = ?", new ScalarHandler(), pid);
        queryRunner.update("delete from product where pid = ?", pid);
        return query.toString();
    }

    @Override
    public List<Product> findPartProduct(int limit, int offset) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        return queryRunner.query("select * from product limit ? offset ?", new BeanListHandler<>(Product.class), limit, offset);
    }

    @Override
    public int findAllProductCount() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        Long query = (Long) queryRunner.query("select count(*) from product", new ScalarHandler());
        return query.intValue();
    }

    @Override
    public boolean isPidAvailable(int pid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        Long query = (Long) queryRunner.query("select count(*) from product where pid = ?", new ScalarHandler(), pid);
        return 1L != query;
    }

    @Override
    public boolean saveProduct(Product product) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(MyC3P0DataSouce.getDataSource());
        int update = queryRunner.update(
                "INSERT INTO product (pid, pname, estorePrice, markPrice, pnum, cid, imgUrl, description) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);",
                product.getPid(),
                product.getPname(),
                product.getEstorePrice(),
                product.getMarkPrice(),
                product.getPnum(),
                product.getCid(),
                product.getImgUrl(),
                product.getDescription());
        return 1 == update;
    }

}
