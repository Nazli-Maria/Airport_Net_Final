import java.util.ArrayList;

public class Airport {
	
	private String name;
	private String nameId;
	private String city;
	private String country;
	private ArrayList<String> connectedCompanies;
	private ArrayList<Airport> connectedAirports;
	
	public Airport(String name,String nameId,String city,String country) {
		
		this.name=name;
		this.setNameId(nameId);
		this.setCity(city);
		this.setCountry(country);
		connectedCompanies=new ArrayList<>();
		connectedAirports=new ArrayList<>();
	}
	
	public void addConnectedAirport(Airport anAirport) {
		
		this.connectedAirports.add(anAirport);
		anAirport.connectedAirports.add(this);
		
		
	}
	public String getName() {
		return this.name;
	}
	public void addConnectedCompanies(String aCompany) {
		
	     this.connectedCompanies.add(aCompany);
	     
	}
	
	public boolean isDirectlyConnectedTo(Airport anAirport) {
		
	
		return connectedAirports.contains(anAirport);
	}
	
	public boolean isInDirectlyConnectedTo(Airport anAirport) {
		
		for(Airport ap:connectedAirports) {
			if(ap.connectedAirports.contains(anAirport))
				return true;
		}
		return false;
	}
	
	public ArrayList<Airport> getCommonConnections(Airport anAirport){
		
		ArrayList<Airport> commonAirports=new ArrayList<>();
		for(Airport ap:connectedAirports) {
			if(anAirport.connectedAirports.contains(ap))
			{
				commonAirports.add(ap);
			}
		}
		return commonAirports;
	}
	
	public void printCompanies() {
		
		for(String company: connectedCompanies)
		 {
			System.out.println(company);
		 }
	}
	
	public ArrayList<Airport> getConnections() {
		
		return this.connectedAirports;
	}
	public ArrayList<String> getCompanies(){
		
		return this.connectedCompanies;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
