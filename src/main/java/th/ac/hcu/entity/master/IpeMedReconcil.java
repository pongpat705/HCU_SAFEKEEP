package th.ac.hcu.entity.master;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_MED_RECONCIL")
@TableGenerator(name="GEN_MED_RECONCIL", initialValue=0, allocationSize=50)
public class IpeMedReconcil {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_MED_RECONCIL")
    private Long medId;
	private String drug;
	private Integer volume;
	private Date date;
	private String note;
	
	public Long getMedId() {
		return medId;
	}
	public void setMedId(Long medId) {
		this.medId = medId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDrug() {
		return drug;
	}
	public void setDrug(String drug) {
		this.drug = drug;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
}
