# ☕ Java OOP Projects

> A curated collection of Java Object-Oriented Programming projects, assignments, and JavaFX GUI applications.

![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square&logo=java)
![JavaFX](https://img.shields.io/badge/GUI-JavaFX-blue?style=flat-square)
![Status](https://img.shields.io/badge/Status-Actively%20Learning-brightgreen?style=flat-square)
![Student](https://img.shields.io/badge/Student-Hanan%20Qaisar-blue?style=flat-square)

---

## 👨‍💻 About

**Student:** Hanan Qaisar  
**Focus:** Core Java, Object-Oriented Programming (OOP) Principles, and JavaFX GUI Desktop Applications  
**Repository:** `Java_OOP`

---

## 📁 Repository Structure

```
Java_OOP/
├── BasicOOP/                          ← Core OOP concepts, arrays, strings, inheritance & polymorphism
├── DeliverySystem/                    ← Restaurant order & food delivery logistics
├── GarageX_VehicleShowroom/           ← Vehicle showroom demo with abstract classes & composition
├── javafx/                            ← JavaFX GUI applications & component showcases ⭐
├── Library_Management_System/         ← Library item abstraction (Books & Magazines)
├── MobileStore/                       ← Mobile phone store inventory (Dockerized)
├── Music_Library/                     ← Terminal music player & playlist manager (Dockerized)
├── OOP_Assignments/                   ← Lab assignments & university practice modules
├── Smart_Student_Ranking_System/      ← JavaFX Student ranking & sorting GUI application ⭐
├── StringAnalyzing_Processing/        ← String manipulation algorithms & palindrome checks
├── University_Staff_Management/       ← Staff hierarchy using OOP inheritance
└── Vehical_Rental_System/             ← Vehicle rental platform with polymorphism
```

---

## 🚀 Projects Overview

| # | Project | Category | Key Concepts / Highlights |
|---|---------|----------|---------------------------|
| 1 | **[Smart_Student_Ranking_System](./Smart_Student_Ranking_System)** ⭐ | **JavaFX GUI App** | Student CGPA/Roll ranking dashboard using Comparators & JavaFX FXML |
| 2 | **[javafx](./javafx)** ⭐ | **JavaFX GUI App** | Desktop UI controls, event handling, scenes, stages & layout managers |
| 3 | **[BasicOOP](./BasicOOP)** | **Core Java** | Constructors, copy constructors, ArrayList, 2D matrices, `super` vs `this` |
| 4 | **[DeliverySystem](./DeliverySystem)** | **OOP System** | Restaurant menu aggregation, food ordering & bill calculations |
| 5 | **[GarageX_VehicleShowroom](./GarageX_VehicleShowroom)** | **OOP System** | Abstract `Vehicle` base class, `Engine` composition & runtime downcasting |
| 6 | **[Library_Management_System](./Library_Management_System)** | **OOP System** | Abstract `LibraryItem` hierarchy (`Book` & `Magazine` management) |
| 7 | **[MobileStore](./MobileStore)** | **System / Docker** | Mobile inventory & battery details with Docker containerization |
| 8 | **[Music_Library](./Music_Library)** | **System / Docker** | CLI Music player, podcast episodes, sorting algorithms & Docker setup |
| 9 | **[OOP_Assignments](./OOP_Assignments)** | **Lab Assignments** | Bank accounts, university course registrations & lab grading assignments |
| 10 | **[StringAnalyzing_Processing](./StringAnalyzing_Processing)** | **Algorithms** | Reverse string logic, vowel counting & palindrome detection |
| 11 | **[University_Staff_Management](./University_Staff_Management)** | **Inheritance** | Staff hierarchy (`Person` → `Employee` → `Faculty`/`AdminStaff`) |
| 12 | **[Vehical_Rental_System](./Vehical_Rental_System)** | **Polymorphism** | Rental calculations for `Car`, `Bike`, and `SUV` |

---

## 🧠 Core Topics Covered

- **Classes, Objects & Encapsulation**: Private fields, validation getters/setters, constructors, and copy constructors.
- **Inheritance & Polymorphism**: Abstract classes, interface implementation, method overloading, method overriding, and `instanceof` downcasting.
- **Has-A Relationships**: Object composition (e.g. `Vehicle` + `Engine`, `Room` + `Amenity`).
- **Graphical User Interfaces (GUI)**: JavaFX FXML layouts, Controllers, Application lifecycle, and Event Handling.
- **Containerization**: Dockerfile configurations for Java applications.

---

## ⚡ How to Run

```bash
# Compile any single console file
javac FileName.java

# Run console app
java ClassName
```

> **For JavaFX projects** (`Smart_Student_Ranking_System` & `javafx/demo`), run using Maven:
> ```bash
> ./mvnw javafx:run
> ```

---

*Learning Java OOP & JavaFX one project at a time. 🚀*