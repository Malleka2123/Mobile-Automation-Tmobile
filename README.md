# 📱 Mobile Automation Framework – T-Mobile

[![Maven Build](https://github.com/Malleka2123/mobile-automation-tmobile/actions/workflows/maven.yml/badge.svg)](https://github.com/Malleka2123/mobile-automation-tmobile/actions/workflows/maven.yml)  
[![GitHub issues](https://img.shields.io/github/issues/Malleka2123/mobile-automation-tmobile)](https://github.com/Malleka2123/mobile-automation-tmobile/issues)  
[![License](https://img.shields.io/github/license/Malleka2123/mobile-automation-tmobile)](https://github.com/Malleka2123/mobile-automation-tmobile/blob/main/LICENSE)

This repository contains an Appium + TestNG automation suite for core mobile features such as messaging, calling, and UI validations on Android and iOS devices.

## 🛠️ Tech Stack
- Appium
- TestNG
- Java
- Maven
- Jenkins (CI/CD Integration)

## 🧪 Features Tested
- SMS Messaging  
- Call Handling (Incoming/Outgoing)  
- Conference Calls  
- Group Messaging with Images  
- Performance Validation (load times, UI response)

## 📂 Project Structure
📁 src
├── test
│ ├── base
│ ├── tests
│ └── utils
├── resources
└── pom.xml

## ▶️ Getting Started

1. Clone the repo:
    ```bash
    git clone https://github.com/Malleka2123/mobile-automation-tmobile.git
    cd mobile-automation-tmobile
    ```

2. Install prerequisites:
    - [Java JDK 8+](https://adoptium.net/)
    - [Maven](https://maven.apache.org/install.html)
    - [Android SDK](https://developer.android.com/studio)
    - [Appium](https://appium.io/docs/en/about-appium/intro/)
    - Set up Android Emulator or connect a real device with USB debugging enabled

3. Start Appium server:
    ```bash
    appium --session-override
    ```

4. Build project dependencies:
    ```bash
    mvn clean install
    ```

## 🚀 Running Tests

