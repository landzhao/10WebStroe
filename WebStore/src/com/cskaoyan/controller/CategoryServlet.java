package com.cskaoyan.controller;

import com.cskaoyan.servcie.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryServlet",urlPatterns = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String op = request.getParameter("op");

        if (op!=null&&!op.isEmpty()){


            switch (op){

                case "showAllUsers":
                    addCategory(request,response);
                    break;




            }


        }

    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) {


        String cname = request.getParameter("cname");

        boolean ok= categoryService.addCategory(cname);

        if (ok){

            //跳转到显示所有的category页面

        }else{



        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
