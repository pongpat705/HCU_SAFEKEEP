package th.ac.hcu.entity.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "IPE_MED_LIST")
@TableGenerator(name="GEN_MED_LIST", initialValue=0, allocationSize=50)
public class IpeMedList {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_MED_LIST")
    private Long listId;
	
	private String drug;
	private Integer volume;
	public Long getListId() {
		return listId;
	}
	public void setListId(Long listId) {
		this.listId = listId;
	}
	public String getDrug() {
		return drug;
	}
	public void setDrug(String drug) {
		this.drug = drug;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
}
