import jdk.jfr.Event;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public
class GameEvent
{
	private String eventText;
	private ArrayList<EventChoice> choices;

	/**
	 * Create a GameEvent object with text and choices.
	 *
	 * @param eventText Text that describes the event.
	 * @param choices A list with choices the player can make.
	 */
	public
	GameEvent(String eventText, ArrayList<EventChoice> choices)
	{
		this.eventText = eventText;
		this.choices = choices;
	}

	/**
	 * TODO
	 * A game event is represented on a single line of the input file.
	 * It is formatted as follows:
	 * <p>
	 * EventText;EventChoice;EventChoice;EventChoice...
	 * <p>
	 * The first part is always the eventText. There can be one or more EventChoice(s).
	 */
	public static
	GameEvent read(String input)
	{
		ArrayList<EventChoice> choices = new ArrayList<>();

		String[] spl = input.split(";");

		for (int i = 1; i < spl.length; i++)
		{
			choices.add(EventChoice.read(spl[i]));
		}

		return new GameEvent(spl[0], choices);

		/* There is a class (and read method for event choices)!
		 * Don't forget to make use of these things.
		 * You can implement this method with either a scanner or some String parsing logic.
		 * Why not look up some useful methods in the Javadoc?
		 * Here is a link: https://docs.oracle.com/en/java/javase/16/docs/api/index.html
		 */
	}

	/**
	 * Get the next event for the choice that the user made.
	 *
	 * @param userChoice The number of the choice the user made (1 based)
	 * @return The pointer to the next event.
	 */
	public
	int makeChoice(int userChoice)
	{
		EventChoice choice = choices.get(userChoice - 1);
		return choice.getNextEvent();
	}

	/**
	 * Create a human readable String representation of a game event with all choices.
	 *
	 * @return the String representation of the GameEvent
	 */
	public
	String toString()
	{
		StringBuilder output = new StringBuilder(eventText).append(
			"\n");
		for (EventChoice choice : choices)
		{
			output.append(choice.toString()).append("\n");
		}
		return output.toString();
	}

	/**
	 * Getter for the text corresponding with this event.
	 *
	 * @return The eventText.
	 */
	public
	String getEventText()
	{
		return eventText;
	}

	/**
	 * Getter for the list of choices corresponding with this event.
	 *
	 * @return The list of EventChoice.
	 */
	public
	ArrayList<EventChoice> getChoices()
	{
		return choices;
	}
}
