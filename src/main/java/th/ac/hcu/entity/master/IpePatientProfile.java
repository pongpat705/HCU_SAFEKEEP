package th.ac.hcu.entity.master;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import th.ac.hcu.entity.UserRole;

@Entity
@Table(name = "IPE_PATIENT_PROFILE")
@TableGenerator(name="GEN_PATIENT_PROFILE", initialValue=0, allocationSize=50)
public class IpePatientProfile {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PATIENT_PROFILE")
    private Long patientId;
	
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
	private String curatorRelation;
	private String supervisor;
	@OneToMany(mappedBy="patient", fetch=FetchType.EAGER)
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
	
	private String nDiagnosis;//8
	private String nCare;//9
	private String nEstimate;//10
	
	//social Almoner
	private String sFormerJob; //1
	private String sWorkDuration; //1
	private String sIncome; //2
	//paramconfig
	private String sResidence; //3
	
	private String sResidenceDescription;//3

	@OneToMany(mappedBy="patient", fetch=FetchType.EAGER)
	private List<IpeFamilyMember> members;//4
	
	private String sGenogramImg; //4.2
	private String sEcoMapImg; //4.3
	private String sMentalCondition;//5.1
	private String sFamilyCondition;//5.2
	private String sRiskCondition;//5.3
	private String sNeedCondition;//5.4
	private String sHelpingGuid;//6
	private String sPatientMapImg;//7
	
	//pharma
	
	
	
	
	
	
}
