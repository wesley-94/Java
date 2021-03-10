package kr.or.connect.daoexam.dto;

public class Role {
	private int roleID;
	private String description;
	
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", description=" + description + "]";
	}

}
