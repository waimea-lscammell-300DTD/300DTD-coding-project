# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a game.

You are a new mercenary joining the tf2 cast, start off by meeting the amazing scout
and get to know the other mercenaries along the way, beware what choice you choose
if you choose wrong you may pay the price. Successfully meet all of the mercs without angering
which could lead to your death.

### Game Features and Rules

The game has the following features and/or rules:

- Choose from 4 choices, which in some scenes will have less.
- This game has branching off scene which can sometimes bring you back to a previous scene.
- Death and denial and winning scenes.
- Being brought to other scenes by a choice.
- If you meet 4 mercs without dying you win.
- There is  counter for how many times you deny someone (say no) and if you get 3 denials then it adds to your kill counter

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

- UI Setup / The whole UI showing up correctly/playing the game to see if the buttons go in the right spot
- Choosing an choice and checking to see if the right sound plays / Sounds playing when you make a choice/ Go through the game and test
all of the buttons and check if their sound works.
- Testing if the denial, death and meet counters work like they should / death,denial and meet counters / test all of the different outcomes and see if the code is working right

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Testing if the right choices hide in the right scenes

I will go through the game to see if the right choices show on the right scenes and will hide any spare buttons

#### Test Data / Actions to Use

The following things I should try
- Going through every scene and restarting the game if I end up dying, making sure all of the buttons show up
- If there are buttons that show in the wrong scene or are supposed to be showing I will fix them
#### Expected Outcome

The buttons show up correctly for the right scenes

## Button sound testing

Checking if when you press a specific button on a specific scene it will play the right voiceline after you press it

#### Test Data / Actions to Use

Playing through every scenes to see if the sounds work (some scenes I purposly didnt add sound)

#### Expected Outcome

The sounds will work as I wanted them too

### Denial, death and meet counters

Checking if the Denial, death and meet counters work when I die, successfully meet a merk or deny someone.
I will also check if the death number goes up after I get 3 denials.
I also check if when you die or win it will come up in the console.

#### Test Data / Actions to Use

I will pick the death scenes first, then pick the denial scenes, and then pick the meet scenes

#### Expected Outcome

The counters should go up correctly

---


## Evidence / Results of Testing

### Sound Test

The video below shows the sounds being played when you press a choice and it will play a specific sound depending on the scene

[Sound Test](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/lscammell_waimea_school_nz/EQYJ7WB0YDdAkf1-8Shu5GcB29OwW41D3WZZaphEw_LBPg?e=zbInRE&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)

Note that if you press 2 buttons quickly that have sounds with them it will play ontop of each other

### Denail, death, meet counter test

This video below shows the player choosing the scenes where you die and the counter going up because of it, it also shows the denial counter go up (also adding to the deaths when it gets to 5) and the meet counter.
Also when the player dies it says in the console that you have won or died

[Denial, death and meet counter test](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/lscammell_waimea_school_nz/EV4bxJiikGVHo26-BbjVuGkBeZpYkkVH_URF8G_B7gFWzQ?e=miSRvF&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)

Note that the denial counter doesnt reset after you get to 5 denials


### Button Appearing test

In this video below it shows the player playng through the game, in some of the scenes there is blank spaces
if there isnt bugs then the scenes should have varying buttons showing, some might have 2, some might have 1.

[Button Appearing test](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/lscammell_waimea_school_nz/ERupSdeqY-RBu1tdioU908MBwHmIKQpsHZ12cfwgj4PGJQ?e=Kijcpj&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)

note that it is intentional that there is intentional for there to be varying button amounts

