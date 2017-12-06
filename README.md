# cs56-games-tetris
Ready for F16 (Franklin Tang)

A classic game of Tetris.

project history
===============

```
 F16 | wpeery | Juan-Pacheco|  A classic tetris game.
```
# F16 Final Remarks
When we started this project it was running but there were a lot of bugs to be worked out. We fixed some of them 
but there are still a lot more that need to be worked out. The two biggest things that need to be done with the code now are:
- Refactoring (TetrisBoard.java in particular)
- Fixing bugs (issues #30 and #39 are the most gamebreaking)

The rest of the issues are either adding new features or making the game look better. Another important thing to keep in mind
is that when working on sound effects is that if you are working remotely by sshing to csil you won't be able to hear the sound.
You have to either physically be at csil or download the code and run it on your own machine at home (I used eclipse).

Good luck!

Wesley and Juan


```
 W16 | hannavigil 4pm | davzaman | FourPieces | A classic tetris game.
```

# W16 Final Remarks
The game started out very bare, and needed a lot of improvement. We are
thankful for the previous group doing most of the GUI legwork for the basics of the
game. As it stands the game is currently mostly functional and can be played fairly well.
However, the bulk of the issues that need to be taken care of involve fixing
bugs and tests (rather than new features). Most of these probably revovle around the complicated nature of the
code in the TetrisBoard class. The process of refactoring and cleaning the code is still
an ongoing one. 

Good luck, have fun!

Best,
    Skyler and Davina

### Bugs from Franklin:
- Rapid movements can cause some blocks to "shed" a one unit block that stays on screen in definitely. The block can interfere with other blocks while present.
- Instead of instantly  placing down the block on harddrop, it should be a faster animation speed so that the clearing animation is in sync.
- A slight nuance that the game has is the ability to move the blocks momentarily before solidifying in space. This could just be a feature I guess.
- No exit buttons to the main menu.
- If the block is against either wall and the left or right keys are pressed, the block will stop when contacting the wall for too long. This bug only occurs once in a while so just take note when it does occur.

### Suggestions from Franklin:
- Perhaps have a save button for if you want to play more and you don't have time.
- When the game ends, there could be a "Game over" text that overlays onto the screen.
- Tetris games usually have the blocks moving every pixel so with the grid, you can make the animation move down every pixel instead of a constant rate. (This might make it more complicated though).


```
 F17 | jesmarsc | matthewmitx | A classic tetris game.
```
# F17 Final Remarks
The core of the project had been made when we started contributing. Besides fixing some bugs and adding features, the main problems were in the organization of the code. The TetrisBoard.java file contained all of the music, controls, and menu panels. Major changes are listed below, some of which are incomplete but give a sense of direction of where we wanted to take the project.

### NEW FEATURES:
- Defeat screen window pops out when losing.
- Main menu button now available in the side panel.

### MAJOR CHANGES:
- Some menus got refactored into their own classes outside of the TetrisBoard. These menus include the main menu and difficulty menu. We refactored the side panel but experienced some resizing issues when using this refactored panel. For example, the buttons would not resize properly and the text in them would have tracing ellipses (i.e. Main Men...). The ref

- CardLayout was implemented so that contributors did not have to keep track of panel visibility. Prior to this, panel visibilty would have to be set when changing panels (i.e. .setVisible(true)). This also helped reduce code to a single .show() member function to show the desired panel. There is still a case where visibilty must be set when clicking on the rules button on the side menu.

### SUGGESTED STEPS:
1. Try to refactor the side menu panel and the rules panel (appears when clicking the rules button).
2. Add them to the CardLayout panel to allow switching between them. The desired behaviour is to hide the restart and rules button when the rules button is clicked (or you can just change this behavior).
3. If possible, continue refactoring the music methods and the KeyAdapter.
4. Finally, refactor the TetrisBoard. The TetrisBoard represents the board and grid itself. We believed that this should not have contained all the menu panels and should have been its own class. It will kind of be its own class after all the above refactoring, but it handles GUI changes as well. The goal was to make another class handle this job.

### NOTES:
- The suggested steps are difficult and provide a sizeable amount of points. Most of the small issues have been fixed and major issues remain that can be hard to fix.

- You will notice that the music methods are commented out. We did this because they would cause lag when playing the game remotely from CSIL.
 
