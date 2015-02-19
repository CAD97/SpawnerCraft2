# SpawnerCraft
Recoding of SpawnerCraft mod for Minecraft 1.8, using Forge

SpawnerCraft is a part of my "Nearly Vanilla" series of mods. This series intends to introduce small gameplay changes
into the game to make more things within the game available and convenient, while maintaining balance.

SpawnerCraft allows a player to create their own spawners wherever they wish, while (by default) still requiring the
player to find a generated spawner, therefor keeping the element of exploration and reward in vanilla, while adding the
possiblility to move spawners (with a bit of work) or even obtain a non-standard spawner that is not available in a
survival map normally.

## Installing
### From Source
* Install git (or a git GUI) to your machine.
* In the folder where you want to save the repo, do:
```bash
> git clone https://github.com/CAD97/SpawnerCraft2.git
> cd SpawnerCraft2
> gradlew setupDecompWorkspace idea | eclipse
```
(use idea OR eclipse, not both. Whichever is appropriate for your machine)
* Point your IDE to the appropriate folder and code away
* If you want to build the latest, replace the last command with `> gradlew build` and use the .jar it builds
(Located in .\build\libs)

### From Release
1. Go to the [releases](https://github.com/CAD97/SpawnerCraft2/releases) tab
2. Download the version that you want
3. Drop into the mods folder of your local Forge installation
4. Enjoy!

## Naming Conventions
When I upload a binary .jar to the releases tab, I name it by one of two conventions:
### Release
`MCversion-MODversion`
### Prerelease
`MCversion-YYYY.MM.DD-HH.MM` with optional tag `-rc` for a release candidate

The version within the mod will refer to the next version most of the time. Please refer back to the .jar to see what
version you are using.

## Contributing
### Pull Requests
Create a pull request. I will see it. If you put something meaningful in the description box (or it is self-descriptive,
like `add fr_FR.lang`), I will do one of four things. A. Respond how you can improve your pull request. B. Respond and
then merge your pull request. C. Respond why your pull request does not meet my vision. D. Respond and then code what
was in your pull request myself, if I like it but not your implementation.
### Issues
Submit a bug report. I will see it. If you put something meaningful in the description box, I will attempt to fix it.
If you also submit a pull request to fix the issue, I will thank you gratefully and then consider the pull request.
### Feature Request
Submit a bug report with tag `Enhancement`, and explain why you think the feature would fit into this mod. I will see it
and consider it.

## License
See LICENSE. This source is Open Source under the GNU GPL 3. As such, you may do anything permitted by that license.
If you need more permissions, contact me and I'll likely give them to you. You may use this mod in a modpack without
asking, as long as you link to this repository or another front-end of this mod posted by me, CAD97, somewhere visible.

## If I disappear
Don't panic. Make some activity that sends me an email. I will respond.
