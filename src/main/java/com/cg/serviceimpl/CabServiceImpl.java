package com.cg.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Convertor;

import com.cg.dto.CabDto;
import com.cg.entities.Cab;
import com.cg.exception.CabAlreadyExistsException;
import com.cg.exception.CabNotFoundException;
import com.cg.repository.CabRepository;
import com.cg.service.ICabService;



@Service
@Transactional
public class CabServiceImpl implements ICabService {
	
	CabServiceImpl(){
		System.out.println("CabService Bean Created");
	}
	@Autowired
	private CabRepository cabRepository;
	/*
	 * Method Name 		- insertCab
	 * Parameter List 	- CabDto object
	 * Return Type		- CabDto object
	 * Description		- insert the CabDto object into database
	 */
	@Override
	public CabDto insertCab(CabDto cab) throws CabAlreadyExistsException {

		// check if cab object is empty or null
		if (cab == null)
			return null;

		Optional<Cab> cabOptional = cabRepository.findById(Convertor.convertCabDTOtoEntity(cab).getCabId());

		if (cabOptional.isPresent()) {		
			throw new CabAlreadyExistsException("Cab Already Exists");
		}

		Cab cabEntity = Convertor.convertCabDTOtoEntity(cab);
		Cab cabEntity2 = cabRepository.save(cabEntity);
		CabDto cabdto = Convertor.convertCabEntitytoDTO(cabEntity2);
		return cabdto;
	}

	/*
	 * Method Name 		- updateCab
	 * Parameter List 	- CabDto object
	 * Return Type		- CabDto object
	 * Description		- update the existing CabDto object in database
	 */
	@Override
	public CabDto updateCab(CabDto cab) {

		if (cab == null)
			return null;

		Optional<Cab> cabOptional = cabRepository.findById(Convertor.convertCabDTOtoEntity(cab).getCabId());

		if (!cabOptional.isPresent()) {
			
			throw new CabAlreadyExistsException("cab does not Exists");
		}

		Cab custEntity = Convertor.convertCabDTOtoEntity(cab);
	

		return Convertor.convertCabEntitytoDTO(cabRepository.save(custEntity));

	}

	/*
	 * Method Name 		- viewCabsOfType
	 * Parameter List 	- String carType
	 * Return Type		- List<CabDto>
	 * Description		- This method returns the List of cabs which are of type carType from the database
	 */
	@Override
	public List<CabDto> viewCabsOfType(String carType) throws CabNotFoundException {
		List<Cab> cabList = cabRepository.findByCarType(carType);
		List<CabDto> cabdtoList = new ArrayList<>();

		if (!cabList.isEmpty()) {
			for (Cab c : cabList) {
				cabdtoList.add(Convertor.convertCabEntitytoDTO(c));
			}
		} else {
			throw new CabNotFoundException("Cab List is empty");
		}
		return cabdtoList;
	}

	/*
	 * Method Name 		- countCabsOfType
	 * Parameter List 	- String carType
	 * Return Type		- int 
	 * Description		- This method returns the count of cabs of type carType from the database
	 */
	@Override
	public int countCabsOfType(String carType) {
		long count = cabRepository.countByCarType(carType);
		int cabCount =(int) count;
		return cabCount;
	}

	/*
	 * Method Name 		- viewCabToBooked
	 * Parameter List 	- None
	 * Return Type		- List<CabDto>
	 * Description		- This method returns the List of availableCabs from database where booked = false
	 */
	@Override
	public List<CabDto> viewCabToBeBooked() throws CabNotFoundException {
		List<Cab> cabList = cabRepository.findByBookedFalse();
		List<CabDto> cabdtoList = new ArrayList<>();

		if (!cabList.isEmpty()) {
			for (Cab c : cabList) {
				cabdtoList.add(Convertor.convertCabEntitytoDTO(c));
			}
		} else {
		
			throw new CabNotFoundException("Cab List is empty");
		}
		return cabdtoList;
	}

	/*
	 * Method Name 		- findCabById
	 * Parameter List 	- int id(cabId)
	 * Return Type		- CabDto object
	 * Description		- get the CabDto object from database and return it 
	 */
	@Override
	public CabDto findCabById(int id) throws CabNotFoundException {
		Optional<Cab> cab = cabRepository.findById(id);

		if (cab.isPresent()) {

			return Convertor.convertCabEntitytoDTO(cab.get());
		}
		throw new CabNotFoundException("Cab not found with id: " + id);
	}

	/*
	 * Method Name 		- deleteCab
	 * Parameter List 	- CabDto object
	 * Return Type		- CabDto object
	 * Description		- delete the CabDto object from the database if it exists
	 */
	@Override
	public CabDto deleteCab(CabDto cab) throws CabNotFoundException {


		Optional<Cab> cabOptional = cabRepository.findById(cab.getCabId());

		if (cabOptional.isPresent()) {

			cabRepository.delete(Convertor.convertCabDTOtoEntity(cab));
	
			return cab;
		}
		throw new CabNotFoundException("Cab not found ");

	}

}