# 📚 Recommendation Service

This microservice is responsible for recommending top-rated courses to users, including personalized suggestions based on their enrolled courses.

---

## 🚀 Technologies Used

- **Java 21**
- **Spring Boot 3.5**
- **Spring Cloud WebClient**
- **Maven**
- **Docker & Docker Compose**
- **Swagger/OpenAPI (Springdoc)**

---

## 📦 Features

- ✅ Get Top 5 Rated Courses
- ✅ Get User Personalized Recommendations (based on course tags)
- ✅ Integrates with External Course and Enrollment APIs
- ✅ Dockerized for production-ready deployment

---

## 🔧 Configuration

Configuration is set using environment variables and can be overridden in `application.properties`.

| Key                      | Description                                 |
|--------------------------|---------------------------------------------|
| `EXTERNAL_API_URL`       | URL to get all courses                      |
| `EXTERNAL_API_USER_URL`  | URL to get user enrollments                 |
| `SERVER_PORT`            | Port number of this service (default: 5006) |

---

## 🐳 Running with Docker Compose

### ✅ Build and Run

```bash
docker-compose up --build
