package licodipo.dao;
 
import java.util.List;
import java.util.Map;

import licodipo.bean.CarPartBean;
import licodipo.model.CarPart;
 
public interface CarPartDao{
 
	void addCarPart(CarPart carPart);
	void deleteCarPart(int id);
	Map<String,Object> editCarPart(int id);
	void updateCarPart(CarPartBean carPartBean);
	List<CarPart> findAllCarParts();
	List<CarPart> search(String str);
}