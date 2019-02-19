package th.ac.hcu.entity.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "PARAMETER_INFO")
@TableGenerator(name="GEN_PARAMETER_INFO", initialValue=0, allocationSize=1)
public class ParameterInfo {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_PARAMETER_INFO")
    private Long 	id;
	
	private String	groupCode;
	
	private String	infoCode;
	
	private String	infoTh;
	
	private String	infoEn;
	
	private Integer	sortingOrder;
	
	private char	isDefault;
	
	private Date	createDate;
	
	private String	createBy;
	
	private Date	updateDate;
	
	private String 	updateBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getInfoTh() {
		return infoTh;
	}

	public void setInfoTh(String infoTh) {
		this.infoTh = infoTh;
	}

	public String getInfoEn() {
		return infoEn;
	}

	public void setInfoEn(String infoEn) {
		this.infoEn = infoEn;
	}

	public Integer getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(Integer sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	public char getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(char isDefault) {
		this.isDefault = isDefault;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	
}
