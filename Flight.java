
public class Flight {
	
	private Airport airportA;
	private Airport airportB;
	private int duration;
	private String nameOfAirline;
	
	public Flight(Airport airportA,Airport airportB,int duration,String nameOfAirline) {
		
		this.airportA=airportA;
		this.airportB=airportB;
		this.duration=duration;
		this.nameOfAirline=nameOfAirline;
	}
	
	public Airport getAirportA() {
		
		return airportA;
	}
	
	public Airport getAirportB() {
		
		return airportB;
	}
	
	public int getDuration() {
		
		return duration;
	}
	
	public String getNameOfAirline() {
		
		return nameOfAirline;
	}
	
	public String toString() {
		
		return "Flight operated by " +nameOfAirline +", duration "+duration+" minutes";
	}

}
