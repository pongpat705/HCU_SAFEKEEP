package th.ac.hcu.entity.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_CONCLUDE_ANALYSIS")
@TableGenerator(name="GEN_CONCLUDE_ANALYSIS", initialValue=0, allocationSize=50)
public class IpeConcludeAnalysis {
	
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_CONCLUDE_ANALYSIS")
    private Long caId;

	private String functional;
	private String impairment;
	private String pathology;
	public Long getCaId() {
		return caId;
	}
	public void setCaId(Long caId) {
		this.caId = caId;
	}
	public String getFunctional() {
		return functional;
	}
	public void setFunctional(String functional) {
		this.functional = functional;
	}
	public String getImpairment() {
		return impairment;
	}
	public void setImpairment(String impairment) {
		this.impairment = impairment;
	}
	public String getPathology() {
		return pathology;
	}
	public void setPathology(String pathology) {
		this.pathology = pathology;
	}
}
