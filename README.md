
<p align="center">
<a href="https://insomnia.rest/run/?label=Asap%20Log&uri=https%3A%2F%2Fraw.githubusercontent.com%2Ffrichardben%2Fcrud-mongo%2Fmain%2Finsomnia.json%3Ftoken%3DAF6SUQWHIUQVYN3VD542URC7UGI3C" target="_blank"><img src="https://insomnia.rest/images/run.svg" alt="Run in Insomnia"></a>
</p>

## :rocket: Overview

Crud de customers and policy



## :computer: Getting Started

### :construction: Prerequisites

To run this server you will need two containers running on your machine.

To do so, you will need to run the following commands:

- `docker run --name mongodb -p 27017:27017 -d  -t mongodb`;


_Remember: If you restart your machine, you will need to start again the server with `docker start <container_id>`._


### :anchor: Installing

```
$ git clone https://github.com/frichardben/crud-mongo.git

# Go into the repository
$ cd crud-mongo

# Run the backend server
$ mvn spring-boot:run 
$ 


```

