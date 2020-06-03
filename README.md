# MjRangeBar


The MjRangeBar is android RangeBar Graph library that adds some basic material styling, as well as start and end values of range bar,start and end values of Range and item value as floats and some other things using views and Canvas.

**Developers can customize the following attributes (programmatically):**

  - Background Color
  - RangeBar Selected Color
  - RangeBar Stroke Color
  - Magic
  - Min & Max Text Color
  - Value Text Color
  - Circle Color
  - out Of Bound Text Color
  
  **Supported on API Level 15 and above.**
  
  ![github-small](https://github.com/m-jayy/MjRangeBar/blob/master/screenshots/ss1.png)

# How to Use
In your project build.gradle. Add the following lines
```Gradle
Allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
In your app build.gradle. Add the following lines
```Gradle
implementation 'com.github.m-jayy:MjRangeBar:0.1.0'
```

# Examples
#### Layout XML
```XML
  <com.mohsin.rangebar_graph.RangeBarGraph
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:layout_gravity="center_horizontal"
        android:paddingBottom="90dp"
        android:adjustViewBounds="true"
        />
```
#### Java
```Java
RangeBarGraph = (RangeBarGraph) findViewById(R.id.RangeBarGraph);
RangeBarGraph.setValues(0.0, 400.0, 130.0, 350.0, 80.0);

//        RangeBarGraph.setRangeBarBackgroundColor("ffffff");
//        RangeBarGraph.setRangeBarStrokeColor("#eaeaea");
//        RangeBarGraph.setRangeBarSelectedColor("#eaeaea");
//        RangeBarGraph.setRangeBarValueTextColor("#333333");
//        RangeBarGraph.setRangeBarMinMaxTextColor("#333333");
//        RangeBarGraph.setvalueCircleColor("#333333");
//        RangeBarGraph.setoutOfBoundColor("#FF0000");
```


![github-small](https://github.com/m-jayy/MjRangeBar/blob/master/screenshots/ss2.png)

# Plan for Future

 - Better documentation.
 - Kotlin conversion
 - Add more functionality
 

# License

**Free Software, Hell Yeah!** :metal:



# Contribution
We'd love for you to participate in the development of our project. So we need all the help we can get. You are always welcome to contribute and help us maintain the library.


