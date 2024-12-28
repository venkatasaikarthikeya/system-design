Resources:
    - https://blog.algomaster.io/p/how-to-answer-a-lld-interview-problem

### how to answer an LLD interview problem?
    - Low Level Design (LLD) or Object oriented design (OOD) interview tests your ability to translate high-level requirements into
      detailed class structures, methods and their interactions using object-oriented design principles.

### Step-by-Step approach:
    Step - 1 : Clarify requirements
    Step - 2 : Identify entities/objects
    Step - 3 : Class design
    Step - 4 : Implementation
    Step - 5 : Exception handling

### Approaches while designing your classes:
    There are two ways in which you can design your classes:
    1. Top-down approach  (Big to Small) - In this approach you will start designing a high level class and while designing this if you need another
       class, then you would deviate and go ahead and design that low level class, and so on, once you are done with the dependencies
       you would again continue building the high level class.
    2. Bottom-up approach (Small to Big) - In this approach, you will start designing the classes that don't have a dependency on other class and
       continue in this way, and design bigger classes and then ultimately build the high level classes by utilizing the low level
       classes whih you've built in the previous steps.