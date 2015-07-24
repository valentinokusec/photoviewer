# Photoviewer

PhotoViewer is an application that lets you see the best locals in Varaždin. It consists of three activities. First one contains a list of locals, second one more details for each local and third one gallery with pinch to zoom effect.

## Project structure

The project consists of five packages, activity package that holds our activities, fragment for our fragment, object for our location object, imageview that contains our custom image,view class for zoom to pinch effect and adapter for our custom list row adapter.

## Activities

The application has three activites. MainActivity for the list of the locals, Info for the more information about the local, and Gallery for viewing images of the location.

## MainActivity

Contains a list of 10 locals, each row in the list has an image, name, address, and mail address.

```java
String[] name = {
        "Al acarte",
        "Aquamarin",
        "Barfly",
        "Emporio",
        "Mabis",
        "Mea Culpa",
        "Medonja",
        "MyWay",
        "Office",
        "Ritz"
} ;
```

