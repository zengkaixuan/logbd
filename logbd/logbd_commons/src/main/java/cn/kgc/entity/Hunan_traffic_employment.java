package cn.kgc.entity;

public class Hunan_traffic_employment {
	private Integer years;
	private double railway_transportation;
	private double highway_transportation;
	private double waterway_transportation;
	private double air_transportation;
	private double pipage_transportation;
	private double others;

	public Hunan_traffic_employment() {
		super();
	}

	public Hunan_traffic_employment(Integer years,
			double railway_transportation, double highway_transportation,
			double waterway_transportation, double air_transportation,
			double pipage_transportation, double others) {
		super();
		this.years = years;
		this.railway_transportation = railway_transportation;
		this.highway_transportation = highway_transportation;
		this.waterway_transportation = waterway_transportation;
		this.air_transportation = air_transportation;
		this.pipage_transportation = pipage_transportation;
		this.others = others;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public double getRailway_transportation() {
		return railway_transportation;
	}

	public void setRailway_transportation(double railway_transportation) {
		this.railway_transportation = railway_transportation;
	}

	public double getHighway_transportation() {
		return highway_transportation;
	}

	public void setHighway_transportation(double highway_transportation) {
		this.highway_transportation = highway_transportation;
	}

	public double getWaterway_transportation() {
		return waterway_transportation;
	}

	public void setWaterway_transportation(double waterway_transportation) {
		this.waterway_transportation = waterway_transportation;
	}

	public double getAir_transportation() {
		return air_transportation;
	}

	public void setAir_transportation(double air_transportation) {
		this.air_transportation = air_transportation;
	}

	public double getPipage_transportation() {
		return pipage_transportation;
	}

	public void setPipage_transportation(double pipage_transportation) {
		this.pipage_transportation = pipage_transportation;
	}

	public double getOthers() {
		return others;
	}

	public void setOthers(double others) {
		this.others = others;
	}

	@Override
	public String toString() {
		return "Hunan_traffic_employment [years=" + years
				+ ", railway_transportation=" + railway_transportation
				+ ", highway_transportation=" + highway_transportation
				+ ", waterway_transportation=" + waterway_transportation
				+ ", air_transportation=" + air_transportation
				+ ", pipage_transportation=" + pipage_transportation
				+ ", others=" + others + "]";
	}

}
