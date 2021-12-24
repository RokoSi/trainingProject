package ru.sfedu.Medicine.api;

import ru.sfedu.Medicine.model.ListPatient;

public interface Result {
    Result saveOrUpdateSubject(ListPatient List);

    //boolean barrierRegistration(Integer barrierFloor);

   // Result<Object> grantAccess(Integer subjectId, Integer barrierId, Integer year, Integer month, Integer day, Integer hours);

    //boolean gateAction(Integer subjectId, Integer barrierId, MoveType moveType);
}
