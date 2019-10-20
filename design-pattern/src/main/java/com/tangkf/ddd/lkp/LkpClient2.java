package com.tangkf.ddd.lkp;

import java.util.ArrayList;
import java.util.List;

/**
 * 有一个集团公司，下属单位有分公司和直属部门，现在要求打印出所有下属单位的员工ID。先来看一下违反迪米特法则的设计。
 * 现在这个设计的主要问题出在CompanyManager中，根据迪米特法则，只与直接的朋友发生通信，而SubEmployee类并不是CompanyManager类的直接朋友（以局部变量出现的耦合不属于直接朋友），
 * 从逻辑上讲总公司只与他的分公司耦合就行了，与分公司的员工并没有任何联系，这样设计显然是增加了不必要的耦合。
 * 按照迪米特法则，应该避免类中出现这样非直接朋友关系的耦合。
 * @author t00458
 */
public class LkpClient2 {
    public static void main(String[] args){
        CompanyManager e = new CompanyManager();
        e.printAllEmployee(new SubCompanyManager());
    }


    //总公司员工
    static class Employee{
        private String id;
        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return id;
        }
    }

    //分公司员工
    static class SubEmployee{
        private String id;
        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return id;
        }
    }

    static class SubCompanyManager{
        public List<SubEmployee> getAllEmployee(){
            List<SubEmployee> list = new ArrayList<SubEmployee>();
            for(int i=0; i<100; i++){
                SubEmployee emp = new SubEmployee();
                //为分公司人员按顺序分配一个ID
                emp.setId("分公司"+i);
                list.add(emp);
            }
            return list;
        }
        public void printEmployee(){
            List<SubEmployee> list = this.getAllEmployee();
            for(SubEmployee e:list){
                System.out.println(e.getId());
            }
        }
    }

    static class CompanyManager{

        public List<Employee> getAllEmployee(){
            List<Employee> list = new ArrayList<Employee>();
            for(int i=0; i<30; i++){
                Employee emp = new Employee();
                //为总公司人员按顺序分配一个ID
                emp.setId("总公司"+i);
                list.add(emp);
            }
            return list;
        }

        public void printAllEmployee(SubCompanyManager sub){
            sub.printEmployee();
            List<Employee> list2 = this.getAllEmployee();
            for(Employee e:list2){
                System.out.println(e.getId());
            }
        }
    }
}
