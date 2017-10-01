package th.ac.hcu.entity.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_MEDICAL_TECHNICAL")
@TableGenerator(name="GEN_MEDICAL_TECHNICAL", initialValue=0, allocationSize=50)
public class IpeMedicalTechnical {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_MEDICAL_TECHNICAL")
    private Long medicalId;
	
	private String record;
	private String nomalValue;
	private String result;
	
	public Long getMedicalId() {
		return medicalId;
	}
	public void setMedicalId(Long medicalId) {
		this.medicalId = medicalId;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getNomalValue() {
		return nomalValue;
	}
	public void setNomalValue(String nomalValue) {
		this.nomalValue = nomalValue;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
