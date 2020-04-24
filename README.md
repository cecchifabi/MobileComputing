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
