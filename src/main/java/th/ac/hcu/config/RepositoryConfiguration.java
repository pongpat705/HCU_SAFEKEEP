package th.ac.hcu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import th.ac.hcu.entity.User;
import th.ac.hcu.entity.UserRole;
import th.ac.hcu.entity.master.IpeConcludeAnalysis;
import th.ac.hcu.entity.master.IpeDrpReport;
import th.ac.hcu.entity.master.IpeDrugList;
import th.ac.hcu.entity.master.IpeFamilyMember;
import th.ac.hcu.entity.master.IpeGoalPlan;
import th.ac.hcu.entity.master.IpeMedReconcil;
import th.ac.hcu.entity.master.IpeMedicalTechnical;
import th.ac.hcu.entity.master.IpeNurseImg;
import th.ac.hcu.entity.master.IpePatientExamination;
import th.ac.hcu.entity.master.IpePatientPhStudent;
import th.ac.hcu.entity.master.IpePatientProfile;
import th.ac.hcu.entity.master.IpePatientPtStudent;
import th.ac.hcu.entity.master.IpePatientTransaction;
import th.ac.hcu.entity.master.IpePhCompliance;
import th.ac.hcu.entity.master.IpeProgressNote;
import th.ac.hcu.entity.master.IpeStudentEstimate;
import th.ac.hcu.entity.master.IpeUseDrug;
import th.ac.hcu.entity.master.IpeVisitLog;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(User.class, UserRole.class, IpePatientProfile.class, IpeDrugList.class, IpeFamilyMember.class, IpeMedicalTechnical.class,
				IpeNurseImg.class, IpePatientTransaction.class, IpeStudentEstimate.class, IpeUseDrug.class, IpeVisitLog.class,
				IpePatientPtStudent.class, IpePatientPhStudent.class, IpeConcludeAnalysis.class, IpeDrpReport.class, IpeGoalPlan.class,
				IpeMedReconcil.class, IpePatientExamination.class, IpePhCompliance.class, IpeProgressNote.class);
	}
	
}
