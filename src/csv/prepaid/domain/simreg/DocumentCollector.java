package csv.prepaid.domain.simreg;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class DocumentCollector implements Serializable {

	private Long id;
	private String collectorName;
	
	public DocumentCollector() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollectorName() {
		return collectorName;
	}

	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof DocumentCollector))
			return false;
		DocumentCollector castOther = (DocumentCollector) other;
		return new EqualsBuilder().append(collectorName,
				castOther.collectorName).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-202070665, 272570273).append(collectorName)
				.toHashCode();
	}
	
	
}
