package com.example.backendskyteck.serviceImplimentation;

import org.springframework.stereotype.Service;
import com.example.backendskyteck.serviceInterface.*;
import com.example.backendskyteck.repository.*;
import com.example.backendskyteck.entities.*;

import java.util.List;
import java.util.Optional;

@Service
public class ICompRespImp implements ICompResService {

    private final ComplaintRepository complaintRepository;
    private final ResponseRepository responseRepository;

    public ICompRespImp(ComplaintRepository complaintRepository, ResponseRepository responseRepository) {
        this.complaintRepository = complaintRepository;
        this.responseRepository = responseRepository;
    }

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

    @Override
    public Complaint updateComplaint(Complaint complaint) {
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
    public Response updateResponse(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public void deleteResponse(int id) {
        responseRepository.deleteById(id);
    }


}
