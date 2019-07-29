package licodipo.controller;
 
import java.util.List;
import java.util.Map;

import licodipo.bean.CarPartBean;
import licodipo.controller.CarPartController;
import licodipo.dao.CarPartDao;
import licodipo.model.CarPart;
 
public class CarPartControllerImpl implements CarPartController{
 
	CarPartDao carPartDao;
 
	public void setCarPartDao(CarPartDao carPartDao) {
		this.carPartDao = carPartDao;
	}
 
	public void addCarPart(CarPart carPart){
 
		carPartDao.addCarPart(carPart);
	}
	
	public List<CarPart> findAllCarParts(){
 
		return carPartDao.findAllCarParts();
	}

	@Override
	public Map<String,Object> editCarPart(int id) {
		return carPartDao.editCarPart(id);
	}

	@Override
	public void updateCarPart(CarPartBean carPartBean) {
		carPartDao.updateCarPart(carPartBean);
		
	}
	public void deleteCarPart(int id) {
		carPartDao.deleteCarPart(id);
	}

	@Override
	public List<CarPart> search(String str) {
		return carPartDao.search(str);
	}
}