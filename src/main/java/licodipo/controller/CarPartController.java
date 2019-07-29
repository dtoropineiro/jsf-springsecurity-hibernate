package licodipo.controller;

import java.util.List;
import java.util.Map;

import licodipo.bean.CarPartBean;
import licodipo.model.CarPart;

public interface CarPartController {

	void addCarPart(CarPart carPart);

	Map<String,Object> editCarPart(int id);

	void updateCarPart(CarPartBean carPartBean);

	void deleteCarPart(int id);
	List<CarPart> findAllCarParts();
	List<CarPart> search(String str);
}