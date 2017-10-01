package th.ac.hcu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import th.ac.hcu.event.UserEntityListener;


@Entity
@Table(name = "USER")
@TableGenerator(name="GEN_USER", initialValue=0, allocationSize=50)
@EntityListeners(UserEntityListener.class)
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_USER")
    private Long userId;
	
	@Column(unique = true)
	private String userName;
	
	private String password;
	
	private String enabled;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<UserRole> userRole;

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}

	
}
