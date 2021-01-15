<div style="border: 3px solid red; margin: 125px 225px 0px 225px;">
	<div class="room">
		REGISTER
		<c:if test="${registerStatus == 'success'}">
			<div class="hide">Register successfully, please LOGIN to
				proceed</div>
		</c:if>
	</div>
	<div style="display: flex; justify-content: center;">
		<form action="/snakes-and-ladders/register" method="post">
			<table>
				<tr>
					<td><label>Firstname</label></td>
					<td>:</td>
					<td><input type="text" name="fname"></td>
				</tr>
				<tr>
					<td><label>Lastname</label></td>
					<td>:</td>
					<td><input type="text" name="lname"></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td>:</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td>:</td>
					<td><input type="password" name="pswd"></td>
				</tr>
				<tr>
					<td colspan="3"><button type="submit">Register</button></td>
				</tr>
			</table>
		</form>
	</div>
</div>