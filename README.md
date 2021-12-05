# DemoBlazeTask

This is a maven project.

Java language and OOP concept(Encapsulation,Inheritence,Abstraction,Polymorphism) has been used.

Build up with Cucumber-Junit framework.(Feature File,StepDefinitions,Runner class, Hooks)

Resources/Feature file where I keep scenarios. It is written with plain English by using Gherkin Language.

Step Definitions are java classes where all java code is written in it.

Runner class is text executer. Working with Tags. it also has rerun and report extension.

Hooks class is where I keep my before and after method.


Page Object Model design pattern has been used.(Configuration properties,Configuration readers,pages,Utilities)

Pom.xml is brain of our project I put all kind of dependencies and libraries needed.
Configuration Properties is a central for saving all necesary data(url,browser,credentials).
Pages are each web page has a corresponding java class where I keep all necesary locators and methods.
Utilities folder has Driver,Browser Utils and Configuration Readers class.

The task can be run in different browsers as chrome,firefox.

Because of my internet connection I put waits before some steps(otherwise my tests were failed) but if the environment fast they are not necessary.

Reports:
Default-html-reports and cucumber-html-reports are implemented in Target folder that you can see them as well.



