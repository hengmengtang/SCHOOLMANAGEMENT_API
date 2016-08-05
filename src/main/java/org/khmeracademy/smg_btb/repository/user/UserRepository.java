package org.khmeracademy.smg_btb.repository.user;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	interface SQL{
		final String R_USER="SELECT u_id, username,password,possition,date,status FROM smg_user";
		final String C_USER="INSERT INTO smg_user("
			+ "u_id,"
			+ "username,"
			+ "password,"
			+ "possition,"
			+ "date,"
			+ "status,"
			+ "stu_id,"
			+ "staff_id"
		    + ") "
		    + "VALUES(#{user_id},"
		    + "#{username},"
		    + "#{password},"
		    + "#{possition},"
		    + "#{date},"
		    + "#{status},"
		    + " (SELECT stu_id "
		    + "FROM smg_student "
		    + "WHERE " 
		    + "eng_full_name=#{username} "
		    + "AND "
		    + "phone=#{phone}),"
		    + "(SELECT staff_id "
		    + "FROM smg_staff "
		    + "WHERE " 
		    + "eng_full_name=#{username} "
		    + "AND "
		    + "phone=#{phone})";
		final String U_UPDATE_USER="UPDATE smg_user "
				+ "SET username='khmer',"
				+ "password=#{password} "
				+ "WHERE "
				+ "username='tang' "
				+ "AND "
				+ "password=#{password}";
		final String U_CHANGE_USER_STATUAS="UPDATE smg_user SET status='f' "
				+ "WHERE u_id=#{user_id} AND username=#{username}";
	}
	@Select(SQL.R_USER)
	@Results({
		@Result(property="user_id",column="u_id"),
		@Result(property="username",column="username"),
		@Result(property="password",column="password"),
		@Result(property="possition",column="possition"),
		@Result(property="date",column="date"),
		@Result(property="status",column="status")
	})
	public ArrayList<User> findAll();
	@Insert(SQL.C_USER)
	public boolean insert(User user);
	@Update(SQL.U_UPDATE_USER)
	public boolean update(String username,String password);
	@Update(SQL.U_CHANGE_USER_STATUAS)
	public boolean changeStatus(int user_id,String username);
	
}
