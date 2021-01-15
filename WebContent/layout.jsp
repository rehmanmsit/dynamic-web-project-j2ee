<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="header">
		<h3 style="text-align: center;">Snakes and Ladders</h3>
	</div>
	<div class="sec">
		<div class="side">
			<div class="plain"></div>

			<c:if test="${!sessionScope.isLoggedIn}">
				<div class="sideDivPlay">
					<h3 class="textAlgCent">
						<a href="/snakes-and-ladders/login">LOGIN</a>
					</h3>
				</div>
				<div class="sideDivPlay">
					<h3 class="textAlgCent">
						<a href="/snakes-and-ladders/register">REGISTER</a>
					</h3>
				</div>
			</c:if>

			<div class="sideDivPlay">
				<h3 class="textAlgCent">
					<a href="/snakes-and-ladders/play">PLAY</a>
				</h3>
			</div>
		</div>
		<div class="main ${homeClass}">

			<c:if test="${page == 'register'}">
				<jsp:include page="registerForm.jsp" />
				<script type="text/javascript" src="./js/index.js"></script>
			</c:if>

			<c:if test="${page == 'create'}">
				<jsp:include page="create.jsp" />
			</c:if>

			<c:if test="${page == 'play'}">
				<jsp:include page="play.jsp" />
			</c:if>

			<c:if test="${page == 'login'}">
				<jsp:include page="login.jsp" />
			</c:if>

			<c:if test="${page == 'join'}">
				<jsp:include page="join.jsp" />
			</c:if>

			<c:if test="${page == 'game'}">
				<jsp:include page="game.jsp" />
				<script type="text/javascript" src="./js/game.js"></script>
			</c:if>

			<c:if test="${page == 'win'}">
				<jsp:include page="win.jsp" />
			</c:if>

		</div>
	</div>
	<div class="footer">
		<h3 style="text-align: center;">@@copy rights</h3>
	</div>
</body>
</html>