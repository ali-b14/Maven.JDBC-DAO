package daos;

import java.util.List;

public class CarDAO extends DAO<Car>  {
    @Override
    public Car findById(int id) {
        return null;
    }
    @Override
    public List<Car> findAll(){
        //select * from cars, get record set,
        // make a list have a variable be a list(arraylist)
        // loop through record set create an instance of a car that has the field values and put that new car into your list
        //return list
        return null;
    }

    @Override
    public Car update(Car dto) {
        return null;
    }

    @Override
    public Car create(Car dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
