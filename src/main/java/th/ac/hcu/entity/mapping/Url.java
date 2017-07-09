package th.ac.hcu.entity.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MAPPING_URL")
@TableGenerator(name="GEN_MAPPING_URL", initialValue=0, allocationSize=50)
public class Url {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="GEN_MAPPING_URL")
    private Long 	id;
	
	private String 	masterId;
	
	private String	url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
