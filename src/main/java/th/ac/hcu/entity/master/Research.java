package th.ac.hcu.entity.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MASTER_RESEARCH")
public class Research {

	@Id
	@GenericGenerator(name = "GEN_MASTER_RESEARCH", strategy = "th.ac.hcu.generator.ResearchIdGenerator") 
    @GeneratedValue(generator="GEN_MASTER_RESEARCH")
    private String 	masterId;
	
	private String 	name;
	
	private Integer	yearForm;

	private Integer	yearTo;
	
	private Integer researchType;
	
	private Integer	researchCharactor;
	
	private Integer major;
	
	private Integer	start;

	private Integer	end;
	
	private String 	researchPlace;
	
	private Integer	researchStatus;

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearForm() {
		return yearForm;
	}

	public void setYearForm(Integer yearForm) {
		this.yearForm = yearForm;
	}

	public Integer getYearTo() {
		return yearTo;
	}

	public void setYearTo(Integer yearTo) {
		this.yearTo = yearTo;
	}

	public Integer getResearchType() {
		return researchType;
	}

	public void setResearchType(Integer researchType) {
		this.researchType = researchType;
	}

	public Integer getResearchCharactor() {
		return researchCharactor;
	}

	public void setResearchCharactor(Integer researchCharactor) {
		this.researchCharactor = researchCharactor;
	}

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String getResearchPlace() {
		return researchPlace;
	}

	public void setResearchPlace(String researchPlace) {
		this.researchPlace = researchPlace;
	}

	public Integer getResearchStatus() {
		return researchStatus;
	}

	public void setResearchStatus(Integer researchStatus) {
		this.researchStatus = researchStatus;
	}
	
}
