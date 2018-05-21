/**
  * Copyright 2018 bejson.com 
  */
package com.zhanghao.nhapp.Entity.User;

import java.util.List;

/**
 * Auto-generated: 2018-04-27 19:7:36
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private int Result;
    private String Message;
    private long UserID;
    private List<com.zhanghao.nhapp.Entity.User.OrganizationsandappModel> OrganizationsandappModel;
    private List<EmployeesModel> EmployeesModel;
    private List<DeptMercCustModel> DeptMercCustModel;
    private List<MrStockModel> mrStockModel;
    private List<GrStockModel> grStockModel;
    public void setResult(int Result) {
         this.Result = Result;
     }
     public int getResult() {
         return Result;
     }

    public void setMessage(String Message) {
         this.Message = Message;
     }
     public String getMessage() {
         return Message;
     }

    public void setUserID(long UserID) {
         this.UserID = UserID;
     }
     public long getUserID() {
         return UserID;
     }

    public void setOrganizationsandappModel(List<OrganizationsandappModel> OrganizationsandappModel) {
         this.OrganizationsandappModel = OrganizationsandappModel;
     }
     public List<OrganizationsandappModel> getOrganizationsandappModel() {
         return OrganizationsandappModel;
     }

    public void setEmployeesModel(List<EmployeesModel> EmployeesModel) {
         this.EmployeesModel = EmployeesModel;
     }
     public List<EmployeesModel> getEmployeesModel() {
         return EmployeesModel;
     }

    public void setDeptMercCustModel(List<DeptMercCustModel> DeptMercCustModel) {
         this.DeptMercCustModel = DeptMercCustModel;
     }
     public List<DeptMercCustModel> getDeptMercCustModel() {
         return DeptMercCustModel;
     }

    public void setMrStockModel(List<MrStockModel> mrStockModel) {
         this.mrStockModel = mrStockModel;
     }
     public List<MrStockModel> getMrStockModel() {
         return mrStockModel;
     }

    public void setGrStockModel(List<GrStockModel> grStockModel) {
         this.grStockModel = grStockModel;
     }
     public List<GrStockModel> getGrStockModel() {
         return grStockModel;
     }

}