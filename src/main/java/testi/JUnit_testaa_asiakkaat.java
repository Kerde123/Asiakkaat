package testi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import model.Asiakas;
import model.dao.Dao;

class JUnit_testaa_asiakkaat {

	@Test
	@Order(1) 
	public void testPoistaKaikkiAsiakkaat () {
		// Poistetaan kaikki asiakkaat
		Dao dao = new Dao ();
		dao.poistaKaikkiAsiakkaat("nimda");
		ArrayList<Asiakas> asiakkaat = dao.listaaKaikki();
		assertEquals(0, asiakkaat.size());
	}
	
	@Test
	@Order(2) 
	public void testLisaaAsiakas() {		
		//Tehd‰‰n muutama uusi testiasiakas
		Dao dao = new Dao();
		Asiakas asiakas_1 = new Asiakas(25, "Maija", "Korhonen", "11733737" , "maija.k.@jsaf.fi");
		Asiakas asiakas_2 = new Asiakas(26, "Pertti", "Teppo", "9398321", "p.t.@ssssss.fi");
		Asiakas asiakas_3 = new Asiakas(27, "Hilla", "Halla", "0393301", "hh@gmail.com");
		assertEquals(true, dao.lisaaAsiakas(asiakas_1));
		assertEquals(true, dao.lisaaAsiakas(asiakas_2));
		assertEquals(true, dao.lisaaAsiakas(asiakas_3));
	
}
	@Test
	@Order(3) 
	public void testMuutaAsiakas() {
		//Muutetaan yht‰ asiakasta
		Dao dao = new Dao();
		Asiakas muutettava = dao.etsiAsiakas(2);
		muutettava.setEtunimi("Paavo");
		muutettava.setSukunimi("Paavola");
		muutettava.setPuhelin("019384222");
		muutettava.setSposti("paavo.p.@luukku.com");
		dao.muutaAsiakas(muutettava, 2);	
		assertEquals("Paavo", dao.etsiAsiakas(2).getEtunimi());
		assertEquals("Paavola", dao.etsiAsiakas(2).getSukunimi());
		assertEquals("019384222", dao.etsiAsiakas(2).getPuhelin());
		assertEquals("paavo.p.@luukku.com", dao.etsiAsiakas(2).getSposti());
	}
	
	@Test
	@Order(4) 
	public void testPoistaAsiakas() {
		Dao dao = new Dao();
		dao.poistaAsiakas(2);
		assertEquals(null, dao.etsiAsiakas(2));
	}

}
