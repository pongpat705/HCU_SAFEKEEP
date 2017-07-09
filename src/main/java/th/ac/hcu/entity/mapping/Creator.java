package th.ac.hcu.entity.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MAPPING_CREATOR")
@TableGenerator(name="GEN_MAPPING_CREATOR", initialValue=0, allocationSize=50)
public class Creator {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_MAPPING_CREATOR")
    private Long id;
	
	private String masterId;
	
	private String creatorId;
	
	private String creatorName;
	
	private String creatorSurname;
	
	private String role;
	
	private String qaPercentage;
	
	@NotNull
	private char isInternal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorSurname() {
		return creatorSurname;
	}

	public void setCreatorSurname(String creatorSurname) {
		this.creatorSurname = creatorSurname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getQaPercentage() {
		return qaPercentage;
	}

	public void setQaPercentage(String qaPercentage) {
		this.qaPercentage = qaPercentage;
	}

	public char getIsInternal() {
		return isInternal;
	}

	public void setIsInternal(char isInternal) {
		this.isInternal = isInternal;
	}
	
}
