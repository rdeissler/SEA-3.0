/**
 * myscript
 */


var para = document.getElementById("id4711");
para.textContent = "Hello from JavaScript";
//  fetch("http://localhost:8080/personen.json");
// var cell = document.getElementById("IdSabine");
//	fetch("personen.json")
//		.then( irgendwas => irgendwas.json() )
//		.then(myjson => console.log(myjson.personen[0].vorname));
// json einlesen
function getJson(irgendwas) { 	// irgendwas beinhaltet json mit allen kommunikations-metadaten
	return irgendwas.json();	// irgendwas.json ist der rheine json-inhalt
}
// celle ersetzen
function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle = document.getElementById("idTable001");
	var i = 0;
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		i++;
		tabelle.insertAdjacentHTML("beforeend",
			"<tr>"
			+ "<td>" + i + "</td>"
			+ "<td>" + laufvariable.anrede + "</td>"
			+ "<td>" + laufvariable.vorname + "</td>"
			+ "<td>" + laufvariable.nachname + "</td>"
			+ "<td><img src='" + getIcon(laufvariable.anrede) + "'></td>"
			+ "</tr>"
		)
		//			+ "<td><img src='images/man.png'></td>"

		//		document.getElementById("id003").textContent = laufvariable.anrede;
		//		document.getElementById("id001").textContent = laufvariable.vorname;
		//		document.getElementById("id002").textContent = laufvariable.nachname;


	}
}



fetch("personen.json")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML) 		// entpricht: cell.textContent = myjson.personen[0].vorname);

//function getIcon(anrede) {
//	if (anrede = "Frau") {return 'images/frau.png'}
//	else if (anrede = "Herr") {return 'images/man.png'}
//				else {return 'images/frau.png'}
//				}

function getIcon(anrede) {
	switch(anrede) {
  		case "Herr":
    		return 'images/man.png'
  		case "Frau":
    		return 'images/frau.png'
  		default:
    		return 'images/frau.png'
	}
}


