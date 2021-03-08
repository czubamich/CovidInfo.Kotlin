# CovidInfo.Kotlin
<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
  <p align="left">
    Android Kotlin example app for <a href="https://github.com/czubamich/CovidInfo.RestAPI/">CovidInfo.RestAPI</a>
</p>

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#features">Features</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#important-note">Important Note</a></li>
        <li><a href="#report-issues">Report Issues</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

![Product Screen Shot](https://github.com/czubamich/CovidInfo.Kotlin/blob/master/screenshot.png)

### Built With

* [Kotlin](https://kotlinlang.org/)
* [MVVM](https://developer.android.com/jetpack/docs/guide)
* [Compose](https://developer.android.com/jetpack/compose)
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [Retrofit2](https://github.com/square/retrofit)
* [AnyChart](https://www.anychart.com/)
* [joda-time](https://github.com/dlew/joda-time-android)
* [Material Design](https://material.io/develop/android)

### Features
* RestAPI communication through Retrofit2
* Single Activity Architecture

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites
To build this project, you require:

* Android Studio 4.1.1
* Gradle 7.0
* Android Device (Minimum API 26)


### Installation
1. Clone the repo
   ```sh
   git clone https://github.com/czubamich/CovidInfo.Kotlin.git
   ```
2. Open project in Android Studio.
3. Run 'app' SHIFT+F10.

### Important Note
Application is designed to work with [CovidInfo.RestAPI](https://github.com/czubamich/CovidInfo.RestAPI/) </br>
_RestAPI source IP is set to localhost by default_

You can configure the IP through baseUrl argument in RestAPI.kt

### Report issues

Something not working quite as expected? Do you need a feature that has not been implemented yet? Check the issue tracker and add a new one if your problem is not already listed. Please try to provide a detailed description of your problem, including the steps to reproduce it.

<!-- CONTACT -->
## Contact

Michael Czuba - czuba.mich@gmail.com

<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [LiveEvent](https://github.com/hadilq/LiveEvent)
* [SmoothBottomBar](https://github.com/ibrahimsn98/SmoothBottomBar)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/czubamich/CovidInfo.Kotlin.svg?style=for-the-badge
[contributors-url]: https://github.com/czubamich/CovidInfo.Kotlin/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/czubamich/CovidInfo.Kotlin.svg?style=for-the-badge
[forks-url]: https://github.com/czubamich/CovidInfo.Kotlin/network/members
[stars-shield]: https://img.shields.io/github/stars/czubamich/CovidInfo.Kotlin.svg?style=for-the-badge
[stars-url]: https://github.com/czubamich/CovidInfo.Kotlin/stargazers
[issues-shield]: https://img.shields.io/github/issues/czubamich/CovidInfo.Kotlin.svg?style=for-the-badge
[issues-url]: https://github.com/czubamich/CovidInfo.Kotlin/issues
[license-shield]: https://img.shields.io/github/license/czubamich/CovidInfo.Kotlin.svg?style=for-the-badge
[license-url]: https://github.com/czubamich/CovidInfo.Kotlin/blob/master/LICENSE.txt

<!-- README created using the following template -->
<!-- https://github.com/othneildrew/Best-README-Template -->
