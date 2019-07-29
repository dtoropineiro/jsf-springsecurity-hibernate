package licodipo.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import licodipo.controller.CarPartController;
import licodipo.model.CarPart;

@SuppressWarnings("serial")
public class CarPartBean implements Serializable{
	private static List<CarPart> currentList;
	CarPartController carPartController;
	private int id;
	private String strSearch;
	private String name;
	private String description;
	private String make;
	private String model;
	private String engine;
	private Integer price;
	private Integer stock;
	@SuppressWarnings("unused")
	private Map<String,Object> sessionMapObj;
	
	public String toSearch(String strSearch) {
		currentList = carPartController.search(strSearch);
		return "search";
	}
	public String getStrSearch() {
		return strSearch;
	}
	public void setStrSearch(String strSearch) {
		this.strSearch = strSearch;
	}
	public List<CarPart> getCurrentList() {
		return currentList;
	}
	public static void setCurrentList(List<CarPart> currentList) {
		CarPartBean.currentList = currentList;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void getMapObj() {
		
	}
	
	
	public String getName() {
		return name;
	}
	public String getNameById(String id) {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public String create() {
		return "faces/create";
	}
	public void setCarPartController(CarPartController carPartController) {
		this.carPartController = carPartController;
	}
 
	//get all car part data from database
	public List<CarPart> getCarPartList(){
		return carPartController.findAllCarParts();
	}
	
	public List<CarPart> search(String str){
		return carPartController.search(str);
	}
	
	public String getNameById() {
		return "";
	}
	public String addCarPart(){
		
		CarPart carPart = new CarPart();
		carPart.setName(getName());
		
		carPartController.addCarPart(carPart);
		
		clearForm();
		
		return "/faces/default.xhtml";
	}
	public String addCarPartAndContinue(CarPartBean carPartBean){
		
		CarPart carPart = new CarPart();
		carPart.setName(carPartBean.getName());
		carPart.setDescription(carPartBean.getDescription());
		carPart.setMake(carPartBean.getMake());
		carPart.setModel(carPartBean.getModel());
		carPart.setPrice(carPartBean.getPrice());
		carPart.setStock(carPartBean.getStock());
		carPartController.addCarPart(carPart);
		
		clearForm();
		
		return "/secure/default.xhtml";
	}
	

	public String goToEditPage() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = 
		         fc.getExternalContext().getRequestParameterMap();
		
		id = Integer.parseInt(params.get("partid"));
		@SuppressWarnings("unused")
		Map<String,Object> sessionObj = carPartController.editCarPart(id);
		
		return "edit";
	}
	
	
	public String editCarPart(CarPartBean carPartBean) {
		carPartController.updateCarPart(carPartBean);
		return "default";
	}
	public String delete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = 
		         fc.getExternalContext().getRequestParameterMap();
		
		id = Integer.parseInt(params.get("partid"));
		carPartController.deleteCarPart(id);
		return "";
	}
	//clear form values
	private void clearForm(){
		setName("");
		setModel("");
		setMake("");
		setDescription("");
		setPrice(null);
		setStock(null);
		
	}
	
	
	
}
