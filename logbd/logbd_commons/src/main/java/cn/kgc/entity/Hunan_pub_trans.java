package cn.kgc.entity;

public class Hunan_pub_trans {
	private Integer years;
	private double total_operations_num;
	private double total_transline_length;
	private double total_passengers;

	public Hunan_pub_trans(Integer years, double total_operations_num,
			double total_transline_length, double total_passengers) {
		super();
		this.years = years;
		this.total_operations_num = total_operations_num;
		this.total_transline_length = total_transline_length;
		this.total_passengers = total_passengers;
	}

	public Hunan_pub_trans() {
		super();
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public double getTotal_operations_num() {
		return total_operations_num;
	}

	public void setTotal_operations_num(double total_operations_num) {
		this.total_operations_num = total_operations_num;
	}

	public double getTotal_transline_length() {
		return total_transline_length;
	}

	public void setTotal_transline_length(double total_transline_length) {
		this.total_transline_length = total_transline_length;
	}

	public double getTotal_passengers() {
		return total_passengers;
	}

	public void setTotal_passengers(double total_passengers) {
		this.total_passengers = total_passengers;
	}

	@Override
	public String toString() {
		return "Hunan_pub_trans [years=" + years + ", total_operations_num="
				+ total_operations_num + ", total_transline_length="
				+ total_transline_length + ", total_passengers="
				+ total_passengers + "]";
	}

}
