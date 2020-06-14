var chooseLanguage = document.getElementById('chooseLanguage');
var lingoGame = document.getElementById('lingoGame');
var endGame = document.getElementById('endGame');
var scoreboard = document.getElementById('scoreboard');
var nextWord = document.getElementById('nextWord');

var gameid = null;
var roundid = null;
var langid = null;
var length = null;
var score = null;
var playername = null;

function initPage(){
	fetch('restservices/language/getAll', {method: 'GET'})
	.then(response => response.json())
	.then(function(myJson){
		for (const object of myJson){
			var option = document.createElement('option');
			var languagestr = document.createTextNode(object.language);
			option.appendChild(languagestr);
			option.value = object.langid;
			
			document.getElementById('languages').appendChild(option);
		}
	})
}

function selectLanguage(){
	var languageDropdown = document.getElementById('languages');
	var selectedOption = languageDropdown.options[languageDropdown.selectedIndex].text;
	langid = languageDropdown.options[languageDropdown.selectedIndex].value;
	
	if(selectedOption != "-- Language --"){
		createGame()
	}
}

function createGame(){
	setLength();
	
	lingoGame.style.display = "block";
	chooseLanguage.style.display = "none";
	
	fetch('restservices/game/create', {
		method: 'POST',
		body: JSON.stringify({
			langid: langid,
			length: length
		}),
		headers:{
			'Content-Type': 'application/json'
		}})
	.then(response => response.json())
	.then(function(myJson){
		for (const object of myJson){
			gameid = object.gameid;
			roundid = object.roundid;
			
			var rij = document.createElement('tr');
			var td1 = document.createElement('td');
			var givenWord = document.createTextNode(object.givenWord);
			td1.appendChild(givenWord);
			rij.appendChild(td1);
			
			document.getElementById('resultTable').appendChild(rij);
		}
	})
}

function checkGuess(){
	var guessedWord = document.getElementById("guessedWord").value;
	
	fetch('restservices/round/check', {
		method: 'POST',
		body: JSON.stringify({
			roundid: roundid,
			guessedWord: guessedWord,
			gameid: gameid,
			langid: langid,
			length: length
		}),
		headers:{
			'Content-Type': 'application/json'
		}})
	.then(response => response.json())
	.then(function(myJson){
		for (const object of myJson){
			var rij = document.createElement('tr');
			var td1 = document.createElement('td');
			var givenWord = document.createTextNode(object.givenWord);
			td1.appendChild(givenWord);
			rij.appendChild(td1);
			
			var td2 = document.createElement('td');
			var feedback = document.createTextNode(object.feedback);
			td2.appendChild(feedback);
			rij.appendChild(td2);
			
			document.getElementById('resultTable').appendChild(rij);
			
			if (object.feedback == "Congratulations!"){
				nextWord.style.display = "block";
			}
			if (object.feedback == "Game Over!"){
				endGame.style.display = "block";
				lingoGame.style.display = "none";
				document.getElementById("playername").value = "player" + gameid;
			}
		}
	})
}

function nextRound(){
	var tableHeaderRowCount = 1;
	var table = document.getElementById('resultTable');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}
	
	setLength();
	
	document.getElementById("guessedWord").value = "";
	nextWord.style.display = "none";
	
	fetch('restservices/round/next', {
		method: 'POST',
		body: JSON.stringify({
			gameid: gameid,
			langid: langid,
			length: length
		}),
		headers:{
			'Content-Type': 'application/json'
		}})
	.then(response => response.json())
	.then(function(myJson){
		for (const object of myJson){
			roundid = object.roundid;
			
			var rij = document.createElement('tr');
			var td1 = document.createElement('td');
			var givenWord = document.createTextNode(object.givenWord);
			td1.appendChild(givenWord);
			rij.appendChild(td1);
			
			document.getElementById('resultTable').appendChild(rij);
		}
	})
}

function saveScore(){
	playername = document.getElementById("playername").value;
	
	fetch('restservices/game/endGame', {
		method: 'POST',
		body: JSON.stringify({
			gameid: gameid,
			playername: playername
		}),
		headers:{
			'Content-Type': 'application/json'
		}})
	.then(response => response.json())
	.then(function(myJson){
		for (const object of myJson){
			endGame.style.display = "none";
			scoreboard.style.display = "block";
			score = object.score;
			openScoreboard();
		}
	})
}

function openScoreboard(){
	document.getElementById("playernameLbl").innerHTML = playername;
	document.getElementById("scoreLbl").innerHTML = score;
	
	fetch('restservices/game/getTopFifty', {method: 'GET'})
	.then(response => response.json())
	.then(function(myJson){
		for (const object of myJson){
			var rij = document.createElement('tr');
			var td1 = document.createElement('td');
			var playername = document.createTextNode(object.playername);
			td1.appendChild(playername);
			rij.appendChild(td1);
			
			var td2 = document.createElement('td');
			var score = document.createTextNode(object.score);
			td2.appendChild(score);
			rij.appendChild(td2);
			
			document.getElementById('scoreTable').appendChild(rij);
		}
	})
}

function setLength(){
	if(length == null){
		length = 5;
	}
	if(length == 5){
		length = 6;
	}
	if(length == 6){
		length = 7;
	}
	if(length == 7){
		length = 5;
	}
}

function mainMenu(){
	gameid = null;
	roundid = null;
	langid = null;
	length = null;
	score = null;
	playername = null;
	
	document.getElementById("playernameLbl").value = "";
	document.getElementById("scoreLbl").value = "";
	document.getElementById("playername").value = "";
	document.getElementById("guessedWord").value = "";
	
	chooseLanguage.style.display = "block";
	lingoGame.style.display = "none";
	endGame.style.display = "none";
	nextWord.style.display = "none";
	scoreboard.style.display = "none";
}

window.onload = initPage;