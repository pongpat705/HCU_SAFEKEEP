package th.ac.hcu.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "USER")
@TableGenerator(name="GEN_USER", initialValue=0, allocationSize=50)
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_USER")
    private Long id;
	
	private String userName;
	
	private String password;
	
	private String enabled;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<UserRole> userRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUsersRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
}
