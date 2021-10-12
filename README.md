# Among Us Crusher

Breadth-first search algorithm to find the shortest path to the among us text
based game for the mentorate assignment.

The assignment was just to implement some missing Java methods in the `Game`
directory but I thought it would be cool to find the shortest path to victory.


## How to run

Make sure you have NodeJS and GCC installed.
Compile the path finding program:

```sh
g++ shortest_path.cpp -o shortest_path
```

Then run the `decode.js` file which will decode the `Game/gameContents.txt` file
into the input for our path finding program:

```sh
node decode.js
```

Last, run the path finding program with the input file:

```sh
./shortest_path < input.txt
```

The depth will be printed, and shortest path will be printed in reverse.

You can now run the game using this path and you'll get the shortest route to
victory!

### Spoiler warning

Don't look at `out.txt` if you want to figure out who the impostor is yourself.
This file is an example run of the Java program using the shortest path to
victory.