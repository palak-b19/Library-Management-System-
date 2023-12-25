# Library-Management-System-
You can use the interface either as a librarian or as a student. A librarian manages members/students and books of the library. A librarian can view, register or remove members. They can also view books, add a book, remove a book, issue a book and collect dues/fines. The fine is applied as 3 rupees per day post the return due date of a book

Abstract Class


1. The Animal Class has been made abstract, containing fields like name, sound, feed and
description. It has appropriate getter and setter methods for every field. It has abstract
methods for sound(), feed(). The concrete implementation for each has been provided
in the subclasses of the Animal class.
2. The classes Mammal(), Amphibian() and Reptile() extend the Animal class and also
provide concrete implementation of the abstract methods defined in the Animal Class
along with overriding the toString method.
Interfaces
1. The Offer interface has been created which has one method applyOffer(). The concrete
implementation for the same is provided in the classes Discounts and specialDeals.
2. Discounts and specialDeals are both types of offer available to the visitors of the zoo,
but are implemented differently, therefore both implement a common interface.
3. Both Discounts and specialDeals have data members and member functions unique to
them plus the applyOffer function which is applied differently for both the classes.
Object Class
1. The toString() method of the object class has been overridden in the Mammal,
Amphibian, Reptile, Discounts and specialDeals classes.
2. The .equals() method of the object class is used to compare strings at many places in
the code.
3. While creating objects of animals, discounts and specialDeals to preload them into the
system, I created them all with the declared type of class object and actual type of
respective animal (mammal, amphibian, reptile or discount and special deal.
4. I typecasted these objects into appropriate types, so that they could be loaded into the
system. (In the Main class)
5. Ex: Object morethan2 = new specialDeals(15,2);
ZooTopia.setdealsHashMap(dealID, (Offer) morethan2);
Inheritance
1. Mammal, Amphibian and Reptile class extend the abstract class Animal and inherit its
properties. Discounts and specialDeals implement the Offers Interface, inheriting the
common properties and implementing them.
Polymorphism
1. I have made Objects with declared type Animal and actual type Mammal, Amphibian
and Reptile. Objects with declared type Offer have also been created and type casted
into Discounts and specialDeals.
2. I have created HashMap<Integer, Animal> and HashMap<Integer, Offer>, However
I store objects of actual type Mammal, Reptile and Amphibian in Animal HashMap, and
Of actual type Discounts and specialDeals in Offer HashMap. (RunTime Polymorphism)
3. I have created 2 constructors in the Visitor Class, with different parameters i.e. multiple
methods with the same name but different parameters within the same class. (Compile
Time Polymorphism)
Association
1. Zoo has an admin object as one of its attributes, An admin is initialized every time we
initialize an instance of Zoo. We instantiate a Zoo in the main method at the beginning
of the code.
Encapsulation
1. Encapsulation has been done in every class by declaring the fields as private and
creating appropriate getters and setters for all the fields. Member functions have been
kept public unless necessary to keep them private (such as in case of helper functions)
