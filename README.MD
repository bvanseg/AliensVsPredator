[discord-shield]: https://img.shields.io/discord/269680025228410880.svg?colorB=7289DA&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHYAAABWAgMAAABnZYq0AAAACVBMVEUAAB38%2FPz%2F%2F%2F%2Bm8P%2F9AAAAAXRSTlMAQObYZgAAAAFiS0dEAIgFHUgAAAAJcEhZcwAACxMAAAsTAQCanBgAAAAHdElNRQfhBxwQJhxy2iqrAAABoElEQVRIx7WWzdGEIAyGgcMeKMESrMJ6rILZCiiBg4eYKr%2Fd1ZAfgXFm98sJfAyGNwno3G9sLucgYGpQ4OGVRxQTREMDZjF7ILSWjoiHo1n%2BE03Aw8p7CNY5IhkYd%2F%2F6MtO3f8BNhR1QWnarCH4tr6myl0cWgUVNcfMcXACP1hKrGMt8wcAyxide7Ymcgqale7hN6846uJCkQxw6GG7h2MH4Czz3cLqD1zHu0VOXMfZjHLoYvsdd0Q7ZvsOkafJ1P4QXxrWFd14wMc60h8JKCbyQvImzlFjyGoZTKzohwWR2UzSONHhYXBQOaKKsySsahwGGDnb%2FiYPJw22sCqzirSULYy1qtHhXGbtgrM0oagBV4XiTJok3GoLoDNH8ooTmBm7ZMsbpFzi2bgPGoXWXME6XT%2BRJ4GLddxJ4PpQy7tmfoU2HPN6cKg%2BledKHBKlF8oNSt5w5g5o8eXhu1IOlpl5kGerDxIVT%2BztzKepulD8utXqpChamkzzuo7xYGk%2FkpSYuviLXun5bzdRf0Krejzqyz7Z3p0I1v2d6HmA07dofmS48njAiuMgAAAAASUVORK5CYII%3D
[discord-invite]: https://discord.com/invite/4D6h2F5

[actions-shield]: https://github.com/bvanseg/ccake/actions/workflows/rust.yml/badge.svg
[actions-yml]: https://github.com/bvanseg/ccake/actions/workflows/rust.yml

[license]: https://img.shields.io/github/license/ri5ux/aliensvspredator
[code-size]: https://img.shields.io/github/languages/code-size/ri5ux/aliensvspredator

[java-lang]: https://www.java.com/
[java-shield]: https://img.shields.io/badge/Made%20with-Java-ED8B00.svg

[curse-download-shield]: https://cf.way2muchnoise.eu/full_221641_downloads.svg
[curse-files-link]: https://www.curseforge.com/minecraft/mc-mods/aliensvspredator/files

[curse-downloads-shield]: https://cf.way2muchnoise.eu/full_221641_downloads.svg
[curse-files-link]: https://www.curseforge.com/minecraft/mc-mods/aliensvspredator/files

[curse-versions-shield]: https://cf.way2muchnoise.eu/versions/221641.svg
[curse-link]: https://www.curseforge.com/minecraft/mc-mods/aliensvspredator

AliensVsPredator (Minecraft Mod)
=============
![GitHub][license]
[![java-shield][]][java-lang]
![GitHub code size in bytes][code-size]
[![discord-shield][]][discord-invite]
[![curse-downloads-shield]][curse-files-link]
[![curse-versions-shield]][curse-link]

## Links ##
* [Source]
* [Issues]

## Prerequisites ##
* [Java Development Kit 8 or Newer]
* [Gradle]

## Contributing ##
Please read the following if you plan on contributing to this project. It is very important to have your development 
environment set up properly. Aside from that, pull requests that do not follow the same format will not be accepted.

## 1) Clone The Repository ##
Open your command line, and execute the following commands:

1. `git clone git@github.com:Ri5ux/AliensVsPredator.git`
2. `cd AliensVsPredator`

## 2) Setup the Development Environment ##
__Note:__ If [Gradle] is not installed on your system, you may use ./gradlew on Unix based platforms or ./gradlew.bat
on Windows platforms.

1. Run `gradle setupDecompWorkspace` and wait for it to complete.
2. Once completed, copy `mdxlib_at.cfg` from the mdxlib jar located in your .gradle cache directory with the following structure `.gradle\caches\modules-2\files-2.1\com.arisux\mdxlib\X.X.X.X\0000000000000000000000000000000000000000\mdxlib-X.X.X.X-deobf.jar`.
3. Paste `mdxlib_at.cfg` into this repo's `src\main\resources\` directory.
4. Run `gradle setupDecompWorkspace` once more. This time, it should detect an Access Transformer. If it does not, then you have copied it to the wrong location.

## 3) Setup your IDE ##

__Note:__ If you experience any errors setting up your IDE, please run `gradle setupDecompWorkspace --refresh-dependencies`
to rule out any dependency related issues.

#### [IntelliJ IDEA]

1. `gradle idea`

#### [Eclipse]

1. `gradle eclipse`

## Updating your Repository ##

Run the following to sync your copy of the repository up with the latest changes:

* `git pull`

If you experience any new errors, it may be due to a dependency change. Please refresh your dependencies:
* `gradle --refresh-dependencies`

## Building The Project ##

1. To initiate the build process, run `gradle build`.
2. You can find the compiled project artifacts in `./build/libs`.

__Note:__ If the above entry is not added, the build process and setup process will fail.

[Source]: https://github.com/Ri5ux/AliensVsPredator
[Issues]: https://github.com/Ri5ux/AliensVsPredator/issues
[IntelliJ IDEA]: https://www.jetbrains.com/idea/
[Eclipse]: https://www.eclipse.org/
[Gradle]: https://www.gradle.org/
[Java Development Kit 8 or Newer]: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
