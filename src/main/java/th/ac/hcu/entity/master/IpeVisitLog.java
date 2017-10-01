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
@Table(name = "IPE_VISIT_LOG")
@TableGenerator(name="GEN_VISIT_LOG", initialValue=0, allocationSize=50)
public class IpeVisitLog {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_VISIT_LOG")
    private Long logId;
	
	private Date date;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
