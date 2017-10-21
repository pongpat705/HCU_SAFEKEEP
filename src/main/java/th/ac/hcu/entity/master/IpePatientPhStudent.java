package th.ac.hcu.entity.master;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_PATIENT_PH_STUDENT")
@TableGenerator(name="GEN_PATIENT_PH_STUDENT", initialValue=0, allocationSize=50)
public class IpePatientPhStudent {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PATIENT_PH_STUDENT")
    private Long phId;
	
	private String studentId;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpePhCompliance> compliances;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeDrpReport> drpReports;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeMedReconcil> reconcils;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private IpePatientProfile patient;
	
	public Long getPhId() {
		return phId;
	}
	public void setPhId(Long phId) {
		this.phId = phId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public List<IpePhCompliance> getCompliances() {
		return compliances;
	}
	public void setCompliances(List<IpePhCompliance> compliances) {
		this.compliances = compliances;
	}
	public List<IpeDrpReport> getDrpReports() {
		return drpReports;
	}
	public void setDrpReports(List<IpeDrpReport> drpReports) {
		this.drpReports = drpReports;
	}
	public List<IpeMedReconcil> getReconcils() {
		return reconcils;
	}
	public void setReconcils(List<IpeMedReconcil> reconcils) {
		this.reconcils = reconcils;
	}
	public IpePatientProfile getPatient() {
		return patient;
	}
	public void setPatient(IpePatientProfile patient) {
		this.patient = patient;
	}
}
