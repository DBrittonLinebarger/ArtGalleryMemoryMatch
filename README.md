### Art Gallery Memory Match

* [User stories](docs/user-stories.md)
* [Wireframes](docs/wireframes.md)
* [Updated Wireframes](docs/wireframes-updated.pdf)
* [ERD Update](docs/memory-match-erd-update.pdf)   
* [ERD pdf](docs/memory-match-erd.pdf)  
* [ERD](docs/erd.md)
* [Milestone 2](docs/milestone-2.md)
* [Dashboard Fragment w/Spinner](docs/dashboard-fragment.PNG)
* [Data Model](docs/data-model.md)


## Art Gallery Memory Match Description

My personal Android project is called “Art Gallery Memory Match”.  Like the classic memory game, the object is to match pairs of cards. A 4 x 5 grid of cards will feature works of art from the Metropolitan Museum of Art. The user will be able to choose a theme (i.e. flowers, van Gogh, etc.) for the content of the cards. The user will also have the option to play timed or untimed rounds.  I may add the choice of difficulty levels (easy, medium, hard), where the number of cards presented will increase from level to level.
The cards will be face down at the beginning of the game. The player will flip over a pair of cards.  If the two cards match, they will be remain face up.  If the cards do not match, they will get turned back over and remain in the grid.  Play will continue until all the cards have been matched and are face up or time has expired.  Players earn points for matching pairs when playing timed rounds.

Audience: This app may appeal to those of all ages who love art, as well as to people looking to strengthen memory skills.

Data/Services Needed 
The app will need a source for artwork for the cards.  The Metropolitan Museum of Art provides access to artworks in its Collection for unrestricted commercial and noncommercial use via an API. This is what I plan to use. They do not require API users to register or obtain an API key to use the service. 

Persisting Data: User Name/ID, Round Results (highest scores/fastest time)

Primary Navigation Scheme: Bottom Navigation to allow users to move between screens to make selections (themes, timed/untimed round, difficulty level, scores, etc.).

## Motivation for Selecting Topic for App  

I decided to create this matching game to provide a fun way for users, who love art, to strengthen their memory skills.  With a background in education, I also wanted to create an app that could be used as a blueprint for reinforcing academic skills.  

## Current State of Completion  

In its current state, the app allows users to play a basic version of the memory match game.  Users are able to enter a search term to create a themed selection of cards if at least 8 images are returned.  Up to fifty images are randomly selected from the search results and stored for each theme for later use in game play.  There are several unimplemented/incomplete elements that need to be implemented or corrected for a more usable prototype:  
* facilitate faster retrieval of images for tiles in game if possible  
* add progress bar to track downloading of images





