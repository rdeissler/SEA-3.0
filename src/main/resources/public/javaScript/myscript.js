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
			+ "<td>" + laufvariable.id + "</td>"
			+ "<td>" + laufvariable.anrede + "</td>"
			+ "<td>" + laufvariable.vorname + "</td>"
			+ "<td>" + laufvariable.nachname + "</td>"
			+ "<td>" + laufvariable.str + "</td>"
			+ "<td>" + laufvariable.hausNr + "</td>"
			+ "<td>" + laufvariable.plz + "</td>"
			+ "<td>" + laufvariable.ort + "</td>"
			+ "<td>" + laufvariable.email + "</td>"
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
		case "Divers":
			return 'images/frau.png'
		default:
			return 'images/frau.png'
	}
}

function oninputclick(event) {
	event.preventDefault();  // verhindert GET Request, Event wird nicht weiter vom Browser bearbeitet
	console.log("Click");
	var id = document.getElementById("id").value;
	console.log(id);
	var anrede = document.getElementById("anrede").value;
	console.log(anrede);
	var vorname = document.getElementById("vorname").value;
	console.log(vorname);
	var nachname = document.getElementById("nachname").value;
	console.log(nachname);
	var str = document.getElementById("str").value;
	console.log(str);
	var hausNr = document.getElementById("hausNr").value;
	console.log(hausNr);
	var plz = document.getElementById("plz").value;
	console.log(plz);
	var ort = document.getElementById("ort").value;
	console.log(ort);
	var email = document.getElementById("email").value;
	console.log(email);

	var jsondata = `{"id": "${id}", "anrede": "${anrede}", "vorname": "${vorname}", "nachname": "${nachname}", "str": "${str}", "hausNr": "${hausNr}", "plz": "${plz}", "ort": "${ort}", "email": "${email}"}`;
	console.log(jsondata);

	fetch("http://localhost:8080/json/person", {  // fetch ist hier ein Push zum Server
		method: 'POST', // or PUT  hier wird ein http mit einem POST Request abgesetzt
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
		}
	})
}


function oninputdelclick(event) {
	event.preventDefault(); 
	var id = document.getElementById("id").value;
	console.log(id)
	
	fetch(`http://localhost:8080/json/person/${id}`, {  
		method: 'DELETE' 
		
	});
	
	}



var input = document.getElementById("button");
input.addEventListener("click", oninputclick);

// delete Button
var inputdel = document.getElementById("delbutton");
inputdel.addEventListener("click", oninputdelclick);


// fetch Statement (Anweisung)
//fetch("http://localhost:8080/personen.json")
fetch("http://localhost:8080/json/persons/all")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML); 		// entpricht: cell.textContent = myjson.personen[0].vorname);



