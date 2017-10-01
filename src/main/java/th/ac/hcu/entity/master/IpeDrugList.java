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
@Table(name = "IPE_DRUG_LIST")
@TableGenerator(name="GEN_DRUG_LIST", initialValue=0, allocationSize=50)
public class IpeDrugList {
	
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_DRUG_LIST")
    private Long listId;
	
	private String drugName;
	private String managing;
	private String qty;
	
	public Long getListId() {
		return listId;
	}
	public void setListId(Long listId) {
		this.listId = listId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getManaging() {
		return managing;
	}
	public void setManaging(String managing) {
		this.managing = managing;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
}
