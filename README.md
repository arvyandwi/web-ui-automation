# README

## Web UI Automation
Project UI Automation platform Web menggunakan Selenium WebDriver & Cucumber Integration.

## Introduction
Project bertujuan untuk memahami proses UI Automation menggunakan Selenium WebDriver, Cucumber Integration dan menerapkan Object-Oriented Programming Java.

## Installation
Untuk proses instalasi project, ikuti tahap-tahap berikut:
1. Buat sebuah folder kosong
2. Buka terminal pada directory folder kosong tersebut
3. Clone repository dengan menjalankan `git clone https://github.com/arvyandwi/web-ui-automation.git`

## Setup & Dependencies
Project menggunakan `selenium-java: 4.27.0`, `WebDriverManager: 5.9.2` (see [here](https://github.com/bonigarcia/webdrivermanager)), `cucumber-java: 7.20.1` and `junit-jupiter: 5.11.4` pada file `build.gradle`. Semua dependencies dapat dilihat di [Maven Repository](https://mvnrepository.com/).

## How To Run
Klik Tombol Run pada Feature File atau `CucumberTest.java`.

atau

Terminal:
1. Buka IntelliJ IDEA atau IDE apa saja (e.g. VSCode).
2. Ketik `./gradlew clean test` atau `./gradlew clean test --info` untuk melihat lebih detail step-step dari fitur yang kita running.

Bisa juga dengan menggunakan `./gradlew cucumber`. Untuk menggunakannya perlu menambahkan Custom Task `cucumber` pada file `build.gradle`.

Terminal dengan `tags`:
1. Buka IntelliJ IDEA atau IDE apa saja (e.g. VSCode).
2. Ketik `./gradlew cucumber -Ptags="tags"`

## Reports
Report akan di-generate berupa HTML & JSON pada folder `reports` yang terdiri dari `test-report-cucumber.html` dan `test-report-cucumber.json`.



