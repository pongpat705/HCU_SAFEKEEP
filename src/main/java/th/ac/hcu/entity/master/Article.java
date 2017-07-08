package th.ac.hcu.entity.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MASTER_ARTICLE")
public class Article {

	@Id
	@GenericGenerator(name = "GEN_MASTER_ARTICLE", strategy = "th.ac.hcu.generator.ArticleIdGenerator") 
    @GeneratedValue(generator="GEN_MASTER_ARTICLE")
    private String 	masterId;
	
	private String 	year;
	
	private String	name;
	
	private String 	nameNation;

	private Integer major;

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

}
