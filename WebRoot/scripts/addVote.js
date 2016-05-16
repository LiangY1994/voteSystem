var i = 4;
function addOption(){
	var br = document.createElement("br");
	var options = document.getElementById("optionList");
	options.appendChild(br);
	var txt = document.createTextNode("\rOption "+i+":");
	i++;
	options.appendChild(txt);
	var newNode = document.createElement("input");
	newNode.type = "text";
	newNode.name = "option";
	options.appendChild(newNode);
}
