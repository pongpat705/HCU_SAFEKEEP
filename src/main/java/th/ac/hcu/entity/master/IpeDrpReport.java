package th.ac.hcu.entity.master;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_DRP_REPORT")
@TableGenerator(name="GEN_DRP_REPORT", initialValue=0, allocationSize=50)
public class IpeDrpReport {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_DRP_REPORT")
    private Long drpId;
	
	private Date date;
	private String drps;
	private String patientName;
	private String detail;
	private String intervention;
	private String physicalResponse;
	private String fu;
	public Long getDrpId() {
		return drpId;
	}
	public void setDrpId(Long drpId) {
		this.drpId = drpId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDrps() {
		return drps;
	}
	public void setDrps(String drps) {
		this.drps = drps;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getIntervention() {
		return intervention;
	}
	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}
	public String getPhysicalResponse() {
		return physicalResponse;
	}
	public void setPhysicalResponse(String physicalResponse) {
		this.physicalResponse = physicalResponse;
	}
	public String getFu() {
		return fu;
	}
	public void setFu(String fu) {
		this.fu = fu;
	}
}
