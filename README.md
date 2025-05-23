# Local Football League Management System

## 📋 Overview
The **Local Football League Management System** is a Java EE-based web application developed to assist league administrators in managing teams and players within local football leagues. The system provides features such as adding, updating, removing, and listing teams and players with detailed attributes.

---

## 🧰 Technology Stack

| Layer               | Technology                             |
|--------------------|----------------------------------------|
| Frontend           | HTML, JSP 2.1                          |
| Backend            | Servlets, EJB (Enterprise Java Beans) |
| Persistence        | JPA (Java Persistence API), JPQL       |
| Database           | Java DB (Apache Derby)                |
| Application Server | GlassFish 4.1.1                        |
| IDE                | NetBeans 8.2                          |
| JDK                | Java SE 8                             |



## ⚙️ Features

### Team Management
- ✅ Add new teams
- 🗑️ Remove teams
- 🔁 Update team information
- 📋 List teams with filtering/sorting

### Player Management
- ✅ Register new players
- 🗑️ Delete player records
- 🔁 Update player details / team transfers
- 📋 List players by team, age, position, nationality
- 🔍 Search for players using player ID

---

## 🚦 Development Guidelines

- **No HTML in Servlets**: All views must be rendered through JSPs.
- **Database Auto-Creation**: Tables are auto-generated using JPA Entities under `za.ac.tut.entities`.
- **Business Logic**: Encapsulated strictly using EJBs in `za.ac.tut.model.bl`.
- **Facade Pattern**: Every entity has:
  - `AbstractFacade.java` for shared CRUD operations
  - `EntityNameFacade.java` for specific logic
  - `EntityNameFacadeLocal.java` as its local interface

---

## 🏗️ Build & Deployment Instructions

1. **Clone the Repository**
   git clone https://github.com/11Siya05/Local-Football-League-Management-System

Open in NetBeans 8.2

Configure GlassFish Server

Add Java DB and set LocalFootballLeaguePU as the persistence unit in persistence.xml.

Run the Project

Deploy using GlassFish and open in browser: http://localhost:8080/LocalFootballLeague

📄 License
This project is developed for academic and educational purposes. All rights reserved.

🙋‍♂️ Author
Full Stack Java Developer
Specializing in Java EE, EJB, JPA, JSP, and Servlets

Let me know if you want this formatted as an actual file or included in your NetBeans project.
