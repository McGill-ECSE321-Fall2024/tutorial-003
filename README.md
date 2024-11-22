# Event Registration System

The event registration system lets users create and register for events.

## Running the App Locally

First, create a database as described in https://mcgill-ecse321-fall2024.github.io/tutorial-notes/#_setting_up_a_local_postgresql_database.
The database credentials are specified in [application.properties](EventRegistration-Backend/src/main/resources/application.properties)

Start the backend:
```sh
cd EventRegistration-Backend
./gradlew bootRun
```

Start the frontend:
```sh
cd EventRegistration-Frontend
npm run dev
```

Run the backend tests:
```sh
cd EventRegistration-Backend
./gradlew test
```

## Dependencies

The app was developed with
- PostgreSQL 14.3
- Java 21
- Node.js v22.11.0
- npm v10.9.0.
