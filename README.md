# cs56-games-tetris
Ready for F16 (Franklin Tang)

A classic game of Tetris.

project history
===============
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

<h2>Bugs from Franklin:<h2>
- **Rapid movements can cause some blocks to "shed" a one unit block that stays on screen in definitely. The block can interfere with other blocks while present.
- **Instead of instantly  placing down the block on harddrop, it should be a faster animation speed so that the clearing animation is in sync.
- **A slight nuance that the game has is the ability to move the blocks momentarily before solidifying in space. This could just be a feature I guess.
- **No exit buttons to the main menu.
- **If the block is against either wall and the left or right keys are pressed, the block will stop when contacting the wall for too long. This bug only occurs once in a while so just take note when it does occur.
- **Music button should be able to change states to indicate whether it's on or not. I cannot hear any music either so maybe that's a bug as well.
- **When the game ends, the screen shouldn't reset and clear all the blocks.

<h2>Suggestions from Franklin:<h2>
- **Perhaps have a save button for if you want to play more and you don't have time.
- **When the game ends, there could be a "Game over" text that overlays onto the screen.
- **Have a grid so that the players can see where their blocks are landing.
- **Tetris games usually have the blocks moving every pixel so with the grid, you can make the animation move down every pixel instead of a constant rate. (This might make it more complicated though).
