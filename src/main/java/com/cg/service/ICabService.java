package com.cg.service;

import java.util.List;
import com.cg.dto.CabDto;
import com.cg.exception.CabNotFoundException;

public interface ICabService {

        public CabDto insertCab(CabDto cab);
        public CabDto updateCab(CabDto cab);
        public CabDto deleteCab(CabDto cab) throws CabNotFoundException;
        public List<CabDto> viewCabsOfType(String carType)throws CabNotFoundException;
        public int countCabsOfType(String carType)throws CabNotFoundException;
        public List<CabDto> viewCabToBeBooked() throws CabNotFoundException;
        public CabDto findCabById(int id) throws CabNotFoundException;
    
}