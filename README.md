# Todo list app
Godfather k8s workshop example project written in Spring Boot.

## Running the app
Build the image:
`docker build -t godfather/k8s-workshop:1.0.0 .`

Run the container in background:
`docker run -d --name todolist -p 8080:8080 godfather/k8s-workshop:1.0.0`

Open the app in UA:
`http://localhost:8080`

Browse the HTTP API:
`http://localhost:8080/swagger-ui.html`
