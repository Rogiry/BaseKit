# BaseKit #
BaseKit is contain that Activity, Application and Basic Method for android.

# Download #

### Maven ###

Download the latest JAR or grab via Maven:

```gradle
<dependency>
  <groupId>com.rogiry</groupId>
  <artifactId>basekit</artifactId>
  <version>0.0.1</version>
  <type>pom</type>
</dependency>
```

### Gradle ###
```gradle
compile 'com.rogiry:basekit:{lastest-version}'
```

and Add repository

```gradle
repositories {
    ...
    maven {
        url 'https://dl.bintray.com/rogiry/AndroidLib/'
    }
}
```

(The add repository process will delete after jcenter Sync)




# Usage #
There are two way use it.

First, using generic application.
set name is 'com.rogiry.basekit.BaseApplication'

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.rogiry.basekit.example">

    <application
        android:name="com.rogiry.basekit.BaseApplication">
        ...
    </application>

</manifest>
```

Second, CustomApplication extend BaseApplication.
extend BaseApplication

```java
public class CustomApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }
    ...
}

```

and, Sets the name in the application tag of the manifest file.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.rogiry.basekit.example">

    <application
        android:name=".CustomApplication">
        ...
    </application>

</manifest>
```



### __Important__ ###
Always extend BaseActivity when using Activities.

```java
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add Your logic...
        ...
    }
}
```

