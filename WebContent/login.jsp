<div style="border: 3px solid red; margin: 125px 225px 0px 225px;">
	<div class="room">
		LOGIN
		<c:if test="${loginStatus == 'fails'}">
			<div class="hide">login username password are not correct!!!</div>
		</c:if>
	</div>
	<div style="display: flex; justify-content: center;">
		<form action="/snakes-and-ladders/login" method="post">
			<table>
				<tr>
					<td><label>Username</label></td>
					<td>:</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td><label>Password </label></td>
					<td>:</td>
					<td><input type="password" name="psw"></td>
				</tr>
				<tr>
					<td colspan="3"><button type="submit">Login</button></td>
				</tr>
			</table>
		</form>
	</div>
</div>