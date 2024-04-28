# Forecast App

Forecast App is an Android application that provides weather forecasts for the next three days using data from the Tomorrow.io API.

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
4. [Technologies Used](#technologies-used)
5. [Contributing](#contributing)
6. [License](#license)
7. [Acknowledgments](#acknowledgments)

## Overview
Forecast App allows users to view weather forecasts for the next three days. It retrieves weather data from the Tomorrow.io API and displays it in a user-friendly interface. Users can specify their location to get accurate weather information.

## Features
- View weather forecasts for the next three days.
- Specify location to get accurate weather data.
- Pull-to-refresh functionality to update weather information.
- Offline support: View previously fetched weather data even without an internet connection.
- Unit tests and UI tests for ensuring application stability and reliability.

## Getting Started
### Prerequisites
Before running the application, make sure you have the following software installed on your system:
- Android Studio
- Git

### Installation
Follow these steps to run the application on your local machine:
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/Abdelilahskali/forcast.git
   ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Technologies Used
Forecast App is built using the following technologies and libraries:
- Kotlin programming language
- Android Jetpack components (ViewModel, LiveData)
- Jetpack Compose for building the user interface
- Retrofit for making network requests
- Room Database for local data persistence
- Kotlin Coroutines for asynchronous programming
- Dagger Hilt for dependency injection

## Contributing
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue on GitHub or submit a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Thanks to Tomorrow.io for providing the weather forecast API.
- Hat tip to anyone whose code was used as inspiration.
- Special thanks to the contributors of open-source libraries used in this project.

Feel free to customize and expand this README to better suit your project! If you have any questions or need further assistance, don't hesitate to ask.
