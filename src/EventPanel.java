import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

/**
 * EventPanel is a JPanel that displays details of an Event, such as the event name and date.
 * If the event implements Completable, a "Complete" button is displayed, allowing the user to mark the event as complete.
 */
public class EventPanel extends JPanel {

    /**
     * The Event object that this panel represents.
     */
    private Event event;

    /**
     * A JButton that allows the user to mark the event as complete.
     * This button is only visible for events that implement the Completable interface.
     */
    private JButton completeButton;

    /**
     * Constructs an EventPanel to display information about a given Event.
     * If the event is Completable, the panel will include a button to mark the event as complete.
     *
     * @param event The event to be displayed in this panel.
     */
    public EventPanel(Event event) {
        this.event = event;

        // Set the layout to BorderLayout to control the positioning of components in the panel
        setLayout(new BorderLayout());

        // Add padding around the panel for better visual separation
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setBackground(Color.lightGray);


        // Create a panel to display the event's name and date/time
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 1));  // Set GridLayout with 2 rows, 1 column

        // Format the LocalDateTime to a more readable format using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Create labels for event name and date/time
        JLabel nameLabel = new JLabel("Event: " + event.getName());
        JLabel dateTimeLabel = new JLabel("Date and Time: " + event.getDateTime().format(formatter));

        // Add the labels to the info panel
        infoPanel.add(nameLabel);
        infoPanel.add(dateTimeLabel);
        infoPanel.setBackground(Color.GRAY);

        // Add the info panel to the center of the EventPanel layout
        add(infoPanel, BorderLayout.CENTER);

        // If the event implements Completable, display the "Complete" button
        if (event instanceof Completable) {
            completeButton = new JButton("Complete");

            // Disable the "Complete" button if the event is already marked as complete
            if (((Completable) event).isComplete()) {
                completeButton.setEnabled(false);  // Button disabled if event is already completed
            }

            // Add an ActionListener to the button to mark the event as complete when clicked
            completeButton.addActionListener(e -> {
                ((Completable) event).complete();  // Mark the event as complete
                completeButton.setEnabled(false);  // Disable the button after completion
                JOptionPane.showMessageDialog(null, event.getName() + " marked as complete!");  // Notify user
            });

            // Add the "Complete" button to the bottom (south) of the EventPanel layout
            add(completeButton, BorderLayout.SOUTH);
        }
    }

    /**
     * Returns the Event object associated with this panel.
     *
     * @return The Event displayed in this panel.
     */
    public Event getEvent() {
        return event;
    }
}
