# Art Gallery Memory Match

* [User stories](docs/user-stories.md)
* [Wireframes](docs/wireframes.md)    
* [ERD pdf](docs/memory-match-erd.pdf)  
* [ERD](docs/erd.md)




## Art Gallery Memory Match Description


My final Android project is called “Art Gallery Memory Match”.  Like the classic memory game, the object is to match pairs of cards. A 4 x 5 grid of cards will feature works of art from the Metropolitan Museum of Art. The user will be able to choose a theme (i.e. flowers, van Gogh, etc.) for the content of the cards. The user will also have the option to play timed or untimed rounds.  I may add the choice of difficulty levels (easy, medium, hard), where the number of cards presented will increase from level to level.
The cards will be face down at the beginning of the game. The player will flip over a pair of cards.  If the two cards match, they will be removed from the game.  If the cards do not match, they will get turned back over and remain in the grid.  Play will continue until all the cards have been matched and removed or time has expired.  Players earn points for matching pairs when playing timed rounds.

Audience: This app may appeal to those of all ages who love art, as well as to people looking to strengthen memory skills.

Data/Services Needed 
I will need a source for artwork for the cards.  The Metropolitan Museum of Art provides access to artworks in its Collection for unrestricted commercial and noncommercial use via an API. This is what I plan to use. They do not require API users to register or obtain an API key to use the service. 

Persisting Data: User Name/ID, Round Results (highest scores/fastest time)

Primary Navigation Scheme: Bottom Navigation to allow users to move between screens to make selections (themes, timed/untimed round, difficulty level, scores, etc.).
