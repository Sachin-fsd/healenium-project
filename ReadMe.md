# 🛡️ Healenium-Powered Self-Healing Automation 🚀

[![Awesome Automation](https://img.shields.io/badge/Awesome-Automation-brightgreen.svg)](https://github.com/SeleniumHQ/selenium)
[![Self-Healing](https://img.shields.io/badge/Self--Healing-Enabled-blueviolet.svg)](https://github.com/epam/healenium)
[![Dockerized](https://img.shields.io/badge/Dockerized-Ready-informational.svg)](https://www.docker.com/)
[![Maintenance](https://img.shields.io/badge/Maintained-Yes-success.svg)](https://github.com/your-repo/your-project)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## 🌟 Overview

This repository showcases a robust and intelligent self-healing automation framework leveraging the power of **Healenium** in conjunction with **Selenium Grid** and **Docker Compose**. Say goodbye to brittle tests plagued by frequently changing UI elements! This setup automatically attempts to identify and recover from broken locators, significantly reducing test maintenance overhead and improving overall test stability.

By integrating Healenium's smart locator analysis with the scalability of Selenium Grid, all orchestrated seamlessly with Docker Compose, this framework provides a cutting-edge solution for modern web application testing.

## ✨ Key Features

* **Intelligent Self-Healing:** Automatically analyzes failed locators and attempts to identify alternative, stable locators based on previously successful interactions.
* **Reduced Maintenance:** Minimizes the need for manual test updates due to UI changes, saving valuable time and resources.
* **Enhanced Test Stability:** Leads to more reliable and consistent test execution, reducing false negatives.
* **Scalable Selenium Grid:** Leverages Selenium Hub and Node architecture for parallel test execution across multiple browsers (Chrome, Firefox, Edge).
* **Containerized Environment:** Fully containerized using Docker Compose for easy setup, consistent environments, and simplified dependency management.
* **Real-time Reporting:** Provides a web-based UI (Healenium Report) to track healing attempts, success rates, and selector information.
* **Easy Integration:** Simple to integrate with your existing Selenium WebDriver test projects.

## 🛠️ Prerequisites

Before you get started, ensure you have the following installed on your system:

* **Docker:** [Install Docker](https://docs.docker.com/get-docker/)
* **Docker Compose:** Usually included with Docker Desktop. [Install Docker Compose Standalone](https://docs.docker.com/compose/install/) if needed.
* **Java Development Kit (JDK):** Required for running your Selenium tests. [Install JDK](https://openjdk.java.net/install/) (version 17 or higher recommended).
* **Maven or Gradle:** For managing your Java test dependencies. [Install Maven](https://maven.apache.org/install.html) or [Install Gradle](https://gradle.org/install/).

## 🚀 Getting Started

Follow these simple steps to get your self-healing automation environment up and running:
You should have `docker` installed on your system.

1. **Clone the Repository (if applicable):**
    ```bash
    git clone https://github.com/Sachin-fsd/healenium-project.git
    cd healenium-project
    ```

2. **Pull Images for docker, eg: pull selenoid image:**
   Navigate to the directory containing your `docker-compose.yml` file and run:
    ```bash
    docker pull selenoid/vnc:chrome_102.0
    ```

3. **Start the Docker Compose Stack:**
    Navigate to the directory containing your `docker-compose.yml` file and run:
    ```bash
    docker-compose up -d
    ```
    This command will download the necessary Docker images and start all the Healenium and Selenium components in detached mode.  


4. **Access the Healenium Report UI:**
    Once the containers are running, you can access the Healenium reporting interface in your web browser at:
    ```
    http://localhost:7878/healenium/report/
    ```

5. **Integrate Healenium into Your Selenium Tests (optional):**
    Add the Healenium dependency to your project's `pom.xml` (Maven) or `build.gradle` (Gradle):

    **Maven (`pom.xml`):**
    ```xml
    <dependency>
        <groupId>com.epam.healenium</groupId>
        <artifactId>healenium-web</artifactId>
        <version>LATEST_VERSION</version> </dependency>
    ```

    **Gradle (`build.gradle`):**
    ```gradle
    implementation 'com.epam.healenium:healenium-web:LATEST_VERSION' // Replace with the latest Healenium version
    ```

6. **Wrap Your WebDriver with `SelfHealingDriver` (optional):**
    In your test code, instantiate your WebDriver as usual (e.g., `ChromeDriver`) and then wrap it with `SelfHealingDriver`:

    ```java
    import com.epam.healenium.SelfHealingDriver;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;

    public class YourTestClass {
        public static void main(String[] args) {
            WebDriver delegate = new ChromeDriver();
            SelfHealingDriver driver = SelfHealingDriver.create(delegate);

            // Now use the 'driver' object for your Selenium interactions
            driver.get("[https://www.example.com](https://www.example.com)");
            // ... your test steps ...

            driver.quit();
        }
    }
    ```

7. **Run Your Tests:**
    Execute your Selenium tests as you normally would. Healenium will automatically intercept WebDriver commands and attempt to heal failing locators.


8. **Monitor Healing Reports:**
    After your tests have run, visit the Healenium Report UI (`http://localhost:7878/healenium/report/`) to view any healing events, selector information, and overall test execution details.

## ⚙️ Configuration

The core configuration for this setup is managed through the `docker-compose.yml` file. You can customize the following aspects:

* **Selenium Grid Scaling:** Adjust the `replicas` value for the browser node services (`chrome`, `firefox`, `edge`) to control the number of parallel test execution instances.
* **Port Mappings:** Modify the port mappings for the Healenium UI (`7878:7878`) and Selenium Hub (`4444:4444`) if needed to avoid conflicts.
* **Environment Variables:** Configure environment variables for the Healenium backend and proxy (if required) to adjust database connections or other settings. Refer to the Healenium documentation for available options.

## 🧪 Running Tests

Execute your Selenium tests using your preferred test runner (e.g., JUnit, TestNG). Ensure that your WebDriver instance is wrapped with `SelfHealingDriver` as described in the "Getting Started" section.

## 📊 Viewing Selectors

You can inspect the locators that Healenium has learned and stored in its database by navigating to: `http://localhost:7878/healenium/selectors/`

This interface provides valuable insights into the locators Healenium is using and their status.

## 💡 Contributing

We welcome contributions to this project! If you have suggestions, bug reports, or would like to contribute code, please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and commit them.
4.  Push your changes to your fork.
5.  Submit a pull request.

[//]: # (## 📄 License)

[//]: # ()
[//]: # (This project is licensed under the [MIT License]&#40;LICENSE&#41;.)

## 🔗 Useful Resources

* **Healenium Documentation:** [https://healenium.io/docs/](https://healenium.io/docs/)
* **Selenium Documentation:** [https://www.selenium.dev/documentation/](https://www.selenium.dev/documentation/)
* **Docker Documentation:** [https://docs.docker.com/](https://docs.docker.com/)
* **Docker Compose Documentation:** [https://docs.docker.com/compose/](https://docs.docker.com/compose/)

## 🙏 Acknowledgements

* The Healenium team for developing this incredible self-healing automation library.
* The Selenium project for providing the foundation for web browser automation.
* The Docker community for the powerful containerization technology.

---

**🚀 Level up your automation game with Healenium! 🛡️**
Happy Coding