package th.ac.hcu.entity.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MAPPING_CLASS")
@TableGenerator(name="GEN_MAPPING_CLASS", initialValue=0, allocationSize=50)
public class Class {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_MAPPING_CLASS")
    private Long 	id;
	
	private String 	masterId;
	
	private String	classId;
	
	private String	externalClass;
	
	private String	academicService;
	
	private	String	conference;
	
	private String	other;

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

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getExternalClass() {
		return externalClass;
	}

	public void setExternalClass(String externalClass) {
		this.externalClass = externalClass;
	}

	public String getAcademicService() {
		return academicService;
	}

	public void setAcademicService(String academicService) {
		this.academicService = academicService;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
}
