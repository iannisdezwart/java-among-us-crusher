import java.util.Scanner;

public
class EventChoice
{

	private String choiceText;
	private int nextEvent;

	/**
	 * Create a new EventChoice object
	 *
	 * @param choiceText The text describing the choice.
	 * @param nextEvent Pointer to the next event in the list.
	 */
	public
	EventChoice(String choiceText, int nextEvent)
	{
		this.choiceText = choiceText;
		this.nextEvent = nextEvent;
	}

	public static
	EventChoice read(String input)
	{
		String[] spl = input.split("&");
		return new EventChoice(spl[0], Integer.parseInt(spl[1]));
	}

	/**
	 * Getter for the next event
	 *
	 * @return Pointer towards the event after this choice
	 */
	public int
	getNextEvent()
	{
		return nextEvent;
	}

	/**
	 * Getter for the text corresponding to this choice
	 *
	 * @return The choice text.
	 */
	public String
	toString()
	{
		return choiceText;
	}
}
