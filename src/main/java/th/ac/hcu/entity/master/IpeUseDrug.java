package th.ac.hcu.entity.master;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_USE_DRUG")
@TableGenerator(name="GEN_USE_DRUG", initialValue=0, allocationSize=50)
public class IpeUseDrug {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_USE_DRUG")
    private Long drugId;
	
	private Date date;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeDrugList> drugList;//4
	
	private String isAllergy;
	@Lob
	private String allergyDescription;
	
	//paramconfig
	private String usingDrug;
	@Lob
	private String drugAdvice;
	//paramconfig
	private String drugProblem;
	@Lob
	private String problemDescription;

	public Long getDrugId() {
		return drugId;
	}

	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}

	public List<IpeDrugList> getDrugList() {
		return drugList;
	}

	public void setDrugList(List<IpeDrugList> drugList) {
		this.drugList = drugList;
	}

	public String getIsAllergy() {
		return isAllergy;
	}

	public void setIsAllergy(String isAllergy) {
		this.isAllergy = isAllergy;
	}

	public String getAllergyDescription() {
		return allergyDescription;
	}

	public void setAllergyDescription(String allergyDescription) {
		this.allergyDescription = allergyDescription;
	}

	public String getUsingDrug() {
		return usingDrug;
	}

	public void setUsingDrug(String usingDrug) {
		this.usingDrug = usingDrug;
	}

	public String getDrugAdvice() {
		return drugAdvice;
	}

	public void setDrugAdvice(String drugAdvice) {
		this.drugAdvice = drugAdvice;
	}

	public String getDrugProblem() {
		return drugProblem;
	}

	public void setDrugProblem(String drugProblem) {
		this.drugProblem = drugProblem;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
