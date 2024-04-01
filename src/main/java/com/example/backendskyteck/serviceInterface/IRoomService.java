package com.example.backendskyteck.serviceInterface;

import com.example.backendskyteck.entities.Room;

import java.util.List;

public interface IRoomService {

      Room  addRoom (Room room);
      Room updateRoom (Room room);
      List<Room> rooms ();
      //room by id of the creater ( what he did create )
    //room by the subscription to room()

    void removeRoom( Long numRoom);

    //unsubscibe to room

}
