import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * AddEventModal is a modal dialog that allows users to create and add a new event (either a Meeting or Deadline)
 * to the EventListPanel. The user can enter the event name, type, date and time, and location (for meetings).
 */
public class AddEventModal extends JDialog {

    /**
     * A JTextField to enter the name of the event.
     */
    private JTextField nameField;

    /**
     * A JComboBox that allows the user to choose between adding a "Meeting" or "Deadline".
     */
    private JComboBox<String> eventTypeDropdown;

    /**
     * A JTextField for entering the event's date and time in the format "yyyy-MM-ddTHH:mm".
     */
    private JTextField dateTimeField;

    /**
     * A JTextField to enter the location of the event (only used for meetings).
     */
    private JTextField locationField;

    /**
     * A reference to the EventListPanel where the new event will be added.
     */
    private EventListPanel eventListPanel;

    /**
     * Constructs an AddEventModal dialog, setting up the form fields and the add event button.
     *
     * @param eventListPanel The EventListPanel to which the new event will be added.
     */
    public AddEventModal(EventListPanel eventListPanel) {
        this.eventListPanel = eventListPanel;

        // Set the title and size of the modal dialog
        setTitle("Add Event");
        setSize(400, 300);
        setLayout(new GridLayout(6, 1));  // Use a GridLayout with 6 rows for the form fields

        // Event Name input field
        nameField = new JTextField();  // Create a text field for the event name
        add(new JLabel("Event Name:"));  // Add label for the name field
        add(nameField);  // Add the name field itself

        // Event Type dropdown to select between "Meeting" and "Deadline"
        eventTypeDropdown = new JComboBox<>(new String[]{"Meeting", "Deadline"});
        eventTypeDropdown.addActionListener(e -> toggleLocationField());  // Change form behavior based on event type
        add(new JLabel("Event Type:"));  // Add label for the event type dropdown
        add(eventTypeDropdown);  // Add the dropdown itself

        // Date and Time input field for the event's starting time
        dateTimeField = new JTextField("2024-09-25T15:00");  // Prepopulate with an example datetime
        add(new JLabel("Event Date and Time:"));  // Add label for the date and time field
        add(dateTimeField);  // Add the date and time field itself

        // Location input field (only visible for meetings)
        locationField = new JTextField();  // Create a text field for the location of the meeting
        add(new JLabel("Location (for Meetings):"));  // Add label for the location field
        add(locationField);  // Add the location field itself

        // Button to add the event
        JButton addButton = new JButton("Add Event");
        addButton.addActionListener(e -> addEvent());  // Attach action listener to handle adding the event
        add(addButton);  // Add the button itself
    }

    /**
     * Toggles the visibility of the location field based on the selected event type.
     * If the user selects "Meeting", the location field will be shown. If "Deadline" is selected, it will be hidden.
     */
    private void toggleLocationField() {
        String selected = (String) eventTypeDropdown.getSelectedItem();  // Get the selected event type
        locationField.setVisible("Meeting".equals(selected));  // Show location field only if "Meeting" is selected
    }

    /**
     * Adds the new event (either a Meeting or Deadline) to the EventListPanel.
     * If the event is a Meeting, a location and default duration are added.
     * If the event is a Deadline, only the name and date are needed.
     */
    private void addEvent() {
        // Get the event name and date/time from the input fields
        String name = nameField.getText();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeField.getText());

        // Check if the event type is a Meeting
        if ("Meeting".equals(eventTypeDropdown.getSelectedItem())) {
            String location = locationField.getText();  // Get the location for the meeting
            LocalDateTime endDateTime = dateTime.plusHours(1);  // Set default meeting duration to 1 hour
            // Add the Meeting event to the EventListPanel wrapped in an EventPanel
            eventListPanel.addEvent(new EventPanel(new Meeting(name, dateTime, endDateTime, location)));
        } else {
            // Add the Deadline event to the EventListPanel wrapped in an EventPanel
            eventListPanel.addEvent(new EventPanel(new Deadline(name, dateTime)));
        }

        // Close the modal after adding the event
        dispose();
    }
}
