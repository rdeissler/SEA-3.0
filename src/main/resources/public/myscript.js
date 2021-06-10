/**
 * myscript
 */

var para = document.getElementById("id4711");
para.textContent = "Hello from JavaScript";


fetch("http://localhost:8080/personen.json")
//fetch("personen.json"); würde hier auch gehen
	.then( irgendeinObjekt => irgendeinObjekt.jso() )
	.then(myjson => console.log(myjson))

