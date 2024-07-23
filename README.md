## Author

Juan Pablo Poveda Cañon

# TALLER TEST

## Prerequisitos

Maven: Automatiza y estandariza el flujo de vida de la construcción de software.

Git: Administrador descentralizado de configuraciones.

 
## Instalación

Clonamos el proyecto TallerSeguridadARSW donde se encuentra el backend de nuestra aplicación Web.  

```
git clone https://github.com/juancanon1725/TallerSeguridadARSW.git
```

## Ejecución

Para compilar el proyecto se debe usar:

```
 mvn clean install
```

Para ejecutar el proyecto utilizamos los comandos:

```
 mvn spring-boot:run 
```

Para lanzar el sonar:

```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
```

##  INTEGRANDO ANÁLISIS ESTÁTICO DE CÓDIGO Y COBERTURA DE PRUEBAS UNITARIAS.

Utilizando el Plugin de jacoco genere el reporte de cobertura de las pruebas unitarias.

![reporteJACOCO](https://github.com/user-attachments/assets/34b72a83-22e8-4e7c-9123-50acb12d3c12)

Genere la integración con sonar:

```
 mvn verify sonar:sonar -D sonar.token=[TOKEN_GENERADO] 
```

Evidenciamos el minimo cubrimiento de pruebas de un 80%:

![SonarReporte](https://github.com/user-attachments/assets/f319b860-aa54-4e51-9341-52b7bd38f6df)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

