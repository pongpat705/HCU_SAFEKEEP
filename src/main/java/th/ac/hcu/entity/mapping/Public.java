package th.ac.hcu.entity.mapping;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MAPPING_PUBLICATION")
@TableGenerator(name="GEN_MAPPING_PUBLICATION", initialValue=0, allocationSize=50)
public class Public {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_MAPPING_PUBLICATION")
    private Long 	id;
	
	private String 	masterId;
	
	private Integer publicQuality;
	
	private Integer sourceType;
	
	private String 	sourceTitle;
	
	private Integer publishYear;
	
	private Date	publishDate;
	
	private String	volume;
	
	private String	issue;
	
	private String	page;
	
	private String 	to;
	
	private	String	totalPage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public Integer getPublicQuality() {
		return publicQuality;
	}

	public void setPublicQuality(Integer publicQuality) {
		this.publicQuality = publicQuality;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceTitle() {
		return sourceTitle;
	}

	public void setSourceTitle(String sourceTitle) {
		this.sourceTitle = sourceTitle;
	}

	public Integer getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	
}
