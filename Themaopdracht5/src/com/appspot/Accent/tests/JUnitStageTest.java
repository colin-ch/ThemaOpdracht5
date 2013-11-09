package com.appspot.Accent.tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Id;

import org.junit.Before;
import org.junit.Test;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.StageOpleider;

public class JUnitStageTest {
	private Id id;
	private StageBegeleider stagebeg;
	private Leerling u;
	private StageBedrijf bedrijf1;
	private StageOpleider opleider;
	private Stage stage;
	private Date date;
	private Beoordeling beoordeling;
	private ArrayList<Beoordeling> beoordelingen;
	
	@Before
	public void setUp() throws Exception {
		date = new Date();
		stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		u = new Leerling("123", "123", "123@gmail.com", "leerling1", " ", "Student", "leerling1", 16, date, "V1IE", "stagebeg" );	
		bedrijf1 = new StageBedrijf("bedrijf1", "123","bedrijf@gmail.com", "utrecht", "123456");
		opleider = new StageOpleider("jopie");
		stage = new Stage(1, u.getUsername(), opleider.getNaam(), bedrijf1.getUsername(), date, date);
		beoordeling = new Beoordeling("datum hier", "Opmerking hier");
		beoordelingen = new ArrayList<Beoordeling>();
		beoordelingen.add(beoordeling);
	}

	@Test
	public void testSetGetStage() {
		try{
			stage.setDeLeerling(u.getUsername());
			stage.setDeOpleider(opleider.getNaam());
			stage.setHetBedrijf(bedrijf1.getUsername());
			stage.setBegindatum(date);
			stage.setEinddatum(date);
			stage.setBeoordelingen(beoordelingen);
			stage.setId(0);
		}
		catch(Exception e){
			fail("fail op try setters");
		}
		try{
			if(stage.getBegindatum() != null && stage.getEinddatum() != null && stage.getId() == 0){
			}
			else{
				fail("fail invoer try getters");
			}
		}
		catch(Exception e){
			fail("fail op try getters");
		}
		
	}

}
