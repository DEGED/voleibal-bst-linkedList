package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Participant;


public class VoleibolEvent {

	public VoleibolEvent() {
		//this.newOnes = new ArrayList<Participant>();
	}
	
	private Participant root;
	private Participant first;
	
	private Participant countryRoot;
	//private ArrayList<Participant> newOnes;
	
	public void loadParticipants(String path, String step) throws IOException{
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		int cont = 0;
		while(line != null){
			String[] temporalDataArray = line.split(step);
			Participant temporalNewParticipant = new Participant(temporalDataArray[0], temporalDataArray[1],temporalDataArray[2],temporalDataArray[3],temporalDataArray[4],temporalDataArray[6]);
			addParticipant(temporalNewParticipant);
			line = br.readLine();
			if(cont<499) {
				addingOficialParticipants(temporalNewParticipant);
				System.out.println(temporalNewParticipant.getFirstName());
			}
			cont++;
		}
		fileReader.close();
		br.close();
	}
	public List<Participant> preOrder(){
		return preOrder(root);
	}
	private List<Participant> preOrder(Participant currentNode){
		List<Participant> l = new ArrayList<>();
		if(currentNode != null){
			l.add(currentNode);
			List<Participant> ll = preOrder(currentNode.getLeft());
			List<Participant> lr = preOrder(currentNode.getRigth());
			//System.out.println(ll);
			//System.out.println(lr);
			l.addAll(ll);
			l.addAll(lr);
		}
		return l;
	}
	
	public void addParticipant(Participant part) {
		addParticipant(part, root);
	}
	
	public void addParticipant(Participant part, Participant current) {
		if(root == null){
			root = part;
		}
		else {
			if(part.compareTo(current) <= 0) {
				if(current.getLeft() == null) {
					current.setLeft(part);
				}else{
					addParticipant(part, current.getLeft());
				}
			}else{
				if(current.getRigth() == null) {
					current.setRigth(part);
				} else {
					addParticipant(part, current.getRigth());
				}
			}
			
		}
	}
	public void addingOficialParticipants(Participant newOne){
		if(first == null){
			first = newOne;
		}else{
			Participant current = first;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(newOne);
			Participant temp = current;
			current = current.getNext();
			current.setPreovious(temp);
		}
	}
	public void print(){
		Participant current = first;
		while(current != null) {
			current = current.getNext();
//			System.out.println(current.getFirstName());
		}
	
	}
	public void findTeamCountry(String country) {
		Participant current = first;
		while(current.getNext() != null){
			if(current.getCountry().equalsIgnoreCase(country)) {
				addParticipantCountry(current);
				System.out.println(current.getCountry());
			}else {
			current = current.getNext();
			}
		}
	}
	public void addParticipantCountry(Participant part) {
		addParticipant(part, countryRoot);
	}
	public void addParticipantCountry(Participant part, Participant current) {
		if(countryRoot == null){
			countryRoot = part;
		}
		else {
			if(part.compareTo(current) <= 0) {
				if(current.getLeft() == null) {
					current.setLeft(part);
				}else{
					addParticipant(part, current.getLeft());
				}
			}else{
				if(current.getRigth() == null) {
					current.setRigth(part);
				} else {
					addParticipant(part, current.getRigth());
				}
			}
			
		}
	}
}