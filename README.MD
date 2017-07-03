AliensVsPredator (Minecraft Mod)
=============

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
