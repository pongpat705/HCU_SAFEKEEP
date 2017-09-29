package th.ac.hcu.entity.master;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_NURSE_IMG")
@TableGenerator(name="GEN_NURSE_IMG", initialValue=0, allocationSize=50)
public class IpeNurseImg {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_NURSE_IMG")
    private Long imgId;
	
	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private IpePatientTransaction transaction;
	
	private String type;
	private String description;
	private Date cleanDate;
	public Long getImgId() {
		return imgId;
	}
	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}
	public IpePatientTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(IpePatientTransaction transaction) {
		this.transaction = transaction;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCleanDate() {
		return cleanDate;
	}
	public void setCleanDate(Date cleanDate) {
		this.cleanDate = cleanDate;
	}
}
