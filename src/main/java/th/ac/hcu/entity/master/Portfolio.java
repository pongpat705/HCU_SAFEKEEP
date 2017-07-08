package th.ac.hcu.entity.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MASTER_PORTFOLIO")
public class Portfolio {

	@Id
	@GenericGenerator(name = "GEN_MASTER_PORTFOLIO", strategy = "th.ac.hcu.generator.PortfolioIdGenerator") 
    @GeneratedValue(generator="GEN_MASTER_PORTFOLIO")
    private String 	masterId;
	
	private String	name;
	
	private String 	nameNation;
	
	private String 	year;

	private Integer researchCharactor;
	
	private Integer major;

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

	public String getNameNation() {
		return nameNation;
	}

	public void setNameNation(String nameNation) {
		this.nameNation = nameNation;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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
	
}
