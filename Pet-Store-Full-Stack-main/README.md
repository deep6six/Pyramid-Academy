# Pet-Store-Full-Stack
## Team-Project: 2
***Team Members:***
**Jacob Stout, Joel Brinson, Kevin Drake, Randy Kim**
## Motivation
*This Program is a Full-Stack-Web-Service* We have created an online Pet-Store. This program uses Springboot, and React to allow web services. We have an **Admin Status**, where others would be a **Customer**. You can create an account, and browse our items. We have *Animals*, and *Animal Accessories* available for purchase.

## How to Run
1. Make sure to have *IntelliJ* and/or *Visual Studio Code* Installed
2. Clone the Repository to a your own **Local** Repository from [GitHub](https://github.com/Pet-Store-React-App/Pet-Store-Full-Stack)
3. Need to update some settings:
    1. IntelliJ -> settings -> Build, Execution, Deployment tab -> Build Tools -> Maven. On **Maven** Page, Select *Always update Snapshot*
    2. Visual Studio Code -> open terminal -> enter **npm i npm@latest** -> press Enter, allow time for it to run the update
4. Once Everything is updated, and IntelliJ shows that you have the *Maven* library you can then run. 
5. Create a **Customer** account, and view our selection!!!

![WebPage](https://github.com/Pet-Store-React-App/Pet-Store-Full-Stack/blob/main/Pet-Store-Page.png)

## Code Snippet
*I chose this portion of code because it shows the Animal Entity, as well as the Annotations to **Auto Generate** the Sequence of ID's for this specific entity*
```Java
@Entity
@Table(name = "tbl_animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_gen")
    @SequenceGenerator(name="animal_gen", initialValue = 2001, allocationSize = 1)
    private int id;
    private String type;
    private String name;
    private String description;
    private double price;
    private String color;

    public Animal() {
    }
```
## Tests

## Contributors
[Jacob Stout](https://github.com/JediJake66), [Joel Brinson](https://github.com/jtbrinson11), [Kevin Drake](https://github.com/KDrake80), [Randy Kim](https://github.com/deep6six)