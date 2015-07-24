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

### Info

The info activity holds all the relevant data for each location. After we initiliaze all our views we set their resources from the Location object.

```java
banner.setImageResource(Location.getBanner());
image1.setImageResource(Location.getImage1());
image2.setImageResource(Location.getImage2());
image3.setImageResource(Location.getImage3());
lname.setText(Location.getName());
ladress.setText(Location.getAdress());
lmailadress.setText(Location.getMailadress());
```

And for each of the images at the bottom of the screen we set an onclicklistener so that one is clicked the app switches to gallery activity.

```java
image1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {

        Intent i = new Intent(getApplicationContext(), Gallery.class);

        startActivity(i);
    }
});

```

### Gallery
Gallery activity has a view pager, each page has one image,  thus creating an gallery without using gallery or horizontal swipe layout. First we create our needed variables, NUM_PAGES for the max number of the pages for the view pager class,  and we create our ViewPager and PagerAdapter.
```java

private static final int NUM_PAGES = 5;


private ViewPager mPager;


private PagerAdapter mPagerAdapter;
```
We create our pager and set an custom pageradapter
```

mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
mPager.setAdapter(mPagerAdapter);
```

Our pageadapter calls create method from the fragment class so that everytime the users  swipes the fragment is recreated and the page number variable is passed.
```java

private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ScreenSlidePageFragment.create(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
```

## Adapters

We have one adapter, List class for the list rows. 
When the list is created we need to pass all the data in our costructor
```java

public List(Activity context,
                  String[] name,String[] adress,String[] mailadress, Integer[] imageId) {
    super(context, R.layout.list_row, name);
    this.context = context;
    this.name = name;
    this.adress = adress;
    this.mailadress = mailadress;
    this.imageId = imageId;
}

```
Then for every row we set the resource for every view.
```java

@Override
public View getView(int position, View view, ViewGroup parent) {
    LayoutInflater inflater = context.getLayoutInflater();
    View rowView= inflater.inflate(R.layout.list_row, null, true);
    TextView name = (TextView) rowView.findViewById(R.id.txt);
    TextView adress = (TextView) rowView.findViewById(R.id.txt1);
    TextView mailadress = (TextView) rowView.findViewById(R.id.txt2);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
    name.setText(this.name[position]);
    adress.setText(this.adress[position]);
    mailadress.setText(this.mailadress[position]);
    imageView.setImageResource(imageId[position]);
    return rowView;
}
```
## Fragments

We have one fragmet that holds one imageview, and based on the position of the view pager the fragment shows different picture.
Here we have our create method that is called every time the users swipes the screen, and in there we are passing the position of the view pager.
```java

public static ScreenSlidePageFragment create(int pageNumber) {
    ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_PAGE, pageNumber);
    fragment.setArguments(args);
    return fragment;
}

```

In our oncreate view we simple set the resource of our imageview based on the page number. 
```java

switch (getArguments().getInt(ARG_PAGE)){
    case 0:  image.setImageResource(Location.getImage11());
        break;
    case 1:  image.setImageResource(Location.getImage12());
        break;
    case 2:  image.setImageResource(Location.getImage13());
        break;
    case 3:  image.setImageResource(Location.getImage14());
        break;
    case 4:  image.setImageResource(Location.getImage15());
        break;

}
```
One important note we are using a custom imageview for our images for the pinch to zoom effect

## Objects

We have one object for the location with properties and the getters and setters for each property. 
We have name, adress and mail address for the basic date, image1 image2 image3 for the images in the Info activity, image11, image12,image13,image14,image15 for the gallery activity.

```java
public static  String name;
public static String adress;
public static String  mailadress;
public static int banner;

public static int image1;
public static int image2;
public static int image3;

public static int image11;
public static int image12;
public static int image13;
public static int image14;
public static int image15;

```
And as it has been mentioned earlier each property has corresponding getter and setter.

## TouchImageView

Our custom class for imageview that gives image pinchtozoom effect. I did not write this class and all credits go to github user Rathor.

## Bugs

The application dosn't show croatian symbols properly, will be fixed in the next release.

