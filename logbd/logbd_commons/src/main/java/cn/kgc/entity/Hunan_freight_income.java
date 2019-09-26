package cn.kgc.entity;

public class Hunan_freight_income {
	private Integer id;
	private String city;
	private Double income;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(income);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hunan_freight_income other = (Hunan_freight_income) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(income) != Double
				.doubleToLongBits(other.income))
			return false;
		return true;
	}

	public Hunan_freight_income() {
		super();
	}

	public Hunan_freight_income(Integer id, String city, Double income) {
		super();
		this.id = id;
		this.city = city;
		this.income = income;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Hunan_freight_income [id=" + id + ", city=" + city
				+ ", income=" + income + ", getId()=" + getId()
				+ ", getCity()=" + getCity() + ", getIncome()=" + getIncome()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
