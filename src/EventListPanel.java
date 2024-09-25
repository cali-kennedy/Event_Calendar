import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.awt.Color.*;

/**
 * EventListPanel is a JPanel that manages the display of EventPanel objects,
 * providing functionalities for sorting, filtering, and adding events.
 */
public class EventListPanel extends JPanel {

    /**
     * A list of EventPanel objects, representing the events added to the event list.
     */
    private ArrayList<EventPanel> eventPanels;

    /**
     * The main panel to display the list of EventPanel objects.
     * Each EventPanel is displayed vertically in this panel.
     */
    private JPanel displayPanel;

    /**
     * A JComboBox that allows users to sort the event list by name or date.
     */
    private JComboBox<String> sortDropDown;

    // Checkboxes for filtering options
    private JCheckBox hideCompletedCheckBox;
    private JCheckBox hideDeadlinesCheckBox;
    private JCheckBox hideMeetingsCheckBox;

    /**
     * Constructs the EventListPanel and initializes the layout, control panel,
     * sorting and filtering options, and event list display area.
     */
    public EventListPanel() {
        // Set the layout for the main panel to BorderLayout
        setLayout(new BorderLayout());

        // Initialize the list that holds the EventPanel objects
        eventPanels = new ArrayList<>();

        // Create the display panel that will show EventPanels, and set it to stack vertically
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        // Initialize the control panel for sorting and filtering options
        JPanel controlPanel = new JPanel(new FlowLayout());

        // Create and set up the sorting dropdown
        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Reverse Name", "Sort by Date"});
        sortDropDown.addActionListener(e -> sortEvents());  // Attach sorting functionality
        controlPanel.add(sortDropDown);

        // Create and set up the "Hide Completed" checkbox
        hideCompletedCheckBox = new JCheckBox("Hide Completed");
        hideCompletedCheckBox.addActionListener(e -> refreshDisplay());  // Refresh display when toggled
        controlPanel.add(hideCompletedCheckBox);

        // Create and set up the "Hide Deadlines" checkbox
        hideDeadlinesCheckBox = new JCheckBox("Hide Deadlines");
        hideDeadlinesCheckBox.addActionListener(e -> refreshDisplay());  // Refresh display when toggled
        controlPanel.add(hideDeadlinesCheckBox);

        // Create and set up the "Hide Meetings" checkbox
        hideMeetingsCheckBox = new JCheckBox("Hide Meetings");
        hideMeetingsCheckBox.addActionListener(e -> refreshDisplay());  // Refresh display when toggled
        controlPanel.add(hideMeetingsCheckBox);

        // Add Event Button to allow adding a new event via AddEventModal
        JButton addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> {
            AddEventModal addEventModal = new AddEventModal(this);  // Create the modal for adding events
            addEventModal.setVisible(true);  // Make the modal visible
        });
        controlPanel.add(addEventButton);

        // Add the control panel (for sorting, filtering, and adding events) to the top (NORTH) of the layout
        add(controlPanel, BorderLayout.NORTH);

        // Create a scrollable view for the display panel and add it to the center
        JScrollPane scrollPane = new JScrollPane(displayPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Adds a new EventPanel to the list and refreshes the display to show the added event.
     *
     * @param eventPanel The EventPanel to be added to the event list.
     */
    public void addEvent(EventPanel eventPanel) {
        eventPanels.add(eventPanel);   // Add the event panel to the list
        displayPanel.add(eventPanel);  // Add the event panel to the display panel
        displayPanel.revalidate();     // Revalidate to update the layout after adding the new component
        displayPanel.repaint();        // Repaint the display to ensure it appears visually
    }

    /**
     * Refreshes the event list display based on the current filter settings
     * (completed events, deadlines, meetings) and applies the selected filters.
     */
    private void refreshDisplay() {
        displayPanel.removeAll();  // Remove all existing components from the display panel

        // Iterate through each EventPanel and apply the filters
        for (EventPanel eventPanel : eventPanels) {
            Event event = eventPanel.getEvent();  // Retrieve the event object from the panel

            // If "Hide Completed" is selected and the event is completed, skip adding it to the display
            if (hideCompletedCheckBox.isSelected() && event instanceof Completable && ((Completable) event).isComplete()) {
                continue;
            }

            // If "Hide Deadlines" is selected and the event is a Deadline, skip adding it to the display
            if (hideDeadlinesCheckBox.isSelected() && event instanceof Deadline) {
                continue;
            }

            // If "Hide Meetings" is selected and the event is a Meeting, skip adding it to the display
            if (hideMeetingsCheckBox.isSelected() && event instanceof Meeting) {
                continue;
            }

            // Add the filtered event panels back to the display panel
            displayPanel.add(eventPanel);
        }

        // Revalidate and repaint the display panel to reflect the filtered results
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /**
     * Sorts the event list based on the selected sorting option in the dropdown.
     * Options include sorting by name, reverse name, or by event date.
     */
    private void sortEvents() {
        // Get the selected sorting option from the sortDropDown
        String selected = (String) sortDropDown.getSelectedItem();

        // Perform sorting based on the selected option
        if ("Sort by Name".equals(selected)) {
            eventPanels.sort(Comparator.comparing(e -> e.getEvent().getName()));  // Sort alphabetically by name
        } else if ("Sort by Reverse Name".equals(selected)) {
            eventPanels.sort((e1, e2) -> e2.getEvent().getName().compareTo(e1.getEvent().getName()));  // Reverse alphabetical
        } else if ("Sort by Date".equals(selected)) {
            eventPanels.sort(Comparator.comparing(e -> e.getEvent().getDateTime()));  // Sort by date
        }

        // Refresh the display after sorting
        refreshDisplay();
    }
}
