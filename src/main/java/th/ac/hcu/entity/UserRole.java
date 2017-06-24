package th.ac.hcu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "USER_ROLE")
@TableGenerator(name="GEN_USER_ROLE", initialValue=0, allocationSize=50)
public class UserRole {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_USER_ROLE")
    private Long id;
	
	private String role;
	
	private String enabled;
	
	@ManyToOne
	@JoinColumn(name = "user", insertable = false, updatable = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
