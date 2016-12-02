# cs56-games-tetris
Ready for F16 (Franklin Tang)

A classic game of Tetris.

project history
===============

```
 F16 | wpeery | Juan-Pacheco|  A classic tetris game.
```
<h2>##F16 Final Remarks</h2>
When we started this project it was running but there were a lot of bugs to be worked out. We fixed some of them 
but there are still a lot more that need to be worked out. The two biggest things that need to be done with the code now are:
1. Refactoring (TetrisBoard.java in particular)
2. Fixing bugs (issues #30 and #39 are the most gamebreaking)
The rest of the issues are either adding new features or making the game look better. Another important thing to keep in mind
is that when working on sound effects is that if you are working remotely by sshing to csil you won't be able to hear the sound.
You have to either physically be at csil or download the code and run it on your own machine at home (I used eclipse).
Good luck!
- Wesley and Juan


```
 W16 | hannavigil 4pm | davzaman | FourPieces | A classic tetris game.
```

<h2>##W16 Final Remarks</h2>
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

<h2>Bugs from Franklin:</h2>
- Rapid movements can cause some blocks to "shed" a one unit block that stays on screen in definitely. The block can interfere with other blocks while present.
- Instead of instantly  placing down the block on harddrop, it should be a faster animation speed so that the clearing animation is in sync.
- A slight nuance that the game has is the ability to move the blocks momentarily before solidifying in space. This could just be a feature I guess.
- No exit buttons to the main menu.
- If the block is against either wall and the left or right keys are pressed, the block will stop when contacting the wall for too long. This bug only occurs once in a while so just take note when it does occur.
- When the game ends, the screen shouldn't reset and clear all the blocks.

<h2>Suggestions from Franklin:</h2>
- Perhaps have a save button for if you want to play more and you don't have time.
- When the game ends, there could be a "Game over" text that overlays onto the screen.
- Tetris games usually have the blocks moving every pixel so with the grid, you can make the animation move down every pixel instead of a constant rate. (This might make it more complicated though).
