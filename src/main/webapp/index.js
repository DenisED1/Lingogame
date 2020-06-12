var chooseLanguage = document.getElementById('chooseLanguage');
var lingoGame = document.getElementById('lingoGame');

function initPage(){
	fetch('restservices/language/getAll', {method: 'GET'})
	.then(response => response.json())
	.then(function(myJson){
		console.log(myJson)
		for (const language of myJson){
			var option = document.createElement('option');
			var languagestr = document.createTextNode(language.language);
			option.appendChild(languagestr);
			option.value = language.langid;
			
			document.getElementById('languages').appendChild(option);
		}
	})
}

function selectLanguage(){
	var languageDropdown = document.getElementById('languages');
	var selectedOption = languageDropdown.options[languageDropdown.selectedIndex].text;
	var selectedOptionValue = languageDropdown.options[languageDropdown.selectedIndex].value;
	console.log(selectedOptionValue, selectedOption);
	if(selectedOption != "-- Language --"){
		createGame()
	}
}

function createGame(){
	lingoGame.style.display = "block";
	chooseLanguage.style.display = "none";
}

function createRound(){
	
}

function updateRound(){
	
}

function endGame(){
	
}

window.onload = initPage;