import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.*;


public class myFrame extends JFrame {
	
	private JPanel panel;
	private JTextField cityName;
	private JButton findBtn;
	private CentralRegistry c;
	private JFrame infoFrame;
    private JPanel textsPanel;
    private JTextField airportName,codeName,city,country;
    private JTextArea airlinesTextArea;
    private JPanel secondPanel;
    private JTextField destination;
    private JButton findFlights;
    private JTextArea directFlightsDetails;
    private JTextArea indirectFlightsDetails;
    private JButton backBtn;
    private JPanel centralPanel;
    private JPanel thirdPanel;
    
	
	 public myFrame(CentralRegistry c) {
		 
		 this.c=c;
		 panel=new JPanel();
		 cityName=new JTextField(15);
		 findBtn=new JButton("Find");
		 
		
		 
		 panel.add(cityName);
		 panel.add(findBtn);
		 
		 this.setContentPane(panel);
		 
		 ButtonListener listener= new ButtonListener();
		 findBtn.addActionListener(listener);
		 
		 this.setVisible(true);
		 this.setSize(400,200);
		 this.setTitle("Find Airport");
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 }
	 
	 class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e){  
				String city=cityName.getText();
				Airport ap=c.getAirport(city);
				if(ap==null)
				{
					showInfoMessage(city+" does not have an airport");
					
				}
				else {
					
					showInfoOfAirport(ap);
				}
				
				
		         
		}  
		 private void showInfoMessage(String message) {
			 
			 JOptionPane.showMessageDialog(null, message,"Message",JOptionPane.INFORMATION_MESSAGE);
		 }
		 
		 private void showInfoOfAirport(Airport ap) {
			 
			 infoFrame=new JFrame();
			 
			 
			 textsPanel=new JPanel();
			 airportName=new JTextField(15);
			 codeName=new JTextField(15);
			 city=new JTextField(15);
			 country=new JTextField(15);
			 airlinesTextArea=new JTextArea();
			 
			 
			 
			 //fill the text fields
			 
			 airportName.setText(ap.getName());
			 codeName.setText(ap.getNameId());
			 city.setText(ap.getCity());
			 country.setText(ap.getCountry());
			 airlinesTextArea.setText(String.join("\n",ap.getCompanies()));
			 
			 textsPanel.setLayout(new GridLayout(1,5));
			 textsPanel.add(airportName);
			 textsPanel.add(codeName);
			 textsPanel.add(city);
			 textsPanel.add(country);
			 textsPanel.add(airlinesTextArea);
			 
			 JPanel mainPanel=new JPanel();
			 mainPanel.setLayout(new BorderLayout());
			 mainPanel.add(textsPanel,BorderLayout.NORTH);
			 
			 //----------------------------------------------
			 
			 secondPanel=new JPanel();
			 GridLayout grid=new GridLayout(2,2);
			
			 secondPanel.setLayout(grid);
			 destination=new JTextField(15);
			 findFlights=new JButton("Find Flights");
			 directFlightsDetails=new JTextArea();
			 indirectFlightsDetails=new JTextArea();
			 
			
			 
			 secondPanel.add(destination);
			 secondPanel.add(findFlights);
			 secondPanel.add(directFlightsDetails);
			 secondPanel.add(indirectFlightsDetails);
			 
			 mainPanel.add(secondPanel,BorderLayout.CENTER);
			 
			
			 
			 //Second ActionListener
			 
			
			 findFlights.addActionListener(new ActionListener() {
			     @Override
			     public void actionPerformed(ActionEvent e) {
			        
			         String destinationCity = destination.getText();
			         if(destinationCity.equals(ap.getCity())) {
			        	 showInfoMessage("Arrival and departure city can not be the same");
			         }
			         else {
			        	 Airport destAp=c.getAirport(destinationCity);
			        	 
			        	 directFlightsDetails.setText(c.getDirectFlightsDetails(ap,destAp));
			        	 indirectFlightsDetails.setText("Indirect flights through..."+"\n"+c.getInDirectFlightsDetails(ap,destAp));
			        	 
			         }
			         
			 }
		});
			 
			 backBtn=new JButton("Back to Search Screen");
			
			 
			
			 
			 backBtn.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
				 infoFrame.dispose();
				 setVisible(true);
				 }
				 
		 });
			 mainPanel.add(backBtn,BorderLayout.SOUTH);
			 
			 
		 

			 
			 
			 infoFrame.setContentPane(mainPanel);
			 
			 infoFrame.pack();
			 infoFrame.setVisible(true);
			 infoFrame.setTitle("Airport Page");
			 infoFrame.setSize(900,600);
			 infoFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 }
			
			
}
}

