package th.ac.hcu.entity.master;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_PATIENT_PROFILE")
@TableGenerator(name="GEN_PATIENT_PROFILE", initialValue=0, allocationSize=50)
public class IpePatientProfile {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PATIENT_PROFILE")
    private Long patientId;
	
	private String indexName;
	
	//PATIENT PROFILE
	private String name;
	private Long age;
	private String mobile;
	private String houseNo;
	private String groupNo;
	private String district;
	private String prefecture;
	private String province;
	
	private String diagnose;
	private String period;
	private String curator;
	private String curatorAge;
	private String curatorRelation;
	private String supervisor;
	private String supervisorMobile;
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeVisitLog> visits;
	
	//nurse
	private String nSickness;//1
	private String nGeneralAppearance;//2
	private String nBodyTemp;//3
	private String nPulseRate;//3
	private String nRespiratoryRate;//3
	private String nBloodPressure;//3
	//paramconfig
	private String nSelfHelp;//4
	
	private String nFoodCondition;//5
	private String nMentalCondition;//6
	private	String nHowSupTakeCare;//7
	
	private String nCheckBySystem;//8
	//paramconfig
	private String nCheckByTools;//8
	private String nCheckByToolsDesc;
	
	private String nDiagnosis;//8
	private String nCare;//9
	private String nEstimate;//10
	
	//social Almoner
	private String sFormerJob; //1
	private String sWorkDuration; //1
	private String sIncome; //2
	//paramconfig
	private String sResidence; //3
	private String sResidenceCost;
	private String sResidenceRelation;
	@Lob
	private String sResidenceDescription;//3

	private String sFamilyCount;
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeFamilyMember> members;//4
	
	@Lob
	private String sGenogramImg; //4.2
	@Lob
	private String sEcoMapImg; //4.3
	private String sMentalCondition;//5.1
	private String sFamilyCondition;//5.2
	private String sRiskCondition;//5.3
	private String sNeedCondition;//5.4
	private String sHelpingGuid;//6
	@Lob
	private String sPatientMapImg;//7
	
	//pharma
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeUseDrug> useDrugs;
	
	//gerneral health
	private String gAnswer1;
	private String gAnswer2;
	private String gAnswer3;
	private String gAnswer4;
	private String gAnswer5;
	private String gAnswer6;
	private String gAnswer7;
	private String gAnswer8;
	private String gAnswer9;
	
	//lab
	private Integer lGlucose;
	private Integer lCholesterol;
	private Integer lTriglyceride;
	private Integer lHdlc;
	private Integer lLdlc;
	private Integer lBun;
	private Integer lCreatinine;
	private Integer lUric;
	private Integer lAlt;
	private Integer lAst;
	private String labAdvice;
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeMedicalTechnical> medical;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpePatientTransaction> transactions;

	
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	
	@OneToOne(cascade=CascadeType.ALL)
	private IpePatientPhStudent phStudent;
	
