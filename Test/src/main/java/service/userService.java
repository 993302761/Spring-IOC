package service;

import dao.userDao;

public class userService extends userDao {


    private userDao userDao;

    public dao.userDao getUserDao() {
        return userDao;
    }

    public void setUserDao(dao.userDao userDao) {
        this.userDao = userDao;
    }

    public void test(){
        System.out.println("ok");
    }
}
