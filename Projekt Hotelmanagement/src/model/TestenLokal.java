package model;


public class TestenLokal {

	
	public static void main(String[] args) {
		//********************* Gast Anlegen mit Procedure *****************//
		//Variante über Objekt
		Gast newG = new Gast("","Dincc","Haselgraben 17","073062920","0176-70788524",
				"DincAlim@hotmail.de","1991-01-15","m","DE15011991","deutsch",
				89269,"Vöhringen","Deutschland","Raiba-Vöhringen",3105829,72069336,
				"DE545454545");
		
		
		newG.GastAnlegenProcedure();
		
		//Variante nur über Procedure
		/*
		Gast.GastanlegenProcedure( 15,"Alev","Kanar","Hochschulstr.12",32635,"017670788524","Alev@aol.de",
				"12.12.1990","weiblich","8376323","deutsch",51, 51,89000,"Langenau","EU", 1,"Raiba-Langenau",
				1234532, 72069736,"DEU287834" );
	*/
		
		
		
	}

}
