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
            <button @click="createEvent()" v-bind:disabled="isCreateBtnDisabled">Create Event</button>
            <button class="danger-btn" @click="clearInputs()">Clear</button>
        </div>
        <h2>Events</h2>
        <table>
            <tbody id="events-tbody">
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Type</th>
                </tr>
                <tr v-for="e in events">
                    <td>{{ e.name }}</td>
                    <td>{{ e.date }}</td>
                    <td>{{ e.type === "IN_PERSON" ? "In person" : "Online" }}</td>
                </tr>
            </tbody>
        </table>
    </main>
</template>

<script>
import axios from "axios";

const client = axios.create({
    // IMPORTANT: baseURL, not baseUrl
    baseURL: "http://localhost:8080"
});

export default {
    name: "EventsView",
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
        try {
            const response = await client.get("/events");
            this.events = response.data.events
        }
        catch (e) {
            // TODO: show the user a warning
            console.log(e);
        }
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
            try {
                const response = await client.post("/events", newEvent);
                this.events.push(response.data);
                this.clearInputs();
            }
            catch (e) {
                // TODO: show the user a warning
                console.log(e);
            }
        },
        clearInputs() {
            this.newEventType = "IN_PERSON";
            this.newEventName = null;
            this.newEventDate = null;
            this.newEventStartTime = null;
            this.newEventEndTime = null;
            this.newEventRegLimit = null;
            this.newEventLocation = null;
        }
    },
    computed: {
        isCreateBtnDisabled() {
            return (
                !this.newEventName
                || !this.newEventDate
                || !this.newEventStartTime
                || !this.newEventEndTime
                || !this.newEventLocation
            );
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
    padding-top: 1em;
    text-decoration: underline;
}

table {
    border-collapse: collapse;
}

td,
th {
    padding: 0.5em;
    border: 1px solid white;
}

.danger-btn {
    border: 1px solid red;
    color: red;
}
</style>