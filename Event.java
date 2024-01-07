
package csc212_project;

// The Event class represents an event with attributes like title, date and time, location, and associated contact.
public class Event implements Comparable<Event> {
    
    String title;
    String date; // Format: 2023/12/31
    String time;
    String location;
    boolean EventType; // event = true, appointment = false
    LinkedList<String> contacts_names;  

    // Default constructor to initialize the event with empty values.
    public Event() {
        this.title = "";
        this.date = "";
        this.time = "";
        this.location = "";
        this.EventType = true;
        this.contacts_names = new LinkedList<String>();
    }
    
   // Constructor to initialize the event with provided values and an initial contact.
    public Event(String title, String date, String time, String location, boolean EventType, String contact ) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.EventType = EventType;
        this.contacts_names = new LinkedList<String>();
        contacts_names.Add(contact);
    }

    // Method to add a contact to this event.
    public boolean addContact(String contact) {
        //Event: True --> can add more than one contact, False --> just add one contact. 
        if ((this.EventType == true) || ((this.EventType == false) && (contacts_names.size == 0)))
            return contacts_names.Add(contact);

        System.out.println("Couldn't add more than contact for an appoinment");
        return false;
    }

    public boolean removeContact(String contact) {
        String name = contacts_names.remove(contact);
        if (name != null)
            return true;
        return false;
    }

    // Override of the toString method to provide a string representation of the Event object.
    @Override
    public String toString() {
        String eventT, EFlag;
        if(this.EventType == true)
            eventT = "Event "; 
            else 
            eventT = "Appoinment ";
       
        if(this.EventType == true) 
            EFlag = "\n";
        else
            EFlag = "";

        String str = "\n" + eventT + "title: " + title +
                "\nContacts names: " + EFlag + contacts_names.toString() +
                "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + " " + time +
                "\nEvent location: " + location +
                "\nType: " + eventT ;
        return str;
    }

    // compare events based on their titles.
    @Override
    public int compareTo(Event obj) {
        try {
            return (this.title.compareToIgnoreCase(obj.title)); //0 equal, - less,+ big 
        
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public boolean compareToSameEvent(Event obj) {
        try {
            return ((this.title.compareToIgnoreCase(obj.title) == 0) &&
                    (this.date.compareTo(obj.date) == 0) &&
                    (this.time.compareToIgnoreCase(obj.time) == 0) && (this.EventType == obj.EventType));
       
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}// End class Event