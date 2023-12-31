package ampath.or.ke.spot.services;


import ampath.or.ke.spot.models.Years;
import ampath.or.ke.spot.repositories.YearsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("YearService")
public class YearsService {
    Date nowDate = new Date();
    private YearsRepository yearsRepository;
    @Autowired
    public YearsService(YearsRepository yearsRepository) {
        this.yearsRepository = yearsRepository;
    }
    public Years save(Years dataset) {
        return yearsRepository.save(dataset);
    }
    public void delete(Years dataset){
        yearsRepository.delete(dataset);
    }
    public List<Years> getAllDataset(){return  yearsRepository.findAll();}

}