<div class="roomBdrMrg">
	<div class="room">CREATE ROOM</div>
	<div class="roomConDis">
		<form action="/snakes-and-ladders/create" method="post">
			<table>
				<tr class="roomPad">
					<td><label>Choose your room</label></td>
					<td>:</td>
					<td><select name="room">
							<option value="RED">Red</option>
							<option value="GREEN">Green</option>
							<option value="BLACK">Black</option>
							<option value="BLUE">Blue</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Choose your colour</label></td>
					<td>:</td>
					<td><select name="colour">
							<option value="RED">Red</option>
							<option value="GREEN">Green</option>
							<option value="BLACK">Black</option>
							<option value="BLUE">Blue</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="3"><button type="submit">Create</button></td>
				</tr>
			</table>
		</form>
	</div>
</div>