# MVVM Architecture Android: Sample App (Hilt)
This repository contains a sample app that implements MVVM architecture using Kotlin, Hilt,
Retrofit, Coroutines, Flow, Stateflow, Room, etc.

## Major Highlights

- MVVM Architecture
- Kotlin
- Hilt
- Retrofit
- Coroutines
- Flows
- Stateflow
- View binding
- Unit Test
- Offline Support

## Dagger2 and Dagger Hilt Main Differences

## [Dagger2](https://github.com/pavanmankar/newsTrending)
- It is a fully-featured, compile-time dependency injection framework.
- Configuration: Requires a lot of boilerplate code and manual configuration.
- Learning Curve: Steeper learning curve due to its comprehensive feature set.
- Flexibility: Offers a high level of flexibility and customization.
- Use Cases: Suitable for complex.
- There are annotations defined in Dagger 2 to specify which operation to take. We will now briefly touch on these.
- [Dagger Project Link](https://github.com/pavanmankar/newsTrending)

## @Provides
The classes to be used are specified here. Dagger finds and retrieves the desired injection by looking at the @Provide methods.

## @Inject
It is used to tell Dagger what all dependencies are that need to be passed. We can use @Inject in 3 different places.
Constructors
Objects
Methods

## @Module
Classes in which @Provide annotations are used are told to Dagger with the @Module annotation.

## @Component
It’s something like a bridge between @Module and @Inject. It is used to create interfaces that connect everything. Here we define from which modules we get our dependencies.

## @Scope
It determines the life processes.

## Hilt
- Type:Hilt is a library built on top of Dagger 2, designed to simplify dependency injection in Android applications.
- Configuration: Offers simplified annotations and reduced boilerplate code compared to Dagger 2.
- Learning Curve: Easier to learn and use, especially for developers new to Dagger.
- Flexibility: Sacrifices some flexibility for ease of use and reduced setup.
- Use Cases: Aimed at Android app developers for more straightforward dependency injection.
- Annotations such as module, inject and provides are also used in Hilt. We will now briefly touch on these.

## @HiltAndroidApp
Generates the Hilt code. It should be added to the Application class.

## @AndroidEntryPoint
Thanks to this annotation, many components such as Activity, Fragment, View become ready to be @Inject.

## @HiltViewModel
Used for classes that derive from ViewModel.
For Retrofit client or database operations, when we create and @Inject objects as modules, Hilt finds those objects from within the modules and presents them to us.

## @InstallIn
This indicates that Hilt-created DI containers must be present in module bindings. We specify the scope we will use.

#### The app contains the following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding ViewModel.
4. **utils**: Utility classes.

# Application Architecture
![alt text](https://cdn-images-1.medium.com/max/1600/1*OqeNRtyjgWZzeUifrQT-NA.png)
![alt text](https://media.geeksforgeeks.org/wp-content/uploads/20210720231513/viewmodal.png)

The main advantage of using MVVM, there is no two-way dependency between ViewModel and Model, unlike MVP. Here the view can observe the data changes in the ViewModel as we are using LiveData which is lifecycle aware. The viewmodel-to-view communication is achieved through observer pattern (basically observing the state changes of the data in the viewmodel).


  ## Features Implemented

- Fetching News
- Top Headlines News
- News Based on Source
- News Based on Selection
- News Based on Language Selection
- Instant Search using Flows Operator
  * Debounce
  * Filter
  * DistinctUntilChanged
  * FlatMapLatest
  * Map
- Unit Test
  - Mockito
  - JUnit
  - [Turbine](https://github.com/cashapp/turbine/)

### License

```
   Copyright (C) 2022

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0
