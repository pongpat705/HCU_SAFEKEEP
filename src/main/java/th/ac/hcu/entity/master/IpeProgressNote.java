package th.ac.hcu.entity.master;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_PROGRESS_NOTE")
@TableGenerator(name="GEN_PROGRESS_NOTE", initialValue=0, allocationSize=50)
public class IpeProgressNote {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PROGRESS_NOTE")
    private Long progressId;
	
	private Date date;
	private String note;
	public Long getProgressId() {
		return progressId;
	}
	public void setProgressId(Long progressId) {
		this.progressId = progressId;
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
	
}
