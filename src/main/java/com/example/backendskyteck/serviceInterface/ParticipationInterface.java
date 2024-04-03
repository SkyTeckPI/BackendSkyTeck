package com.example.backendskyteck.serviceInterface;

import com.projectpi.projectpi.Entity.Participation;

public interface ParticipationInterface {
    Participation participate(Long Id, Long NumEvent);
    void acceptParticipation(Long IdPart);
    void rejectParticipation(Long IdPart);
    Participation archiveParticipation(Long IdPart);
}
