package org.khmeracademy.smg_btb.entity.form.studentlogin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLogin {
	
	@JsonProperty("EMAIL")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static class changePassword{
		
		private String username;
		private String old_password;
		private String new_password;
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getNew_password() {
			return new_password;
		}
		
		public void setNew_password(String new_password) {
			this.new_password = new_password;
		}
		
		public String getOld_password() {
			return old_password;
		}
		
		public void setOld_password(String old_password) {
			this.old_password = old_password;
		}
		
	}
}
