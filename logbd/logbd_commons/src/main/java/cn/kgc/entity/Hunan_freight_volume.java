package cn.kgc.entity;

public class Hunan_freight_volume {
	private Integer years;
	private double total;
	private double total_railway;
	private double national_railway;
	private double local_railway;
	private double joint_venture_railway;
	private double highway;
	private double waterway;

	public Hunan_freight_volume() {
		super();
	}

	public Hunan_freight_volume(Integer years, double total,
			double total_railway, double national_railway,
			double local_railway, double joint_venture_railway, double highway,
			double waterway) {
		super();
		this.years = years;
		this.total = total;
		this.total_railway = total_railway;
		this.national_railway = national_railway;
		this.local_railway = local_railway;
		this.joint_venture_railway = joint_venture_railway;
		this.highway = highway;
		this.waterway = waterway;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal_railway() {
		return total_railway;
	}

	public void setTotal_railway(double total_railway) {
		this.total_railway = total_railway;
	}

	public double getNational_railway() {
		return national_railway;
	}

	public void setNational_railway(double national_railway) {
		this.national_railway = national_railway;
	}

	public double getLocal_railway() {
		return local_railway;
	}

	public void setLocal_railway(double local_railway) {
		this.local_railway = local_railway;
	}

	public double getJoint_venture_railway() {
		return joint_venture_railway;
	}

	public void setJoint_venture_railway(double joint_venture_railway) {
		this.joint_venture_railway = joint_venture_railway;
	}

	public double getHighway() {
		return highway;
	}

	public void setHighway(double highway) {
		this.highway = highway;
	}

	public double getWaterway() {
		return waterway;
	}

	public void setWaterway(double waterway) {
		this.waterway = waterway;
	}

	@Override
	public String toString() {
		return "Hunan_freight_volume [years=" + years + ", total=" + total
				+ ", total_railway=" + total_railway + ", national_railway="
				+ national_railway + ", local_railway=" + local_railway
				+ ", joint_venture_railway=" + joint_venture_railway
				+ ", highway=" + highway + ", waterway=" + waterway + "]";
	}

}
