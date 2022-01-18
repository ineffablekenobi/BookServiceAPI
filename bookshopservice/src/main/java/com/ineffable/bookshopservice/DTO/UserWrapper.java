package com.ineffable.bookshopservice.DTO;


import com.ineffable.bookshopservice.Models.User;

import java.util.List;

public class UserWrapper {
   private List<User> userList;

    public UserWrapper(List<User> userList) {
        this.userList = userList;
    }

    public UserWrapper() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
