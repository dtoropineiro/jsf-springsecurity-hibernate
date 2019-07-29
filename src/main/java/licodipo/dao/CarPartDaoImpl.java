package licodipo.dao;
 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import licodipo.bean.CarPartBean;
import licodipo.dao.CarPartDao;
import licodipo.model.CarPart;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
public class CarPartDaoImpl extends 
       HibernateDaoSupport implements CarPartDao{
	
	public static HashMap<Integer, CarPart> hashData = new HashMap<>();
	
	public void addCarPart(CarPart carPart){
		hashData.put(carPart.getId(), carPart); 
		getHibernateTemplate().save(carPart);
	}
 
	public List<CarPart> findAllCarParts(){
		@SuppressWarnings("unchecked")
		List<CarPart> list = getHibernateTemplate().find("from CarPart");
		for (CarPart c : list) { 
            hashData.put(c.getId(), c);
        } 
		return list;
	}
	
	public CarPart findById(int id) {
		CarPart carPart = hashData.get(id);
		return carPart;
		
	}
	public void updateCarPart(CarPartBean carPartBean) {
		CarPart carPart = new CarPart();
		carPart.setId(carPartBean.getId());
		carPart.setName(carPartBean.getName());
		carPart.setDescription(carPartBean.getDescription());
		carPart.setMake(carPartBean.getMake());
		carPart.setModel(carPartBean.getModel());
		carPart.setPrice(carPartBean.getPrice());
		carPart.setStock(carPartBean.getStock());
		
		getHibernateTemplate().update(carPart);
	}
	public void deleteCarPart(int id){
		CarPart carPart = findById(id);
		getHibernateTemplate().delete(carPart);
	}

	@Override
	public Map<String,Object> editCarPart(int id) {
		CarPartBean editRecord = null;
		CarPart carPart = findById(id);
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        editRecord = new CarPartBean();
        editRecord.setId(carPart.getId());
        editRecord.setDescription(carPart.getDescription());
        editRecord.setName(carPart.getName());
        editRecord.setModel(carPart.getModel());
        editRecord.setMake(carPart.getMake());
        editRecord.setPrice(carPart.getPrice());
        editRecord.setStock(carPart.getStock());
        sessionMapObj.put("editPartObj", editRecord);
		return sessionMapObj;
	}

	@Override
	public List<CarPart> search(String str) {
		List<CarPart> list = getHibernateTemplate().find("FROM CarPart WHERE name LIKE '%" + str + "%'");
		return list;
	}
	


}