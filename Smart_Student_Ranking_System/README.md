# 🎓 Smart Student Ranking System (JavaFX)

> A modern JavaFX desktop application for sorting, ranking, and managing student academic performance using Object-Oriented Programming (OOP) and Comparator interfaces.

---

## ✨ Features

- **JavaFX Graphical User Interface**: Rich interactive visual dashboard.
- **Dynamic Student Ranking**: Sort students by:
  - **Name** (Alphabetical sorting using `Comparator`)
  - **Roll Number** (Numerical identification sorting)
  - **CGPA** (Natural order ranking for high academic achievers)
- **Modular MVC Architecture**: Clean separation between FXML layouts, Controllers, and Domain Models (`Student`).

---

## 🛠️ Technology Stack

- **GUI Framework:** JavaFX 17+
- **Language:** Java 17+
- **Build System:** Maven
- **Architecture:** Model-View-Controller (MVC)

---

## 📁 Directory Structure

```
Smart_Student_Ranking_System/
├── src/main/java/src/smart_student_ranking_system/
│   ├── Main.java               ← Application Entry Point & Launch Logic
│   ├── MainController.java     ← JavaFX UI Controller
│   ├── Student.java            ← Model Class with Comparators
│   └── summary.java            ← Ranking summary generator
├── src/main/resources/
│   └── hello-view.fxml         ← FXML Layout Interface
└── pom.xml                     ← Maven Dependencies & JavaFX Plugin
```

---

## 🚀 How to Run

### Using Maven:
```bash
cd Smart_Student_Ranking_System
./mvnw javafx:run
```

---

## 👨‍💻 Author

**Hanan Qaisar**  
*Java OOP & JavaFX Project*
