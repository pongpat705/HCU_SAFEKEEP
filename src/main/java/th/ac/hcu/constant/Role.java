package th.ac.hcu.constant;

public enum Role {
	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_USER("ROLE_USER");
	
	private String roleName;

	Role(String roleName){
		this.roleName = roleName;
	}
	
	private String roleName(){
		return roleName;
	}
}
