package th.ac.hcu.entity.master;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private String indexName;

	//Wounds
	private String wAns1;
	private String wAns2;
	private String wAns2Descp;
	private String imgs;
	
	//phlegm
	private String pAns1;
	private String pAns2;
	
	//urine
	private String uAns1;
	private String uAns1Descp;
	private String uAns2;
	private String uAns3;
	
	//selfCare
	private String sAns1;
	private String sAns2;
	private String sAns2Descp;
	
	//exercise
	private String eAns1;
	private String eAns1Descp;
	private String eAns2;
	
	//Daily ability
	private String daAns1;
	private String daAns2;
	private String daAns3;
	private String daAns4;
	private String daAns5;
	private String daAns6;
	private String daAns7;
	private String daAns8;
	private String daAns9;
	private String daAns10;
	
	//Severe osteoarthritis
	private String soAns1;
	private String soAns2;
	private String soAns3;
	private String soAns4;
	private String soAns5;
	private String soAns6;
	private String soAns7;
	private String soAns8;
	private String soAns9;
	private String soAns10;
	private String soAns11;
	private String soAns12;
	
	//Pain level
	private Integer plAns1;
	private Integer plAns2;
	private Integer plAns3;
	private Integer plAns4;
	private Integer plAns5;
	
	//Stiffness
	private Integer snAns1;
	private Integer snAns2;
	
	//Knee operation
	private Integer koAns1;
	private Integer koAns2;
	private Integer koAns3;
	private Integer koAns4;
	private Integer koAns5;
	private Integer koAns6;
	private Integer koAns7;
	private Integer koAns8;
	private Integer koAns9;
	private Integer koAns10;
	private Integer koAns11;
	private Integer koAns12;
	private Integer koAns13;
	private Integer koAns14;
	private Integer koAns15;
	
	private Date createdDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeMedicalTechnical> medical;
	private String medicalAdvice;
	
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

	public String getwAns1() {
		return wAns1;
	}

	public void setwAns1(String wAns1) {
		this.wAns1 = wAns1;
	}

	public String getwAns2() {
		return wAns2;
	}

	public void setwAns2(String wAns2) {
		this.wAns2 = wAns2;
	}

	public String getpAns1() {
		return pAns1;
	}

	public void setpAns1(String pAns1) {
		this.pAns1 = pAns1;
	}

	public String getpAns2() {
		return pAns2;
	}

	public void setpAns2(String pAns2) {
		this.pAns2 = pAns2;
	}

	public String getuAns1() {
		return uAns1;
	}

	public void setuAns1(String uAns1) {
		this.uAns1 = uAns1;
	}

	public String getuAns2() {
		return uAns2;
	}

	public void setuAns2(String uAns2) {
		this.uAns2 = uAns2;
	}

	public String getuAns3() {
		return uAns3;
	}

	public void setuAns3(String uAns3) {
		this.uAns3 = uAns3;
	}

	public String getsAns1() {
		return sAns1;
	}

	public void setsAns1(String sAns1) {
		this.sAns1 = sAns1;
	}

	public String getsAns2() {
		return sAns2;
	}

	public void setsAns2(String sAns2) {
		this.sAns2 = sAns2;
	}

	public String geteAns1() {
		return eAns1;
	}

	public void seteAns1(String eAns1) {
		this.eAns1 = eAns1;
	}

	public String geteAns2() {
		return eAns2;
	}

	public void seteAns2(String eAns2) {
		this.eAns2 = eAns2;
	}

	public String getDaAns1() {
		return daAns1;
	}

	public void setDaAns1(String daAns1) {
		this.daAns1 = daAns1;
	}

	public String getDaAns2() {
		return daAns2;
	}

	public void setDaAns2(String daAns2) {
		this.daAns2 = daAns2;
	}

	public String getDaAns3() {
		return daAns3;
	}

	public void setDaAns3(String daAns3) {
		this.daAns3 = daAns3;
	}

	public String getDaAns4() {
		return daAns4;
	}

	public void setDaAns4(String daAns4) {
		this.daAns4 = daAns4;
	}

	public String getDaAns5() {
		return daAns5;
	}

	public void setDaAns5(String daAns5) {
		this.daAns5 = daAns5;
	}

	public String getDaAns6() {
		return daAns6;
	}

	public void setDaAns6(String daAns6) {
		this.daAns6 = daAns6;
	}

	public String getDaAns7() {
		return daAns7;
	}

	public void setDaAns7(String daAns7) {
		this.daAns7 = daAns7;
	}

	public String getDaAns8() {
		return daAns8;
	}

	public void setDaAns8(String daAns8) {
		this.daAns8 = daAns8;
	}

	public String getDaAns9() {
		return daAns9;
	}

	public void setDaAns9(String daAns9) {
		this.daAns9 = daAns9;
	}

	public String getDaAns10() {
		return daAns10;
	}

	public void setDaAns10(String daAns10) {
		this.daAns10 = daAns10;
	}

	public String getSoAns1() {
		return soAns1;
	}

	public void setSoAns1(String soAns1) {
		this.soAns1 = soAns1;
	}

	public String getSoAns2() {
		return soAns2;
	}

	public void setSoAns2(String soAns2) {
		this.soAns2 = soAns2;
	}

	public String getSoAns3() {
		return soAns3;
	}

	public void setSoAns3(String soAns3) {
		this.soAns3 = soAns3;
	}

	public String getSoAns4() {
		return soAns4;
	}

	public void setSoAns4(String soAns4) {
		this.soAns4 = soAns4;
	}

	public String getSoAns5() {
		return soAns5;
	}

	public void setSoAns5(String soAns5) {
		this.soAns5 = soAns5;
	}

	public String getSoAns6() {
		return soAns6;
	}

	public void setSoAns6(String soAns6) {
		this.soAns6 = soAns6;
	}

	public String getSoAns7() {
		return soAns7;
	}

	public void setSoAns7(String soAns7) {
		this.soAns7 = soAns7;
	}

	public String getSoAns8() {
		return soAns8;
	}

	public void setSoAns8(String soAns8) {
		this.soAns8 = soAns8;
	}

	public String getSoAns9() {
		return soAns9;
	}

	public void setSoAns9(String soAns9) {
		this.soAns9 = soAns9;
	}

	public String getSoAns10() {
		return soAns10;
	}

	public void setSoAns10(String soAns10) {
		this.soAns10 = soAns10;
	}

	public String getSoAns11() {
		return soAns11;
	}

	public void setSoAns11(String soAns11) {
		this.soAns11 = soAns11;
	}

	public String getSoAns12() {
		return soAns12;
	}

	public void setSoAns12(String soAns12) {
		this.soAns12 = soAns12;
	}

	public Integer getPlAns1() {
		return plAns1;
	}

	public void setPlAns1(Integer plAns1) {
		this.plAns1 = plAns1;
	}

	public Integer getPlAns2() {
		return plAns2;
	}

	public void setPlAns2(Integer plAns2) {
		this.plAns2 = plAns2;
	}

	public Integer getPlAns3() {
		return plAns3;
	}

	public void setPlAns3(Integer plAns3) {
		this.plAns3 = plAns3;
	}

	public Integer getPlAns4() {
		return plAns4;
	}

	public void setPlAns4(Integer plAns4) {
		this.plAns4 = plAns4;
	}

	public Integer getPlAns5() {
		return plAns5;
	}

	public void setPlAns5(Integer plAns5) {
		this.plAns5 = plAns5;
	}

	public Integer getSnAns1() {
		return snAns1;
	}

	public void setSnAns1(Integer snAns1) {
		this.snAns1 = snAns1;
	}

	public Integer getSnAns2() {
		return snAns2;
	}

	public void setSnAns2(Integer snAns2) {
		this.snAns2 = snAns2;
	}

	public Integer getKoAns1() {
		return koAns1;
	}

	public void setKoAns1(Integer koAns1) {
		this.koAns1 = koAns1;
	}

	public Integer getKoAns2() {
		return koAns2;
	}

	public void setKoAns2(Integer koAns2) {
		this.koAns2 = koAns2;
	}

	public Integer getKoAns3() {
		return koAns3;
	}

	public void setKoAns3(Integer koAns3) {
		this.koAns3 = koAns3;
	}

	public Integer getKoAns4() {
		return koAns4;
	}

	public void setKoAns4(Integer koAns4) {
		this.koAns4 = koAns4;
	}

	public Integer getKoAns5() {
		return koAns5;
	}

	public void setKoAns5(Integer koAns5) {
		this.koAns5 = koAns5;
	}

	public Integer getKoAns6() {
		return koAns6;
	}

	public void setKoAns6(Integer koAns6) {
		this.koAns6 = koAns6;
	}

	public Integer getKoAns7() {
		return koAns7;
	}

	public void setKoAns7(Integer koAns7) {
		this.koAns7 = koAns7;
	}

	public Integer getKoAns8() {
		return koAns8;
	}

	public void setKoAns8(Integer koAns8) {
		this.koAns8 = koAns8;
	}

	public Integer getKoAns9() {
		return koAns9;
	}

	public void setKoAns9(Integer koAns9) {
		this.koAns9 = koAns9;
	}

	public Integer getKoAns10() {
		return koAns10;
	}

	public void setKoAns10(Integer koAns10) {
		this.koAns10 = koAns10;
	}

	public Integer getKoAns11() {
		return koAns11;
	}

	public void setKoAns11(Integer koAns11) {
		this.koAns11 = koAns11;
	}

	public Integer getKoAns12() {
		return koAns12;
	}

	public void setKoAns12(Integer koAns12) {
		this.koAns12 = koAns12;
	}

	public Integer getKoAns13() {
		return koAns13;
	}

	public void setKoAns13(Integer koAns13) {
		this.koAns13 = koAns13;
	}

	public Integer getKoAns14() {
		return koAns14;
	}

	public void setKoAns14(Integer koAns14) {
		this.koAns14 = koAns14;
	}

	public Integer getKoAns15() {
		return koAns15;
	}

	public void setKoAns15(Integer koAns15) {
		this.koAns15 = koAns15;
	}

	public String getwAns2Descp() {
		return wAns2Descp;
	}

	public void setwAns2Descp(String wAns2Descp) {
		this.wAns2Descp = wAns2Descp;
	}

	public String getuAns1Descp() {
		return uAns1Descp;
	}

	public void setuAns1Descp(String uAns1Descp) {
		this.uAns1Descp = uAns1Descp;
	}

	public String getsAns2Descp() {
		return sAns2Descp;
	}

	public void setsAns2Descp(String sAns2Descp) {
		this.sAns2Descp = sAns2Descp;
	}

	public String geteAns1Descp() {
		return eAns1Descp;
	}

	public void seteAns1Descp(String eAns1Descp) {
		this.eAns1Descp = eAns1Descp;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public List<IpeStudentEstimate> getEstimates() {
		return estimates;
	}

	public void setEstimates(List<IpeStudentEstimate> estimates) {
		this.estimates = estimates;
	}
	
}
