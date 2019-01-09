package com.kevin.service;

import com.kevin.entity.Manager;
import com.kevin.entity.User;

public interface ManagerService {
    public String login(Manager manager);
    public void update(Manager manager);
    public void edit(Manager manager);
    public Manager get(int id);
    public Manager getByinfo(String username);
}