	@OneToOne(cascade=CascadeType.ALL)
	private IpePatientPtStudent ptStudent;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getCurator() {
		return curator;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public String getCuratorRelation() {
		return curatorRelation;
	}

	public void setCuratorRelation(String curatorRelation) {
		this.curatorRelation = curatorRelation;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getSupervisorMobile() {
		return supervisorMobile;
	}

	public void setSupervisorMobile(String supervisorMobile) {
		this.supervisorMobile = supervisorMobile;
	}

	public List<IpeVisitLog> getVisits() {
		return visits;
	}

	public void setVisits(List<IpeVisitLog> visits) {
		this.visits = visits;
	}

	public String getnSickness() {
		return nSickness;
	}

	public void setnSickness(String nSickness) {
		this.nSickness = nSickness;
	}

	public String getnGeneralAppearance() {
		return nGeneralAppearance;
	}

	public void setnGeneralAppearance(String nGeneralAppearance) {
		this.nGeneralAppearance = nGeneralAppearance;
	}

	public String getnBodyTemp() {
		return nBodyTemp;
	}

	public void setnBodyTemp(String nBodyTemp) {
		this.nBodyTemp = nBodyTemp;
	}

	public String getnPulseRate() {
		return nPulseRate;
	}

	public void setnPulseRate(String nPulseRate) {
		this.nPulseRate = nPulseRate;
	}

	public String getnRespiratoryRate() {
		return nRespiratoryRate;
	}

	public void setnRespiratoryRate(String nRespiratoryRate) {
		this.nRespiratoryRate = nRespiratoryRate;
	}

	public String getnBloodPressure() {
		return nBloodPressure;
	}

	public void setnBloodPressure(String nBloodPressure) {
		this.nBloodPressure = nBloodPressure;
	}

	public String getnSelfHelp() {
		return nSelfHelp;
	}

	public void setnSelfHelp(String nSelfHelp) {
		this.nSelfHelp = nSelfHelp;
	}

	public String getnFoodCondition() {
		return nFoodCondition;
	}

	public void setnFoodCondition(String nFoodCondition) {
		this.nFoodCondition = nFoodCondition;
	}

	public String getnMentalCondition() {
		return nMentalCondition;
	}

	public void setnMentalCondition(String nMentalCondition) {
		this.nMentalCondition = nMentalCondition;
	}

	public String getnHowSupTakeCare() {
		return nHowSupTakeCare;
	}

	public void setnHowSupTakeCare(String nHowSupTakeCare) {
		this.nHowSupTakeCare = nHowSupTakeCare;
	}

	public String getnCheckBySystem() {
		return nCheckBySystem;
	}

	public void setnCheckBySystem(String nCheckBySystem) {
		this.nCheckBySystem = nCheckBySystem;
	}

	public String getnCheckByTools() {
		return nCheckByTools;
	}

	public void setnCheckByTools(String nCheckByTools) {
		this.nCheckByTools = nCheckByTools;
	}

	public String getnDiagnosis() {
		return nDiagnosis;
	}

	public void setnDiagnosis(String nDiagnosis) {
		this.nDiagnosis = nDiagnosis;
	}

	public String getnCare() {
		return nCare;
	}

	public void setnCare(String nCare) {
		this.nCare = nCare;
	}

	public String getnEstimate() {
		return nEstimate;
	}

	public void setnEstimate(String nEstimate) {
		this.nEstimate = nEstimate;
	}

	public String getsFormerJob() {
		return sFormerJob;
	}

	public void setsFormerJob(String sFormerJob) {
		this.sFormerJob = sFormerJob;
	}

	public String getsWorkDuration() {
		return sWorkDuration;
	}

	public void setsWorkDuration(String sWorkDuration) {
		this.sWorkDuration = sWorkDuration;
	}

	public String getsIncome() {
		return sIncome;
	}

	public void setsIncome(String sIncome) {
		this.sIncome = sIncome;
	}

	public String getsResidence() {
		return sResidence;
	}

	public void setsResidence(String sResidence) {
		this.sResidence = sResidence;
	}

	public String getsResidenceDescription() {
		return sResidenceDescription;
	}

	public void setsResidenceDescription(String sResidenceDescription) {
		this.sResidenceDescription = sResidenceDescription;
	}

	public List<IpeFamilyMember> getMembers() {
		return members;
	}

	public void setMembers(List<IpeFamilyMember> members) {
		this.members = members;
	}

	public String getsGenogramImg() {
		return sGenogramImg;
	}

	public void setsGenogramImg(String sGenogramImg) {
		this.sGenogramImg = sGenogramImg;
	}

	public String getsEcoMapImg() {
		return sEcoMapImg;
	}

	public void setsEcoMapImg(String sEcoMapImg) {
		this.sEcoMapImg = sEcoMapImg;
	}

	public String getsMentalCondition() {
		return sMentalCondition;
	}

	public void setsMentalCondition(String sMentalCondition) {
		this.sMentalCondition = sMentalCondition;
	}

	public String getsFamilyCondition() {
		return sFamilyCondition;
	}

	public void setsFamilyCondition(String sFamilyCondition) {
		this.sFamilyCondition = sFamilyCondition;
	}

	public String getsRiskCondition() {
		return sRiskCondition;
	}

	public void setsRiskCondition(String sRiskCondition) {
		this.sRiskCondition = sRiskCondition;
	}

	public String getsNeedCondition() {
		return sNeedCondition;
	}

	public void setsNeedCondition(String sNeedCondition) {
		this.sNeedCondition = sNeedCondition;
	}

	public String getsHelpingGuid() {
		return sHelpingGuid;
	}

	public void setsHelpingGuid(String sHelpingGuid) {
		this.sHelpingGuid = sHelpingGuid;
	}

	public String getsPatientMapImg() {
		return sPatientMapImg;
	}

	public void setsPatientMapImg(String sPatientMapImg) {
		this.sPatientMapImg = sPatientMapImg;
	}

	public List<IpeUseDrug> getUseDrugs() {
		return useDrugs;
	}

	public void setUseDrugs(List<IpeUseDrug> useDrugs) {
		this.useDrugs = useDrugs;
	}

	public String getgAnswer1() {
		return gAnswer1;
	}

	public void setgAnswer1(String gAnswer1) {
		this.gAnswer1 = gAnswer1;
	}

	public String getgAnswer2() {
		return gAnswer2;
	}

	public void setgAnswer2(String gAnswer2) {
		this.gAnswer2 = gAnswer2;
	}

	public String getgAnswer3() {
		return gAnswer3;
	}

	public void setgAnswer3(String gAnswer3) {
		this.gAnswer3 = gAnswer3;
	}

	public String getgAnswer4() {
		return gAnswer4;
	}

	public void setgAnswer4(String gAnswer4) {
		this.gAnswer4 = gAnswer4;
	}

	public String getgAnswer5() {
		return gAnswer5;
	}

	public void setgAnswer5(String gAnswer5) {
		this.gAnswer5 = gAnswer5;
	}

	public String getgAnswer6() {
		return gAnswer6;
	}

	public void setgAnswer6(String gAnswer6) {
		this.gAnswer6 = gAnswer6;
	}

	public String getgAnswer7() {
		return gAnswer7;
	}

	public void setgAnswer7(String gAnswer7) {
		this.gAnswer7 = gAnswer7;
	}

	public String getgAnswer8() {
		return gAnswer8;
	}

	public void setgAnswer8(String gAnswer8) {
		this.gAnswer8 = gAnswer8;
	}

	public String getgAnswer9() {
		return gAnswer9;
	}

	public void setgAnswer9(String gAnswer9) {
		this.gAnswer9 = gAnswer9;
	}

	public List<IpePatientTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<IpePatientTransaction> transactions) {
		this.transactions = transactions;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getsResidenceCost() {
		return sResidenceCost;
	}

	public void setsResidenceCost(String sResidenceCost) {
		this.sResidenceCost = sResidenceCost;
	}

	public String getnCheckByToolsDesc() {
		return nCheckByToolsDesc;
	}

	public void setnCheckByToolsDesc(String nCheckByToolsDesc) {
		this.nCheckByToolsDesc = nCheckByToolsDesc;
	}

	public String getsResidenceRelation() {
		return sResidenceRelation;
	}

	public void setsResidenceRelation(String sResidenceRelation) {
		this.sResidenceRelation = sResidenceRelation;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public Integer getlGlucose() {
		return lGlucose;
	}

	public void setlGlucose(Integer lGlucose) {
		this.lGlucose = lGlucose;
	}

	public Integer getlCholesterol() {
		return lCholesterol;
	}

	public void setlCholesterol(Integer lCholesterol) {
		this.lCholesterol = lCholesterol;
	}

	public Integer getlTriglyceride() {
		return lTriglyceride;
	}

	public void setlTriglyceride(Integer lTriglyceride) {
		this.lTriglyceride = lTriglyceride;
	}

	public Integer getlHdlc() {
		return lHdlc;
	}

	public void setlHdlc(Integer lHdlc) {
		this.lHdlc = lHdlc;
	}

	public Integer getlLdlc() {
		return lLdlc;
	}

	public void setlLdlc(Integer lLdlc) {
		this.lLdlc = lLdlc;
	}

	public Integer getlBun() {
		return lBun;
	}

	public void setlBun(Integer lBun) {
		this.lBun = lBun;
	}

	public Integer getlCreatinine() {
		return lCreatinine;
	}

	public void setlCreatinine(Integer lCreatinine) {
		this.lCreatinine = lCreatinine;
	}

	public Integer getlUric() {
		return lUric;
	}

	public void setlUric(Integer lUric) {
		this.lUric = lUric;
	}

	public Integer getlAlt() {
		return lAlt;
	}

	public void setlAlt(Integer lAlt) {
		this.lAlt = lAlt;
	}

	public Integer getlAst() {
		return lAst;
	}

	public void setlAst(Integer lAst) {
		this.lAst = lAst;
	}

	public String getLabAdvice() {
		return labAdvice;
	}

	public void setLabAdvice(String labAdvice) {
		this.labAdvice = labAdvice;
	}

	public List<IpeMedicalTechnical> getMedical() {
		return medical;
	}

	public void setMedical(List<IpeMedicalTechnical> medical) {
		this.medical = medical;
	}

	public IpePatientPhStudent getPhStudent() {
		return phStudent;
	}

	public void setPhStudent(IpePatientPhStudent phStudent) {
		this.phStudent = phStudent;
	}

	public IpePatientPtStudent getPtStudent() {
		return ptStudent;
	}

	public void setPtStudent(IpePatientPtStudent ptStudent) {
		this.ptStudent = ptStudent;
	}

	public String getCuratorAge() {
		return curatorAge;
	}

	public void setCuratorAge(String curatorAge) {
		this.curatorAge = curatorAge;
	}

	public String getsFamilyCount() {
		return sFamilyCount;
	}

	public void setsFamilyCount(String sFamilyCount) {
		this.sFamilyCount = sFamilyCount;
	}



	
}
