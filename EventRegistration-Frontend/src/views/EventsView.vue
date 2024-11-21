<template>
	<main>
		<h1>Event Registration</h1>
		<h2>New Event</h2>
		<div>
			<select v-model="newEventType">
				<option value="IN_PERSON">In person</option>
				<option value="ONLINE">Online</option>
			</select>
			<input type="text" placeholder="Name" v-model="newEventName" />
			<input type="date" placeholder="Date" v-model="newEventDate" />
			<input type="time" placeholder="Start Time" v-model="newEventStartTime" />
			<input type="time" placeholder="End Time" v-model="newEventEndTime" />
			<input type="text" placeholder="Registration Limit" v-model="newEventRegLimit" />
			<input type="text" placeholder="Location" v-model="newEventLocation" />
			<button id="create-btn" @click="createEvent" v-bind:disabled="!isEventValid()">Create Event</button>
			<button class="danger-btn" @click="clearInputs">Clear</button>
		</div>
		<h2>Events</h2>
		<table>
			<tbody>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Type</th>
				</tr>
				<tr v-for="e in events">
					<td>
						<!-- (Almost) vanilla HTML way: just use <a> tag.
						     Use v-bind: to dynamically construct href.
						     This reloads the whole page.
						 -->
						<!-- <a v-bind:href="`/event/${e.id}`">{{ e.name }}</a> -->
						<!-- The recommended way to do it with vue router.
						     https://router.vuejs.org/guide/
						     If you want to navigate using JavaScript, see
						     https://router.vuejs.org/guide/essentials/navigation.html
						 -->
						<RouterLink v-bind:to="{ name: 'event-details', params: { eid: e.id } }">{{ e.name }}</RouterLink>
					</td>
					<td>{{ e.date }}</td>
					<td>{{ e.type === "IN_PERSON" ? "In person" : "Online" }}</td>
				</tr>
			</tbody>
		</table>
	</main>
</template>

<script>
import axios from "axios";
import { RouterLink } from "vue-router";

const axiosClient = axios.create({
	// NOTE: it's baseURL, not baseUrl
	baseURL: "http://localhost:8080"
});

export default {
	name: "events",
	data() {
		return {
			events: [],
			newEventType: "IN_PERSON",
			newEventName: null,
			newEventDate: null,
			newEventStartTime: null,
			newEventEndTime: null,
			newEventRegLimit: null,
			newEventLocation: null
		};
	},
	async created() {
		const response = await axiosClient.get("/events");
		// TODO: error handling
		this.events = response.data.events;
	},
	methods: {
		async createEvent() {
			const newEvent = {
				type: this.newEventType,
				name: this.newEventName,
				date: this.newEventDate,
				startTime: this.newEventStartTime,
				endTime: this.newEventEndTime,
				registrationLimit: this.newEventRegLimit,
				location: this.newEventLocation
			};
			const response = await axiosClient.post("/events", newEvent);
			// TODO: error handling
			this.events.push(response.data);
			this.clearInputs();
		},
		clearInputs() {
			this.newEventType = "IN_PERSON";
			this.newEventName = null;
			this.newEventDate = null;
			this.newEventStartTime = null;
			this.newEventEndTime = null;
			this.newEventRegLimit = null;
			this.newEventLocation = null;
		},
		isEventValid() {
			return this.newEventName
				&& this.newEventDate
				&& this.newEventStartTime
				&& this.newEventRegLimit
				&& this.newEventLocation;
		}
	}
};
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
	border: 1px solid var(--color-border);
	padding: 0.25em;
}
</style>
