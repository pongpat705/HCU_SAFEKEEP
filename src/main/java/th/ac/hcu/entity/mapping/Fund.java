package th.ac.hcu.entity.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MAPPING_FUND")
@TableGenerator(name="GEN_MAPPING_FUND", initialValue=0, allocationSize=50)
public class Fund {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_MAPPING_FUND")
    private Long 	id;
	
	private String 	masterId;
	
	private String	fundSource;
	
	private Integer	fundYear;
	
	private	Integer	fundYearTotal;
	
	private	Double	fundValue;
	
	private char	isInternal;

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

	public String getFundSource() {
		return fundSource;
	}

	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}

	public Integer getFundYear() {
		return fundYear;
	}

	public void setFundYear(Integer fundYear) {
		this.fundYear = fundYear;
	}

	public Integer getFundYearTotal() {
		return fundYearTotal;
	}

	public void setFundYearTotal(Integer fundYearTotal) {
		this.fundYearTotal = fundYearTotal;
	}

	public Double getFundValue() {
		return fundValue;
	}

	public void setFundValue(Double fundValue) {
		this.fundValue = fundValue;
	}

	public char getIsInternal() {
		return isInternal;
	}

	public void setIsInternal(char isInternal) {
		this.isInternal = isInternal;
	}
	
	
}
