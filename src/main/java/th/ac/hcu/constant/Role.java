package th.ac.hcu.constant;

public enum Role {
	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_STUD("ROLE_STUD"),
	ROLE_STUD_PT("ROLE_STUD_PT"),
	ROLE_STUD_PH("ROLE_STUD_PH"),
	ROLE_PATIEN("ROLE_PATIEN"),
	ROLE_PROF("ROLE_PROF");
	
	private String roleName;

	Role(String roleName){
		this.roleName = roleName;
	}
	
	private String roleName(){
		return roleName;
	}
}
	