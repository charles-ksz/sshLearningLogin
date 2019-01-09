package com.kevin.action;


import com.kevin.entity.Manager;
import com.kevin.service.ManagerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("manager_")
@Scope("prototype")
public class ManagerAction {
    @Resource
    private ManagerService managerService;
   private Manager manager;


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public  String login()

    {
        return  managerService.login(manager);
    }
    public  String  update()
    {
        managerService.update(manager);
        return "update";
    }
    public  String edit()
    {
        System.out.println("guanliyuan "+manager.getId());
       // manager=managerService.
        manager=managerService.getByinfo(manager.getUsername());
        //managerService.edit(manager);
        return  "edit";
    }



}
