let xhr = new XMLHttpRequest();

/*
*initialisation de XHR
 *   onreadystatechange
*/
xhr.onreadystatechange =function(){
    console.log(xhr.readyState);  //affichage des etapes de réception de la réponse
    if(xhr.readyState==4 && xhr.status==200){ //200 ca veut dire le code http d'une requette 
    	console.log(xhr.responseText);
    	let communes = JSON.parse(xhr.responseText);
    	for (let i = 0; i < communes.length; i++) {
			let commune = communes[i];
			
			document.getElementById("view").innerHTML+=`<li>  ${commune.nom}</li>`;
			//data-latitude=${commune.latitude} data-logtitude=${commune.longtitude};
			console.log(commune.nom);
			document.getElementsByName("")
		}
    }
}

function lancerRequete(){
	
	let val=document.getElementById("view");
	val.innerHTML="";
	let uri=document.getElementById("cp");
    //let uri= "rest/communes/cp/9721";
	if(uri.value.length<2){
		//alert('entrer un code postal');
	}
	else{
		uri= `rest/communes/cp/${uri.value}`;
	    xhr.open("GET",uri);
	    xhr.send();
	    console.log(`requéte vers ${uri}`);
	}
   // xhr.open("GET",uri);
    //xhr.send();
    //console.log(`requéte vers ${uri}`);
}


document.addEventListener("DOMContentLoaded", function(){
	document.getElementById("b1").addEventListener("click",lancerRequete);
    document.getElementById("cp").addEventListener("keyup",lancerRequete);
});

document.addEventListener("DOMContentLoaded", function(){
	
});
