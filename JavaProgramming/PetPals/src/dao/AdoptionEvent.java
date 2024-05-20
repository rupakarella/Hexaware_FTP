package dao;

import java.util.ArrayList;
import java.util.List;

import exception.NullReferenceException;

public class AdoptionEvent {
    private List<IAdoptable> participants;

    public AdoptionEvent() {
        this.participants = new ArrayList<>();
    }

    public void hostEvent() {
        System.out.println("Hosting adoption event!");
        for (IAdoptable participant : participants) {
            // Check for null references in participant
            try {
                if (participant == null) {
                    throw new NullReferenceException("Null participant in adoption event.");
                }
                System.out.println("Participant: " + participant);
                participant.adopt();
            } catch (NullReferenceException e) {
                System.err.println(e.getMessage());
            }
        }

        // Additional logic for the event
        System.out.println("Adoption event successfully hosted!");
    }

    public void registerParticipant(IAdoptable participant) {
    	try {
            // Check for null references in participant
            if (participant == null) {
                throw new NullReferenceException("Null participant cannot be registered.");
            }

            participants.add(participant);
            System.out.println("Participant registered for the adoption event.");
        } catch (NullReferenceException e) {
            System.err.println(e.getMessage());
        }
    }
}
