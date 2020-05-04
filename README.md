# MobileComputing
Repository for the course of Mobile Computing

## Homework 1: HW1_Dialler
Build an app that acts as a dialler, with a “keypad” to enter the number to call.

Start with the simplest approach possible. When you press the dial button, a call
should be started (just hand-over to the “real” built-in dialler, using an [implicit Intent](https://developer.android.com/guide/components/intents-common?hl=en#Phone)).
You should add a set of 3 “speed dial” buttons.

When the user does a long press on one of these “speed dials”, a secondary activity
(or fragment) is offered to allow the user to update the speed dial details (the label 
and associated number).

__Note:__ you don’t need to save the definition of the speed dials, but if you choose to, 
consider using [SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences).

## Homework 2: HW2_Weather_Forecasts
Build an app that offers a weather forecast.

The user should, first, select the city of interest (from a limited list of cities)
and then get the forecast for the upcoming days (for the selected city).

The app should make use of fragments (and RecyclerView) and offer two layout arrangements
(“landscape” and large diagonal; “normal” screen). The weather forecast content should 
be obtained by invoking an external API. 

A sample project [NextWeather](https://gitlab.com/ico_gl/ua-cm-gs) is available to demonstrate the use of the IPMA API
(using the [Retrofit library](https://guides.codepath.com/android/Consuming-APIs-with-Retrofit)).

I used the following API: [OpenWeather One Call API](https://openweathermap.org/api/one-call-api).

For the API calls, I used [Fast Android Networking](https://medium.com/@filswino/making-rest-calls-download-upload-files-with-one-line-of-code-on-android-no-retrofit-needed-5c0574f41476).
