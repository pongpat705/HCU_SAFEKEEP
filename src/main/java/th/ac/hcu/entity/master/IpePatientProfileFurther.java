package th.ac.hcu.entity.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_PATIENT_PROFILE_FURTHER")
@TableGenerator(name="GEN_PATIENT_PROFILE_FURTHER", initialValue=0, allocationSize=50)
public class IpePatientProfileFurther {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PATIENT_PROFILE_FURTHER")
	private Long furtherId;
	
	@Column(length=100)
	private String major;
	@Column(length=300)
	private String description;
	
	private Date createdDate;

	public Long getFurtherId() {
		return furtherId;
	}

	public void setFurtherId(Long furtherId) {
		this.furtherId = furtherId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
