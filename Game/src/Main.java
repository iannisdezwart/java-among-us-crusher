import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main
{

	private static ArrayList<String> lines;
	private static Scanner userInput;

	public static void
	main(String[] args) throws FileNotFoundException
	{
		lines = new ArrayList<>();
		userInput = new Scanner(System.in);
		File gameContests = new File("gameContents.txt");
		Scanner fileScanner = new Scanner(gameContests);

		while (fileScanner.hasNextLine())
		{
			lines.add(fileScanner.nextLine());
		}

		// Start the game loop with event index 0.
		// As long as the next event is not -1 the game continuous.
		// Call the processEvent method in the loop to process the next event.
		int nextEvent = 0;
		while (nextEvent != -1)
		{
			nextEvent = processEvent(nextEvent);
		}
	}

	/**
	 * Takes an event index, processes it to a GameEvent, lets the user make a choice,
	 * and finally returns the index of the next event.
	 *
	 * @param event The index of the event that needs to be processed
	 * @return The index of the next event.
	 */
	private static int
	processEvent(int event)
	{
		// Retrieve the String corresponding to the event index and convert it to a GameEvent.
		String eventLine = lines.get(event);
		GameEvent currentEvent = GameEvent.read(eventLine);

		// Show the user the event and their choices and ask them to make a choice.
		System.out.println(currentEvent.toString());
		System.out.println(
			"What do you do? Choose a number that corresponds with an option: ");
		int userChoice = userInput.nextInt();

		// Return the index of the next event based on the choice of the user.
		return currentEvent.makeChoice(userChoice);
	}

}
