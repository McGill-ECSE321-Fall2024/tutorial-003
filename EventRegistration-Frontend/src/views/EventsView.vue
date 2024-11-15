<template>
	<main>
		<h1>Event Registration</h1>
		<h2>New Event</h2>
		<div>
			<select>
				<option value="IN_PERSON">In person</option>
				<option value="ONLINE">Online</option>
			</select>
			<input type="text" placeholder="Name" />
			<input type="date" placeholder="Date" />
			<input type="time" placeholder="Start Time" />
			<input type="time" placeholder="End Time" />
			<input type="text" placeholder="Registration Limit" />
			<input type="text" placeholder="Location" />
			<button id="create-btn">Create Event</button>
			<button class="danger-btn">Clear</button>
			<button class="danger-btn">Delete All Events</button>
		</div>
		<h2>Events</h2>
		<table>
			<tbody id="events-tbody">
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Limit</th>
				</tr>
				<tr>
					<td>Party</td>
					<td>2024-03-23</td>
					<td>1</td>
				</tr>
			</tbody>
		</table>
	</main>
</template>

<script>

</script>

<style>
main {
	display: flex;
	flex-direction: column;
	align-items: stretch;
}

h2 {
	text-decoration: underline;
	padding-top: 0.5em;
}

.danger-btn {
	color: red;
	border: 1px solid red;
}

#create-btn {
	color: green;
	border: 1px solid green;
}

table {
	border-collapse: collapse;
}

td, th {
	border: 1px solid white;
	padding: 0.25em;
}
</style>
