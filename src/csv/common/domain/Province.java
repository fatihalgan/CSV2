package csv.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Province implements Serializable {

	private Long id;
	private String name;
	
	private Set<District> districts = new HashSet<District>();
	
	public Province() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<District> getDistricts() {
		return districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}
	
	public List<District> getDistrictsAsList() {
		return new ArrayList<District>(getDistricts());
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Province))
			return false;
		Province castOther = (Province) other;
		return new EqualsBuilder().append(name, castOther.name).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1214027199, 1738641165).append(name)
				.toHashCode();
	}
	
	
}
