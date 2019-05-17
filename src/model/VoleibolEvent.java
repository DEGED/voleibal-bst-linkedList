package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Participant;


public class VoleibolEvent {

	public VoleibolEvent() {
		this.newOnes = new ArrayList<Participant>();
	}
	
	private Participant root;
	private Participant first;
	
	private ArrayList<Participant> newOnes;
	
	public void loadParticipants(String path, String step) throws IOException{
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		while(line != null && line.charAt(0) != 'i'){
			String[] temporalDataArray = line.split(step);
			Participant temporalNewParticipant = new Participant(Integer.parseInt(temporalDataArray[1]), temporalDataArray[2],temporalDataArray[3],temporalDataArray[4],Integer.parseInt(temporalDataArray[5]),Integer.parseInt(temporalDataArray[6]),temporalDataArray[7]);
			newOnes.add(temporalNewParticipant);
			line = br.readLine();
		}
		fileReader.close();
		br.close();
	}
	// TODO delete this method when verify if all the objects are in the array
	public void printingMethods() {
		for(int i = 0; i< newOnes.size(); i++) {
			System.out.println(newOnes.get(i).getFirstName());
		}
	}
}
