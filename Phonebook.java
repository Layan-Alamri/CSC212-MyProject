
package csc212_project;
// Importing Scanner class for reading input data from the user
import java.util.Scanner;

// This class represents a Phonebook application
public class Phonebook {

     // Creating a Scanner object to read input data from the user
    public static Scanner input = new Scanner(System.in);

    // Creating a BST to store contacts
    public static BST<String, Contact> contacts = new BST<String, Contact>();

    // Creating a linked list to store events
    public static LinkedList<Event> events = new LinkedList<Event>();

 
    // This method displays the main menu and returns user's choice
    public static int option() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event/appointment");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");
        System.out.print("\nEnter your choice: ");
        
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        System.out.println();
        return choice;
    }

    // This method displays the menu for searching contacts and returns user's choice
    public static int criteria1() {
        System.out.println("Enter search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email Address");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.print("\nEnter your choice: ");
        
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        System.out.println();
        return choice;
    }

    // This method displays the submenu for scheduling events and returns user's choice
    public static int criteria2() {
        System.out.println("Enter type:");
        System.out.println("1. event");
        System.out.println("2. appointment");
        System.out.print("\nEnter your choice: ");
        
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        System.out.println();
        return choice;
    }
    
    // This method displays the submenu for searching events and returns user's choice
    public static int criteria3() {
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event tittle");
        System.out.print("\nEnter your choice: ");
        
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        System.out.println();
        return choice;
    }

    // 1. Add a contact
    // This method allows the user to add a new Contact to the phonebook
    public static void AddContact() {
        Contact con = new Contact();

        System.out.print("Enter the contact's name: ");
        con.name = input.nextLine();
        if (!contacts.empty() && contacts.findkey(con.name)) {
            System.out.println("There is a contact with the same name you entered!");
            return;
        }

        System.out.print("Enter the contact's phone number: ");
        con.phoneNumber = input.nextLine();
        if (!contacts.empty() && (contacts.SearchPhone(con.phoneNumber))) {
            System.out.println("There is a contact has same phone number you entered!");
            return;
        }

        System.out.print("Enter the contact's email address: ");
        con.emailAddress = input.nextLine();

        System.out.print("Enter the contact's address: ");
        con.address = input.nextLine();

        System.out.print("Enter the contact's birthday: ");
        con.birthday = input.nextLine();

        System.out.print("Enter any notes for the contact: ");
        con.notes = input.nextLine();

        if (contacts.insert(con.name, con))
            System.out.println("\nContact added successfully!");

    }//End method AddContact()

        // 2. Search for a contact
    // This method allows the user to search for a contact based on various criteria
    public static void SearchContact() {
        if (contacts.empty())
            System.out.println("No Contacts have been added yet!");
        else {
            int choice = criteria1();
            switch (choice) {
                case 1: {
                    // Search for contact by name
                    System.out.print("Enter the contact's name: ");
                    String name = input.nextLine();

                    if (!contacts.empty() && contacts.findkey(name)) {
                        System.out.println("Contact found!");

                        System.out.println(contacts.retrieve().toString());
                        break;
                    }
                    System.out.println("Contact not found!");
                }
                    break;

                case 2: {
                    // Search for contact by phone number
                    System.out.print("Enter the contact's phone number:");
                    String phoneNumber = input.nextLine();

                    if (!contacts.empty() && contacts.SearchPhone(phoneNumber)) {
                        System.out.println("Contact found!");

                        System.out.println(contacts.retrieve());
                        break;
                    }
                    System.out.println("Contact not found!");
                }
                    break;

                case 3: {
                    // Search for contact by email address
                    System.out.print("Enter the contact's email address: ");
                    String emailAddress = input.nextLine();

                    if (!contacts.empty()) {
                        contacts.SearchEmail(emailAddress);
                        System.out.println("Contact found!");
                        break;
                    }
                    System.out.println("Contact not found!");

                }
                    break;

                case 4: {
                    // Search for contact by address
                    System.out.print("Enter the contact's address: ");
                    String address = input.nextLine();

                    if (!contacts.empty()) {
                        contacts.SearchAddress(address);
                        System.out.println("Contact found!");
                        break;
                    }
                    System.out.println("Contacts not found!");
                }
                    break;

                case 5: {
                    // Search for contact by birthday
                    System.out.print("Enter the contact's Birthday: ");
                    String birthday = input.next();

                    if (!contacts.empty()) {
                        contacts.SearchBirthday(birthday);
                        System.out.println("Contact found!");
                        break;
                    }
                    System.out.println("Contact not found!");
                }
            }
        }
    }// End method SearchContact.

    // 3. Delete a contact
    // This method allows the user to delete a contact from the phonebook
    public static void DeleteContact() {
        Contact c = new Contact();

        if (contacts.empty())
            System.out.println("No Contacts have been added yet!");
        else {
            System.out.print("Enter the contact's name: ");
            c.name = input.nextLine();

            if (!contacts.findkey(c.name))
                System.out.println("Contact not found!");
            else {
                c = contacts.retrieve();
                contacts.removeKey(c.name);
                if (!c.events.empty()) {
                    c.events.findFirst();
                    for (int i = 0; i < c.events.size; i++) {
                        Event e = c.events.retrieve();
                        if ((!events.empty()) && events.search(e)
                                && (events.retrieve().date.compareTo(e.date) == 0)
                                && (events.retrieve().time.compareTo(e.time) == 0)
                                && (events.retrieve().location.compareTo(e.location) == 0)
                                && (events.retrieve().EventType == e.EventType)) {
                            Event Update_Event = events.retrieve();

                            Update_Event.removeContact(c.name);
                            if (Update_Event.contacts_names.empty()) {
                                events.remove(e);
                                System.out.println("Delete event, No cantact particapate");
                            } else
                                events.update(Update_Event);
                        }
                        c.events.findNext();
                    }
                }
                System.out.println("Contact Deleted Successfully !");
                System.out.println(c);
            }
        }
    } //End method DeleteContact.

  // 4. Schedule an event
    // This method allows the user to schedule an event and associate it with a contact
    public static void ScheduleEvent() {
        if (contacts.empty()) {
            System.out.println("No Contacts have been added yet!");
            return;
        }

        Contact c = new Contact();
        Event e = new Event();

        boolean event_Updated = false;
        boolean Added_Event_To_Contact = false;

        int choice = criteria2();
        String type;
        if (choice == 1) {
            type = "Event";
            e.EventType = true;
            System.out.print("Enter event title: ");
            e.title = input.nextLine();

            System.out.print("Enter contacts name separated by a comma: ");
            String line = input.nextLine();
            String[] names = line.split(",");

            System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
            e.date = input.next();

            e.time = input.next();

            System.out.print("Enter event location: ");
            input.nextLine();
            e.location = input.nextLine();

            for (int i = 0; i < names.length; i++) {
                c.name = names[i].trim();

                if (!contacts.empty() && contacts.findkey(c.name) == true) {
                    c = contacts.retrieve();
                    Added_Event_To_Contact = c.addEvent(e);
                    if (Added_Event_To_Contact) {
                        // event added to contact
                        contacts.update(c.name, c);
                        if ((!events.empty()) && events.search(e)
                                && (events.retrieve().date.compareTo(e.date) == 0)
                                && (events.retrieve().time.compareTo(e.time) == 0)
                                && (events.retrieve().location.compareTo(e.location) == 0)
                                && (events.retrieve().EventType == e.EventType)) {
                            
                            Event eventFound = events.retrieve();
                            eventFound.contacts_names.Add(c.name);
                            events.update(eventFound);
                            event_Updated = true;
                        }

                        if (!event_Updated) {
                            e.contacts_names.Add(c.name);
                            events.Add(e);
                        }
                        System.out.println("Event scheduled successfully for " + c.name + "  !");
                    } else
                        System.out.println("Contact has conflict Event/Appoinment for " + c.name + "  !");
                } else
                    System.out.println("Cantcat " + c.name + " not found !");
            } // end for
        } // end schedule event
        else { // schedule appoinment
            type = "Appoinment";
            e.EventType = false;
            System.out.print("Enter appoinment title: ");
            input.nextLine();
            e.title = input.nextLine();

            System.out.print("Enter contact name: ");
            c.name = input.nextLine();

            if (!contacts.empty() && contacts.findkey(c.name) == true) {
                c = contacts.retrieve();

                System.out.print("Enter appoinment date and time (MM/DD/YYYY HH:MM): ");
                e.date = input.next();

                e.time = input.next();

                System.out.print("Enter appoinment location: ");
                input.nextLine();
                e.location = input.nextLine();

                if ((!events.empty()) && events.search(e)
                        && (events.retrieve().date.compareTo(e.date) == 0)
                        && (events.retrieve().time.compareTo(e.time) == 0)
                        && (events.retrieve().location.compareTo(e.location) == 0)
                        && (events.retrieve().EventType == e.EventType)) {
                    System.out.println(
                            "Appointment had been scheduled previously, could not add more contacts, try again ");
                } else {
                    Added_Event_To_Contact = c.addEvent(e);
                    if (Added_Event_To_Contact) {
                        // event added to contact
                        contacts.update(c.name, c);
                        e.contacts_names.Add(c.name);
                        events.Add(e);
                        System.out.println("Appoinment scheduled successfully!   ");
                    } else
                        System.out.println("Contact has conflict Event/Appoinment !  ");
                }
            } else
                System.out.println("Cantcat not found !");
        } // end schedule appoinment
    }// End method ScheduleEvent.
    
    // 5. Print event details
    // This method allows the user to print event details either by contact name or
    // event title
    public static void PrintEvent() {
        if (contacts.empty()) {
            System.out.println("No Contacts have been added yet! ");
            return;
        }
        int choice = criteria3();
        switch (choice) {
            case 1: {
                // Print event details by contact name
                Contact c = new Contact();
                System.out.print("Enter the contact name :  ");
                c.name = input.nextLine();

                if (!contacts.empty()) {
                    if (contacts.findkey(c.name) == true) {
                        System.out.println("Contact found !");
                        c = contacts.retrieve();

                        c.events.findFirst();
                        for (int i = 0; i < c.events.size; i++) {
                            Event e = c.events.retrieve();
                            if (!events.empty() && events.search(e)
                                    && (events.retrieve().date.compareTo(e.date) == 0)
                                    && (events.retrieve().time.compareTo(e.time) == 0)
                                    && (events.retrieve().location.compareTo(e.location) == 0)
                                    && (events.retrieve().EventType == e.EventType))
                                
                                System.out.println(events.retrieve().toString());
                            c.events.findNext();
                        }
                        if (c.events.empty())
                            System.out.println("No events found for this contact !");
                    } else
                        System.out.println("Contact not found !");
                } else
                    System.out.println("Contact not found !");
            }
                break;

            case 2: {
                // Print event details by event title
                Event e = new Event();
                System.out.print("Enter the event title:  ");
                e.title = input.nextLine();

                if (!events.empty()) {
                    events.findFirst();
                    for (int i = 0; i < events.size; i++) {
                        if (events.retrieve().compareTo(e) == 0) {
                            if (events.retrieve().EventType == true)
                                System.out.println("Event found!");
                            else
                                System.out.println("Appoinment found!");

                            Event ee = events.retrieve();
                            System.out.println(ee);
                        }
                        events.findNext();
                    }
                } else
                    System.out.println("Event/Appoinment not found !");
            }
                break;
        }// End switch (choice).
    }// End method PrintEvent.

    // 6. Print contacts by first name
    // This method allows the user to print contacts that have a specific first name
    public static void PrintContactsFirstName() {
        if (contacts.empty()) {
            System.out.println("No Contacts have been added yet!");
            return;
        }

        System.out.print("Enter the first name:");
        String fname = input.next().trim();

        if (contacts.empty())
            System.out.println("No Contacts found !");
        else
            contacts.SearchSameFirstName(fname);
    }// End method PrintContactsFirstName.

    
    // 7. Print all events alphabetically // O(n)
    // This method allows the user to print all events in the phonebook in
    // alphabetical order
    public static void PrintAllEvents() {
        if (!events.empty()) {
            events.findFirst();
            for (int i = 0; i < events.size; i++) {
                System.out.println((i + 1) + ". Event : " + events.retrieve().title);
                events.findNext();
            }
        } else
            System.out.println("No events found !");
    }// End method PrintAllEvents.

    // Main method to run the Phonebook application
    public static void main(String[] args) {

        System.out.println("Welcome to the BST Phonebook!");
        int choice = -1;
        do {
            try {
                choice = option();
                switch (choice) {
                    case 1:
                        // Option to add a new contact to the phonebook
                        AddContact();
                        break;

                    case 2:
                        // Option to search for a contact based on various criteria
                        SearchContact();
                        break;

                    case 3:
                        // Option to delete a contact from the phonebook
                        DeleteContact();
                        break;

                    case 4:
                        // Option to schedule an event and associate it with a contact
                        ScheduleEvent();
                        break;

                    case 5:
                        // Option to print event details either by contact name or event title
                        PrintEvent();
                        break;

                    case 6:
                        // Option to print contacts that have a specific first name
                        PrintContactsFirstName();
                        break;

                    case 7:
                        // Option to print all events in the phonebook in alphabetical order
                        PrintAllEvents();
                        break;

                    case 8:
                        // Option to exit the application
                        System.out.println("Goodbye!");
                        break;
                    default:
                        // In case the user enters an invalid choice
                        System.out.println("Bad choice! Try again");
                }
            } catch (Exception e) {
                System.out.println("Bad choice! Try again");
                input.nextLine(); // Consume newline
            }
            System.out.println();
        } while (choice != 8); // Exit when user chooses option 8
    }// End main.

}// End class Phonebook