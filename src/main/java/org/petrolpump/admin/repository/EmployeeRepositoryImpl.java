package org.petrolpump.admin.repository;

import java.util.*;



import org.petrolpump.admin.config.DBConfig;
import org.petrolpump.admin.model.EmployeeModel;
import java.sql.Date;
public class EmployeeRepositoryImpl extends DBConfig implements EmployeeRepository{
    List<EmployeeModel> list=new ArrayList<EmployeeModel>();
	int empId=0;
    public int  getEmployeeId()
    {
    	try {
    		stmt=conn.prepareStatement("select max(eid) from employee");
    		rs=stmt.executeQuery();
    		if(rs.next())
    		{
    			empId=rs.getInt(1);
    		}
    		return ++empId;
    	}
    	catch(Exception ex)
    	{
    		System.out.println("Error is"+ex);
    		return -1;
    	}
    }

	public boolean isAddNewEmployee(EmployeeModel model) {
		try {
			int employeeid=this.getEmployeeId();
			stmt=conn.prepareStatement("Insert into employee values(?,?,?,?,?,?)");
			stmt.setInt(1, employeeid);
			stmt.setString(2,model.getName());
		    stmt.setString(3,model.getEmail());
			stmt.setString(4,model.getContact());
			stmt.setString(5,model.getAddress());
			stmt.setInt(6,model.getSal());
		
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			return false;
		}
	
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		try {
			stmt=conn.prepareStatement("select *from employee");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				EmployeeModel emp=new EmployeeModel();
				emp.setId(rs.getInt("eid"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setContact(rs.getNString("contact"));
				emp.setSal(rs.getInt("salary"));
				list.add(emp);
			}
			return list.size()>0?list:null;
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return null;
		}

	}

	
	public boolean allocateMachine(int eid, int mid, String... x) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("insert into employeemachinejoin values(?,?,?,?,?)");
			stmt.setInt(1, eid);
			stmt.setInt(2, mid);
			stmt.setString(3,x[0]);
			stmt.setString(4,x[1]);
			String s=x[2];
		    //import date from java.sql.date package
			//and using its static method converted string into date
		    Date date=Date.valueOf(s);
			//String split[]=x[2].split("-");
			//java.sql.Date d=new java.sql.Date(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
			stmt.setDate(5,date);
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return false;
		}
		
	}

	@Override
	public int verifyEmployee(String email, String contact) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("select *from employee where email=? and contact=?");
			stmt.setString(1,email);
			stmt.setString(2,contact);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else {
				return 0;
			}
			
			
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return 0;
		}
		
	}

	@Override
	public EmployeeModel getProfile(int employeeId) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("select *from employee where eid=?");
			stmt.setInt(1, employeeId);
			rs=stmt.executeQuery();
			EmployeeModel e=null;
			if(rs.next())
			{
				e=new EmployeeModel();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setContact(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setSal(rs.getInt(6));
			}
			return e;
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return null;
		}
		
	}

}
