
package csc212_project;

// The Contact class implements the Comparable interface, meaning it can be compared to other Contacts.
public class Contact implements Comparable<Contact> {

     String name;
     String phoneNumber;
     String emailAddress;
     String address;
     String birthday;
     String notes;
     LinkedList<Event> events;

    // Constructor to initialize the contact with an empty state.
    public Contact() {
        this.name = "";
        this.phoneNumber = "";
        this.emailAddress = "";
        this.address = "";
        this.birthday = "";
        this.notes = "";
        events = new LinkedList<Event>();
    }

    // Constructor to initialize the contact with the provided values.
    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        events = new LinkedList<Event>();
    }
 
    
    // Override of the toString method to provide a string representation of the Contact object.
    @Override
    public String toString() {
        String pEvents = "\nEvents: " + "No events";
        if (!events.empty()) {
            pEvents = "\nEvents: " + events.toString();
        }

        return "\nName: " + name +
                "\nPhone Number: " + phoneNumber +
                "\nEmail Address: " + emailAddress +
                "\nAddress: " + address +
                "\nBirthday: " + birthday +
                "\nNotes: " + notes +
                pEvents + "\n";
    }

    // Method to add an event to the list of events.
    public boolean addEvent(Event event) {
        if (!events.empty()) {
            events.findFirst();
            for (int i = 0; i < events.size; i++) {
                if ((events.retrieve().date.compareTo(event.date) == 0)
                 && (events.retrieve().time.compareTo(event.time) == 0))
                    return false;
            }
        }
        events.Add(event);
        return true;
    } 

     // Method to remove an event with a specific title from the list of events.
    public boolean removeEvent(String eTitle) {
        if (events.empty())
            return false;
        
        Event obj = new Event();
        obj.title = eTitle;
        if (events.search(obj)) {
            events.remove(obj);
            return true;
        }
        return false;
    }

    // Method to compare two contacts by name.
    @Override
    public int compareTo(Contact o) {
        try {
            return (this.name.compareToIgnoreCase(o.name)); //0 exit, - less,+ big 

        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    // Method to compare two contacts by first name.
    public int compareFirstName(String n) {
        try {
            String[] new_name = this.name.split(" ");
            return (new_name[0].trim().compareToIgnoreCase(n));
      
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    // Method to compare two contacts by phone number.
    public int compareToPhone(String phoneNumber) {
        try {
            return (this.phoneNumber.compareToIgnoreCase(phoneNumber)); //0 exit, - less,+ big
                                                                
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    // Method to compare two contacts by email Address.
    public int compareToEmail(String emailAddress) {
        try {
            return (this.emailAddress.compareToIgnoreCase(emailAddress)); //0 exit, - less,+ big 
        
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    // Method to compare two contacts by address.
    public int compareToAddress(String address) {
        try {
            return (this.address.compareToIgnoreCase(address)); //0 exit, - less,+ big 
       
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    // Method to compare two contacts by birthday.
    public int compareToBirthday(String birthday) {
        try {
            return (this.birthday.compareTo(birthday)); //0 exit, - less,+ big 
       
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}// End class Contact.