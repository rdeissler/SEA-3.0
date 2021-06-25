/**
 * myscript
 */
function getJson(irgendwas) { 	// irgendwas beinhaltet json mit allen kommunikations-metadaten
	return irgendwas.json();	// irgendwas.json ist der rheine json-inhalt
}
// celle ersetzen
function getTxtFromJsonUndPackInsHTML(myjson) {

	var tabelle = document.getElementById("idTable001");
//	var i = 1;
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		tabelle.insertAdjacentHTML("beforeend",
			"<tr>"
	//		+ "<td> ${i++} </td>"
			+ "<td>" + laufvariable.id + "</td>"
			+ "<td><img src='" + getIcon(laufvariable.anrede) + "'></td>"
			+ "<td>" + laufvariable.anrede + "</td>"
			+ "<td>" + laufvariable.vorname + "</td>"
			+ "<td>" + laufvariable.nachname + "</td>"
			+ "<td>" + laufvariable.bday + "</td>"
			+ "<td>" + laufvariable.str + "</td>"
			+ "<td>" + laufvariable.hausnr + "</td>"
			+ "<td>" + laufvariable.plz + "</td>"
			+ "<td>" + laufvariable.ort + "</td>"
			+ "<td>" + laufvariable.email + "</td>"
			+ "<td>" + laufvariable.version + "</td>"
			
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

// Abfrage des clicks mit übergabe der Daten
// Add
function oninputclick(event) {
	event.preventDefault();  // verhindert GET Request, Event wird nicht weiter vom Browser bearbeitet
	console.log("Click");
//	var id = document.getElementById("id").value;
//	console.log(id);
	var anrede = document.getElementById("anrede").value;
	console.log(anrede);
	var vorname = document.getElementById("vorname").value;
	console.log(vorname);
	var nachname = document.getElementById("nachname").value;
	console.log(nachname);
	var bday = document.getElementById("bday").value;
	console.log(bday);
	var str = document.getElementById("str").value;
	console.log(str);
	var hausnr = document.getElementById("hausnr").value;
	console.log(hausnr);
	var plz = document.getElementById("plz").value;
	console.log(plz);
	var ort = document.getElementById("ort").value;
	console.log(ort);
	var email = document.getElementById("email").value;
	console.log(email);
//	var version = document.getElementById("version").value;
//	console.log(email);

	var jsondata = `{"anrede": "${anrede}", "vorname": "${vorname}", "nachname": "${nachname}","bday": "${bday}", "str": "${str}", "hausnr": "${hausnr}", "plz": "${plz}", "ort": "${ort}", "email": "${email}"}`;
	console.log(jsondata);

	fetch(`/json/person`, {   // fetch ist hier ein Push zum Server
		method: 'POST', // or PUT  hier wird ein http mit einem POST Request abgesetzt
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
		}
	})
}



//Delete One
function oninputdelclick(event) {
	event.preventDefault();   // verhindert das Neuladen der Seite
	var id = document.getElementById("id").value;
	console.log(id)
	
	fetch(`/json/person/${id}`, {  
		method: 'DELETE' 
		});
	}
	
// delete One Button
var inputdel = document.getElementById("delbutton");
inputdel.addEventListener("click", oninputdelclick);


// Update

function oninputupdateclick(event) {
	event.preventDefault(); 
	var id = document.getElementById("id").value;
	console.log(id)
	var anrede = document.getElementById("anrede").value;
	console.log(anrede);
	var vorname = document.getElementById("vorname").value;
	console.log(vorname);
	var nachname = document.getElementById("nachname").value;
	console.log(nachname);
	var bday = document.getElementById("bday").value;
	console.log(bday);
	var str = document.getElementById("str").value;
	console.log(str);
	var hausnr = document.getElementById("hausnr").value;
	console.log(hausnr);
	var plz = document.getElementById("plz").value;
	console.log(plz);
	var ort = document.getElementById("ort").value;
	console.log(ort);
	var email = document.getElementById("email").value;
	console.log(email);
	var version = document.getElementById("version").value;
	console.log(email);

	var jsondata = `{"id": "${id}", "anrede": "${anrede}", "vorname": "${vorname}", "nachname": "${nachname}","bday": "${bday}", "str": "${str}", "hausnr": "${hausnr}", "plz": "${plz}", "ort": "${ort}", "email": "${email}", "version": "${version}"}`;
	console.log(jsondata);
	
	fetch(`/json/person`, {  
		method: 'PUT' ,
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
			}
		});
	}

// Update Button
var inputupdate = document.getElementById("updatebutton");
inputupdate.addEventListener("click", oninputupdateclick);

/*
//Delete All
function oninputdelallclick(event) {
	event.preventDefault(); 
	var id = document.getElementById("id").value;
	console.log(id)
	
	fetch(`http://localhost:8080/json/persons/all`, {  
		method: 'DELETE' 
		});
	}
	
// delete All Button
var inputdelall = document.getElementById("delallbutton");
inputdelall.addEventListener("click", oninputdelallclick);

*/


// Eingabe Button
var input = document.getElementById("button");
input.addEventListener("click", oninputclick);


// fetch Statement (Anweisung)
//fetch("http://localhost:8080/personen.json")
fetch("/json/persons/all")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML) 		// entpricht: cell.textContent = myjson.personen[0].vorname);



