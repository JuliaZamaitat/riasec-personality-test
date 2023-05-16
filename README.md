# Holland-Code (RIASEC) Personality Test


This repository contains the code and resources for the Holland Codes project, which is based on Dr. John Holland's theory of categorizing people and work environments into six different groups. 

The project aims to help individuals understand their personality types and explore career possibilities that align with their interests. It was part of a research project conducted at [Université III Toulouse - Paul Sabatier](https://www.univ-tlse3.fr) in the study program 'Compuer Science for Aerospace'.




## Overview

The Holland Codes project provides a comprehensive assessment tool for users to determine their Holland Code, which consists of three letters representing their primary personality types. 
The code is determined based on their preferences and similarities to the six groups identified in Dr. Holland's theory.


## Features

* Self-assessment: Users can take an interactive test to discover their Holland Code and understand their personality traits.
* Career exploration: The project offers career possibilities corresponding to each Holland Code.
* User-friendly interface: The user interface is designed to be intuitive and easy to navigate, ensuring a smooth and engaging experience.


## Technologies Used

* Frontend: React.js (v8) and Next.js (v13)
* Backend: Spring Boot (v3) with Drools rule engine (v7)
* Database: MySQL for storing user data and profession information


## Installation

1. Clone the repository: git clone https://github.com/JuliaZamaitat/riasec-personality-test.git
2. Install the required dependencies for the frontend and backend:
    * Frontend: `cd frontend && npm install`
   * Backend: `cd backend && mvn install`

3. Set up a MySQL database and update the database configuration in the backend application properties. I used this following public docker image:

`docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=pw -d mysql:tag`


4. Start the frontend and backend servers:
    * Frontend: `cd frontend && npm run dev`
    * Backend: `cd backend && mvn spring-boot:run`


## Contact

For any inquiries or questions, please reach out to the project maintainer:

Name: Julia Zamaitat
Email: j.zamaitat@gmail.com


