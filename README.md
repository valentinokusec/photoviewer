# Photoviewer

PhotoViewer is an application that lets you see the best locals in Varaždin. It consists of three activities. First one contains a list of locals, second one more details for each local and third one gallery with pinch to zoom effect.

## Project structure

The project consists of five packages, activity package that holds our activities, fragment for our fragment, object for our location object, imageview that contains our custom image,view class for zoom to pinch effect and adapter for our custom list row adapter.

## Activities

The application has three activites. MainActivity for the list of the locals, Info for the more information about the local, and Gallery for viewing images of the location.

### MainActivity

Contains a list of 10 locals, each row in the list has an image, name, address, and mail address.
At the begging we initialize all the data that one local can have. We create an array for each data. We have name of the local, address mail address. Then we have int arrays for the images, imageid for the list population, imageid1, imageid2, imageid3 for thhe images in the Info class, and image11,image12,image13,image14,image15 for the gallery class.

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
We create our List and populate it with the date from the arrays 
```java
List adapter = new List(MainActivity.this, name,adress,mailadress, imageId);
```

When one of the item in the list is clicked, we populate the Location object with the data based on the position and the arrays.
```java

Location.setName(name[position]);
Location.setAdress(adress[position]);
Location.setMailadress(mailadress[position]);
Location.setBanner(bannerid[position]);
Location.setImage1(imageid1[position]);
Location.setImage2(imageid2[position]);
Location.setImage3(imageid3[position]);
Location.setImage11(imageid11[position]);
Location.setImage12(imageid12[position]);
Location.setImage13(imageid13[position]);
Location.setImage14(imageid14[position]);
Location.setImage15(imageid15[position]);
```
