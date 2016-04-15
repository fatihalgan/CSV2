package csv.roaming.domain;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Currency generated by hbm2java
 */
public class Currency implements java.io.Serializable {

	private Long currencyId;
	private String currencyName;
	private String currencyShortCode;
	private Set<TariffCalculationParams> tariffCalculationParamses = new HashSet<TariffCalculationParams>(
			0);

	public Currency() {
	}

	public Currency(Long currencyId, String currencyName,
			String currencyShortCode) {
		this.currencyId = currencyId;
		this.currencyName = currencyName;
		this.currencyShortCode = currencyShortCode;
	}

	public Currency(Long currencyId, String currencyName,
			String currencyShortCode,
			Set<TariffCalculationParams> tariffCalculationParamses) {
		this.currencyId = currencyId;
		this.currencyName = currencyName;
		this.currencyShortCode = currencyShortCode;
		this.tariffCalculationParamses = tariffCalculationParamses;
	}

	public Long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencyShortCode() {
		return this.currencyShortCode;
	}

	public void setCurrencyShortCode(String currencyShortCode) {
		this.currencyShortCode = currencyShortCode;
	}

	public Set<TariffCalculationParams> getTariffCalculationParamses() {
		return this.tariffCalculationParamses;
	}

	public void setTariffCalculationParamses(
			Set<TariffCalculationParams> tariffCalculationParamses) {
		this.tariffCalculationParamses = tariffCalculationParamses;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Currency))
			return false;
		Currency castOther = (Currency) other;
		return new EqualsBuilder().append(currencyName, castOther.currencyName)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(463575233, -2070110999).append(currencyName)
				.toHashCode();
	}

}