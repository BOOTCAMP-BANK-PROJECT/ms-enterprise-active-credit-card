<div id="top"></div>

<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->


<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

[![Contributors][contributors-shield]][contributors-url] <!--
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
-->
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">

<!--
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>
-->

<h3 align="center">GATEWAY SERVICE PROJECT</h3>

  <p align="center">
    Gateway Service with Spring Cloud for Bootcamp Bank Project!
    <br />
    <a href="https://github.com/BOOTCAMP-BANK-PROJECT/gateway-server"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/BOOTCAMP-BANK-PROJECT/gateway-server">View Demo</a>
    ·
    <a href="https://github.com/BOOTCAMP-BANK-PROJECT/gateway-server/issues">Report Bug</a>
    ·
    <a href="https://github.com/BOOTCAMP-BANK-PROJECT/gateway-server/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is a Gateway Service with Spring Cloud for Bootcamp Bank Project.


### Built With

This section list any major frameworks/libraries used to bootstrap this project. 

* [Java Development Kit 11](https://adoptium.net/es/temurin/releases)
* [Java Spring Framework](https://spring.io/)
* [Apache Maven 3.8.5](https://maven.apache.org/download.cgi/)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

* JRE 11
  ```sh
  https://adoptium.net/es/temurin/releases
  ```

* Apache Maven 3.8.5
  ```sh
  https://maven.apache.org/download.cgi/
  ```

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Clone the repo
   ```sh
   git clone https://github.com/BOOTCAMP-BANK-PROJECT/gateway-server.git
   ```
2. Install Maven dependencies
   ```sh
   mvn clean install package
   ```
   This will generate the next files:<br />

    ```
   ./target/app-jar-with-dependencies.jar
   ./target/app.jar
   ./target/app.jar.original
    ```

3. Copy the ```./config-server-example/gateway-server.yml``` file to your config-server-properties repository and customize it.
   

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

To build a docker image of the jar in a docker image run the following command.

```
   docker build -t my_user/spring-gateway-server:0.0.1-SNAPSHOT .
```
<br />

First of all, you need to add the next environment variables to your Operating System:

```
CONFIG_SERVER_URI: "config_service_url, like 192.168.0.9:8081"
SECURITY_USERNAME: "app_security_username, root by default"
SECURITY_PASSWORD: "app_security_password, 1234 by default"
```

<br />
To run the service with Java run the following command.

```
   java -jar ./target/app.jar
```
<br />

To use it with docker-compose you must duplicate the ```docker-compose.override.example.yml``` file and rename it as ```docker-compose.override.yml```,
then modify the yml file according to your requirements.


<br />
To run the service with docker-compose run the following command.

```
docker-compose up -d
```

<br />
To test if the service is working correctly, go the following URL (port 8089 by default):

```
http://localhost:8080/
```
<br />

<!--
_For more examples, please refer to the [Documentation](https://example.com)_
-->

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See `MIT LICENSE` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
<!--## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - email@example.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)

<p align="right">(<a href="#top">back to top</a>)</p>
-->



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/BOOTCAMP-BANK-PROJECT/config-server.svg?style=for-the-badge
[contributors-url]: https://github.com/BOOTCAMP-BANK-PROJECT/gateway-server/graphs/contributors
<!--
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
-->
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/BOOTCAMP-BANK-PROJECT/gateway-server/blob/main/LICENSE

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/samuel14luis/