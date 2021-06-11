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


function getIcon(anrede) {
	switch (anrede) {
		case "Herr":
			return 'images/man.png'
		case "Frau":
			return 'images/frau.png'
		default:
			return 'images/frau.png'
	}
}

function oninputclick(event) {
	event.preventDefault();  // verhindert GET Request, Event wird nicht weiter vom Browser bearbeitet
	console.log("Click");
	var vorname = document.getElementById("vorname").value;
	console.log(vorname);
	var nachname = document.getElementById("nachname").value;
	console.log(nachname);
	var anrede = document.getElementById("anrede").value;
	console.log(anrede);
	var jsondata = `{"anrede": ${anrede}, "vorname": "${vorname}", "nachname": "${nachname}"}`;
	console.log(jsondata);
	fetch("http://localhost:8080/submitPerson", {  // fetch ist hier ein Push zum Server
    	method: 'POST', // or PUT  hier wird ein http mit einem POST Request abgesetzt
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
		}
	})
}



var input = document.getElementById("button");
input.addEventListener("click", oninputclick);

// fetch Statement (Anweisung)
//fetch("http://localhost:8080/personen.json")
fetch("personen.json")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML); 		// entpricht: cell.textContent = myjson.personen[0].vorname);



