package org.khmeracademy.smg_btb.repository.user;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.form.studentlogin.UserLogin;
import org.khmeracademy.smg_btb.entity.form.user.ParamRegisterUser;
import org.khmeracademy.smg_btb.entity.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	interface SQL{
		final String R_USER="SELECT user_id, username,password,possition,date,status FROM smg_user";
		
		final String C_USER="{CALL insert_user("
				+ "#{username,jdbcType=VARCHAR,mode=IN},"
				+ "#{password,jdbcType=VARCHAR,mode=IN},"
				+ "#{email,jdbcType=VARCHAR,mode=IN},"
				+ "#{success,jdbcType=INTEGER,mode=OUT})}";
		
		final String U_CHANGE_PASSWORD="{CALL change_password(#{username,jdbcType=VARCHAR,mode=IN},#{old_password,jdbcType=VARCHAR,mode=IN},"
				+ "#{new_password,jdbcType=VARCHAR,mode=IN})}";
		final String U_CHANGE_USER_STATUAS="UPDATE smg_user SET status='f' "
				+ "WHERE user_id=#{user_id} AND username=#{username}";
		final String R_FIND_USER_BY_EMAIL="SELECT * FROM user_detail WHERE email=#{email}";
		
		final String C_UPLOAD_PHOTO_USER="INSERT INTO smg_user VALUES(photo=#{path}) WHERE email=#{email}";
	}
	@Select(SQL.R_USER)
	@Results({
		@Result(property="user_id",column="user_id"),
		@Result(property="username",column="username"),
		@Result(property="password",column="password"),
		@Result(property="possition",column="possition"),
		@Result(property="phone",column="phone"),
		@Result(property="date",column="date"),
		@Result(property="status",column="status")
	})
	public ArrayList<User> findAll();
	
	/**
	 * use callable statement to call function in server
	 * @option to measure we are used call able statement 
	 * @param user
	 * @return
	 */
	@Insert(SQL.C_USER)
	@Options(statementType=StatementType.CALLABLE)
	public int save(ParamRegisterUser user);
	
	@Update(SQL.U_CHANGE_PASSWORD)
	@Options(statementType=StatementType.CALLABLE)
	public boolean changePassword(UserLogin.changePassword changePasswrod);
	
	@Update(SQL.U_CHANGE_USER_STATUAS)
	public boolean changeStatus(int user_id,String username);
	
	@Select(SQL.R_FIND_USER_BY_EMAIL)
	public User findUserByEmail(@Param("email") String email);
	
	@Insert(SQL.C_UPLOAD_PHOTO_USER)
	public boolean insert(@Param("path") String path,@Param("email") String email);
}
