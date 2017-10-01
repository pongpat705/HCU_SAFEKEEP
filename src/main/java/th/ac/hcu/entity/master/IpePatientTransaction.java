package th.ac.hcu.entity.master;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_PATIENT_TRANSACTION")
@TableGenerator(name="GEN_PATIENT_TRANSACTION", initialValue=0, allocationSize=50)
public class IpePatientTransaction {
	
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PATIENT_TRANSACTION")
    private Long transactionId;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeMedicalTechnical> medical;
	private String medicalAdvice;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeNurseImg> imgs;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeStudentEstimate> estimates;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public List<IpeMedicalTechnical> getMedical() {
		return medical;
	}

	public void setMedical(List<IpeMedicalTechnical> medical) {
		this.medical = medical;
	}

	public String getMedicalAdvice() {
		return medicalAdvice;
	}

	public void setMedicalAdvice(String medicalAdvice) {
		this.medicalAdvice = medicalAdvice;
	}

	public List<IpeNurseImg> getImgs() {
		return imgs;
	}

	public void setImgs(List<IpeNurseImg> imgs) {
		this.imgs = imgs;
	}
	
}
