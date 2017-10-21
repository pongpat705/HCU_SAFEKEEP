package th.ac.hcu.entity.master;

import java.util.Date;
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
@Table(name = "IPE_PATIENT_PT_STUDENT")
@TableGenerator(name="GEN_PATIENT_PT_STUDENT", initialValue=0, allocationSize=50)
public class IpePatientPtStudent {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PATIENT_PT_STUDENT")
    private Long ptId;
	private String studentId;
	
	private String examiner;
	private String diagnosis;
	private String caution;
	private Date checkin;
	private String symtons;
	
	private String image;
	
	private String agg;
	private String eases;
	private String irritability;
	private String am;
	private String day;
	private String pm;
	private String night;
	
	private String histPresSickness;
	private String histPassSickness;
	private String histSocial;
	private String histFamily;

	//items
	private String item1;
	private String item2;
	private String item3;
	private String item4;
	private String item5;
	private String item6;
	private String item7;
	private String item8;
	private String item9;
	private String item10;
	private String item11;
	private String item12;
	private String item13;
	private String item14;
	private String item15;
	private String item16;
	private String item17;

	private String comment1;
	private String comment2;
	private String comment3;
	private String comment4;
	private String comment5;
	private String comment6;
	private String comment7;
	private String comment8;
	private String comment9;
	private String comment10;
	private String comment11;
	private String comment12;
	private String comment13;
	private String comment14;
	private String comment15;
	private String comment16;
	private String comment17;

	private String assumpDianosis;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpePatientExamination> examinations;
	
	private String physicalDiagnosis;
	private String confirmDiagnosis;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeConcludeAnalysis> concludeAnalysis;
	
	private String shortTermGoal;
	private String longTermGoal;
	private String prediction;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeGoalPlan> goals;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<IpeProgressNote> notes;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private IpePatientProfile patient;

	public Long getPtId() {
		return ptId;
	}

