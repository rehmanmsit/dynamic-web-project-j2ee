<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="display: flex;">
	<div class="gameBoardDiv">
		<div>
			<div class="boardCell" id="100"></div>
			<div class="boardCell" id="81"></div>
			<div class="boardCell" id="80"></div>
			<div class="boardCell" id="61"></div>
			<div class="boardCell" id="60"></div>
			<div class="boardCell" id="41"></div>
			<div class="boardCell" id="40"></div>
			<div class="boardCell" id="21"></div>
			<div class="boardCell" id="20"></div>
			<div class="boardCell" id="1"></div>
		</div>
		<div>
			<div class="boardCell" id="99"></div>
			<div class="boardCell" id="82"></div>
			<div class="boardCell" id="79"></div>
			<div class="boardCell" id="62"></div>
			<div class="boardCell" id="59"></div>
			<div class="boardCell" id="42"></div>
			<div class="boardCell" id="39"></div>
			<div class="boardCell" id="22"></div>
			<div class="boardCell" id="19"></div>
			<div class="boardCell" id="2"></div>
		</div>
		<div>
			<div class="boardCell" id="98"></div>
			<div class="boardCell" id="83"></div>
			<div class="boardCell" id="78"></div>
			<div class="boardCell" id="63"></div>
			<div class="boardCell" id="58"></div>
			<div class="boardCell" id="43"></div>
			<div class="boardCell" id="38"></div>
			<div class="boardCell" id="23"></div>
			<div class="boardCell" id="18"></div>
			<div class="boardCell" id="3"></div>
		</div>
		<div>
			<div class="boardCell" id="97"></div>
			<div class="boardCell" id="84"></div>
			<div class="boardCell" id="77"></div>
			<div class="boardCell" id="64"></div>
			<div class="boardCell" id="57"></div>
			<div class="boardCell" id="44"></div>
			<div class="boardCell" id="37"></div>
			<div class="boardCell" id="24"></div>
			<div class="boardCell" id="17"></div>
			<div class="boardCell" id="4"></div>
		</div>
		<div>
			<div class="boardCell" id="96"></div>
			<div class="boardCell" id="85"></div>
			<div class="boardCell" id="76"></div>
			<div class="boardCell" id="65"></div>
			<div class="boardCell" id="56"></div>
			<div class="boardCell" id="45"></div>
			<div class="boardCell" id="36"></div>
			<div class="boardCell" id="25"></div>
			<div class="boardCell" id="16"></div>
			<div class="boardCell" id="5"></div>
		</div>
		<div>
			<div class="boardCell" id="95"></div>
			<div class="boardCell" id="86"></div>
			<div class="boardCell" id="75"></div>
			<div class="boardCell" id="66"></div>
			<div class="boardCell" id="55"></div>
			<div class="boardCell" id="46"></div>
			<div class="boardCell" id="35"></div>
			<div class="boardCell" id="26"></div>
			<div class="boardCell" id="15"></div>
			<div class="boardCell" id="6"></div>
		</div>
		<div>
			<div class="boardCell" id="94"></div>
			<div class="boardCell" id="87"></div>
			<div class="boardCell" id="74"></div>
			<div class="boardCell" id="67"></div>
			<div class="boardCell" id="54"></div>
			<div class="boardCell" id="47"></div>
			<div class="boardCell" id="34"></div>
			<div class="boardCell" id="27"></div>
			<div class="boardCell" id="14"></div>
			<div class="boardCell" id="7"></div>
		</div>
		<div>
			<div class="boardCell" id="93"></div>
			<div class="boardCell" id="88"></div>
			<div class="boardCell" id="73"></div>
			<div class="boardCell" id="68"></div>
			<div class="boardCell" id="53"></div>
			<div class="boardCell" id="48"></div>
			<div class="boardCell" id="33"></div>
			<div class="boardCell" id="28"></div>
			<div class="boardCell" id="13"></div>
			<div class="boardCell" id="8"></div>
		</div>
		<div>
			<div class="boardCell" id="92"></div>
			<div class="boardCell" id="89"></div>
			<div class="boardCell" id="72"></div>
			<div class="boardCell" id="69"></div>
			<div class="boardCell" id="52"></div>
			<div class="boardCell" id="49"></div>
			<div class="boardCell" id="32"></div>
			<div class="boardCell" id="29"></div>
			<div class="boardCell" id="12"></div>
			<div class="boardCell" id="9"></div>
		</div>
		<div>
			<div class="boardCell" id="91"></div>
			<div class="boardCell" id="90"></div>
			<div class="boardCell" id="71"></div>
			<div class="boardCell" id="70"></div>
			<div class="boardCell" id="51"></div>
			<div class="boardCell" id="50"></div>
			<div class="boardCell" id="31"></div>
			<div class="boardCell" id="30"></div>
			<div class="boardCell" id="11"></div>
			<div class="boardCell" id="10"></div>
		</div>
	</div>
	<div class="diceImg">
		<img src="./img/1.png" id="diceImg" alt="dice" />
	</div>
	<div>
		<input class="diceInput" id="diceInput" type="text" value="1" readonly />
	</div>
	<div>
		<button class="rollBtn" onClick="rollBtn()" type="button">Roll</button>
	</div>
	<form id="gameForm" action="/snakes-and-ladders/game" method="post">
	
		<input type="hidden" id="existingPlace" name="existingPlace" value="${myGameBoard.place}" />
		<input type="hidden" id="diceNumber" name="diceNumber" value="" />
	
	</form>
	<script type="text/javascript">
		<c:forEach items="${gameBoard}" var="element">
			document.getElementById(${element.place}).innerHTML = '<img id="dotImg_${element.userName}" alt="dot" src="./img/${element.colour}.png">';
		</c:forEach>
	</script>
</div>