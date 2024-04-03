package com.example.backendskyteck.serviceImplimentation;

import com.projectpi.projectpi.Entity.Event;
import com.projectpi.projectpi.Entity.Participation;
import com.projectpi.projectpi.Entity.ParticipationStatus;
import com.projectpi.projectpi.Entity.User;
import com.projectpi.projectpi.Repository.EventRepository;
import com.projectpi.projectpi.Repository.ParticipationRepository;
import com.projectpi.projectpi.Repository.UserRepository;
import com.projectpi.projectpi.ServiceInterface.ParticipationInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParticipationImpl implements ParticipationInterface {
    ParticipationRepository repopart;
    UserRepository userRepo;
    EventRepository repo;
    @Override
    public Participation participate(Long Id, Long NumEvent) {
        Event event = repo.findById(NumEvent).orElseThrow(() -> new IllegalArgumentException("Invalid event Id"));
        User user = userRepo.findById(Id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id"));
        Participation participation = new Participation();
        participation.setEvent(event);
        participation.setUser(user);
        participation.setStatus(ParticipationStatus.WAITING); // By default, participation is waiting
        return repopart.save(participation);
    }

    @Override
    public void acceptParticipation(Long IdPart) {
        Participation participation = repopart.findById(IdPart).orElseThrow(() -> new IllegalArgumentException("Invalid participation Id"));
        participation.setStatus(ParticipationStatus.ACCEPTED); // Mark the participation as accepted
        repopart.save(participation); // Save the updated participation
    }

    @Override
    public void rejectParticipation(Long IdPart) {
        Participation participation = repopart.findById(IdPart).orElseThrow(() -> new IllegalArgumentException("Invalid participation Id"));
        participation.setStatus(ParticipationStatus.REJECTED); // Mark the participation as rejected
        repopart.save(participation); // Save the updated participation
    }
    @Override
    public Participation archiveParticipation(Long IdPart) {
        Participation participation = repopart.findById(IdPart)
                .orElseThrow(() -> new IllegalArgumentException("Invalid participation Id"));
        participation.setStatus(ParticipationStatus.ARCHIVED);
        return repopart.save(participation);
    }
}
