package th.ac.hcu.entity.master;


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

	//Wounds
	private String wAns1;
	private String wAns2;
	private String wAns2Descp;
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeNurseImg> imgs;
	
	//phlegm
	private String pAns1;
	private String pAns2;
	
	//urine
	private String uAns1;
	private String uAns2;
	private String uAns3;
	
	//selfCare
	private String sAns1;
	private String sAns2;
	
	//exercise
	private String eAns1;
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
	private String plAns1;
	private String plAns2;
	private String plAns3;
	private String plAns4;
	private String plAns5;
	
	//Stiffness
	private String snAns1;
	private String snAns2;
	
	//Knee operation
	private String koAns1;
	private String koAns2;
	private String koAns3;
	private String koAns4;
	private String koAns5;
	private String koAns6;
	private String koAns7;
	private String koAns8;
	private String koAns9;
	private String koAns10;
	private String koAns11;
	private String koAns12;
	private String koAns13;
	private String koAns14;
	private String koAns15;
	
	
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

	public List<IpeNurseImg> getImgs() {
		return imgs;
	}

	public void setImgs(List<IpeNurseImg> imgs) {
		this.imgs = imgs;
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

	public String getPlAns1() {
		return plAns1;
	}

	public void setPlAns1(String plAns1) {
		this.plAns1 = plAns1;
	}

	public String getPlAns2() {
		return plAns2;
	}

	public void setPlAns2(String plAns2) {
		this.plAns2 = plAns2;
	}

	public String getPlAns3() {
		return plAns3;
	}

	public void setPlAns3(String plAns3) {
		this.plAns3 = plAns3;
	}

	public String getPlAns4() {
		return plAns4;
	}

	public void setPlAns4(String plAns4) {
		this.plAns4 = plAns4;
	}

	public String getPlAns5() {
		return plAns5;
	}

	public void setPlAns5(String plAns5) {
		this.plAns5 = plAns5;
	}

	public String getSnAns1() {
		return snAns1;
	}

	public void setSnAns1(String snAns1) {
		this.snAns1 = snAns1;
	}

	public String getSnAns2() {
		return snAns2;
	}

	public void setSnAns2(String snAns2) {
		this.snAns2 = snAns2;
	}

	public String getKoAns1() {
		return koAns1;
	}

	public void setKoAns1(String koAns1) {
		this.koAns1 = koAns1;
	}

	public String getKoAns2() {
		return koAns2;
	}

	public void setKoAns2(String koAns2) {
		this.koAns2 = koAns2;
	}

	public String getKoAns3() {
		return koAns3;
	}

	public void setKoAns3(String koAns3) {
		this.koAns3 = koAns3;
	}

	public String getKoAns4() {
		return koAns4;
	}

	public void setKoAns4(String koAns4) {
		this.koAns4 = koAns4;
	}

	public String getKoAns5() {
		return koAns5;
	}

	public void setKoAns5(String koAns5) {
		this.koAns5 = koAns5;
	}

	public String getKoAns6() {
		return koAns6;
	}

	public void setKoAns6(String koAns6) {
		this.koAns6 = koAns6;
	}

	public String getKoAns7() {
		return koAns7;
	}

	public void setKoAns7(String koAns7) {
		this.koAns7 = koAns7;
	}

	public String getKoAns8() {
		return koAns8;
	}

	public void setKoAns8(String koAns8) {
		this.koAns8 = koAns8;
	}

	public String getKoAns9() {
		return koAns9;
	}

	public void setKoAns9(String koAns9) {
		this.koAns9 = koAns9;
	}

	public String getKoAns10() {
		return koAns10;
	}

	public void setKoAns10(String koAns10) {
		this.koAns10 = koAns10;
	}

	public String getKoAns11() {
		return koAns11;
	}

	public void setKoAns11(String koAns11) {
		this.koAns11 = koAns11;
	}

	public String getKoAns12() {
		return koAns12;
	}

	public void setKoAns12(String koAns12) {
		this.koAns12 = koAns12;
	}

	public String getKoAns13() {
		return koAns13;
	}

	public void setKoAns13(String koAns13) {
		this.koAns13 = koAns13;
	}

	public String getKoAns14() {
		return koAns14;
	}

	public void setKoAns14(String koAns14) {
		this.koAns14 = koAns14;
	}

	public String getKoAns15() {
		return koAns15;
	}

	public void setKoAns15(String koAns15) {
		this.koAns15 = koAns15;
	}

	public String getwAns2Descp() {
		return wAns2Descp;
	}

	public void setwAns2Descp(String wAns2Descp) {
		this.wAns2Descp = wAns2Descp;
	}

	public List<IpeStudentEstimate> getEstimates() {
		return estimates;
	}

	public void setEstimates(List<IpeStudentEstimate> estimates) {
		this.estimates = estimates;
	}
	
}
