package th.ac.hcu.entity.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_FAMILY_MEMBER")
@TableGenerator(name="GEN_FAMILY_MEMBER", initialValue=0, allocationSize=50)
public class IpeFamilyMember {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_FAMILY_MEMBER")
    private Long memberId;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private IpePatientProfile patient;
	
	private String name;
	private String age;
	private String relation;
	private String job;
	private String income;
	private String remark;
	
}
