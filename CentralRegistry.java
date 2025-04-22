import java.util.ArrayList;

public class CentralRegistry {
	
	private ArrayList<Airport> airports;
	private ArrayList<Flight> flights;
	
	public CentralRegistry() {
		
		airports=new ArrayList<>();
		flights=new ArrayList<>();
	}
	
	public void addFlight(Flight aFlight) {
		
		flights.add(aFlight);
		//connect the Airports
		Airport depAir=aFlight.getAirportA();
		Airport arAir=aFlight.getAirportB();
		depAir.addConnectedAirport(arAir);
		//add companies to the list
		String nameOfAirline=aFlight.getNameOfAirline();
		depAir.addConnectedCompanies(nameOfAirline);
		arAir.addConnectedCompanies(nameOfAirline);
	}
	
	public void addAirport(Airport anAirport) {
		
		airports.add(anAirport);
	}
	
	public Airport getLargestHub() {
		int num=-1;
	    Airport apBest = null;
		for(Airport ap:airports) {
			if(num<ap.getConnections().size())
			 {num=ap.getConnections().size();
			  apBest=ap;
			 }
		}
		return apBest;
	}
	
	public Flight getLongestFlight() {
		int num=-1;
		Flight flLongest=null;
		for(Flight fl:flights) {
			if(num<fl.getDuration())
			{
				num=fl.getDuration();
				flLongest=fl;
				
			}
		}
		return flLongest;
	}
	
	public Airport getAirport(String cityName) {
		
		for(Airport ap:airports) {
			if(ap.getCity().equals(cityName))
				return ap;
		}
		return null;
	}
	
	public String getDirectFlightsDetails(Airport a,Airport b){
		
		 StringBuilder directFlightsDetails=new StringBuilder();
		 int i=0;
		
		for(Flight f:flights) {
			if((f.getAirportA().equals(a)) && (f.getAirportB().equals(b))) {
				i++;
				directFlightsDetails.append("[").append(i).append("]").append(f.toString()).append("\n");
			}
		}
		return directFlightsDetails.toString();
		
		
	}
	
	public String getInDirectFlightsDetails(Airport a,Airport b) {
		
		StringBuilder inDirectFlightsDetails=new StringBuilder();
		int i=0;
		
		for(Airport ap:airports) {
			if(a.isDirectlyConnectedTo(ap) && ap.isDirectlyConnectedTo(b)) {
				i++;
				inDirectFlightsDetails.append("[").append(i).append("]").append(ap.getCity()).append(", ").append(ap.getNameId()).append(" airport").append("\n");
			}
		}
		
		return inDirectFlightsDetails.toString();
	}
	

}