	public void setPtId(Long ptId) {
		this.ptId = ptId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getExaminer() {
		return examiner;
	}

	public void setExaminer(String examiner) {
		this.examiner = examiner;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public String getSymtons() {
		return symtons;
	}

	public void setSymtons(String symtons) {
		this.symtons = symtons;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAgg() {
		return agg;
	}

	public void setAgg(String agg) {
		this.agg = agg;
	}

	public String getEases() {
		return eases;
	}

	public void setEases(String eases) {
		this.eases = eases;
	}

	public String getIrritability() {
		return irritability;
	}

	public void setIrritability(String irritability) {
		this.irritability = irritability;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getNight() {
		return night;
	}

	public void setNight(String night) {
		this.night = night;
	}

	public String getHistPresSickness() {
		return histPresSickness;
	}

	public void setHistPresSickness(String histPresSickness) {
		this.histPresSickness = histPresSickness;
	}

	public String getHistPassSickness() {
		return histPassSickness;
	}

	public void setHistPassSickness(String histPassSickness) {
		this.histPassSickness = histPassSickness;
	}

	public String getHistSocial() {
		return histSocial;
	}

	public void setHistSocial(String histSocial) {
		this.histSocial = histSocial;
	}

	public String getHistFamily() {
		return histFamily;
	}

	public void setHistFamily(String histFamily) {
		this.histFamily = histFamily;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public String getItem4() {
		return item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	public String getItem5() {
		return item5;
	}

	public void setItem5(String item5) {
		this.item5 = item5;
	}

	public String getItem6() {
		return item6;
	}

	public void setItem6(String item6) {
		this.item6 = item6;
	}

	public String getItem7() {
		return item7;
	}

	public void setItem7(String item7) {
		this.item7 = item7;
	}

	public String getItem8() {
		return item8;
	}

	public void setItem8(String item8) {
		this.item8 = item8;
	}

	public String getItem9() {
		return item9;
	}

	public void setItem9(String item9) {
		this.item9 = item9;
	}

	public String getItem10() {
		return item10;
	}

	public void setItem10(String item10) {
		this.item10 = item10;
	}

	public String getItem11() {
		return item11;
	}

	public void setItem11(String item11) {
		this.item11 = item11;
	}

	public String getItem12() {
		return item12;
	}

	public void setItem12(String item12) {
		this.item12 = item12;
	}

	public String getItem13() {
		return item13;
	}

	public void setItem13(String item13) {
		this.item13 = item13;
	}

	public String getItem14() {
		return item14;
	}

	public void setItem14(String item14) {
		this.item14 = item14;
	}

	public String getItem15() {
		return item15;
	}

	public void setItem15(String item15) {
		this.item15 = item15;
	}

	public String getItem16() {
		return item16;
	}

	public void setItem16(String item16) {
		this.item16 = item16;
	}

	public String getItem17() {
		return item17;
	}

	public void setItem17(String item17) {
		this.item17 = item17;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getComment3() {
		return comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getComment4() {
		return comment4;
	}

	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}

	public String getComment5() {
		return comment5;
	}

	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}

	public String getComment6() {
		return comment6;
	}

	public void setComment6(String comment6) {
		this.comment6 = comment6;
	}

	public String getComment7() {
		return comment7;
	}

	public void setComment7(String comment7) {
		this.comment7 = comment7;
	}

	public String getComment8() {
		return comment8;
	}

	public void setComment8(String comment8) {
		this.comment8 = comment8;
	}

	public String getComment9() {
		return comment9;
	}

	public void setComment9(String comment9) {
		this.comment9 = comment9;
	}

	public String getComment10() {
		return comment10;
	}

	public void setComment10(String comment10) {
		this.comment10 = comment10;
	}

	public String getComment11() {
		return comment11;
	}

	public void setComment11(String comment11) {
		this.comment11 = comment11;
	}

	public String getComment12() {
		return comment12;
	}

	public void setComment12(String comment12) {
		this.comment12 = comment12;
	}

	public String getComment13() {
		return comment13;
	}

	public void setComment13(String comment13) {
		this.comment13 = comment13;
	}

	public String getComment14() {
		return comment14;
	}

	public void setComment14(String comment14) {
		this.comment14 = comment14;
	}

	public String getComment15() {
		return comment15;
	}

	public void setComment15(String comment15) {
		this.comment15 = comment15;
	}

	public String getComment16() {
		return comment16;
	}

	public void setComment16(String comment16) {
		this.comment16 = comment16;
	}

	public String getComment17() {
		return comment17;
	}

	public void setComment17(String comment17) {
		this.comment17 = comment17;
	}

	public String getAssumpDianosis() {
		return assumpDianosis;
	}

	public void setAssumpDianosis(String assumpDianosis) {
		this.assumpDianosis = assumpDianosis;
	}

	public List<IpePatientExamination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<IpePatientExamination> examinations) {
		this.examinations = examinations;
	}

	public String getPhysicalDiagnosis() {
		return physicalDiagnosis;
	}

	public void setPhysicalDiagnosis(String physicalDiagnosis) {
		this.physicalDiagnosis = physicalDiagnosis;
	}

	public String getConfirmDiagnosis() {
		return confirmDiagnosis;
	}

	public void setConfirmDiagnosis(String confirmDiagnosis) {
		this.confirmDiagnosis = confirmDiagnosis;
	}

	public List<IpeConcludeAnalysis> getConcludeAnalysis() {
		return concludeAnalysis;
	}

	public void setConcludeAnalysis(List<IpeConcludeAnalysis> concludeAnalysis) {
		this.concludeAnalysis = concludeAnalysis;
	}

	public String getShortTermGoal() {
		return shortTermGoal;
	}

	public void setShortTermGoal(String shortTermGoal) {
		this.shortTermGoal = shortTermGoal;
	}

	public String getLongTermGoal() {
		return longTermGoal;
	}

	public void setLongTermGoal(String longTermGoal) {
		this.longTermGoal = longTermGoal;
	}

	public String getPrediction() {
		return prediction;
	}

	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}

	public List<IpeGoalPlan> getGoals() {
		return goals;
	}

	public void setGoals(List<IpeGoalPlan> goals) {
		this.goals = goals;
	}

	public List<IpeProgressNote> getNotes() {
		return notes;
	}

	public void setNotes(List<IpeProgressNote> notes) {
		this.notes = notes;
	}

	public IpePatientProfile getPatient() {
		return patient;
	}

	public void setPatient(IpePatientProfile patient) {
		this.patient = patient;
	}
	
}
