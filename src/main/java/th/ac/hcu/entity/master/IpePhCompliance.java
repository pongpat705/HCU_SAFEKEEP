package th.ac.hcu.entity.master;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_PH_COMPLIANCE")
@TableGenerator(name="GEN_PH_COMPLIANCE", initialValue=0, allocationSize=50)
public class IpePhCompliance {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PH_COMPLIANCE")
    private Long complianceId;
	
	private String drug;
	
	private Integer takeQty;
	private Integer takePerDay;
	private Date takeTime;
	private String takePerWeek;
	
	private Integer missTime;
	private String missReason;
	
	private String knowsDrug;
	private String resultDrug;
	
	private String problemDesc;
	private String problemIntens;
	public Long getComplianceId() {
		return complianceId;
	}
	public void setComplianceId(Long complianceId) {
		this.complianceId = complianceId;
	}
	public String getDrug() {
		return drug;
	}
	public void setDrug(String drug) {
		this.drug = drug;
	}
	public Integer getTakeQty() {
		return takeQty;
	}
	public void setTakeQty(Integer takeQty) {
		this.takeQty = takeQty;
	}
	public Integer getTakePerDay() {
		return takePerDay;
	}
	public void setTakePerDay(Integer takePerDay) {
		this.takePerDay = takePerDay;
	}
	public Date getTakeTime() {
		return takeTime;
	}
	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
	}
	public String getTakePerWeek() {
		return takePerWeek;
	}
	public void setTakePerWeek(String takePerWeek) {
		this.takePerWeek = takePerWeek;
	}
	public Integer getMissTime() {
		return missTime;
	}
	public void setMissTime(Integer missTime) {
		this.missTime = missTime;
	}
	public String getMissReason() {
		return missReason;
	}
	public void setMissReason(String missReason) {
		this.missReason = missReason;
	}
	public String getKnowsDrug() {
		return knowsDrug;
	}
	public void setKnowsDrug(String knowsDrug) {
		this.knowsDrug = knowsDrug;
	}
	public String getResultDrug() {
		return resultDrug;
	}
	public void setResultDrug(String resultDrug) {
		this.resultDrug = resultDrug;
	}
	public String getProblemDesc() {
		return problemDesc;
	}
	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	public String getProblemIntens() {
		return problemIntens;
	}
	public void setProblemIntens(String problemIntens) {
		this.problemIntens = problemIntens;
	}
	
}
