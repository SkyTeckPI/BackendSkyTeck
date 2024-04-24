package com.example.backendskyteck.serviceImplimentation;

import com.example.backendskyteck.entities.*;

import java.util.List;
import java.util.Optional;


public interface ICompResService {

    List<Complaint> getAllComplaint();

    Optional<Complaint> getComplaintById(int id);

    Complaint createComplaint(Complaint complaint) throws Exception;

    Complaint updateComplaint(Complaint complaint);

    void deleteComplaint(int id);

/************************************/

    List<Response> getAllResponse();

    Optional<Response> getResponseById(int idRep);

    Response createResponse(Response response);

    Response updateResponse(Response response);

    void deleteResponse(int idRep);




}
