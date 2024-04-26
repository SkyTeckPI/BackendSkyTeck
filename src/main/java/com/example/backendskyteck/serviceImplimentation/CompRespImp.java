package com.example.backendskyteck.serviceImplimentation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backendskyteck.repository.*;
import com.example.backendskyteck.entities.*;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompRespImp implements ICompResService {

    private final ComplaintRepository complaintRepository;
    private final ResponseRepository responseRepository;
    @Override
    public List<Complaint> getAllComplaint() {
        return complaintRepository.findAll();
    }

    @Override
    public Optional<Complaint> getComplaintById(int idComp) {
        return complaintRepository.findById(idComp);
    }

    @Override
    public Complaint createComplaint(Complaint complaint) throws Exception {
        Complaint c = complaintRepository.save(complaint);
        return c;
    }

    public Complaint updateComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }
    @Override
    public Complaint updateComplaint(Complaint complaint, Complaint newInfo) {
        Optional.ofNullable(newInfo.getTypeRec()).ifPresent(complaint::setTypeRec);
        Optional.ofNullable(newInfo.getNote()).ifPresent(complaint::setNote);
        Optional.ofNullable(newInfo.getDescription()).ifPresent(complaint::setDescription);
        Optional.ofNullable(newInfo.getStatus()).ifPresent(complaint::setStatus);
        return complaintRepository.save(complaint);
    }


    @Override
    public void deleteComplaint(int id) {
        complaintRepository.deleteById(id);
    }


    /***************************************************/


    @Override
    public List<Response> getAllResponse() {
        return responseRepository.findAll();
    }

    @Override
    public Optional<Response> getResponseById(int id) {
        return responseRepository.findById(id);
    }

    @Override
    public Response createResponse(Response response) {
        return responseRepository.save(response);
    }



    @Override
    public Response updateResponse(Response response,Response NewInfo) {
        return responseRepository.save(response);
    }

    @Override
    public void deleteResponse(int id) {
        responseRepository.deleteById(id);
    }


}
