package cn.kgc.entity;

/**
 * 
 * @author Administrator
 *
 */
public class Hunan_transline_length {
	private Integer years;
	private double railway_mileage;
	private double highway_mileage;
	private double classified_highway;
	private double highway;
	private double primary_road;
	private double secondary_road;
	private double other_road;

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public double getRailway_mileage() {
		return railway_mileage;
	}

	public void setRailway_mileage(double railway_mileage) {
		this.railway_mileage = railway_mileage;
	}

	public double getHighway_mileage() {
		return highway_mileage;
	}

	public void setHighway_mileage(double highway_mileage) {
		this.highway_mileage = highway_mileage;
	}

	public double getClassified_highway() {
		return classified_highway;
	}

	public void setClassified_highway(double classified_highway) {
		this.classified_highway = classified_highway;
	}

	public double getHighway() {
		return highway;
	}

	public void setHighway(double highway) {
		this.highway = highway;
	}

	public double getPrimary_road() {
		return primary_road;
	}

	public void setPrimary_road(double primary_road) {
		this.primary_road = primary_road;
	}

	public double getSecondary_road() {
		return secondary_road;
	}

	public void setSecondary_road(double secondary_road) {
		this.secondary_road = secondary_road;
	}

	public double getOther_road() {
		return other_road;
	}

	public void setOther_road(double other_road) {
		this.other_road = other_road;
	}

	@Override
	public String toString() {
		return "Hunan_transline_length [years=" + years + ", railway_mileage="
				+ railway_mileage + ", highway_mileage=" + highway_mileage
				+ ", classified_highway=" + classified_highway + ", highway="
				+ highway + ", primary_road=" + primary_road
				+ ", secondary_road=" + secondary_road + ", other_road="
				+ other_road + "]";
	}

	public Hunan_transline_length(Integer years, double railway_mileage,
			double highway_mileage, double classified_highway, double highway,
			double primary_road, double secondary_road, double other_road) {
		super();
		this.years = years;
		this.railway_mileage = railway_mileage;
		this.highway_mileage = highway_mileage;
		this.classified_highway = classified_highway;
		this.highway = highway;
		this.primary_road = primary_road;
		this.secondary_road = secondary_road;
		this.other_road = other_road;
	}

	public Hunan_transline_length() {
		super();
	}

}
