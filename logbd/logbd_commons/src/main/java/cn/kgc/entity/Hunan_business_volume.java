package cn.kgc.entity;

public class Hunan_business_volume {
	private Integer years;
	private double total_volume;
	private double other_provinces;
	private double province;
	private double international;

	public Hunan_business_volume() {
		super();
	}

	public Hunan_business_volume(Integer years, double total_volume,
			double other_provinces, double province, double international) {
		super();
		this.years = years;
		this.total_volume = total_volume;
		this.other_provinces = other_provinces;
		this.province = province;
		this.international = international;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public double getTotal_volume() {
		return total_volume;
	}

	public void setTotal_volume(double total_volume) {
		this.total_volume = total_volume;
	}

	public double getOther_provinces() {
		return other_provinces;
	}

	public void setOther_provinces(double other_provinces) {
		this.other_provinces = other_provinces;
	}

	public double getProvince() {
		return province;
	}

	public void setProvince(double province) {
		this.province = province;
	}

	public double getInternational() {
		return international;
	}

	public void setInternational(double international) {
		this.international = international;
	}

	@Override
	public String toString() {
		return "Hunan_business_volume [years=" + years + ", total_volume="
				+ total_volume + ", other_provinces=" + other_provinces
				+ ", province=" + province + ", international=" + international
				+ ", getYears()=" + getYears() + ", getTotal_volume()="
				+ getTotal_volume() + ", getOther_provinces()="
				+ getOther_provinces() + ", getProvince()=" + getProvince()
				+ ", getInternational()=" + getInternational()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
