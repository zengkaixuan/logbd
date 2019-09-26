package cn.kgc.entity;

/**
 * 
 * @author Administrator
 *
 */
public class Public_transportation {
	private Integer years;
	private double total_vehicles;
	private double operating_passenger_capacity;
	private double operating_cargo_capacity;

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public double getTotal_vehicles() {
		return total_vehicles;
	}

	public void setTotal_vehicles(double total_vehicles) {
		this.total_vehicles = total_vehicles;
	}

	public double getOperating_passenger_capacity() {
		return operating_passenger_capacity;
	}

	public void setOperating_passenger_capacity(
			double operating_passenger_capacity) {
		this.operating_passenger_capacity = operating_passenger_capacity;
	}

	public double getOperating_cargo_capacity() {
		return operating_cargo_capacity;
	}

	public void setOperating_cargo_capacity(double operating_cargo_capacity) {
		this.operating_cargo_capacity = operating_cargo_capacity;
	}

	@Override
	public String toString() {
		return "Public_transportation [years=" + years + ", total_vehicles="
				+ total_vehicles + ", operating_passenger_capacity="
				+ operating_passenger_capacity + ", operating_cargo_capacity="
				+ operating_cargo_capacity + "]";
	}

	public Public_transportation(Integer years, double total_vehicles,
			double operating_passenger_capacity, double operating_cargo_capacity) {
		super();
		this.years = years;
		this.total_vehicles = total_vehicles;
		this.operating_passenger_capacity = operating_passenger_capacity;
		this.operating_cargo_capacity = operating_cargo_capacity;
	}

	public Public_transportation() {
		super();
	}

}
