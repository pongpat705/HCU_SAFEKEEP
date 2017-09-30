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
@Table(name = "IPE_STUDENT_ESTIMATE")
@TableGenerator(name="GEN_STUDENT_ESTIMATE", initialValue=0, allocationSize=50)
public class IpeStudentEstimate {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_STUDENT_ESTIMATE")
    private Long estimateId;
	
	private String desctiption;
	
	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private IpePatientTransaction transaction;

	public Long getEstimateId() {
		return estimateId;
	}

	public void setEstimateId(Long estimateId) {
		this.estimateId = estimateId;
	}

	public String getDesctiption() {
		return desctiption;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}
}
